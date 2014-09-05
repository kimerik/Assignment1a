package com.example.eriksson.assignment1a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;


public class ColorPickerActivity extends Activity implements NumberPicker.OnValueChangeListener {


    NumberPicker numR;
    NumberPicker numG;
    NumberPicker numB;

    RelativeLayout layout;
    private static int MIN = 0;
    private static int MAX = 255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);

        // Skapa numberpicker för Röd och hämta den med id, sätt max och min värde, sätt även en listener
        numR = (NumberPicker)findViewById(R.id.numberPickerR);
        numR.setMaxValue(MAX);
        numR.setMinValue(MIN);
        numR.setOnValueChangedListener(this);

        // Skapa numberpicker för Grön och hämta den med id, sätt max och min värde, sätt även en listener
        numG = (NumberPicker)findViewById(R.id.numberPickerG);
        numG.setMaxValue(MAX);
        numG.setMinValue(MIN);
        numG.setOnValueChangedListener(this);

        // Skapa numberpicker för Blå och hämta den med id, sätt max och min värde, sätt även en listener
        numB = (NumberPicker)findViewById(R.id.numberPickerB);
        numB.setMaxValue(MAX);
        numB.setMinValue(MIN);
        numB.setOnValueChangedListener(this);

        // Hämtar min bakgrund
        layout = (RelativeLayout)findViewById(R.id.relativeLayoutColor);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.color_picker, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //Används inte !!!!!!!!!!!!!!!!!!!!!!!!!!1

        /*
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        */
        return super.onOptionsItemSelected(item);
    }

    // Lyssnar på om någon numberpicker ändras
    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        setBackgroundColor();
    }

    public void setBackgroundColor(){
        // sätter den ny bakgroundsfärgen
        layout.setBackgroundColor(Color.rgb(numR.getValue(), numG.getValue(),numB.getValue()));
    }
}
