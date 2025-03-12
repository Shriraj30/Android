package com.example.activitysender;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText firstname,lastname,middlename,dateofbirth,email;
    Button mbtnSubmit;

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
        firstname=findViewById(R.id.firstname);
        lastname=findViewById(R.id.lastname);
        middlename=findViewById(R.id.middlename);
        dateofbirth=findViewById(R.id.dateofbirth);
        email=findViewById(R.id.email);
        mbtnSubmit=findViewById(R.id.btnSubmit);
        mbtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String efirstname=firstname.getText().toString();
                String elastname=lastname.getText().toString();
                String emiddlename=middlename.getText().toString();
                String edateofbirth=dateofbirth.getText().toString();
                String eemail=email.getText().toString();
                Intent intent=new Intent(MainActivity.this,secondactivity.class);
                intent.putExtra("firstname",efirstname);
                intent.putExtra("lastname",elastname);
                intent.putExtra("middlename",emiddlename);
                intent.putExtra("dateofbirth",edateofbirth);
                intent.putExtra("email",eemail);
                startActivity(intent);
            }
        });
    }
}