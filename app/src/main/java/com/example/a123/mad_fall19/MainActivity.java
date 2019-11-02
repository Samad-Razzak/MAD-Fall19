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

    EditText firstname;
    EditText lastname;
    EditText gender;
    EditText country;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstname = findViewById(R.id.etFirstName);
        lastname = findViewById(R.id.etLastName);
        gender = findViewById(R.id.etGender);
        country = findViewById(R.id.etCountry);
        cb = findViewById(R.id.checkBox);
    }

    public void sendMessage(View view)
    {
        String fname = firstname.getText().toString();
        String lname = lastname.getText().toString();
        String gen = gender.getText().toString();
        String cntry = country.getText().toString();
        boolean isError= false;

        if(fname != null && fname.equalsIgnoreCase("")){
            firstname.setError("Please enter Valid first name");
            isError = true;
        }
        if(lname != null && lname.equalsIgnoreCase("")){
            lastname.setError("Please enter Valid last name");
            isError = true;
        }
        if(gen != null && gen.equalsIgnoreCase("")){
            gender.setError("Please enter Valid gender");
            isError = true;
        }
        if(cntry != null && cntry.equalsIgnoreCase("")){
            country.setError("Please enter Valid country");
            isError = true;
        }
        if(!cb.isChecked()){
            cb.setTextColor(Color.RED);
            isError = true;
        }

        if(!isError){
            Intent intent = new Intent(this, beauty.class);
            startActivity(intent);
        }
    }

    private boolean userNameValidation(String str){
        boolean isValid = false;

        if(str.contains("@"))
            isValid = true;
        if(str.length() < 5)
            isValid = false;
        return isValid;
    }
}
