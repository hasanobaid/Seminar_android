package com.hasan.reservationsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Login extends AppCompatActivity {
EditText username ;
EditText password;
Button login ;
ImageView logo ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inialValue();
    }

    private void inialValue() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        logo = (ImageView) findViewById(R.id.logo);

    }

    public void loginAction(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
