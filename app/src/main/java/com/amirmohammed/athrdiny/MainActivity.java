package com.amirmohammed.athrdiny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void openStories(View view) {
        startActivity(new Intent(this, StoriesActivity.class));
    }











    public void openPaint(View view) {
        startActivity(new Intent(this, PaintListActivity.class));
    }
}