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

public class EbookAdapter extends RecyclerView.Adapter {

    ArrayList<Books> erry ;
    Context context;

    public EbookAdapter(ArrayList<Books> ebook, Ebooks_Activity Ebooks_Activity) {

        this.erry= Ebooks_Activity.ebook;
        this.context=Ebooks_Activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ebooks_card,parent,false);
        EbookAdapter.ViewHolder vh = new EbookAdapter.ViewHolder(view);
        return vh;
    }


    private void openURL (String s){
        Uri uri = Uri.parse(s);
        context.startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Picasso.with(context).load(erry.get(position).getImage()).into(((EbookAdapter.ViewHolder) holder).photo);

        // ((ViewHolder) holder).photo.setImageResource(arry.get(position).getImage());
        ((EbookAdapter.ViewHolder) holder).title.setText(erry.get(position).getName());

        ((ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(position == 0){
                    openURL("https://www.bookbub.com/welcome");
                }
                else if (position == 1){
                    openURL("https://manybooks.net/");
                }
                else if (position == 2){
                    openURL("https://openlibrary.org/");
                }
                else if (position == 3){
                    openURL("https://www.smashwords.com/shelves/home/1/free/any");
                }
                else if (position == 4){
                    openURL("https://www.smashwords.com/shelves/home/1/free/any");
                }
            }
        });



    }


    @Override
    public int getItemCount() {
        return erry == null ? 0 :erry.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public ImageView photo;
        public View view;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            view = itemView;
            title = itemView.findViewById(R.id.textView11);
            photo = itemView.findViewById(R.id.imageView7);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                }
            });

        }
    }
}
