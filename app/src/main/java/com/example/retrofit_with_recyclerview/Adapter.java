package com.example.retrofit_with_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<Data> dataArrayList;

    private Context context;

    public Adapter(ArrayList<Data> dataArrayList, Context context) {
        this.dataArrayList = dataArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        Data data = dataArrayList.get(position);
        holder.textView1.setText("Id :" + data.getId() + "\n");
        holder.textView2.setText("Title :" + data.getTitle() + "\n");
        holder.textView3.setText("Body :" + data.getBody() + "\n");

    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2, textView3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.text_View1);
            textView2 = itemView.findViewById(R.id.text_View2);
            textView3 = itemView.findViewById(R.id.text_View3);
        }
    }
}

