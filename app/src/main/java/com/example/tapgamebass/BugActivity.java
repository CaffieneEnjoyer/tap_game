package com.example.tapgamebass;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

public class BugActivity extends AppCompatActivity {
    private int mCount;
    private TextView mShowCount;

    MediaPlayer chirp;
    MediaPlayer music2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bug);

        chirp = MediaPlayer.create(BugActivity.this, R.raw.bugnoise);
        music2 = MediaPlayer.create(BugActivity.this, R.raw.forestmusic);
        mShowCount = (TextView) findViewById(R.id.numberBug);
        music2.setLooping(true);
        music2.start();
    }


    public void onClickBug(View view) {
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = rootRef.child("int2").child(String.valueOf(mCount));
        userRef.child("int2").setValue(ServerValue.increment(1));
        mShowCount.setText(Integer.toString(mCount));
        chirp.start();

    }

    public void onBackPressed() {
        super.onBackPressed();
        music2.release();

    }
}
