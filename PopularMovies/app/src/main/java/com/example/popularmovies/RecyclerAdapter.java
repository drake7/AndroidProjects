package com.example.popularmovies;

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

import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<Movie> movieList;
    private Context context;

    public RecyclerAdapter(Context context, ArrayList<Movie> movieList) {
    this.context=context;
    this.movieList=movieList;
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
        Movie movie=movieList.get(i);
        viewHolder.rating.setText(movie.getRating()+"");
        viewHolder.title.setText(movie.getTitle().toString());
        viewHolder.detail.setText(movie.getOverview().toString());
        Picasso.get().load(movie.getPoster()).into(viewHolder.image);

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,DetailActivity.class);

                Bundle bundle= new Bundle();
                bundle.putString("title",movie.getTitle());
                bundle.putString("overview", movie.getOverview());
                bundle.putString("poster", movie.getPoster());
                bundle.putDouble("rating", movie.getRating());
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {

        return movieList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title;
        TextView detail;

        TextView rating;

        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.movie_title);
            detail = itemView.findViewById(R.id.movie_detail);

            rating = itemView.findViewById(R.id.movie_rating);
            cardView = itemView.findViewById(R.id.card_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Snackbar.make(v,"clicked detected  on item "+position,Snackbar.LENGTH_LONG)
                            .setAction("Action" ,null).show();
                }
            });


        }
    }

}
