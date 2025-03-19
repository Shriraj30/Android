package com.example.sqlitedemo;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button mbtnInsert, mbtnupdate, mbtnDelete, mbtnView;
    EditText medtName, medtDob, medtContact;


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

        mbtnInsert=findViewById(R.id.btnInsert);
        mbtnupdate=findViewById(R.id.btnUpdate);
        mbtnDelete=findViewById(R.id.btnDelete);

        medtName = findViewById(R.id.edtName);
        medtContact = findViewById(R.id.edtContact);
        medtDob = findViewById(R.id.edtDob);
        mbtnView = findViewById(R.id.btnView);
        DatabaseHandler db = new DatabaseHandler(this);

        mbtnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nametxt = medtName.getText().toString();
                String dobtxt = medtDob.getText().toString();
                String contacttxt = medtContact.getText().toString();

                Boolean insertresult = db.insertdata(nametxt, contacttxt, dobtxt);
                if (insertresult == true) {
                    Toast.makeText(MainActivity.this, "Inserted Successfully", Toast.LENGTH_LONG).show();
                }
            }
        });

        mbtnupdate.setOnClickListener(view -> {
            String nametxt = medtName.getText().toString();
            String dobtxt = medtDob.getText().toString();
            String contacttxt = medtContact.getText().toString();

            if (nametxt.isEmpty() || dobtxt.isEmpty() || contacttxt.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            Boolean updateResult = db.updateData(nametxt, contacttxt, dobtxt);
            if (updateResult) {
                Toast.makeText(MainActivity.this, "Updated Successfully", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "Error in Updating", Toast.LENGTH_LONG).show();
            }
        });

        // Delete data
        mbtnDelete.setOnClickListener(view -> {
            String nametxt = medtName.getText().toString();

            if (nametxt.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter the name to delete", Toast.LENGTH_SHORT).show();
                return;
            }

            Boolean deleteResult = db.deleteData(nametxt);
            if (deleteResult) {
                Toast.makeText(MainActivity.this, "Deleted Successfully", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "Error in Deleting", Toast.LENGTH_LONG).show();
            }
        });

        mbtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res=db.getdata();
                if(res.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(),"noentry exists",Toast.LENGTH_LONG).show();
                    return;

                }
                StringBuffer buffer=new StringBuffer();
                while(res.moveToNext())
                {
                    buffer.append("Name:"+res.getString(0)+"\n");
                    buffer.append("Contact:"+res.getString(1)+"\n");
                    buffer.append("Date of Birth:"+res.getString(2)+"\n\n");

                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("User entries");
                    builder.setMessage(buffer.toString());
                    builder.show();


/*
                    String contact=res.getString(1).toString();
                    Log.d("Contact No....",contact);
                    */

                }
                Toast.makeText(MainActivity.this, buffer, Toast.LENGTH_SHORT).show();
            }
        });
    }

}