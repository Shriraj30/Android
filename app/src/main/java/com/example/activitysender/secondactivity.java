package com.example.activitysender;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class secondactivity extends AppCompatActivity {
    TextView mdetails;
    Button mbtnShowprevious;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);

        mdetails = findViewById(R.id.details);
        mbtnShowprevious = findViewById(R.id.btnShowprevious);

        // Retrieve data directly without an explicit Intent instance
        String details = "Student Details:\n\n" +
                "First Name: " + getIntent().getStringExtra("firstname") + "\n" +
                "Middle Name: " + getIntent().getStringExtra("middlename") + "\n" +
                "Last Name: " + getIntent().getStringExtra("lastname") + "\n" +
                "DOB: " + getIntent().getStringExtra("dateofbirth") + "\n" +
                "Email: " + getIntent().getStringExtra("email") ;

        mdetails.setText(details);

        // Button to go back
        mbtnShowprevious.setOnClickListener(v -> finish());
    }
}