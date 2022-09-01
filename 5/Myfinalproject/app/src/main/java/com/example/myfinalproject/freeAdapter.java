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

public class freeAdapter extends RecyclerView.Adapter {

    ArrayList<Freebo> arry ;
    Context context;

    public freeAdapter(ArrayList<Freebo> freeb, Freebooks Freebooks) {

        this.arry= freeb;
        this.context=Freebooks;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.freeb_card,parent,false);
        freeAdapter.ViewHolder vh = new freeAdapter.ViewHolder(view);
        return vh;
    }


    private void openURL (String s){
        Uri uri = Uri.parse(s);
        context.startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Picasso.with(context).load(arry.get(position).getImage()).into(((freeAdapter.ViewHolder) holder).photo);

        // ((ViewHolder) holder).photo.setImageResource(arry.get(position).getImage());
        ((freeAdapter.ViewHolder) holder).title.setText(arry.get(position).getName());
        ((ViewHolder) holder).genre.setText(arry.get(position).getGenre());

    }


    @Override
    public int getItemCount() {
        return arry == null ? 0 :arry.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView genre;
        public ImageView photo;
        public View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            view = itemView;
            title = itemView.findViewById(R.id.textView4title);
            genre = itemView.findViewById(R.id.textView5genre);
            photo = itemView.findViewById(R.id.imageView9book);
        }
    }
}