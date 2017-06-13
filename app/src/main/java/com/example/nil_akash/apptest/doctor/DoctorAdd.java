package com.example.nil_akash.apptest.doctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nil_akash.apptest.R;
import com.example.nil_akash.apptest.database.DatabaseDoctorInfo;
import com.example.nil_akash.apptest.modelclass.DoctorInformation;
import com.example.nil_akash.apptest.userAuthentication.UserInformation;

public class DoctorAdd extends AppCompatActivity {

    private EditText drNameET;
    private EditText drDetailsET;
    private EditText drEmailET;
    private EditText drPhoneET;
    private EditText drLocationET;
    private EditText drAppDateET;
    private Button btn;

    private String FLAG;
    private DoctorInformation drInfo;
    private DatabaseDoctorInfo dbDoctor;        //doctor Database object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_add);

        //Doctor database Initial
        dbDoctor = new DatabaseDoctorInfo(this);

        FLAG = getIntent().getStringExtra("flag");
        drInfo = (DoctorInformation) getIntent().getSerializableExtra("drData");

        if(FLAG.equals("add")){
            getSupportActionBar().setTitle("Add Doctor");

        }else{
            getSupportActionBar().setTitle("Update Doctor Info");
        }

        drNameET = (EditText) findViewById(R.id.etdoctorName);
        drDetailsET = (EditText) findViewById(R.id.etdoctorDetails);
        drEmailET  = (EditText) findViewById(R.id.etEmail);
        drPhoneET = (EditText) findViewById(R.id.etPhoneno);
        drLocationET = (EditText) findViewById(R.id.etlocation);
        drAppDateET = (EditText) findViewById(R.id.etdate);
        btn = (Button) findViewById(R.id.btnAddEdit);

        if(FLAG.equals("add")){
            btn.setText("Add Doctor");

        }else {
            btn.setText("Update Doctor");
            drNameET.setText(drInfo.getDoctorName());
            drDetailsET.setText(drInfo.getDoctorDetails());
            drEmailET.setText(drInfo.getDoctorMail());
            drPhoneET.setText(drInfo.getDoctorPhone());
            drLocationET.setText(drInfo.getDoctorLocation());
            drAppDateET.setText(drInfo.getDoctorLastMeetDate());
        }

    }

    public void addEditDr(View view) {
        DoctorInformation dInfo = new DoctorInformation(drNameET.getText().toString(),drDetailsET.getText().toString(),
                drEmailET.getText().toString(),drPhoneET.getText().toString(),drLocationET.getText().toString(),
                drAppDateET.getText().toString(),drAppDateET.getText().toString());

        if(FLAG.equals("add")){

            if(dbDoctor.InsertDoctorInfo(dInfo)){
                Toast.makeText(this,"Doctor Information Add Successfully",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,DoctorList.class);
                //intent.putExtra("uInfo",uInfo);
                startActivity(intent);
            }else {
                Toast.makeText(this,"Something Wrong",Toast.LENGTH_SHORT).show();
            }
        }else {
            dInfo.setDoctorId(drInfo.getDoctorId());
            if(dbDoctor.UpdateDoctorInfo(dInfo)){
                Toast.makeText(getApplicationContext(),"Update success",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),DoctorDetails.class);
                DoctorInformation ddInfo = dbDoctor.SearchByDrId(drInfo.getDoctorId());
                intent.putExtra("drData",ddInfo);
                startActivity(intent);
            }
        }
    }
}
