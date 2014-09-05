package com.example.eriksson.assignment1a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AddContactActivity extends Activity implements View.OnClickListener {

    // Formulärdata
    EditText contactName;
    EditText contactEmail;
    EditText contactPhone;

    // knappen till att lägga till kontakt
    Button addContactBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

    // Hämtar min knapp och sätter en listener
    addContactBtn = (Button)findViewById(R.id.addContactBtn);
    addContactBtn.setOnClickListener(this);

    // Instansierar mina formulär
    contactName = (EditText)findViewById(R.id.contactName);
    contactEmail = (EditText)findViewById(R.id.contactEmail);
    contactPhone = (EditText)findViewById(R.id.contactPhone);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_contact, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        // ANVÄNDS INTE !!
       /* int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        */
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onClick(View v) {

    String name = contactName.getText().toString();
    String email = contactEmail.getText().toString();
    String phone = contactPhone.getText().toString();

     Boolean valid = true;
    // Kontrollera att användaren har skrivit något namn
     if(contactName.getText().toString().length() == 0) {
         valid = false;
         contactName.setError("Firstname is missing");
     }
     // om användaren har matat in något så validerar vi emailen med regx
     if(contactEmail.getText().length() != 0) {
             if (contactEmail.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {

             } else {
                 valid = false;
                 contactEmail.setError("Not a valid Email");
     }

    // Om den ännu är godkänd så skapar vi en ni intent till telefonboken och skickar med namn, email och telefon.
     if(valid){
             Intent addContact = new Intent(Intent.ACTION_INSERT);
             addContact.setType(ContactsContract.Contacts.CONTENT_TYPE);
             addContact.putExtra(ContactsContract.Intents.Insert.NAME, name);
             addContact.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
             addContact.putExtra(ContactsContract.Intents.Insert.PHONE, phone);
             startActivity(addContact);
            }

         }
     }
 }

