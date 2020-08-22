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

public class mydistrictCustomerAdapter extends ArrayAdapter<districtmodel>
{    private Context context;
     private List<districtmodel> districtmodelList;


    public mydistrictCustomerAdapter(@NonNull Context context, List<districtmodel> districtmodelList) {
        super(context, R.layout.list_custom_item);

        this.context=context;
        this.districtmodelList=districtmodelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {   View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.districtlist_custom_item,null,true);

        TextView distname;
        ImageView disimg;
        distname=view.findViewById(R.id.statename);

        disimg=view.findViewById(R.id.flag);
        distname.setText(districtmodelList.get(position).getDname());

        return view;
    }
}
