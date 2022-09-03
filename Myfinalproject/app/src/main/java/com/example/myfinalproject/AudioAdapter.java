package com.example.myfinalproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AudioAdapter extends RecyclerView.Adapter {

    ArrayList<Books> arry ;
    Context context;

    public AudioAdapter(ArrayList<Books> store, Audiobooks_activity Audiobooks_activity) {

        this.arry= Audiobooks_activity.audioArry;
        this.context=Audiobooks_activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.audio_card,parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }


    private void openURL (String s){
        Uri uri = Uri.parse(s);
        context.startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Picasso.with(context).load(arry.get(position).getImage()).into(((ViewHolder) holder).photo);

        // ((ViewHolder) holder).photo.setImageResource(arry.get(position).getImage());
        ((ViewHolder) holder).title.setText(arry.get(position).getName());

        ((AudioAdapter.ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(position == 0){
                    openURL("https://www.hoopladigital.com/");
                }
                else if (position == 1){
                    openURL("https://www.audible.com/");
                }
                else if (position == 2){
                    openURL("https://www.blinkist.com/");
                }
                else if (position == 3){
                    openURL("https://www.downpour.com/");
                }
                else if (position == 4){
                    openURL("https://www.scribd.com/");
                }
                else if (position == 5){
                    openURL("https://cloudaloud.co.uk/collections");
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
            title = itemView.findViewById(R.id.textViewname8);
            photo = itemView.findViewById(R.id.image11);
        }
    }
}
