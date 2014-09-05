package com.example.eriksson.assignment1a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){
            case R.id.action_addContact:
                Intent addContact = new Intent(this,AddContactActivity.class);
                startActivity(addContact);
                break;
            case R.id.action_randomNumber:
                Intent randomNumber = new Intent(this, RandomNumberActivity.class);
                startActivity(randomNumber);
                break;
            case R.id.action_colorPicker:
                Intent colorPicker = new Intent(this, ColorPickerActivity.class);
                startActivity(colorPicker);
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
