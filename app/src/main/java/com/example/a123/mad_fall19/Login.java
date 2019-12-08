package com.example.a123.mad_fall19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;

public class Login extends AppCompatActivity {

    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
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
            Intent intent = new Intent(this, beauty.class);
            intent.putExtra("NAME", name);
            startActivity(intent);
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
