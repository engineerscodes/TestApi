package com.example.testapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyCustomeAdapter extends ArrayAdapter<StateModel>
{    private Context context;
     private List<StateModel> stateModelList;
    public MyCustomeAdapter( Context context, List<StateModel> stateModelList) {
        super(context,R.layout.list_custom_item,stateModelList);
        this.context=context;
        this.stateModelList=stateModelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {   View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_custom_item,null,true);
        TextView stname,strecovered,stdeath,stcases,stactive,flagname;
        ImageView img;
        stname=view.findViewById(R.id.statename);
        stactive=view.findViewById(R.id.stateactive);
        stcases=view.findViewById(R.id.statecases);
        stdeath=view.findViewById(R.id.statedeaths);
        strecovered=view.findViewById(R.id.stateRecovered);
        img=view.findViewById(R.id.flag);
        stname.setText(stateModelList.get(position).getStates());
        stactive.setText(stateModelList.get(position).getActive());
        stdeath.setText(stateModelList.get(position).getDeath());
        strecovered.setText(stateModelList.get(position).getRecovered());
        stcases.setText(stateModelList.get(position).getCases());
        getflag(stateModelList.get(position).getStates(),img);


        return view;
    }

    public  void getflag(String name,ImageView img)
    {
        if(name.equalsIgnoreCase("Andaman&Nicobar"))
            img.setImageResource(R.drawable.andaman_andnicobar);
        else if(name.equalsIgnoreCase("Goa"))
            img.setImageResource(R.drawable.goa);
        else if(name.equalsIgnoreCase("Maharashtra"))
            img.setImageResource(R.drawable.mah);
        else if(name.equalsIgnoreCase("Tamil Nadu"))
            img.setImageResource(R.drawable.tn);
        else if(name.equalsIgnoreCase("Andhra Pradesh"))
            img.setImageResource(R.drawable.ap);
        else if(name.equalsIgnoreCase("Arunachal Pradesh"))
            img.setImageResource(R.drawable.arunachal_pradesh);
        else if(name.equalsIgnoreCase("Assam"))
            img.setImageResource(R.drawable.assam);
        else if(name.equalsIgnoreCase("Bihar"))
            img.setImageResource(R.drawable.bihar);
        else if(name.equalsIgnoreCase("Chandigarh"))
            img.setImageResource(R.drawable.chand);
        else if(name.equalsIgnoreCase("Chhattisgarh"))
            img.setImageResource(R.drawable.chhattisgarh);
        else if(name.equalsIgnoreCase("Daman and Diu"))
            img.setImageResource(R.drawable.damandiu);
        else if(name.equalsIgnoreCase("Delhi"))
            img.setImageResource(R.drawable.del);
        else if(name.equalsIgnoreCase("Dadra&Nagar Haveli"))
            img.setImageResource(R.drawable.damandiu);
        else if(name.equalsIgnoreCase("Gujarat"))
            img.setImageResource(R.drawable.gujarat);
        else if(name.equalsIgnoreCase("Himachal Pradesh"))
            img.setImageResource(R.drawable.himachal);
        else if(name.equalsIgnoreCase("Haryana"))
            img.setImageResource(R.drawable.haryana);
        else if(name.equalsIgnoreCase("Jharkhand"))
            img.setImageResource(R.drawable.jaha);
        else if(name.equalsIgnoreCase("Ladakh"))
            img.setImageResource(R.drawable.lal);
        else if(name.equalsIgnoreCase("Karnataka"))
            img.setImageResource(R.drawable.karnataka);
        else if(name.equalsIgnoreCase("Kerala"))
            img.setImageResource(R.drawable.kae);
        else if(name.equalsIgnoreCase("Lakshadweep"))
            img.setImageResource(R.drawable.lakshadweep);
        else if(name.equalsIgnoreCase("Meghalaya"))
            img.setImageResource(R.drawable.maghalaya);
        else if(name.equalsIgnoreCase("Manipur"))
            img.setImageResource(R.drawable.man);
        else if(name.equalsIgnoreCase("Madhya Pradesh"))
            img.setImageResource(R.drawable.mp);
        else if(name.equalsIgnoreCase("Mizoram"))
            img.setImageResource(R.drawable.mi);
        else if(name.equalsIgnoreCase("Nagaland"))
            img.setImageResource(R.drawable.nau);
        else if(name.equalsIgnoreCase("Odisha"))
            img.setImageResource(R.drawable.or);
        else if(name.equalsIgnoreCase("Punjab"))
            img.setImageResource(R.drawable.pone);
        else if(name.equalsIgnoreCase("Puducherry"))
            img.setImageResource(R.drawable.ptow);
        else if(name.equalsIgnoreCase("Rajasthan"))
            img.setImageResource(R.drawable.r);
        else if(name.equalsIgnoreCase("Sikkim"))
            img.setImageResource(R.drawable.si);
        else if(name.equalsIgnoreCase("Telangana"))
            img.setImageResource(R.drawable.tal);
        else if(name.equalsIgnoreCase("Tripura"))
            img.setImageResource(R.drawable.t);
        else if(name.equalsIgnoreCase("Uttar Pradesh"))
            img.setImageResource(R.drawable.up);
        else if(name.equalsIgnoreCase("Uttarakhand"))
            img.setImageResource(R.drawable.utk);
        else if(name.equalsIgnoreCase("West Bengal"))
            img.setImageResource(R.drawable.wbengal);
        else if(name.equalsIgnoreCase("Jammu and Kashmir"))
            img.setImageResource(R.drawable.jandk);
















    }
}
