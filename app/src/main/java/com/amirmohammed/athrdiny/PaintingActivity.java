package com.amirmohammed.athrdiny;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.thebluealliance.spectrum.SpectrumPalette;

public class PaintingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painting);

        SpectrumPalette spectrumPalette = findViewById(R.id.painting_colors);
        spectrumPalette.setOnColorSelectedListener(new SpectrumPalette.OnColorSelectedListener() {
            @Override
            public void onColorSelected(int color) {
                PaintView.color = color;
            }
        });

    }

}