package com.example.tapgamebass;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void onClickFishEntry (View view){
        startActivity(new Intent(MainActivity.this, FishActivity.class));
    }
    public void onClickBugEntry (View view){
        startActivity(new Intent(MainActivity.this, BugActivity.class));
    }
    public void onClickCarEntry (View view){
        startActivity(new Intent(MainActivity.this, CarActivity.class));
    }


}


