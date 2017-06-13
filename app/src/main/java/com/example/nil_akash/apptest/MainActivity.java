package com.example.nil_akash.apptest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nil_akash.apptest.doctor.DoctorList;
import com.example.nil_akash.apptest.userAuthentication.Authontication;
import com.example.nil_akash.apptest.userAuthentication.UserInformation;

public class MainActivity extends AppCompatActivity {

    private Button singinBtn;
    private EditText usernameET;
    private EditText passwordET;

    private Authontication auth;

    private String userName;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Log In");
        auth = new Authontication(this);

        singinBtn = (Button) findViewById(R.id.btnsingIn);
        usernameET = (EditText) findViewById(R.id.etuserName);
        passwordET = (EditText) findViewById(R.id.etpassword);

    }

    /*@Override
    protected void onStart() {
        Authontication aaa = new Authontication(this);
        super.onStart();

        if(aaa.haveUser()){
            if(aaa.getUSERINFO().isStatus().equals("true")){
                Intent intent = new Intent(this,DoctorList.class);
                startActivity(intent);
            }else{
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
            }
        }else {
            UserInformation uInfo = aaa.getUSERINFO();
            uInfo.setStatus("false");
            aaa.addUser(uInfo);
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
*/
    //Start Registration Activity for Registration
    public void registrationPage(View view) {
        Intent intent = new Intent(getApplicationContext(),UserRegistration.class);
        startActivity(intent);
    }

    //Sign In Button CLick
    public void signIn(View view) {
        userName = usernameET.getText().toString();
        password = passwordET.getText().toString();

        if(userName.isEmpty()){
            usernameET.setError("Empty field found");
        }else if(password.isEmpty()) {
            passwordET.setError("Empty field found");
        }else{
            if(auth.isUser(userName,password)){
                Intent intent = new Intent(getApplicationContext(),DoctorList.class);
                startActivity(intent);
            }else{

                Toast.makeText(this,"User Name or Passwoard Wrong",Toast.LENGTH_SHORT).show();
            }
        }

    }
}
