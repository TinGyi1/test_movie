package com.example.moive;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView image_view;
    TextView  title,name,review;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        image_view = itemView.findViewById(R.id.image_view);
        title = itemView.findViewById(R.id.title);
        name = itemView.findViewById(R.id.name);
        review = itemView.findViewById(R.id.review);
    }
}
