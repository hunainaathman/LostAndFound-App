package com.example.hunaina.lostandfound;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Askedqn extends AppCompatActivity implements View.OnClickListener{

    Button btnpost;
    EditText etpostqn;
    String qnVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_askedqn);
        btnpost = (Button) findViewById(R.id.btnpost);
        etpostqn = (EditText) findViewById(R.id.etpostqn);
        btnpost.setOnClickListener(this);
    }
@Override
    public void onClick(View v) {
        if (v == btnpost) {
            Intent i = new Intent(getApplicationContext(), Faq.class);
            qnVal = etpostqn.getText().toString();
            Bundle b = new Bundle();
            b.putString("Value", qnVal);
            i.putExtras(b);
            startActivity(i);
        }
    }
}
