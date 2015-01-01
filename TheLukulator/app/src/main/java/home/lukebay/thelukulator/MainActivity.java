package home.lukebay.thelukulator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    TextView resultText;
    int total;
    String expression = new String();

    enum operator {
        ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION
    }

    operator op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = (TextView) findViewById(R.id.answer);
        total = 0;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clear(View view) {
        expression = new String();
        total = 0;
        resultText.setText("0", TextView.BufferType.EDITABLE);
    }

    public void zero(View view) {
        resultText.setText("0", TextView.BufferType.EDITABLE);
    }

    public void one(View view) {
        expression += "1";
        resultText.setText(expression, TextView.BufferType.EDITABLE);
    }

    public void two(View view) {
        expression += "2";
        resultText.setText(expression, TextView.BufferType.EDITABLE);
    }

    public void three(View view) {
        resultText.setText("3", TextView.BufferType.EDITABLE);
    }

    public void four(View view) {
        resultText.setText("4", TextView.BufferType.EDITABLE);
    }

    public void five(View view) {
        resultText.setText("5", TextView.BufferType.EDITABLE);
    }

    public void six(View view) {
        resultText.setText("6", TextView.BufferType.EDITABLE);
    }

    public void seven(View view) {
        resultText.setText("7", TextView.BufferType.EDITABLE);
    }

    public void eight(View view) {
        resultText.setText("8", TextView.BufferType.EDITABLE);
    }

    public void nine(View view) {
        resultText.setText("9", TextView.BufferType.EDITABLE);
    }

    public void add(View view) {
        expression += "+";
        resultText.setText(expression, TextView.BufferType.EDITABLE);
    }

    public void subtract(View view) {
        resultText.setText("-", TextView.BufferType.EDITABLE);
    }

    public void multiply(View view) {
        resultText.setText("*", TextView.BufferType.EDITABLE);
    }

    public void divide(View view) {
        resultText.setText("/", TextView.BufferType.EDITABLE);
    }

    public void equals(View view) {
        resultText.setText(Integer.toString(total), TextView.BufferType.EDITABLE);
    }

    /**
     * to update the display you need:
     *  1. the first operand (the current total)
     *  2. the operator (+, -, *, or /)
     *  3. the other operand
     *
     * alternatively, we could accumulate a string
     */
}
