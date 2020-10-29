package com.example.plantapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;

//import android.support.*;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plantapp.adapter.HerbsPlantAdapter;
import com.example.plantapp.adapter.PopularPlantAdapter;
import com.example.plantapp.model.HerbsPlant;
import com.example.plantapp.model.PopularPlant;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> items=new ArrayList<>();
    String[] send;
    RecyclerView popularRecycler;
    RecyclerView herbsRecycler;
    PopularPlantAdapter popularPlantAdapter;
    HerbsPlantAdapter herbsPlantAdapter;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<PopularPlant> popularPlantList = new ArrayList<>();
        final List<HerbsPlant> herbsPlantList = new ArrayList<>();

        popularPlantList.add(new PopularPlant("Bonsai", "Rs 80", R.drawable.popularfood1));
        popularPlantList.add(new PopularPlant("Champa", "Rs 90", R.drawable.popularfood2));
        popularPlantList.add(new PopularPlant("Peace Lily", "Rs 100", R.drawable.popularfood3));
        popularPlantList.add(new PopularPlant("Spider Plant", "Rs 80", R.drawable.popularfood4));
        popularPlantList.add(new PopularPlant("Champa", "Rs 90", R.drawable.popularfood2));
        popularPlantList.add(new PopularPlant("Peace Lily", "Rs 100", R.drawable.popularfood3));
        setPopularRecycler(popularPlantList);

        herbsPlantList.add(new HerbsPlant("Bonsai", "Rs 200", R.drawable.popularfood1,"***********","5.0"));
        herbsPlantList.add(new HerbsPlant("Africa Palm", "Rs 150", R.drawable.asiafood2,"***********","5.0"));
        herbsPlantList.add(new HerbsPlant("Gajar Ka Halwa", "Rs 200", R.drawable.popularfood1,"***********","5.0"));
        herbsPlantList.add(new HerbsPlant("Dal Ka Halwa", "Rs 150", R.drawable.asiafood2,"***********","5.0"));
        setHerbsRecycler(herbsPlantList);

       /* searchView=(SearchView)findViewById(R.id.search_it);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(popularPlantList.contains(query)){
                    popularPlantAdapter.filter(query);
                }
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
*/
    }

    private void setPopularRecycler(List<PopularPlant> popularPlantList) {
        popularRecycler = findViewById(R.id.popular_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        popularRecycler.setLayoutManager(layoutManager);
        popularPlantAdapter = new PopularPlantAdapter(this, popularPlantList);
        popularRecycler.setAdapter(popularPlantAdapter);
    }

    private void setHerbsRecycler(List<HerbsPlant> herbsPlantList) {
        herbsRecycler = findViewById(R.id.herbs_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        herbsRecycler.setLayoutManager(layoutManager);
        herbsPlantAdapter = new HerbsPlantAdapter(this,herbsPlantList);
        herbsRecycler.setAdapter(herbsPlantAdapter);
    }

    public void launchCart(View view) {
        Intent intent=new Intent(this,Cart.class);
        intent.putExtra("thisIsName","Null");
        intent.putExtra("thisIsPrice", "Rs 00");
        intent.putExtra("thisIsQuantity","0");
        //items.add("One");
        //items.add("Two");
      //  items.add("Three");
       // intent.putExtra("key",items);
        startActivity(intent);
    }

    public void launchVoice(View view) {
        startActivity(new Intent(Intent.ACTION_VOICE_COMMAND).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    public void launchDialer(View view) {
        Intent intent=new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0123456789"));
        startActivity(intent);
    }

    public void launch_Web(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.co.in/plants"));
        startActivity(intent);
    }
}



