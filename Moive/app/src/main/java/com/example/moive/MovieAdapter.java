package com.example.moive;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<MovieItem> items;
    RecyclerViewInterface recyclerViewInterface;
    


    public MovieAdapter(Context context, List<MovieItem> items , RecyclerViewInterface recyclerViewInterface)  {

        this.context = context;
        this.items = items;
        this.recyclerViewInterface = recyclerViewInterface;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_view,parent,false);
      
        return new MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.year.setText(items.get(position).getYear());
        holder.title.setText(items.get(position).getTitle());
        holder.imb.setText(items.get(position).getImb());
        //holder.image_view.setImageResource(items.get(position).getImage());
        Glide.with(holder.itemView.getContext())
                .load(items.get(position).getImage())
                .error(R.drawable.error404) // Set the default image resource ID here
                .into(holder.image_view);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
