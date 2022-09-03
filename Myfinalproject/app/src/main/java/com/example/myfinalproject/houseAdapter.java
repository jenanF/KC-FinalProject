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

    private void openURL (String s){
        Uri uri = Uri.parse(s);
        context.startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Picasso.with(context).load(arry.get(position).getImage()).into(((houseAdapter.ViewHolder) holder).photo);


        ((houseAdapter.ViewHolder) holder).title.setText(arry.get(position).getName());

        ((houseAdapter.ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(position == 0){
                    openURL("https://kalemat.com/ar/shop?department%5B0%5D=1");
                }
                else if (position == 1){
                    openURL("https://mintadstore.com/%D9%83%D8%AA%D8%A8");
                }
                else if (position == 2){
                    openURL("https://www.instagram.com/darnotebook/");
                }
                else if (position == 3){
                    openURL("https://novapluskw.com/?lang=ar");
                }
                else if (position == 4){
                    openURL("https://www.instagram.com/darshghf/");
                }
            }
        });



    }


    @Override
    public int getItemCount() {
        return arry == null ? 0 :arry.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public ImageView photo;
        public View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            view = itemView;
            title = itemView.findViewById(R.id.textViewname3);
            photo = itemView.findViewById(R.id.image7);
        }
    }
}
