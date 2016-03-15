package com.example.ro.pub.cs.systems.pdsd.lab04.contactsmanager;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);
        
        View.OnClickListener myhandler1 = new View.OnClickListener() {
            public void onClick(View v) {
            	 switch(v.getId()) {
                 case R.id.button1:
                	 
                	 View layout3 = findViewById(R.id.layout3);

                	 String text = btn1.getText().toString();
                	 if (text.compareTo("Hide Additional Fields") == 0) {
                		 layout3.setVisibility(View.GONE);
                		 btn1.setText("Show Additional Fields");
                	 } else {
                		 layout3.setVisibility(View.VISIBLE);
                		 btn1.setText("Hide Additional Fields");
                	 }
                	 
                   // it was the first button
                   break;
                 case R.id.button2:
                	 Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                	 intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                	 if (name != null) {
                	   intent.putExtra(ContactsContract.Intents.Insert.NAME, name);
                	 }
                	 if (phone != null) {
                	   intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone);
                	 }
                	 if (email != null) {
                	   intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
                	 }
                	 if (address != null) {
                	   intent.putExtra(ContactsContract.Intents.Insert.POSTAL, address);
                	 }
                	 if (jobTitle != null) {
                	   intent.putExtra(ContactsContract.Intents.Insert.JOB_TITLE, jobTitle);
                	 }
                	 if (company != null) {
                	   intent.putExtra(ContactsContract.Intents.Insert.COMPANY, company);
                	 }
                	 ArrayList<ContentValues> contactData = new ArrayList<ContentValues>();
                	 if (website != null) {
                	   ContentValues websiteRow = new ContentValues();
                	   websiteRow.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Website.CONTENT_ITEM_TYPE);
                	   websiteRow.put(ContactsContract.CommonDataKinds.Website.URL, website);
                	   contactData.add(websiteRow);
                	 }
                	 if (im != null) {
                	   ContentValues imRow = new ContentValues();
                	   imRow.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Im.CONTENT_ITEM_TYPE);
                	   imRow.put(ContactsContract.CommonDataKinds.Im.DATA, im);
                	   contactData.add(imRow);
                	 }
                	 intent.putParcelableArrayListExtra(ContactsContract.Intents.Insert.DATA, contactData);
                	 startActivity(intent);
                   // it was the second button
                   break;
                 case R.id.button3:
                	 
               }
            
            }
          };
          btn1.setOnClickListener(myhandler1);
          btn2.setOnClickListener(myhandler1);
          btn3.setOnClickListener(myhandler1);
          
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
