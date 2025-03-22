package com.example.powandavg;

import android.annotation.SuppressLint;
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
    EditText edtnum1,edtnum2;
    Button mbtnpow,mbtnavg;

    @SuppressLint("MissingInflatedId")
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
        mbtnpow=findViewById(R.id.btnpow);
        mbtnavg=findViewById(R.id.btnavg);
        edtnum1=findViewById(R.id.edtnum1);
        edtnum2=findViewById(R.id.edtnum2);


        mbtnpow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                int num1=Integer.parseInt(edtnum1.getText().toString());
                int num2=Integer.parseInt(edtnum2.getText().toString());
                intent.putExtra("num1",num1);
                intent.putExtra("num2",num2);
                intent.putExtra("f",0);
                startActivity(intent);

            }
        });
        mbtnavg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                int num1=Integer.parseInt(edtnum1.getText().toString());
                int num2=Integer.parseInt(edtnum2.getText().toString());
                intent.putExtra("num1",num1);
                intent.putExtra("num2",num2);
                intent.putExtra("f",1);
                startActivity(intent);


            }
        });
    }
}