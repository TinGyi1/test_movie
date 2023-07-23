package com.example.moive;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder  {

    ImageView image_view;
    TextView  title,year,imb;

    public MyViewHolder(@NonNull View itemView,RecyclerViewInterface recyclerViewInterface) {
        super(itemView);
        image_view = itemView.findViewById(R.id.poster);
        title = itemView.findViewById(R.id.title);
        year = itemView.findViewById(R.id.year);
        imb = itemView.findViewById(R.id.imb);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recyclerViewInterface != null){
                    int pos =  getAbsoluteAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        recyclerViewInterface.onItemClick(pos);

                    }


                }
            }
        });
    }


}
