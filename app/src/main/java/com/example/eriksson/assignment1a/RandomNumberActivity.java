package com.example.eriksson.assignment1a;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Random;


public class RandomNumberActivity extends Activity implements View.OnClickListener {

    // Skapar min knapp till att generera nummer
    Button randomNumberBtn;
    // texten som ska visa siffrorna
    TextView randomNumberTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_number);

        //  Hämtar knappen och skapar en listener
        randomNumberBtn = (Button)findViewById(R.id.randomNumberBtn);
        randomNumberBtn.setOnClickListener(this);
        // Instansierar randomtext
        randomNumberTxt = (TextView)findViewById(R.id.randomNumberTxt);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.random_number, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        // Används Inte !!!!!!!!!!!!!!!!!!1111
        /*
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        */
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        // hämtar randomnumber och sätter den till randomText
        randomNumberTxt.setText(getRandomNumber());
    }

    public String getRandomNumber(){
        // Skapar ett random nummer
        Random ran = new Random();
        Double num = ran.nextDouble() * 100;

        // Gör om talet till 2 decimaler
        BigDecimal bd = BigDecimal.valueOf(num);
        bd = bd.setScale(2, BigDecimal.ROUND_FLOOR);
        return bd.toString();
    }

}
