package com.example.androidstopwatch;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    Button start, stop, reflesh;

    int deger = 0;
    long timeDifference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        reflesh = findViewById(R.id.reflesh);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(deger == 0) {
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.start();
                } else if (deger == 2) {
                    chronometer.setBase(chronometer.getBase() + SystemClock.elapsedRealtime() - timeDifference);
                    chronometer.start();
                }
                stop.setEnabled(true);
                deger = 1;
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(deger == 1){
                    timeDifference = SystemClock.elapsedRealtime();
                    chronometer.stop();
                    deger = 2;
                }

            }
        });

        reflesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                deger = 1;

            }
        });
    }
}