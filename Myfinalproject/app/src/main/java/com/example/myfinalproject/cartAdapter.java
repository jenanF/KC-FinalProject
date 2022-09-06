package com.example.myfinalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class cartAdapter extends RecyclerView.Adapter {

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://kcfinalproject1-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = database.getReference();

    ArrayList<Items> arry;
    Context context;

    public cartAdapter(ArrayList<Items> cart, cartActivity cartActivity) {
        this.arry = cart;
        this.context = cartActivity;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_card, parent, false);
        cartAdapter.ViewHolder vh = new cartAdapter.ViewHolder(view);
        return vh;
    }

    private double calTotal(ArrayList<Items> arry) {

        double cal = 0;
        for (Items p :arry){
            cal = cal + p.getPrice();
        }
        return cal;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Picasso.with(context).load(arry.get(position).getImage()).into(((cartAdapter.ViewHolder) holder).photo);

        ((cartAdapter.ViewHolder) holder).title.setText(arry.get(position).getName());
        ((cartAdapter.ViewHolder) holder).price.setText(arry.get(position).getPrice() + "kd");


        ((ViewHolder) holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = arry.get(position).getName();

                Query delt = dbRef.child("myCart").orderByChild("name").equalTo(name);

                delt.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot p :dataSnapshot.getChildren()){
                            p.getRef().removeValue();

                            notifyItemRemoved(position);
                        }

                        Snackbar snackbar = Snackbar.make(view,"item has been deleted", Snackbar.LENGTH_SHORT);
                        snackbar.show();



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });


    }

    @Override
    public int getItemCount() {
        return arry == null ? 0 : arry.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public Button clear;
        public TextView price;
        public TextView total;
        public ImageView photo;
        public ImageView delete;
        public View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            view = itemView;
            title = itemView.findViewById(R.id.textView2title);
            price = itemView.findViewById(R.id.textView5price);
            photo = itemView.findViewById(R.id.imageView7book);
            delete = itemView.findViewById(R.id.imageDelete);
            total = itemView.findViewById(R.id.textViewTotal);
        }
    }
}