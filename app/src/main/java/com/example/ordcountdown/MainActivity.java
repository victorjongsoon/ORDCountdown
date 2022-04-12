package com.example.ordcountdown;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.iwgang.countdownview.CountdownView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountdownView myCountdownView = findViewById(R.id.countdownView);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        // My ORD Time
        String countDate = "01-07-2023";
        Date now = new Date();

        try{
            // Formatting from String to Date
            Date date = sdf.parse(countDate);
            long currentTime = now.getTime();
            long ordDate = date.getTime();
            long countDownToORD = ordDate - currentTime;

            myCountdownView.start(countDownToORD);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}