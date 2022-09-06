package com.example.myfinalproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class rvAdapter extends RecyclerView.Adapter {

    ArrayList<Books> arry ;
    Context context;

    public rvAdapter(ArrayList<Books> store, stores_activity stores_activity) {

        this.arry=store;
        this.context=stores_activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_rv_n_rv,parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Picasso.with(context).load(arry.get(position).getImage()).into(((ViewHolder) holder).photo);

        ((ViewHolder) holder).title.setText(arry.get(position).getName());

        ((rvAdapter.ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(position == 0){
                    context.startActivity(new Intent(context, thatSlaselActivity.class));
                }
                else if (position == 1){
                    context.startActivity(new Intent(context, jarirActivity.class));
                }
                else if (position == 2){
                    context.startActivity(new Intent(context, platenumActivity.class));
                }
                else if (position == 3){
                    context.startActivity(new Intent(context, sofiaActivity.class));
                }
            }
        });




    }


    @Override
    public int getItemCount() {
        return arry == null ? 0 :arry.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public ImageView photo;
        public View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            view = itemView;
            title = itemView.findViewById(R.id.textViewname);
            photo = itemView.findViewById(R.id.image9);
        }
    }
}
