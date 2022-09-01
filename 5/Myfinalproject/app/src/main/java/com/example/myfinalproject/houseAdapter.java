package com.example.myfinalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class houseAdapter extends RecyclerView.Adapter {

    ArrayList<Books> arry ;
    Context context;

    public houseAdapter(ArrayList<Books> store, stores_activity stores_activity) {

        this.arry= stores_activity.pubhouse;
        this.context=stores_activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.house_card,parent,false);
        houseAdapter.ViewHolder vh = new houseAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Picasso.with(context).load(arry.get(position).getImage()).into(((houseAdapter.ViewHolder) holder).photo);


        ((houseAdapter.ViewHolder) holder).title.setText(arry.get(position).getName());



    }


    @Override
    public int getItemCount() {
        return arry == null ? 0 :arry.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public ImageView photo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.textViewname3);
            photo = itemView.findViewById(R.id.image7);
        }
    }
}
