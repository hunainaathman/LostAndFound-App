package com.example.hunaina.lostandfound;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity implements View.OnClickListener{

        TextView txtli, txtfi, txttv, txtfaq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtli = (TextView) findViewById(R.id.txtli);
        txtfi = (TextView) findViewById(R.id.txtfi);
        txttv = (TextView) findViewById(R.id.txttv);
        txtfaq = (TextView) findViewById(R.id.txtfaq);

        txtli.setOnClickListener(this);
        txtfi.setOnClickListener(this);
        txttv.setOnClickListener(this);
        txtfaq.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == txtli){
            Intent i = new Intent(this, RegisterLostItem.class);
            startActivity(i);
        }
        else if (v == txtfi){
            Intent i = new Intent(this, ReportFoundItem.class);
            startActivity(i);
        }
        else if (v == txttv){
            Intent i = new Intent(this, RetrieveLostItem.class);
            startActivity(i);
        }
        else if (v == txtfaq){
            Intent i = new Intent(this, RetrieveFoundItem.class);
            startActivity(i);
        }

    }
}
