package com.example.healthcareapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText regUsername,regPassword,regEmail,regConfirmPass;
    Button register;
    TextView existingUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regUsername = findViewById(R.id.txtRegistrationUsername);
        regPassword = findViewById(R.id.txtRegistrationPassword);
        regEmail = findViewById(R.id.txtRegistrationEmailId);
        regConfirmPass = findViewById(R.id.txtConfirmPassword);
        register = findViewById(R.id.btnRegister);
        existingUser = findViewById(R.id.txtLoginAgain);

        existingUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regUser = regUsername.getText().toString();
                String regPass = regPassword.getText().toString();
                String regEmailId = regEmail.getText().toString();
                String regConfirmPassword = regConfirmPass.getText().toString();
                Database db = new Database(getApplicationContext(),"healthCare",null,1);

                if(regUser.length()==0 || regPass.length()==0 || regEmailId.length()==0 || regConfirmPassword.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Fill all the fields",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(regPass.compareTo(regConfirmPassword)==0)
                {
                    if(isValidPassword(regPass))
                    {
                        db.register(regUser,regEmailId,regPass);
                        Toast.makeText(getApplicationContext(), "Registration successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Password should contain at least 8 characters,having letter,digit and a special character", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Password and Confirm Password fields didn't match", Toast.LENGTH_SHORT).show();
                }

            }
                }
        });

    }

    public static boolean isValidPassword(String passwd) {
        int a=0,b=0,c=0;
        if(passwd.length()<8)
        {
            return false;
        }
        else
        {
            for(int i=0;i<passwd.length();i++)
            {
                if(Character.isLetter(passwd.charAt(i)))
                {
                    a=1;
                }
            }
            for(int j=0;j<passwd.length();j++)
            {
                if(Character.isDigit(passwd.charAt(j)))
                {
                    b=1;
                }
            }
            for(int k=0;k<passwd.length();k++)
            {
               char ch = passwd.charAt(k);
               if(ch>=33&&ch<=46||ch==64)
               {
                   c=1;
               }
            }
            if(a==1 && b==1 && c==1)
            {
                return true;
            }
            return false;
        }
    }

//    public static boolean isValidEmail(String email)
//    {
//        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
//                "[a-zA-Z0-9_+&*-]+)*@" +
//                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
//                "A-Z]{2,7}$";
//
//        Pattern pat = Pattern.compile(emailRegex);
//        if (email == null)
//            return false;
//        return pat.matcher(email).matches();
//    }
}