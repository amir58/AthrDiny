package com.amirmohammed.athrdiny;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class PaintListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint_list);

        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.test);
        images.add(R.drawable.paint2);
        images.add(R.drawable.paint3);
        images.add(R.drawable.paint4);
        images.add(R.drawable.paint5);
        images.add(R.drawable.paint6);
        images.add(R.drawable.paint7);
        images.add(R.drawable.paint8);
        images.add(R.drawable.paint9);
        images.add(R.drawable.paint10);
        images.add(R.drawable.paint11);
        images.add(R.drawable.paint12);
        images.add(R.drawable.paint13);
        images.add(R.drawable.paint14);
        images.add(R.drawable.paint15);

        RecyclerView recyclerView = findViewById(R.id.paint_image_recycler_view);
        recyclerView.setAdapter(new PaintImagesAdapter(images));

    }

}