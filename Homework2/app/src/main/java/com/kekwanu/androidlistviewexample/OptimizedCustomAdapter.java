package com.kekwanu.androidlistviewexample;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

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

    /**
     * This is our ViewHolder.
     * It is used to cache the TextView.
     */
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
//        ListView rows = (ListView)findViewById(R.id.listview);

        /**
         * The convertView parameter is a "scrap-view".
         * It has a non-null value when the ListView is asking you to
         * recycle the row layout, so when convertView is non-null, update
         * its contents instead of inflating a new row layout.
         */
        if (convertView == null){ //the first time around, the view is null, so inflate it

            //inflate using the system inflater. This returns a reference to the inflater,
            // which inflates the resource XML to the corresponding view
            LayoutInflater inflater = LayoutInflater.from(context);

            //use the inflate method this way.
            convertView = inflater.inflate(R.layout.beautiful_layout_item, viewGroup,
                    false);

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

            //  Store the ViewHolder with the View.
            convertView.setTag(viewHolder);

            ((ViewHolder) convertView.getTag()).square1.setBackgroundColor(makeRandomColor());
            ((ViewHolder) convertView.getTag()).square2.setBackgroundColor(makeRandomColor());

        }

        /**
         * We avoided calling findViewById() on the resource,
         * so just use the ViewHolder.
         */

        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.state.setText(getItem(position));

        ((ViewHolder) convertView.getTag()).state.setText(getItem(position));

        /**
         * TODO:
         * The background color of the squares is changed every time the
         * ListView scrolls. Is this within the bounds of the project specifications?
         */
//        ((ViewHolder) convertView.getTag()).square1.setBackgroundColor(makeRandomColor());
//        ((ViewHolder) convertView.getTag()).square2.setBackgroundColor(makeRandomColor());

        /**
         * TODO:
         * Below is experimental code for setting the background color of each row.
         */
//        int evenRowColor = makeRandomColor();
//        int oddRowColor = makeRandomColor();
//        if (position % 2 == 0) {
//            viewGroup.setBackgroundColor(evenRowColor);
//        } else {
//            viewGroup.setBackgroundColor(oddRowColor);
//        }

        return convertView;
    }

    /**
     * This method randomly generates an alpha/transparency value along with an RGB value.
     * @return The integer color value in AARRGGBB format.
     */
    static int makeRandomColor() {
        String TAG = "HW2";
        Random r = new Random();

        int AA = r.nextInt(255);
        Log.i(TAG, "AA = " + AA);

        float[] RGB = new float[3];

        RGB[0] = r.nextInt(255);
        Log.i(TAG, "RR = " + RGB[0]);

        RGB[1] = r.nextInt(255);
        Log.i(TAG, "GG = " + RGB[1]);

        RGB[2] = r.nextInt(255);
        Log.i(TAG, "BB = " + RGB[2]);

        int AARRGGBB = Color.HSVToColor(AA, RGB);
        Log.i(TAG, "AARRGGBB = " + AARRGGBB);

        return AARRGGBB;
    }
}
