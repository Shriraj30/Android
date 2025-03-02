/*<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical"
    >
    <EditText
        android:id="@+id/number1"
        android:hint="Enter the first number"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="numberDecimal"
        />
    <EditText
        android:id="@+id/number2"
        android:layout_marginTop="10dp"
        android:hint="Enter the second number"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="numberDecimal"
        />
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        >
        <Button
            android:id="@+id/addButton"
            android:text="Add"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:layout_height="wrap_content"/>
        <Button
            android:id="@+id/subButton"
            android:text="Subtract"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:layout_height="wrap_content"/>
        <Button
            android:id="@+id/mulButton"
            android:text="Multiply"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:layout_height="wrap_content"/>
        <Button
            android:id="@+id/divButton"
            android:text="Division"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:layout_height="wrap_content"/>

    </LinearLayout>

    <TextView
        android:id="@+id/result"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:textSize="20dp"
        android:background="@color/material_dynamic_neutral90"
        android:hint="Result will Shown here :"/>

</LinearLayout>
*/



package com.example.simplecalculater;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button addButton;
    Button subButton;
    Button mulButton;
    Button divButton;
    TextView result;
    EditText number1;
    EditText number2;


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

        number1=findViewById(R.id.number1);
        number2=findViewById(R.id.number2);
        addButton=findViewById(R.id.addButton);
        subButton=findViewById(R.id.subButton);
        mulButton=findViewById(R.id.mulButton);
        divButton=findViewById(R.id.divButton);
        result=findViewById(R.id.result);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1=Double.parseDouble(number1.getText().toString());
                double num2=Double.parseDouble(number2.getText().toString());

                double res=num1+num2;
                result.setText("Result : "+res);

            }
        });

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1=Double.parseDouble(number1.getText().toString());
                double num2=Double.parseDouble(number2.getText().toString());

                double res=num1-num2;
                result.setText("Result : "+res);

            }
        });

        mulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1=Double.parseDouble(number1.getText().toString());
                double num2=Double.parseDouble(number2.getText().toString());

                double res=num1*num2;
                result.setText("Result : "+res);

            }
        });

        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1=Double.parseDouble(number1.getText().toString());
                double num2=Double.parseDouble(number2.getText().toString());

                double res=num1/num2;
                result.setText("Result : "+res);

            }
        });


    }

}
