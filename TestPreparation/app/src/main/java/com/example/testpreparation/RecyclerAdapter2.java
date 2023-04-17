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
public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.ViewHolder1> {

    // Array of titles for the RecyclerView items
    private String[] titles = {"Coffee", "Coffee1", "coffee2"};

    private String[] titles1 = {"food1", "food2", "food3"};

    private String[] titles2 = {"drink1", "drink2", "drink3"};

    // Array of details for the RecyclerView items
    private String[] details = {"Item one details", "Item two details", "Item three details", "Item four details", "Item five details"};

    // ImageView for the item top
    ImageView imageTop;
    int itemType;

    public RecyclerAdapter2(int itemType) {
        this.itemType = itemType;
    }

    // Method to create a new ViewHolder object for each item in the RecyclerView
    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Inflate the layout for each item
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card, viewGroup, false);

        // Return a new ViewHolder object that holds the inflated layout
        ViewHolder1 viewHolder = new ViewHolder1(v);

        return viewHolder;
    }


    // Method to bind data to each view in the ViewHolder object
    public void onBindViewHolder(@NonNull ViewHolder1 viewHolder, int i) {
        // Set the title text of the TextView in each card layout to the corresponding item from the titles array
        if(itemType == 0) {
            viewHolder.itemTitle.setText(titles[i]);
        }
        if(itemType == 1) {
            viewHolder.itemTitle.setText(titles1[i]);
        }
        if(itemType == 2)
        {   viewHolder.itemTitle.setText(titles2[i]);}
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
    public class ViewHolder1 extends RecyclerView.ViewHolder {
        // Views for the item image, title, detail, and top
        ImageView itemImage;
        TextView itemTitle;
        TextView itemDetail;
        ImageView itemTop;

        // Constructor that initializes the views for each item
        public ViewHolder1(@NonNull View itemView) {
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
                    System.out.println("***************************"+position);
                    // Show a Snackbar with the position of the clicked item
                    Snackbar.make(v, "clicked detected on item " + position, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                    // Call a method in the MainActivity to update the image on the top of the screen
                   // ((SecondActivity) v.getContext())(position);
                }
            });
        }
    }
}
