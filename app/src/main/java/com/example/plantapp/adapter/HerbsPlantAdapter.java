package com.example.plantapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plantapp.MainActivity;
import com.example.plantapp.Next;
import com.example.plantapp.R;
import com.example.plantapp.model.HerbsPlant;
import com.example.plantapp.model.PopularPlant;

import java.util.List;

public class HerbsPlantAdapter extends RecyclerView.Adapter<HerbsPlantAdapter.HerbsPlantViewHolder> {

    Context context;
    List<HerbsPlant> herbsPlantList;

    public HerbsPlantAdapter(Context context, List<HerbsPlant> herbsPlantList) {
        this.context = context;
        this.herbsPlantList = herbsPlantList;
    }




    @NonNull
    @Override
    public HerbsPlantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.herbs_food_row_item,parent,false);
        return new HerbsPlantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HerbsPlantViewHolder holder, final int position) {
        holder.foodImage.setImageResource(herbsPlantList.get(position).getImageUrl());
        holder.name.setText(herbsPlantList.get(position).getName());
        holder.price.setText(herbsPlantList.get(position).getPrice());
        holder.rating.setText(herbsPlantList.get(position).getRating());
        holder.restaurantName.setText(herbsPlantList.get(position).getRestaurantname());


        holder.itemView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                //Magick Here
                Intent intent = new Intent(context, Next.class);
                // intent.putExtra("image_name",popularPlantList.get(position));
                intent.putExtra("image_name", String.valueOf(herbsPlantList.get(position).getName()));
                intent.putExtra("image_price", String.valueOf(herbsPlantList.get(position).getPrice()));
                intent.putExtra("image_photo", String.valueOf(herbsPlantList.get(position).getImageUrl()));
                context.startActivity(intent);
            }
        });

    }

    /*@Override
    public void onBindViewHolder(@NonNull PopularPlantAdapter holder, int position) {
        holder.foodImage.setImageResource(popularPlantList.get(position).getImageUrl());
        holder.name.setText(popularPlantList.get(position).getName())
        holder.price.setText(popularPlantList.get(position).getPrice());

    }
*/
    @Override
    public int getItemCount() {
        return herbsPlantList.size();
    }

    public static final class HerbsPlantViewHolder extends RecyclerView.ViewHolder{
        ImageView foodImage;
        TextView price,name,rating,restaurantName;
        public HerbsPlantViewHolder(@NonNull View itemView){
            super(itemView);

            foodImage=itemView.findViewById(R.id.food_image);
            price=itemView.findViewById(R.id.price);
            name=itemView.findViewById(R.id.name);
            rating=itemView.findViewById(R.id.rating);
            restaurantName=itemView.findViewById(R.id.restaurantName);


        }
    }
}
