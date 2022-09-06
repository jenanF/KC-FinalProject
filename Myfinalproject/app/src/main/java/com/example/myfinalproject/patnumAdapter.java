package com.example.myfinalproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class patnumAdapter extends RecyclerView.Adapter {

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://kcfinalproject1-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = database.getReference();

    ArrayList<Items> arry;
    Context context;

    public patnumAdapter(ArrayList<Items> item, platenumActivity platenumActivity) {
        this.arry=item;
        this.context=platenumActivity;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jarir_card,parent,false);
        patnumAdapter.ViewHolder vh = new patnumAdapter.ViewHolder(view);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Picasso.with(context).load(arry.get(position).getImage()).into(((patnumAdapter.ViewHolder) holder).photo);

        ((patnumAdapter.ViewHolder) holder).title.setText(arry.get(position).getName());
        ((patnumAdapter.ViewHolder) holder).genre.setText(arry.get(position).getGenre());
        ((patnumAdapter.ViewHolder) holder).price.setText(arry.get(position).getPrice()+"kd");

        ((patnumAdapter.ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent d = new Intent(context,DetailsActivity.class);

                d.putExtra("prod",arry.get(position));

                context.startActivity(d);

            }
        });

        ((patnumAdapter.ViewHolder) holder).add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbRef.child("myCart").push().setValue(arry.get(position));
                Snackbar snackbar = Snackbar.make(view,"added to cart", Snackbar.LENGTH_SHORT)
                        .setAction("go to cart", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                context.startActivity(new Intent(context,cartActivity.class));
                            }
                        });
                snackbar.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return arry == null ? 0 :arry.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView genre;
        public TextView price;
        public ImageView photo;
        public ImageView add;
        public View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            view = itemView;
            title = itemView.findViewById(R.id.textView2title);
            genre = itemView.findViewById(R.id.textView8genre);
            price = itemView.findViewById(R.id.textView5price);
            photo = itemView.findViewById(R.id.imageView7book);
            add = itemView.findViewById(R.id.imageView8);
        }
    }
}