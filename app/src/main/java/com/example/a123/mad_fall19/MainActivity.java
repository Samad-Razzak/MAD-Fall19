package com.example.a123.mad_fall19;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    EditText confirm;
    EditText email;
    CheckBox cb;
    DatabaseHelper databaseHelper;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.etName);
        password = findViewById(R.id.etPassword);
        confirm = findViewById(R.id.etConfirm);
        email = findViewById(R.id.etEmail);
        cb = findViewById(R.id.checkBox);
        databaseHelper = new DatabaseHelper(this);
        user = new User();
    }

    public void sendMessage(View view)
    {
        String name = username.getText().toString();
        String pass = password.getText().toString();
        String conf = confirm.getText().toString();
        String mail = email.getText().toString();
        boolean isError= false;

        if(name != null && name.equalsIgnoreCase("")){
            username.setError("Please enter Valid user name");
            isError = true;
        }
        if(pass != null && pass.equalsIgnoreCase("")){
            password.setError("Please enter Valid password");
            isError = true;
        }
        if((conf != null && conf.equalsIgnoreCase("")) || pass != conf){
            confirm.setError("Password is not matching");
            isError = true;
        }
        if(mail != null && mail.equalsIgnoreCase("") && !emailValidation(mail)){
            email.setError("Please enter Valid email");
            isError = true;
        }
        if(!cb.isChecked()){
            cb.setTextColor(Color.RED);
            isError = true;
        }

        if(!isError){
            user.setName(name);
            user.setPassword(pass);
            user.setEmail(mail);
            databaseHelper.addUser(user);
            Intent intent = new Intent(this, Drawer.class);
            startActivity(intent);
        }
    }

    private boolean emailValidation(String str){
        boolean isValid = false;

        if(str.contains("@"))
            isValid = true;
        if(str.length() < 5)
            isValid = false;
        return isValid;
    }
}
