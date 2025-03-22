package com.example.powandavg;

import android.annotation.SuppressLint;
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

public class MainActivity2 extends AppCompatActivity {
    TextView etextResult;

    Button mbtnhome;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etextResult=findViewById(R.id.txtResult);
        mbtnhome=findViewById(R.id.btnhome);
        Intent intent=getIntent();
        int num1=intent.getIntExtra("num1",0);
        int num2=intent.getIntExtra("num2",0);
        int f=intent.getIntExtra("f",0);
        if(f==1)
        {
            claculateAvg(num1,num2);
        }
        else
        {
            calculatePow(num1,num2);
        }

        mbtnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);


            }
        });
    }
    public void calculatePow(int num1,int num2)
    {
        int pow=(int) Math.pow(num1,num2);
        String res="Power:"+pow;
        etextResult.setText(res);
    }
    public void claculateAvg(int num1,int num2)
    {
        float avg=(num1+num2)/2;
        String res="Result: "+avg;
        etextResult.setText(res);
    }

}