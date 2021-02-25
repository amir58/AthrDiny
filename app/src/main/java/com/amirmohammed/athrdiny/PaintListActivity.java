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
        images.add(R.drawable.test2);
        images.add(R.drawable.painting1);
        images.add(R.drawable.painting2);
        images.add(R.drawable.painting3);
        images.add(R.drawable.painting4);
        images.add(R.drawable.painting5);
        images.add(R.drawable.painting6);
        images.add(R.drawable.painting7);
        images.add(R.drawable.painting8);
        images.add(R.drawable.painting9);
        images.add(R.drawable.painting10);
        images.add(R.drawable.painting11);
        images.add(R.drawable.painting12);
        images.add(R.drawable.painting13);
        images.add(R.drawable.painting14);
        images.add(R.drawable.painting15);
        images.add(R.drawable.painting16);
        images.add(R.drawable.painting17);
        images.add(R.drawable.painting18);
        images.add(R.drawable.painting19);
        images.add(R.drawable.painting20);


        RecyclerView recyclerView = findViewById(R.id.paint_image_recycler_view);
        recyclerView.setAdapter(new PaintImagesAdapter(images));

    }

}