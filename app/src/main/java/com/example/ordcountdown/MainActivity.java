package com.example.ordcountdown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cn.iwgang.countdownview.CountdownView;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDatePicker = findViewById(R.id.btnDatePicker);
        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker= new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });

        // hard coding
        //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        // My ORD Time
        // String countDate = "01-07-2023";
        // Date now = new Date();
//
//        try{
//            // Formatting from String to Date
//            Date date = sdf.parse(countDate);
//            long currentTime = now.getTime();
//            long ordDate = date.getTime();
//            long countDownToORD = ordDate - currentTime;
//
//            myCountdownView.start(countDownToORD);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        String pickerDateString = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        TextView tvDatePicker = findViewById(R.id.tvDatePicker);
        CountdownView myCountdownView = findViewById(R.id.countdownView);

        try{
            tvDatePicker.setText(pickerDateString);
            Date now = new Date();

            long currentDate = now.getTime();
            long pickerDate = calendar.getTimeInMillis();
            long countDownToPickleDate = pickerDate - currentDate;
            myCountdownView.start(countDownToPickleDate);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}