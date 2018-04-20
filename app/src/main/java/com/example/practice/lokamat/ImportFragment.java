package com.example.practice.lokamat;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by yamini on 17/4/18.
 *
 */

public class ImportFragment extends Fragment {
    GridView mygrid;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.category, container, false);
        mygrid = (GridView) view.findViewById(R.id.gridview);
        ViewAdapter va = new ViewAdapter(getActivity());
        mygrid.setAdapter(va);
        return view;
 }


class Country {
    int imageId;
    String image_name;
    Country(int imageId, String image_name) {
        this.imageId=imageId;
        this.image_name=image_name;
    }



}

class ViewAdapter extends BaseAdapter {
    ArrayList<Country> list;
    Context context;
    ViewAdapter(Context context) {
        this.context =context;
        Resources res= context.getResources();
        String[] temparray = res.getStringArray(R.array.category_names);
        int [] images = {R.drawable.business};
        list=new ArrayList<Country>();
        Country temp_country = new Country(images[0],temparray[0]);
        list.add(temp_country);

    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    class ViewHolder {
        ImageView mycountry;
        ViewHolder (View v) {
            mycountry = (ImageView) v.findViewById(R.id.imageView);
        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder holder = null;
        if (row == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row =inflater.inflate(R.layout.single_item, viewGroup, false);
            holder=new ViewHolder(row);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }
        Country temp = list.get(i);
        holder.mycountry.setImageResource(R.drawable.business);
        return row;
    }
}
}