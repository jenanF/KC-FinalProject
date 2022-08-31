package com.example.myfinalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class secAdapter extends ArrayAdapter {

    List<Sections> listy;

    public secAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);

        listy=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.sections_card,parent, false);

        Sections currntItem = listy.get(position);

        ImageView back= view.findViewById(R.id.imageViewback);

        back.setImageResource(currntItem.getImage());

        return view;

    }
}
