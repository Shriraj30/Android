package com.example.palindroneapp;

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
    EditText edtGetnum;
    Button btnShowResult;
    TextView lblResult;

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
        btnShowResult=findViewById(R.id.btnShowResult);
        lblResult=findViewById(R.id.lblResult);
        edtGetnum=findViewById(R.id.edtGetnum);

        btnShowResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num=Integer.parseInt(edtGetnum.getText().toString());
                int temp=num,rev,sum=0;
                while (num>0)
                {
                    rev=num%10;
                    num=num/10;
                    sum=sum*10+rev;
                }
                if(temp==sum)
                    lblResult.setText("Number is Palindrone");
                else
                    lblResult.setText("Number is not palindrone");
            }
        });

    }
    }
