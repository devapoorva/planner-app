package com.example.plannerapp.activities;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.plannerapp.R;

public class ContactActivity extends AppCompatActivity {
    EditText edtnum,edtmsg;
    SmsManager sms;
    Button btnsend;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        getSupportActionBar().setTitle("Contact US");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        btnsend=(Button)findViewById(R.id.btnsend);
        edtmsg=(EditText) findViewById(R.id.edtmsg);
        edtnum=(EditText)findViewById(R.id.edtnum);
        sms=SmsManager.getDefault();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void sendsms(View v){
        String mobile = edtnum.getText().toString().trim();
        String message = edtmsg.getText().toString().trim();
        if(mobile.isEmpty()){
            Toast.makeText(this,"Mobile number is empty",Toast.LENGTH_LONG).show();
        }else if(mobile.length()!=10){
            Toast.makeText(this,"Invalid mobile number",Toast.LENGTH_LONG).show();
        }else if(message.isEmpty()){
            Toast.makeText(this,"Empty message",Toast.LENGTH_SHORT).show();
        }else{
            sendSMS(mobile,message);
            edtmsg.setText("");
            edtnum.setText("");
        }
    }

    public void sendSMS(String phoneNo, String msg) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, "7256011646", msg, null, null);
            Toast.makeText(getApplicationContext(), "We will contact you as soon as possible",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }
}
