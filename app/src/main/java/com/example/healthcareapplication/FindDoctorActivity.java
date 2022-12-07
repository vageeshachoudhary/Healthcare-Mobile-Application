package com.example.healthcareapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);

        CardView logout = findViewById(R.id.cardLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(FindDoctorActivity.this,LoginActivity.class));
            }
        });

        CardView back = findViewById(R.id.cardBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(FindDoctorActivity.this,HomepageActivity.class));
            }
        });

        CardView physician = findViewById(R.id.cardFindPhysicians);
        physician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                intent.putExtra("title","Physicians");
                startActivity(intent);
            }
        });

        CardView surgeon = findViewById(R.id.cardFindSurgeons);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                intent.putExtra("title","Surgeons");
                startActivity(intent);
            }
        });

        CardView dentist = findViewById(R.id.cardFindDentists);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                intent.putExtra("title","Dentists");
                startActivity(intent);
            }
        });

        CardView ent = findViewById(R.id.cardFindENT);
        ent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                intent.putExtra("title","ENT");
                startActivity(intent);
            }
        });




    }
}