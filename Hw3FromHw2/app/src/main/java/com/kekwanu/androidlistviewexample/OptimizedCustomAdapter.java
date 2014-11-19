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

/*
Homework3

    Another assignment working with widgets, which are user interface items such as Views.

    Requirements:
        Display the same data from Homework 2, but with the following differences:
            1) A GridView must display the data, with appropriate styling
            2) The GridView must:
                a) have four (4) columns
                b) occupy the entire width of the screen, minus edge padding and margins
            3) Use background colors in each cell, possibly randomly generated
            4) Change the text color of the state TextView
            5) Choose a color that looks good on the background color of its cell

    Tips and Google I/O Style Observations:
        Practice styling Views and Layouts as much as possible. For inspiration browse
        through this app and click on all the menu items. Google I/O 2014 app
        observations:
            use of bright and contrasting colors on their ListViews and GridViews
            observe the use of padding, margins, and white space
            white borders around every View
            always a blatant picture of a person or a hint of a person in every View
            descriptions are below this person display that is at the top of every View

    Some Android Design Guidelines
        For margins, use a 16dp value. This matches with Android's "48dp rhythm" design
        guideline.

    Layout and View Parameters (Info below from the Big Nerd Ranch Guide)
        Some attribute names begin with "layout_", and others do not.

        Attributes not beginning with "layout_" are directions to the widget. When the
        widget is inflated, the widget calls a method to configure itself based on each
        of these attributes and their values.

        Attributes beginning with "layout_" are a direction to the parent of the widget.
        These are also known as layout parameters. They tell the parent layout how to
        arrange the child element within the parent.

    Margins vs. Padding
        Margin attributes are layout parameters. They determine the distance between
        widgets. Because a widget can only know about itself,
        the margins are the responsibility of the widget's parent.

        Padding is not a layout parameter. The android:padding attribute tells the
        widget how much bigger than its contents it should be drawn.
 */


public class OptimizedCustomAdapter extends BaseAdapter {

    private String TAG = "HW3::OptimizedCustomAdapter";
    private ArrayList<String> states;
    private Activity activity;
    private Context context;

    private int[] sq1Colors;
    private int[] sq2Colors;

    public OptimizedCustomAdapter(Context context, ArrayList objects) {
        Log.i(TAG, "::OptimizedCustomAdapter(context, objects)");
        this.context = context;
        this.states  = objects;

        sq1Colors = new int[states.size()];
        sq2Colors = new int[states.size()];

        for (int i = 0; i < sq1Colors.length; i++) {
            sq1Colors[i] = makeRandomColor();
            sq2Colors[i] = makeRandomColor();
        }
    }

    //define the Holder pattern class

    /**
     * This is our ViewHolder, which is based after the "holder pattern" class.
     * It is used to cache the TextView.
     *
     * It should also be used to cache the color of the two squares, the Views.
     */
    static class ViewHolder{
        TextView state;
        TextView bufferSquare;
        TextView square1;
        TextView square2;
        ViewGroup rowView;
    }

    @Override
    public int getCount() {
        Log.i(TAG, "::getCount()");
        return states.size();
    }

    @Override
    public String getItem(int position) {
        Log.i(TAG, "::getItem(position)");
        return states.get(position);
    }

    @Override
    public long getItemId(int position) {
        Log.i(TAG, "::getItemId(position)");
        return position;
    }

    /**
     * Note that when implementing getView(), do not make any assumptions about the
     * order of the calls to getView(). Android may call getView() on all of your View
     * types that are currently on the screen in arbitrary order, such as from the bottom
     * of the screen to the top or from the top of the screen to the bottom.
     */

