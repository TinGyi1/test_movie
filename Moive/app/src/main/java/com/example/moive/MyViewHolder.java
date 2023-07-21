package com.example.moive;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView image_view;
    TextView  title,year,imb;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        image_view = itemView.findViewById(R.id.poster);
        title = itemView.findViewById(R.id.title);
        year = itemView.findViewById(R.id.year);
        imb = itemView.findViewById(R.id.imb);
    }
}
