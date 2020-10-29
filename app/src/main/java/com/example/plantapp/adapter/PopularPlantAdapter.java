package com.example.plantapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plantapp.Next;
import com.example.plantapp.R;
import com.example.plantapp.model.PopularPlant;

import java.util.List;
import java.util.Locale;

public class PopularPlantAdapter extends RecyclerView.Adapter<PopularPlantAdapter.PopularPlantViewHolder> {

    Context context;
    List<PopularPlant> popularPlantList;
    //TextView titleView;

    public PopularPlantAdapter(Context context, List<PopularPlant> popularPlantList) {
        this.context = context;
        this.popularPlantList = popularPlantList;
    }






    @NonNull
    @Override
    public PopularPlantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_food_row_item,parent,false);
        return new PopularPlantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularPlantViewHolder holder, final int position) {
        holder.foodImage.setImageResource(popularPlantList.get(position).getImageUrl());
        holder.name.setText(popularPlantList.get(position).getName());
        holder.price.setText(popularPlantList.get(position).getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                //Magick Here
                Intent intent = new Intent(context, Next.class);
              // intent.putExtra("image_name",popularPlantList.get(position));
               intent.putExtra("image_name", String.valueOf(popularPlantList.get(position).getName()));
               intent.putExtra("image_price", String.valueOf(popularPlantList.get(position).getPrice()));
               intent.putExtra("image_photo", String.valueOf(popularPlantList.get(position).getImageUrl()));
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
        return popularPlantList.size();
    }

    public  final class PopularPlantViewHolder extends RecyclerView.ViewHolder{
        ImageView foodImage;
        TextView price,name;
        public PopularPlantViewHolder(@NonNull View itemView){
            super(itemView);

           // titleView=itemView.findViewById(R.id.name);
            foodImage=itemView.findViewById(R.id.food_image);
            price=itemView.findViewById(R.id.price);
            name=itemView.findViewById(R.id.name);

        }
    }

}
