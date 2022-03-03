package com.example.adapterviewflipperapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter {
  Context context;
  ArrayList<ItemsModel> arrayList;


    public CustomAdapter(@NonNull Context context,ArrayList<ItemsModel> arrayList) {
        super(context,R.layout.items);
        this.context=context;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v =LayoutInflater.from(context).inflate(R.layout.items,parent,false);
        ImageView imageView = (ImageView) v.findViewById(R.id.flagimage);
        TextView textView = (TextView) v.findViewById(R.id.flagname);

        imageView.setImageResource(arrayList.get(position).getFlagimage());
        textView.setText(arrayList.get(position).getFlagname());
        return v;

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }
}
