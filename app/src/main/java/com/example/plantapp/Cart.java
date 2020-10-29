package com.example.plantapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import com.example.plantapp.model.PopularPlant;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity {
    TextView things;
    TextView zigzag;
    TextView name;
    TextView quantity;
    TextView price;
    ListView simpleList;
    String callMe,priceMe;
    EditText a,b,c;
    String e,f,g,h,killer;
   Integer finalCost=0,finalPrice=0,databaseQuant=0,finalQuantity=0;
Integer cost=0;
Integer i=0;
String log;
String practise;
    DatabaseHandler db = new DatabaseHandler(this);
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);



        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<PopularPlant> contacts = db.getAllContacts();

//        String[] myArray = new String[contacts.size()];
       // contacts.toArray(myArray);

        //String[] Zigarray;//=new String[myArray.length];


        //things.setText(String.valueOf(numberList));
ArrayList<String> mangoes =new ArrayList<String>();
       for (PopularPlant cn : contacts) {
           practise=cn.getPrice();
           log =  " Name: " + String.valueOf(cn.getName() )+ " Price pp: " +practise + " Quantity: "+String.valueOf(cn.getQuantity());
           //     log =  " Name: " + String.valueOf(cn.getName() )+ " Price pp: " + String.valueOf(cn.getPrice()) + " Quantity: "+String.valueOf(cn.getQuantity());
            mangoes.add(log);
            log="";
           String databasePrice=practise.replace("Rs ","0");
          // String databasePrice=String.valueOf(cn.getPrice()).replace("Rs ","0");
           finalPrice=Integer.parseInt(databasePrice);
           databaseQuant=Integer.parseInt(cn.getQuantity());
           finalQuantity=finalQuantity+databaseQuant;
           finalCost=finalCost+(finalPrice*databaseQuant);
          //  new (String Zigarray[i])=log;
            //zigzag=findViewById(R.id.data_frombase);
            //zigzag.setText(log);
          //  i++;
            //System.out.print(Zigarray[i]);
            // Writing Contacts to log
        //  Log.d("Name: ", log);
        }
        String[] mangoesArray = new String[mangoes.size()];
         mangoes.toArray(mangoesArray);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_list_view,R.id.tview ,mangoesArray);
        ListView listView = (ListView) findViewById(R.id.pinky);
        listView.setAdapter(adapter);

        builder = new AlertDialog.Builder(this);

        String myName= getIntent().getStringExtra("thisIsName");
        String myPrice = getIntent().getStringExtra("thisIsPrice");
        String myQuantity = getIntent().getStringExtra("thisIsQuantity");
/*

        name = findViewById(R.id.cart_items);
        name.setText(myName);
        callMe=myName;
        h=myQuantity;
        //priceMe=myPrice;
       String originalPrice=myPrice.replace("Rs ","0");

     // assert myPrice != null;
     //   String  chika= null;
       // if (myPrice != null) {
         //   chika = myPrice.substring(3,5);
       // }
//Integer size=originalPrice.length();

       cost=Integer.parseInt(originalPrice)*Integer.parseInt(myQuantity);
        priceMe=String.valueOf(cost);*/
        price = findViewById(R.id.cart_price);
        price.setText("Total : Rs "+String.valueOf(finalCost));
        quantity=findViewById(R.id.cart_items);
        quantity.setText("Quantity : "+String.valueOf(finalQuantity));

        a=findViewById(R.id.per_name);
        b=findViewById(R.id.per_phone);
        c=findViewById(R.id.per_address);




        //killer=e+"\n"+callMe+"\n"+priceMe+"\n"+f+"\n"+g;
        //  String imageName = getIntent().getStringExtra("image_name");

       // String imagePrice = getIntent().getStringExtra("image_price");


       // things = findViewById(R.id.cart_items);
       /* ArrayList<String> numberList = (ArrayList<String>) getIntent().getSerializableExtra("key");
        String[] myArray = new String[numberList.size()];
        numberList.toArray(myArray);
*/
       /* ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_cart, myArray);
        ListView listView = (ListView) findViewById(R.id.pinky);
        listView.setAdapter(adapter);
        //things.setText(String.valueOf(numberList));
        */
      /*  simpleList=(ListView)findViewById(R.id.pinky);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.activity_list_view,R.id.tview,myArray);
        simpleList.setAdapter(arrayAdapter);*/
    /*   String imageName = getIntent().getStringExtra("image_name");
        name = findViewById(R.id.cart_items);
        name.setText(imageName);
        String imagePrice = getIntent().getStringExtra("image_price");
        price = findViewById(R.id.cart_price);
        price.setText(imagePrice);*/

    }



    public void orderAlert(View view) {
        e=a.getText().toString();
        f=b.getText().toString();
        g=c.getText().toString();
   //     builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);
        killer="Name : "+e+"\nQuantity : "+String.valueOf(finalQuantity)+"\nTotal : Rs "+String.valueOf(finalCost)+"\nPh : "+f+"\nAddr : "+g;
        //Setting message manually and performing action on button click
        builder.setMessage(killer)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        /*    Intent intent=new Intent(this,Cart.class);
                        intent.putExtra("det_name",e);
                        intent.putExtra("det_phone", f);
                        intent.putExtra("det_address",g);
                        intent.putExtra("det_cost",String.valueOf(cost));
                        intent.putExtra("det_dish",callMe);
                        startActivity(intent);*/
                      // finish();
                        Intent intent=new Intent(getBaseContext(),MainActivity.class);
                        Toast.makeText(getApplicationContext(),"Order Placed",
                                Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        db.deleteAllContacts();
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                        Toast.makeText(getApplicationContext(),"ReEnter Data",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("Order Placed Successfully");
        alert.show();
    }

    public void clearOrder(View view) {
        db.deleteAllContacts();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}