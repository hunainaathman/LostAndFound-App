package com.example.hunaina.lostandfound;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class RetrieveFoundItem extends AppCompatActivity  {
    List<GetDataAdapter> DataAdapter1;

    RecyclerView recyclerView;

    RecyclerView.LayoutManager recyclerViewlayoutManager;

    RecyclerView.Adapter rVadapter;

    ProgressBar progressBar;

    String GET_JSON_DATA_HTTP_URL = "https://lostandfoundhk.000webhostapp.com/retrievefounditems.php";
    String JSON_NAMES = "names";
    String JSON_CONTACT = "contact";
    String JSON_EMAIL = "email";
    String JSON_ITEM = "item";
    String JSON_DESCRIPTION = "description";
    String JSON_LOCATION = "location";
    String JSON_DATE = "date";

    JsonArrayRequest jsonArrayRequest ;

    RequestQueue requestQueue ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.retrieve);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_retrive_found_item);

        DataAdapter1 = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);

        progressBar = (ProgressBar) findViewById(R.id.progressBar1);

        recyclerView.setHasFixedSize(true);

        recyclerViewlayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(recyclerViewlayoutManager);

        FloatingActionButton FAB = (FloatingActionButton) findViewById(R.id.fab);
        FAB.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(RetrieveFoundItem.this, ReportFoundItem.class);
                startActivity(i);

            }
        });


    }

    public void JSON_DATA_WEB_CALL(){

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        progressBar.setVisibility(View.GONE);

                        JSON_PARSE_DATA_AFTER_WEBCALL(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);
    }

    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array){

        for(int i = 0; i<array.length(); i++) {

            GetDataAdapter DataAdapter2 = new GetDataAdapter();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                DataAdapter2.setName(json.getString(JSON_NAMES));

                DataAdapter2.setItem(json.getString(JSON_ITEM));

                DataAdapter2.setDescription(json.getString(JSON_DESCRIPTION));

                DataAdapter2.setLocation(json.getString(JSON_LOCATION));

                DataAdapter2.setDate(json.getString(JSON_DATE));

            } catch (JSONException e) {

                e.printStackTrace();
            }
            DataAdapter1.add(DataAdapter2);
        }

        rVadapter = new RecyclerViewAdapter(DataAdapter1, this);

        recyclerView.setAdapter(rVadapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.refresh, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
                progressBar.setVisibility(View.VISIBLE);

                JSON_DATA_WEB_CALL();
        }
        return true;
    }
}
