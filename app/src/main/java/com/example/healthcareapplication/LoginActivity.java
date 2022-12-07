package com.example.healthcareapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button login;
    TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.txtUsername);
        password = findViewById(R.id.txtPassword);
        login = findViewById(R.id.btnLogin);
        signup = findViewById(R.id.txtSignUp);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                Database db = new Database(getApplicationContext(),"healthCare",null,1);

                if(user.length()==0 || pass.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Invalid Details",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(db.login(user,pass)==1)
                    {
                        Toast.makeText(getApplicationContext(),"Logged In Successfully",Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("username",user);
                        editor.apply();
                        startActivity(new Intent(LoginActivity.this,HomepageActivity.class));
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Invalid username and password",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }


}