    /**
     * This is a naive implementation of getView().
     * The original implementation with the ViewHolder pattern is below this method.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context).inflate(R.layout
                .beautiful_layout_item, viewGroup, false);

        TextView textView = (TextView) rootView.findViewById(R.id.state);
        textView.setText(states.get(position));

        TextView bufferSquareView = (TextView) rootView.findViewById(R.id.bufferSquare);
        bufferSquareView.setText(Integer.toString(position % 10));

        TextView square1View = (TextView) rootView.findViewById(R.id.square1);
        square1View.setText(Integer.toString(position % 10));

//        square1View.setBackgroundColor(makeRandomColor());

        TextView square2View = (TextView) rootView.findViewById(R.id.square2);
        square2View.setText(Integer.toString(position % 10));

//        square2View.setBackgroundColor(makeRandomColor());

        return rootView;
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup viewGroup){
//        Log.i(TAG, "::getView(position, convertView, viewGroup), " + "and position = " + position);
//
//        ViewHolder viewHolder;
//
//        /**
//         * The convertView parameter is a "scrap-view".
//         * It has a non-null value when the ListView is asking you to
//         * recycle the row layout, so when convertView is non-null, update
//         * its contents instead of inflating a new row layout.
//         */
//
//        /**
//         * If no view is given to us, create one.
//         * Don't put data into the views here, just specify how to find the views.
//         */
//
//        if (convertView == null){ //the first time around, the view is null, so inflate it
//
//
//            /**
//             * From The Big Nerd Ranch Guide, page 16:
//             * When a layout is inflated, each widget in the layout file is
//             * instantiated as defined by its attributes. You specify which layout to
//             * inflate by passing the layout's resource ID.
//             */
//
//            //inflate using the system inflater. This returns a reference to the inflater,
//            // which inflates the resource XML to the corresponding view
//            LayoutInflater inflater = LayoutInflater.from(context);
//
//            //use the inflate method this way.
//            convertView = inflater.inflate(R.layout.beautiful_layout_item, viewGroup,
//                    false);
//
//            //create the viewHolder object, which serves as a sort of "cache"
//            // of the view
//            //this is a highly optimized way of dealing with ListViews on Android
//            //if this is not done, every time you scroll through a ListView, the Android system
//            //will continue to inflate and destroy the view, wasting valuable resources, and the result will be
//            //laggy scrolling.
//            viewHolder = new ViewHolder();
//
//            viewHolder.state = (TextView) convertView.findViewById(R.id.state);
//            viewHolder.bufferSquare = (View) convertView.findViewById(R.id.bufferSquare);
//            viewHolder.square1 = (View) convertView.findViewById(R.id.square1);
//            viewHolder.square2 = (View) convertView.findViewById(R.id.square2);
//            viewHolder.rowView = (ViewGroup) convertView.findViewById(R.id.row);
//
//            //  Store the ViewHolder with the View.
//            convertView.setTag(viewHolder);
//        }
//
//        /**
//         * We avoided calling findViewById() on the resource,
//         * so just use the ViewHolder.
//         */
//
//        viewHolder = (ViewHolder) convertView.getTag();
//        viewHolder.state.setText(getItem(position));
//
//        ((ViewHolder) convertView.getTag()).state.setText(getItem(position));
//        ((ViewHolder) convertView.getTag()).bufferSquare.setBackgroundColor(makeRandomColor());
//        ((ViewHolder) convertView.getTag()).square1.setBackgroundColor(sq1Colors[position]);
//        ((ViewHolder) convertView.getTag()).square2.setBackgroundColor(sq2Colors[position]);
//
//        if (position % 2 == 0) {
//            ((ViewHolder) convertView.getTag()).rowView.setBackgroundColor(evenRowColor);
//        } else {
//            ((ViewHolder) convertView.getTag()).rowView.setBackgroundColor(oddRowColor);
//        }
//
//        return viewGroup;
//    }

    /**
     * This method randomly generates an alpha/transparency value along with an RGB value.
     * @return The integer color value in AARRGGBB format.
     *
     * This is a static method inside of the OptimizedCustomAdapter class. Making this
     * method static inside of this class just makes it so that this method is only
     * callable from inside of this class. This method is not exposed to clients of
     * this class. This is referred to as a static nested class.
     */
    static int makeRandomColor() {
        String TAG = "HW3";
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
