package com.example.testapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.models.PieModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class statelsit extends AppCompatActivity
{    private TextView textView2;
     private ListView listView;
     private SimpleArcLoader simpleArcLoader2;

     public static List<StateModel> stateModelList=new ArrayList<>();
     StateModel stateModel;
     MyCustomeAdapter myCustomeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statelsit);
        textView2=(TextView)findViewById(R.id.textView2);
        listView=(ListView)findViewById(R.id.stateList);
        simpleArcLoader2=(SimpleArcLoader)findViewById(R.id.stateLoader);

        fetchdata();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(statelsit.this,MainActivity2.class));
            }
        });


    }

    private void fetchdata()
    {
        String url="https://api.covidindiatracker.com/state_data.json";
        simpleArcLoader2.start();
        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                try {
                    JSONArray jsonArray=new JSONArray(response);

                    for(int i=0;i<jsonArray.length();i++)
                    {
                       JSONObject jsonObject=jsonArray.getJSONObject(i);
                       String State_name=jsonObject.getString("state");
                       String State_cases=jsonObject.getString("confirmed");
                       String State_death=jsonObject.getString("deaths");
                       String State_recovered=jsonObject.getString("recovered");
                       String State_active=jsonObject.getString("active");
                       if(State_name.equalsIgnoreCase("Andaman and Nicobar Islands"))
                       {
                           State_name="Andaman&Nicobar";
                       }
                        if(State_name.equalsIgnoreCase("Dadra and Nagar Haveli"))
                        {
                            State_name="Dadra&Nagar Haveli";
                        }

                       stateModel =new StateModel(State_name,State_active,State_death,State_recovered,State_cases);
                       stateModelList.add(stateModel);
                    }
                    myCustomeAdapter=new MyCustomeAdapter(statelsit.this,stateModelList);
                    listView.setAdapter(myCustomeAdapter);
                    simpleArcLoader2.stop();
                    simpleArcLoader2.setVisibility(View.GONE);


                } catch (JSONException e) {
                    e.printStackTrace();
                    simpleArcLoader2.stop();
                    simpleArcLoader2.setVisibility(View.GONE);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(statelsit.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

}