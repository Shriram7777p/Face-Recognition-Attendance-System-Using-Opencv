package com.example.aiattendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button b1,b2,b3,b4,b5,b6,b7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        b1=findViewById(R.id.h1);
        b2=findViewById(R.id.h2);
        b3=findViewById(R.id.h3);
        b4=findViewById(R.id.h4);
        b5=findViewById(R.id.h5);
        b6=findViewById(R.id.h6);
        b7=findViewById(R.id.h7);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"1st Hour",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), userlist.class));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"2nd Hour",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), class_2.class));
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"3rd Hour",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), class_3.class));
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"4th Hour",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), class_4.class));
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"5th Hour",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), class_5.class));
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"6th Hour",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), class_6.class));
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"7th Hour",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), class_7.class));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        int id = menuItem.getItemId();
        if (id==R.id.logout){
            Toast.makeText(getApplicationContext(),"Logout",Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(),signin.class));
        }
        if (id==R.id.adduse){
            Toast.makeText(getApplicationContext(),"Add User",Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(),signup.class));
        }
        return true;
    }
}