package com.example.testpreparation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

// RecyclerView Adapter class to bind data to views in a RecyclerView
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    // Array of titles for the RecyclerView items
    private String[] titles = {"food", "drink", "mains"};



    // Array of details for the RecyclerView items
    private String[] details = {"Item one details", "Item two details", "Item three details", "Item four details", "Item five details"};

    // ImageView for the item top
    ImageView imageTop;

    // Method to create a new ViewHolder object for each item in the RecyclerView
    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Inflate the layout for each item
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card, viewGroup, false);

        // Return a new ViewHolder object that holds the inflated layout
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    // Method to bind data to each view in the ViewHolder object
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        // Set the title text of the TextView in each card layout to the corresponding item from the titles array
        viewHolder.itemTitle.setText(titles[i]);
        // Uncomment the following lines to set the details and image for each item
        // viewHolder.itemDetail.setText(details[i]);
        // viewHolder.itemImage.setImageResource(images[i]);
    }

    // Method to get the number of items in the dataset
    @Override
    public int getItemCount() {
        return titles.length;
    }

    // ViewHolder class to hold the views for each item in the RecyclerView
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Views for the item image, title, detail, and top
        ImageView itemImage;
        TextView itemTitle;
        TextView itemDetail;
        ImageView itemTop;

        // Constructor that initializes the views for each item
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize the ImageView and TextView objects for the item title and top
            itemTop = itemView.findViewById(R.id.imageView);
            itemTitle = itemView.findViewById(R.id.item_title);

            // Set an OnClickListener for each item in the RecyclerView
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Get the position of the clicked item
                    int position = getAdapterPosition();

                    // Show a Snackbar with the position of the clicked item
                    Snackbar.make(v, "clicked detected on item " + position, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                    // Call a method in the MainActivity to update the image on the top of the screen
                    ((MainActivity) v.getContext()).setItemTopImage(position);
                }
            });
        }
    }
}
