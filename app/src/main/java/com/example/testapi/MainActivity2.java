package com.example.testapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
        private TextView tv;
    private TextView cases,recovered,critical,active,todayscase,totaldeaths,todaysdeaths,tvaffectednations;
        private SimpleArcLoader simpleArcLoaderdis;
        private ListView distlist;

    public static List<districtmodel>  districtmodelList=new ArrayList<>();
    districtmodel districtmodels;
    mydistrictCustomerAdapter mydistrictCustomerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv=(TextView)findViewById(R.id.district);
        simpleArcLoaderdis=(SimpleArcLoader)findViewById(R.id.disLoader);
        distlist=(ListView)findViewById(R.id.distList);
        fectdistrict();
    }

    private void fectdistrict()
    {
        String url2="https://disease.sh/v3/covid-19/all/";

        StringRequest request=new StringRequest(Request.Method.GET, url2, new Response.Listener<String>()  {
            @Override
            public void onResponse(String response)
            {
                try {
                    int count=0;
                    JSONArray jsonArray=new JSONArray(response);

                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        JSONArray jsonArray2=jsonObject.getJSONArray("districtData");
                        for(int j=0;j<jsonArray2.length();j++)
                        {
                            JSONObject jsonObject1=jsonArray2.getJSONObject(j);
                            String  name=jsonObject1.getString("active");

                            districtmodels=new districtmodel(name);
                            districtmodelList.add(districtmodels);
                        }

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                    simpleArcLoaderdis.stop();
                    simpleArcLoaderdis.setVisibility(View.GONE);

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                simpleArcLoaderdis.stop();
                simpleArcLoaderdis.setVisibility(View.GONE);
                Toast.makeText(MainActivity2.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}