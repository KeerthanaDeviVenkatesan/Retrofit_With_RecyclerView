package com.example.retrofit_with_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Api api;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
   private ArrayList<Data> dataArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler_View);
        dataArrayList=new ArrayList<>();
       getData();
        }

    private void getData() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build();
        api=retrofit.create(Api.class);
        Call<ArrayList<Data>> call=api.dataCall();
        call.enqueue(new Callback<ArrayList<Data>>() {
            @Override
            public void onResponse(Call<ArrayList<Data>> call, Response<ArrayList<Data>> response) {
                dataArrayList=response.body();
                for(int i=0;i<dataArrayList.size();i++){
                    Adapter adapter=new Adapter(dataArrayList,MainActivity.this);
                    layoutManager=new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Data>> call, Throwable t) {

            }
        });
    }
}
