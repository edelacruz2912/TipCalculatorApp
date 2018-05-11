package com.example.eduardo.tipcalculatorapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {


    private EditText mealAmount;
    private String mealAmountString = " ";
    private SeekBar simpleSeekBar;
    private TextView mealTipTextSeekBar;
    private double seekBarValue;//when it was crashing to get the double I just erase it the seekbarValue = 0.00 and it Works. why?
    //tip section
    private TextView tipAmountView;
    //for total section
    private TextView mealBill;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //selecting the EditText to get amount From Customer
        mealAmount = (EditText) findViewById(R.id.amountEntered);
//        mealAmount.getText();


        // seekBar
        simpleSeekBar = (SeekBar) findViewById(R.id.seekBar); // initiate the Seek bar
        simpleSeekBar.setOnSeekBarChangeListener(this);

        //mealTipText for the seekBar
        //getting the textview of id seekBarText
        mealTipTextSeekBar = (TextView) findViewById(R.id.SeekBarText);


        //tip calculation and display amount
        tipAmountView = (TextView) findViewById(R.id.tip);

        //selecting the textView for the mealamount
        mealBill = (TextView) findViewById(R.id.total);

//        tipCalculation = Double.parseDouble(mealAmount.getText().toString()) * (seekBarValue/100) ;
//        tipCalculation =  Double.parseDouble(mealAmount.getText().toString()) * (double)seekBarValue;

//        tipCalculation = Double.parseDouble(mealAmount.getText().toString()) * seekBarValue;
//        tipAmountView.setText(Double.toString(tipCalculation));


//        System.out.print("the value of seekBarValue " + seekBarValue);
//        Log.i("seekBarValue", "the value of seekBarValue " + seekBarValue);


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {


            seekBarValue = progress;
            Log.i("seekBarValue", "the value of seekBarValue " + seekBarValue);
            Log.i("mealAmount", "the value of mealAmount " + mealAmount.getText().toString());


            mealAmountString = (mealAmount.getText().toString());
            Log.i("mealAmountString", "the value of mealAmountString " + mealAmountString);


            double tipCalculation = Double.parseDouble(mealAmountString) * (seekBarValue / 100);
            Log.i("tipCalculation", "the value of calculation " + tipCalculation);

            //calculating the total of meal tip + cost of food
            double billTotal = tipCalculation + Double.parseDouble(mealAmountString);


            //        Double.parseDouble(mealAmount.getText().toString());


            mealTipTextSeekBar.setText(Double.toString(seekBarValue) + " %");

            //displaying the tip calculation on the tip section of the app
            tipAmountView.setText(Double.toString(tipCalculation));

            //displaying the total of the meal
            mealBill.setText(Double.toString(billTotal));


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
