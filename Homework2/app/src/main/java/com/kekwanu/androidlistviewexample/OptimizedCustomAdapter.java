package com.kekwanu.androidlistviewexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PSP502AP001 on 10/22/2014.
 */
public class OptimizedCustomAdapter extends BaseAdapter {

    private ArrayList<String> states;
    private Activity activity;
    private Context context;

    public OptimizedCustomAdapter(Context context, ArrayList objects) {

        this.context = context;
        this.states  = objects;
    }

    //define the Holder pattern class
    static class ViewHolder{
        TextView state;
    }

    @Override
    public int getCount() {
        return states.size();
    }

    @Override
    public String getItem(int position) {
        return states.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup){

        ViewHolder viewHolder;

        if (convertView == null){ //the first time around, the view is null, so inflate it

            //inflate using the system inflater. This returns a reference to the inflater,
            // which inflates the resource XML to the corresponding view
            LayoutInflater inflater = LayoutInflater.from(context);

            //use the inflate method this way.
            convertView = inflater.inflate(R.layout.beautiful_layout_item, viewGroup, false);

            //create the viewholder object, which serves as a sort of "cache" of the view
            //this is a highly optimized way of dealing with ListViews on Android
            //if this is not done, every time you scroll through a ListView, the Android system
            //will continue to inflate and destroy the view, wasting valuable resources, and the result will be
            //laggy scrolling.
            viewHolder = new ViewHolder();
            viewHolder.state = (TextView) convertView.findViewById(R.id.state);
            convertView.setTag(viewHolder);
        }

        ((ViewHolder) convertView.getTag()).state.setText(getItem(position));

        return convertView;
    }
}
