package com.example.nil_akash.apptest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nil_akash.apptest.doctor.DoctorList;
import com.example.nil_akash.apptest.userAuthentication.Authontication;
import com.example.nil_akash.apptest.userAuthentication.UserInformation;

public class UserRegistration extends AppCompatActivity {

    private EditText fullNameET;
    private EditText userNameET;
    private EditText passwoardET;
    private EditText emailET;
    private EditText phoneNoET;

    private UserInformation uInfo;
    private Authontication auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        getSupportActionBar().setTitle("Registration");

        fullNameET = (EditText) findViewById(R.id.etfullName);
        userNameET = (EditText) findViewById(R.id.etuserId);
        passwoardET = (EditText) findViewById(R.id.etPassword);
        emailET = (EditText) findViewById(R.id.etemail);
        phoneNoET = (EditText) findViewById(R.id.etphoneNo);

        auth = new Authontication(this);

    }

    public void Registration(View view) {
        if(userNameET.getText().equals("")){
            userNameET.setError("Empty field found");
        }else if(passwoardET.getText().equals("")){
            passwoardET.setError("Empty Field Found");
        }else {
            uInfo = new UserInformation(fullNameET.getText().toString(),userNameET.getText().toString(),
                    passwoardET.getText().toString(),emailET.getText().toString(),phoneNoET.getText().toString());
            auth.addUser(uInfo);

            Toast.makeText(this,"Registration Complete",Toast.LENGTH_SHORT).show();
            UserInformation uInfo = auth.getUSERINFO();
            Toast.makeText(getApplicationContext(),uInfo.getUserId()+" "+uInfo.getPassword(),Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, DoctorList.class);
            //intent.putExtra("uInfo",uInfo);
            startActivity(intent);
        }

    }
}
