package com.example.imagesapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<Item> itemList;
    private Context context;

    public RecyclerAdapter(Context context, ArrayList<Item> itemList) {
        this.context=context;
        this.itemList=itemList;
    }

    public RecyclerAdapter() {

    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card, viewGroup, false);
        ViewHolder viewHolder =  new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Item item=itemList.get(i);
        viewHolder.setLikes(item.getNumberOfLikes());
        viewHolder.setTags((item.getTags()));
        viewHolder.setImageView(item.getImageUrl());
    }

    @Override
    public int getItemCount() {

        return itemList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView mtags;
        TextView mlikes;
        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

        public void setImageView(String url) {
            image = view.findViewById(R.id.imageView);
            Glide.with(context).load(url).into(image);
        }

        public void setLikes(int likes)
        {
        mlikes = view.findViewById(R.id.likes);
        mlikes.setText(likes+"");
        }

        public void setTags(String tags)
        {
            mtags = view.findViewById(R.id.tags);
            mtags.setText(tags);
        }


        }
    }
