package com.example.nil_akash.apptest.doctor;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nil_akash.apptest.MainActivity;
import com.example.nil_akash.apptest.R;
import com.example.nil_akash.apptest.adapter.DoctorAdapter;
import com.example.nil_akash.apptest.database.DatabaseDoctorInfo;
import com.example.nil_akash.apptest.medicine.MedicineInfoAddEdit;
import com.example.nil_akash.apptest.modelclass.DoctorInformation;
import com.example.nil_akash.apptest.userAuthentication.Authontication;
import com.example.nil_akash.apptest.userAuthentication.UserInformation;

import java.util.ArrayList;
import java.util.List;

public class DoctorList extends AppCompatActivity {

    private ListView lvDrList ;
    private List<DoctorInformation> drInfoList = new ArrayList<>();

    private DoctorAdapter adapter;
    private UserInformation uInfo;
    private DatabaseDoctorInfo dbDrInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);
        getSupportActionBar().setTitle("Doctor List");


        dbDrInfo = new DatabaseDoctorInfo(this);        // create doctor database object

        lvDrList = (ListView) findViewById(R.id.lvdoctorList);
        adapter = new DoctorAdapter(this,drInfoList);

        lvDrList.setAdapter(adapter);

        setData();

        lvDrList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),DoctorDetails.class);
                intent.putExtra("drData",drInfoList.get(position));
                startActivity(intent);
            }
        });

    }

    private void setData() {
        drInfoList.addAll(dbDrInfo.getDrInfo());      //get doctor list form database
        adapter.notifyDataSetChanged();         //update list
    }

    public void addDoctor(View view) {
        Intent intent = new Intent(getApplicationContext(),DoctorAdd.class);
        intent.putExtra("flag","add");
        //intent.putExtra("uInfo",uInfo);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    public void Logout(MenuItem item) {
        Authontication auth = new Authontication(this);
        UserInformation uInfo = auth.getUSERINFO();
        if(uInfo.isStatus().equals("true")){
            uInfo.setStatus("false");
            auth.addUser(uInfo);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }
}
