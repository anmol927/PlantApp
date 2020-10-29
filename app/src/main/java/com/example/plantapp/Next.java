package com.example.plantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.plantapp.model.PopularPlant;

public class Next extends AppCompatActivity {
    int i=0;
    TextView name;
    TextView price;
    ImageView dishImage;
    String sendName;
    String sendPrice;
    String sendQuantity;
    String z="";
    TextView disp;

    DatabaseHandler db = new DatabaseHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        // Inserting Contacts
        //Log.d("Insert: ", "Inserting ..");
      //  db.addContact(new PopularPlant("Ravi", "9100000000"));
       // db.addContact(new PopularPlant("Srinivas", "9199999999"));
        //db.addContact(new PopularPlant("Tommy", "9522222222"));
        //db.addContact(new PopularPlant("Karthik", "9533333333"));


        setContentView(R.layout.activity_next);
        String foodName = getIntent().getStringExtra("image_name");
        sendName=foodName;
        name = findViewById(R.id.dish_name);
        name.setText(foodName);
      String imagePrice = getIntent().getStringExtra("image_price");
      sendPrice=imagePrice;
        price = findViewById(R.id.dish_price);
        price.setText(imagePrice);
       String picture=getIntent().getStringExtra("image_photo");
        dishImage=findViewById(R.id.dish_pic);
        dishImage.setImageResource(Integer.parseInt(picture));
    }




    public void incrementCount(View view) {
    i=i+1;
        disp = findViewById(R.id.dish_count);
       z=String.valueOf(i);
        disp.setText(z);
    }

    public void addToCart(View view) {
             db.addContact(new PopularPlant(sendName, sendPrice,z));
        Toast.makeText(getApplicationContext(),"Added to Cart",
                Toast.LENGTH_SHORT).show();


    }
    public void launchCart(View view) {
        Intent intent=new Intent(this,Cart.class);
        intent.putExtra("thisIsName",sendName);
        intent.putExtra("thisIsPrice", sendPrice);
        intent.putExtra("thisIsQuantity",z);
        //items.add("One");
        //items.add("Two");
        //  items.add("Three");
        // intent.putExtra("key",items);
        startActivity(intent);
    }

    public void decrementCount(View view) {
        i=i-1;
        if(i<0){i=0;}
        disp = findViewById(R.id.dish_count);
   z=String.valueOf(i);
        disp.setText(z);
    }
}