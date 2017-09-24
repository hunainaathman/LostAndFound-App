package com.example.hunaina.lostandfound;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ReportFoundItem extends AppCompatActivity {

    private static final String SAVE_URL = "https://lostandfoundhk.000webhostapp.com/reportfounditem.php";

    public static final String KEY_NAME = "names";
    public static final String KEY_CONTACT = "contacts";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_ITEM = "item";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_LOCATION = "location";
    public static final String KEY_DATE = "date";


    private EditText etname;
    private EditText etcontact;
    private EditText etemail;
    private EditText etitem;
    private EditText etdes;
    private EditText etloc;
    private EditText etdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.report);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_report_found_item);

        etname = (EditText) findViewById(R.id.etname);
        etcontact = (EditText) findViewById(R.id.etcontact);
        etemail = (EditText) findViewById(R.id.etemail);
        etitem = (EditText)findViewById(R.id.etitem);
        etdes = (EditText) findViewById(R.id.etdes);
        etloc = (EditText) findViewById(R.id.etloc);
        etdate = (EditText) findViewById(R.id.etdate);


    }

    private void reportFoundItem() {
        final String names = etname.getText().toString().trim();
        final String contacts = etcontact.getText().toString().trim();
        final String email = etemail.getText().toString().trim();
        final String item = etitem.getText().toString().trim();
        final String description = etdes.getText().toString().trim();
        final String location = etloc.getText().toString().trim();
        final String date = etdate.getText().toString().trim();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, SAVE_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Toast.makeText(ReportFoundItem.this, response, Toast.LENGTH_LONG).show();
            }

        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ReportFoundItem.this, error.toString(), Toast.LENGTH_LONG).show();

                    }

                }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_NAME, names);
                params.put(KEY_CONTACT, contacts);
                params.put(KEY_EMAIL, email);
                params.put(KEY_ITEM, item);
                params.put(KEY_DESCRIPTION, description);
                params.put(KEY_LOCATION, location);
                params.put(KEY_DATE, date);
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.savetodb, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                reportFoundItem();
                ClearEditTextAfterDoneTask();
        }
        return true;
    }

    public void ClearEditTextAfterDoneTask() {
        etname.getText().clear();
        etcontact.getText().clear();
        etemail.getText().clear();
        etitem.getText().clear();
        etdes.getText().clear();
        etloc.getText().clear();
        etdate.getText().clear();
    }
}


