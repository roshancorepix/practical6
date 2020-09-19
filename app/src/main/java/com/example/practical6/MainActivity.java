package com.example.practical6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_dec, btn_inc;
    ProgressBar progressbar;
    int progress = 0;
    TextView tv_progress, tv_age,tv_rating;
    SeekBar seekbar;
    RatingBar rating_bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_inc = findViewById(R.id.btn_inc);
        btn_dec = findViewById(R.id.btn_dec);
        progressbar = findViewById(R.id.progress);
        tv_progress = findViewById(R.id.tv_progress);
        seekbar = findViewById(R.id.seekbar);
        tv_age = findViewById(R.id.tv_age);
        rating_bar = findViewById(R.id.rating_bar);
        tv_rating = findViewById(R.id.tv_rating);

        tv_progress.setText(String.valueOf(progressbar.getProgress()));

        btn_inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (progress < 100) {
                    progress += 5;
                    progressbar.setProgress(progress);
                    tv_progress.setText(String.valueOf(progressbar.getProgress()));
                } else {
                    Toast.makeText(MainActivity.this, "Progressbar is at max Progress", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (progress > 0) {
                    progress -= 5;
                    progressbar.setProgress(progress);
                    tv_progress.setText(String.valueOf(progressbar.getProgress()));
                } else {
                    Toast.makeText(MainActivity.this, "Progressbar is at minimum Progress", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tv_age.setText(String.valueOf(seekbar.getProgress()));
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv_age.setText(String.valueOf(seekbar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tv_age.setText(String.valueOf(seekbar.getProgress()));
            }
        });

        tv_rating.setText(String.valueOf(rating_bar.getRating()));
        rating_bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                tv_rating.setText(String.valueOf(ratingBar.getRating()));
            }
        });
    }
}