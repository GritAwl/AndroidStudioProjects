package com.kekwanu.androidlistviewexample;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by PSP502AP001 on 10/22/2014.
 */
public class OptimizedCustomAdapter extends BaseAdapter {

    private String TAG = "HW2";
    private ArrayList<String> states;
    private Activity activity;
    private Context context;

    public OptimizedCustomAdapter(Context context, ArrayList objects) {

        Log.i(TAG, "OptimizedCustomAdapter::OptimizedCustomAdapter()");
        this.context = context;
        this.states  = objects;
    }

    //define the Holder pattern class
    static class ViewHolder{
        TextView state;
        View square1;
        View square2;
    }

    @Override
    public int getCount() {

        Log.i(TAG, "OptimizedCustomAdapter::getCount()");
        return states.size();
    }

    @Override
    public String getItem(int position) {

        Log.i(TAG, "OptimizedCustomAdapter::getItem()");
        return states.get(position);
    }

    @Override
    public long getItemId(int position) {

        Log.i(TAG, "OptimizedCustomAdapter::getItemId()");
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup){

        Log.i(TAG, "OptimizedCustomAdapter::getView(), " +
                        "and position = " + position);

        ViewHolder viewHolder;
        ListView rows = (ListView)findViewById(R.id.listview);

        if (convertView == null){ //the first time around, the view is null, so inflate it

            //inflate using the system inflater. This returns a reference to the inflater,
            // which inflates the resource XML to the corresponding view
            LayoutInflater inflater = LayoutInflater.from(context);

            //use the inflate method this way.
            convertView = inflater.inflate(R.layout.beautiful_layout_item, viewGroup, false);

            //create the viewHolder object, which serves as a sort of "cache"
            // of the view
            //this is a highly optimized way of dealing with ListViews on Android
            //if this is not done, every time you scroll through a ListView, the Android system
            //will continue to inflate and destroy the view, wasting valuable resources, and the result will be
            //laggy scrolling.
            viewHolder = new ViewHolder();
            viewHolder.state = (TextView) convertView.findViewById(R.id.state);
            viewHolder.square1 = (View) convertView.findViewById(R.id.square1);
            viewHolder.square2 = (View) convertView.findViewById(R.id.square2);
            convertView.setTag(viewHolder);




            if (position % 2 == 0) {
                rows.findViewById(position).setBackgroundColor(0x33FF0000);
            } else {
                rows.findViewById(position).setBackgroundColor(0x33FFFF00);
            }


        }

        ((ViewHolder) convertView.getTag()).state.setText(getItem(position));



        return convertView;
    }
}
