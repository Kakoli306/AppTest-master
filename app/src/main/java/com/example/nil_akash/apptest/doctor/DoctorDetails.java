package com.example.nil_akash.apptest.doctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nil_akash.apptest.R;
import com.example.nil_akash.apptest.adapter.MedicineAdapter;
import com.example.nil_akash.apptest.database.DatabaseDoctorInfo;
import com.example.nil_akash.apptest.database.DatabaseMedicineInfo;
import com.example.nil_akash.apptest.medicine.MedicineInfoAddEdit;
import com.example.nil_akash.apptest.medicine.MedicineItemShow;
import com.example.nil_akash.apptest.modelclass.DoctorInformation;
import com.example.nil_akash.apptest.modelclass.MedicineInformation;

import java.util.ArrayList;
import java.util.List;

public class DoctorDetails extends AppCompatActivity {

    private TextView drNameTV;
    private TextView drDetailsTV;
    private TextView drEmailTv;
    private TextView drPhoneTV;
    private TextView drLocationTV;
    private TextView drLastAppDateTV;

    private GridView gvMedicine;
    private DoctorInformation drInfo;
    private MedicineAdapter adapter;
    private List<MedicineInformation> mInfoList = new ArrayList<>();
    private DatabaseMedicineInfo dbMInfo;
    private DatabaseDoctorInfo dbDrInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detailse);
        getSupportActionBar().setTitle("Doctor Details");

        drNameTV = (TextView) findViewById(R.id.tvdrName);
        drDetailsTV = (TextView) findViewById(R.id.tvdrDetails);
        drEmailTv = (TextView) findViewById(R.id.tvdrMail);
        drPhoneTV = (TextView) findViewById(R.id.tvdrPhoneNo);
        drLocationTV = (TextView) findViewById(R.id.tvdrLocation);
        drLastAppDateTV = (TextView) findViewById(R.id.tvdrAppointmentDate);

        gvMedicine = (GridView) findViewById(R.id.gridMedicine);

        dbMInfo = new DatabaseMedicineInfo(this);       //medicine database initialize
        dbDrInfo = new DatabaseDoctorInfo(this);        //dr database initialize

        adapter= new MedicineAdapter(this,mInfoList);
        gvMedicine.setAdapter(adapter);

        //drInfo = new DoctorInformation();
        drInfo = (DoctorInformation) getIntent().getSerializableExtra("drData");

        setData();

        drNameTV.setText(drInfo.getDoctorName());
        drDetailsTV.setText(drInfo.getDoctorDetails());
        drEmailTv.setText(drInfo.getDoctorMail());
        drLocationTV.setText(drInfo.getDoctorLocation());
        drPhoneTV.setText(drInfo.getDoctorPhone());
        drLastAppDateTV.setText(drInfo.getDoctorLastMeetDate());

        gvMedicine.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MedicineItemShow.class);
                MedicineInformation mifo = mInfoList.get(position);
                mifo.setDrName(drInfo.getDoctorName());
                mifo.setDoctorID(drInfo.getDoctorId());
                intent.putExtra("mInfo",mifo);
                startActivity(intent);
            }
        });
    }

    private void setData() {

        mInfoList.addAll(dbMInfo.GetMedicineData(drInfo.getDoctorId()));
        adapter.notifyDataSetChanged();
    }

    //fab click and button click
    public void medicineAdd(View view) {
        Intent intent = new Intent(this, MedicineInfoAddEdit.class);
        intent.putExtra("drData",drInfo);
        intent.putExtra("flag","add");
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_dr_details,menu);
        return true;

    }

    public void homeActivity(MenuItem item) {
        Intent intent = new Intent(getApplicationContext(),DoctorList.class);
        startActivity(intent);
    }

    public void doctorAddMenu(MenuItem item) {
        Intent intent = new Intent(getApplicationContext(),DoctorAdd.class);
        intent.putExtra("flag","add");
        startActivity(intent);
    }


    public void doctorEditMenu(MenuItem item) {
        Intent intent = new Intent(getApplicationContext(),DoctorAdd.class);
        intent.putExtra("drData",drInfo);
        intent.putExtra("flag","edit");
        startActivity(intent);
    }

    public void doctorDeleteMenu(MenuItem item) {
        Intent intent = new Intent(getApplicationContext(),DoctorList.class);
        if(dbDrInfo.DeleteDoctorInfo(drInfo)){
            startActivity(intent);
        }else {
            Toast.makeText(this,"Error ........",Toast.LENGTH_LONG).show();
        }
    }

    public void logOutMenu(MenuItem item) {


    }

    public void medicineAddMenu(MenuItem item) {
        Intent intent = new Intent(this, MedicineInfoAddEdit.class);
        intent.putExtra("drData",drInfo);
        intent.putExtra("flag","add");
        startActivity(intent);

    }
}
