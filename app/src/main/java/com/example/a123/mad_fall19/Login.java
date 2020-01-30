package com.example.a123.mad_fall19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText email;
    EditText password;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        databaseHelper = new DatabaseHelper(this);
    }

    public void signIn(View v)
    {
        String name = email.getText().toString();
        String pass = password.getText().toString();

        boolean isError= false;

        if((name != null && name.equalsIgnoreCase("")) || !emailValidation(name)){
            email.setError("Please enter Valid email");
            isError = true;
        }

        if(pass != null && pass.equalsIgnoreCase("")){
            password.setError("Please enter Valid password");
            isError = true;
        }

        if(!isError){
            if(databaseHelper.checkUser(name,pass)){
                Intent intent = new Intent(this, Drawer.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Invalid username password", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public  void signUp(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public boolean emailValidation(String str){
        boolean isValid = false;

        if(str.contains("@"))
            isValid = true;
        if(str.length() < 5)
            isValid = false;
        return isValid;
    }
}
