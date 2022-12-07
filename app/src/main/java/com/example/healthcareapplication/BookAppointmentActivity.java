package com.example.healthcareapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Timer;

public class BookAppointmentActivity extends AppCompatActivity {

    TextView h2;
    EditText nme,add,no,fee;

    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;

    private Button dateButton,timeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        h2 = findViewById(R.id.txtBookAppHeading);
        nme = findViewById(R.id.txtFullName);
        add = findViewById(R.id.txtAddress);
        no = findViewById(R.id.txtContact);
        fee = findViewById(R.id.txtFees);

        dateButton = findViewById(R.id.btnCalendar);
        timeButton = findViewById(R.id.btnTime);

        nme.setKeyListener(null);
        add.setKeyListener(null);
        no.setKeyListener(null);
        fee.setKeyListener(null);

        Intent i = getIntent();

        String title = i.getStringExtra("txt1");
        String fullname = i.getStringExtra("txt2");
        String address = i.getStringExtra("txt3");
        String number = i.getStringExtra("txt4");
        String fees = i.getStringExtra("txt5");

        h2.setText(title);
        nme.setText(fullname);
        add.setText(address);
        no.setText(number);
        fee.setText(fees + "/-");

        initDatePicker();

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
    }

        private void initDatePicker() {
            DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener(){

                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    month = month + 1;
                   dateButton.setText(dayOfMonth+"/"+"month"+"/"+year);
                }
            };

            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            int style = AlertDialog.THEME_HOLO_DARK;
            datePickerDialog = new DatePickerDialog(this,style,dateSetListener,year,month,day);
            datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000 );

        }

        private void initTimePicker()
        {
            TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener(){

                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    timeButton.setText(i+":"+i1);
                }
            };

            Calendar cal = Calendar.getInstance();
            int hrs = cal.get(Calendar.HOUR);
            int mins = cal.get(Calendar.MINUTE);

            int style = AlertDialog.THEME_HOLO_DARK;
            timePickerDialog = new TimePickerDialog(this,style,timeSetListener,hrs,mins,true);


        }


    }
