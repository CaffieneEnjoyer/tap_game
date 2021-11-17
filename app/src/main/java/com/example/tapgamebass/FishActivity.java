package com.example.tapgamebass;


import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;



public class FishActivity extends AppCompatActivity {

    private int mCount;
    private TextView mShowCount;

    MediaPlayer pop;
    MediaPlayer music;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish);


        pop = MediaPlayer.create(FishActivity.this, R.raw.pop);
        music = MediaPlayer.create(FishActivity.this, R.raw.elevatormusic);
        mShowCount = (TextView) findViewById(R.id.numberFish);
        music.setLooping(true);
        music.start();
    }
    public void onBackPressed() {
        super.onBackPressed();
        music.release();

    }

    public void onClickFish(View view) {

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = rootRef.child("int1").child(String.valueOf(mCount));
        userRef.child("int1").setValue(ServerValue.increment(1));
        mShowCount.setText(Integer.toString(mCount));
        pop.start();

       // ref.child("int1").addValueEventListener(new ValueEventListener() {
          //  @Override
           // public void onDataChange(DataSnapshot int1) {
             //   int intVal = Integer.valueOf(String.valueOf(int1.getValue()));
               // Toast.makeText(FishActivity.this, intVal, Toast.LENGTH_SHORT).show();


                // Attach a listener to read the data at our posts reference
        //ref.addValueEventListener(new ValueEventListener() {
          ///  @Override
            //public void onDataChange(DataSnapshot dataSnapshot) {
               // intread1 mCount = dataSnapshot.getValue(intread1.class);
                //System.out.println(mCount);
            }


           // @Override
            //public void onCancelled(DatabaseError databaseError) {
              // System.out.println("The read failed: " + databaseError.getCode());
            }
        //});

   // }
//}

