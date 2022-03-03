package com.example.adapterviewflipperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterViewFlipper;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    AdapterViewFlipper adapterViewFlipper;

    CustomAdapter customAdapter;
    ArrayList<ItemsModel> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.adapterviewflipper);



      arrayList.add(new ItemsModel(R.drawable.afghanisthan,"Afganistan"));
      arrayList.add(new ItemsModel(R.drawable.americaflag,"America"));
      arrayList.add(new ItemsModel(R.drawable.bangladesh,"Bangladesh"));
      arrayList.add(new ItemsModel(R.drawable.bruini,"Bruini"));
      arrayList.add(new ItemsModel(R.drawable.canada,"Canada"));
      arrayList.add(new ItemsModel(R.drawable.china,"China"));
      arrayList.add(new ItemsModel(R.drawable.indiaflag,"India"));
      arrayList.add(new ItemsModel(R.drawable.egypt,"Egypt"));
      arrayList.add(new ItemsModel(R.drawable.japan,"Japan"));
      customAdapter=new CustomAdapter(this,arrayList);
   adapterViewFlipper.setAdapter(customAdapter);
     adapterViewFlipper.startFlipping();
     adapterViewFlipper.setFlipInterval(3000);


    }
}
