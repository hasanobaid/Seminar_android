package com.hasan.reservationsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class profile extends AppCompatActivity {

    EditText firstname;
    EditText lastname ;
    EditText personalID;
    EditText email;
    EditText passowrd;
    EditText repassword;
    EditText phonenumber;
    EditText mobilenumber;
    EditText compeny;
    EditText branch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initail();
    }

    private void initail() {
        firstname = (EditText) findViewById(R.id.firstname);
        lastname = (EditText) findViewById(R.id.lastname);
        personalID = (EditText) findViewById(R.id.id);
        passowrd = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.rePassword);
        email = (EditText) findViewById(R.id.email);
        phonenumber = (EditText) findViewById(R.id.phone);
        mobilenumber = (EditText) findViewById(R.id.mobile);
        compeny = (EditText) findViewById(R.id.comp);
        branch = (EditText) findViewById(R.id.branch);
    }
}
