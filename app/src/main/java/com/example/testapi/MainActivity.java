package com.example.testapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity
{   private TextView cases,recovered,critical,active,todayscase,totaldeaths,todaysdeaths,tvaffectednations;
    private SimpleArcLoader simpleArcLoader;
    private ScrollView scrollView;
    private PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cases=(TextView)findViewById(R.id.cases);
        recovered=(TextView)findViewById(R.id.cases2);
        critical=(TextView)findViewById((R.id.cases3));
        active=(TextView)findViewById(R.id.cases4);
        todayscase=(TextView)findViewById(R.id.cases5);
        totaldeaths=(TextView)findViewById(R.id.cases6);
        todaysdeaths=(TextView)findViewById(R.id.cases7);
        tvaffectednations=(TextView)findViewById(R.id.cases8);

        scrollView=(ScrollView)findViewById(R.id.scrollStats);
        simpleArcLoader=(SimpleArcLoader)findViewById(R.id.load);
        pieChart=(PieChart)findViewById(R.id.piechart);
        fetch();
    }

    private void fetch()
    {
        String url="https://disease.sh/v3/covid-19/all/";
        simpleArcLoader.start();
        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                try {
                    JSONObject jsonObject= new JSONObject(response.toString());
                    cases.setText(jsonObject.getString("cases"));
                    recovered.setText(jsonObject.getString("recovered"));
                    active.setText(jsonObject.getString("active"));
                    critical.setText(jsonObject.getString("critical"));
                    todayscase.setText(jsonObject.getString("todayCases"));
                    todaysdeaths.setText(jsonObject.getString("todayDeaths"));
                    totaldeaths.setText(jsonObject.getString("deaths"));
                    tvaffectednations.setText(jsonObject.getString("affectedCountries"));

                    pieChart .addPieSlice(new PieModel("cases",Integer.parseInt(cases.getText().toString()), Color.parseColor("#FFA726")));

                    pieChart .addPieSlice(new PieModel("recovered",Integer.parseInt(recovered.getText().toString()), Color.parseColor("#66BB6A")));
                    pieChart .addPieSlice(new PieModel("death",Integer.parseInt(totaldeaths.getText().toString()), Color.parseColor("#EF5350")));
                    pieChart .addPieSlice(new PieModel("Active",Integer.parseInt(active.getText().toString()), Color.parseColor("#29B6F6")));
                    pieChart.startAnimation();
                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);



                } catch (JSONException e) {
                    e.printStackTrace();
                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {   simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void Gototracker(View view)
    {

        startActivity( new Intent(MainActivity.this,statelsit.class));


    }
}
