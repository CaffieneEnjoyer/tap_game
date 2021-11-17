package com.example.tapgamebass;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

public class CarActivity extends AppCompatActivity {
    private int mCount;
    private TextView mShowCount;

    MediaPlayer honk;
    MediaPlayer music3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        honk = MediaPlayer.create(CarActivity.this, R.raw.honk);
        music3 = MediaPlayer.create(CarActivity.this, R.raw.funkymusic);
        mShowCount = (TextView) findViewById(R.id.numberCar);
        music3.setLooping(true);
        music3.start();
    }


    public void onClickCar(View view) {
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = rootRef.child("int3").child(String.valueOf(mCount));
        userRef.child("int3").setValue(ServerValue.increment(1));
        mShowCount.setText(Integer.toString(mCount));
        honk.start();

    }

    public void onBackPressed() {
        super.onBackPressed();
        music3.release();

    }
}
