<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <DatePicker
        android:id="@+id/SimpleDatePicker"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="#150"
        android:datePickerMode="spinner"
        />
    <Button
        android:id="@+id/btnSubmit"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_below="@+id/SimpleDatePicker"
        android:layout_margin="50dp"
        android:text="Submit"
        android:textColor="#fff"
        android:textSize="20sp"
        android:background="#150"
        />

</RelativeLayout>


package com.example.datepicker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.Month;

public class MainActivity extends AppCompatActivity {
    DatePicker SimpleDatePicker;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SimpleDatePicker=findViewById(R.id.SimpleDatePicker);
        btnSubmit=findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Day="Day is:"+SimpleDatePicker.getDayOfMonth();

                String Month="Month is:"+SimpleDatePicker.getMonth();

                String Year="Year is:"+SimpleDatePicker.getYear();

                Toast.makeText(MainActivity.this,Day+"\n"+ Month+"\n"+Year,Toast.LENGTH_LONG).show();

            }
        });
    }
}  
  
