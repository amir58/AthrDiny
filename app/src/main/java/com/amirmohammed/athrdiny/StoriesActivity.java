package com.amirmohammed.athrdiny;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class StoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);

        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.story_1);
        images.add(R.drawable.story_2);
        images.add(R.drawable.story_3);
        images.add(R.drawable.story_4);
        images.add(R.drawable.story_5);
        images.add(R.drawable.story_6);
        images.add(R.drawable.story_7);
        images.add(R.drawable.story_8);
        images.add(R.drawable.story_9);

        ViewPager viewPager = findViewById(R.id.stories_view_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, images);
        viewPager.setAdapter(adapter);

    }


}