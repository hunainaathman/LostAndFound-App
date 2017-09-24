package com.example.hunaina.lostandfound;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Faq extends AppCompatActivity {
   private ListView listView1;
    private Button btnreply;
    private TextView tvqn;
    String Val;
    Bundle extras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.faq);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_faq);

        listView1 = (ListView)findViewById(R.id.listView1);

        FloatingActionButton FAB = (FloatingActionButton) findViewById(R.id.fab);
        FAB.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(Faq.this, Askedqn.class);
                startActivity(i);

            }
        });


    }

}
