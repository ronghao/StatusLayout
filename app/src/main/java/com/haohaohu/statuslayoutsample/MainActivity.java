package com.haohaohu.statuslayoutsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.haohaohu.statuslayoutsample.imp.DefaultActivity;
import com.haohaohu.statuslayoutsample.imp.DefaultStatusProgressActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBaseClick(View view) {
        Intent intent = new Intent(MainActivity.this, BaseStatusActivity.class);
        startActivity(intent);
    }

    public void onDefaultClick(View view) {
        Intent intent = new Intent(MainActivity.this, DefaultActivity.class);
        startActivity(intent);
    }

    public void onDefaultProgressClick(View view) {
        Intent intent = new Intent(MainActivity.this, DefaultStatusProgressActivity.class);
        startActivity(intent);
    }
}
