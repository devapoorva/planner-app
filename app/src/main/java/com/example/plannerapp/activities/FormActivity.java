package com.example.plannerapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.plannerapp.R;
import com.example.plannerapp.database.DatabaseHelper;
import com.example.plannerapp.dto.ApplicationForm;
import com.example.plannerapp.util.AppUtil;

import java.util.Calendar;

public class FormActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private EditText edtFormName,edtFormMobile,edtFormEmail,edtFormSource,edtFormDestination,edtFormPerson,edtFormStartDate,edtFormEndDate;
    private Button btnSubmit;
    private String startDate="";
    private String endDate="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        databaseHelper = new DatabaseHelper(this);
        getSupportActionBar().setTitle("App Form");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        initialize();
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.edtFormEndDate.setOnClickListener(view -> {
            Calendar calendar = Calendar.getInstance();
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    this,
                    (datePicker, year, month, day) -> {
                        this.endDate = day+"-"+month+"-"+year;
                        this.edtFormEndDate.setText(this.endDate);
                    }
                    ,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            );
            datePickerDialog.show();
        });
        this.edtFormStartDate.setOnClickListener(view -> {
            Calendar calendar = Calendar.getInstance();
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    this,
                    (datePicker, year, month, day) -> {
                        this.startDate = day+"-"+month+"-"+year;
                        this.edtFormStartDate.setText(this.startDate);                    }
                    ,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            );
            datePickerDialog.show();
        });

        this.btnSubmit.setOnClickListener(view -> {
            String name = this.edtFormName.getText().toString().trim();
            String mobile = this.edtFormMobile.getText().toString().trim();
            String email = this.edtFormEmail.getText().toString().trim();
            String source = this.edtFormSource.getText().toString().trim();
            String destination = this.edtFormDestination.getText().toString().trim();
            String persons = this.edtFormPerson.getText().toString().trim();
            if(name.isEmpty()){
                AppUtil.showToast(this,"Name should not be empty");
            }else if(mobile.isEmpty()){
                AppUtil.showToast(this,"Mobile should not be empty");
            }else if(mobile.length()!=10){
                AppUtil.showToast(this,"Please enter valid mobile number");
            }else if(email.isEmpty()){
                AppUtil.showToast(this,"Email address should not be empty");
            }else if(!AppUtil.isValidEmail(email)){
                AppUtil.showToast(this,"Please enter valid email");
            }else if(source.isEmpty()){
                AppUtil.showToast(this,"Please enter source");
            }else if(destination.isEmpty()){
                AppUtil.showToast(this,"Please enter destination");
            }else if(persons.isEmpty()){
                AppUtil.showToast(this,"Please enter number of persons");
            }else if(startDate.isEmpty()){
                AppUtil.showToast(this,"Start date should not be empty");
            }else if(endDate.isEmpty()){
                AppUtil.showToast(this,"End date should not be empty");
            }else{
                ApplicationForm applicationForm = new ApplicationForm(name,mobile,email,source,destination,persons,startDate,endDate);
                if(this.databaseHelper.isMobileExist(applicationForm.getMobileNumber())){
                    AppUtil.showToast(this,"Mobile number already exist");
                }else if(this.databaseHelper.isEmailExist(applicationForm.getEmail())){
                    AppUtil.showToast(this,"Email address already exist");
                }else{
                    if(this.databaseHelper.insertApplication(applicationForm)){
                        AppUtil.showToast(this,"Thanks for registration");
                        clearForm();
                    }else{
                        AppUtil.showToast(this,"Application form not submitted");
                    }
                }
            }
        });

    }

    private void clearForm(){
        this.edtFormName.setText("");
        this.edtFormMobile.setText("");
        this.edtFormEmail.setText("");
        this.edtFormSource.setText("");
        this.edtFormDestination.setText("");
        this.edtFormPerson.setText("");
        this.startDate = "";
        this.endDate = "";
        this.edtFormStartDate.setText("");
        this.edtFormEndDate.setText("");
    }

    private void initialize(){
        this.edtFormName = findViewById(R.id.edtFormName);
        this.edtFormMobile = findViewById(R.id.edtFormMobile);
        this.edtFormEmail = findViewById(R.id.edtFormEmail);
        this.edtFormSource = findViewById(R.id.edtFormSource);
        this.edtFormDestination = findViewById(R.id.edtFormDestination);
        this.edtFormPerson = findViewById(R.id.edtFormPerson);
        this.edtFormStartDate = findViewById(R.id.edtFormStartDate);
        this.edtFormEndDate = findViewById(R.id.edtFormEndDate);
        this.btnSubmit = findViewById(R.id.btnSubmit);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}