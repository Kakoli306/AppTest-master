package com.example.nil_akash.apptest.medicine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nil_akash.apptest.R;
import com.example.nil_akash.apptest.database.DatabaseMedicineInfo;
import com.example.nil_akash.apptest.doctor.DoctorDetails;
import com.example.nil_akash.apptest.doctor.DoctorList;
import com.example.nil_akash.apptest.modelclass.ImageConverter;
import com.example.nil_akash.apptest.modelclass.MedicineInformation;

public class MedicineItemShow extends AppCompatActivity {

    private ImageView ivMedicineImage;
    private TextView doctorNameTV;
    private TextView detailsTv;
    private TextView dateTV;

    private MedicineInformation mInfo;
    private DatabaseMedicineInfo dbMInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_item_show);

        getSupportActionBar().setTitle("Medicine Information");

        dbMInfo = new DatabaseMedicineInfo(this);
        mInfo = (MedicineInformation) getIntent().getSerializableExtra("mInfo");

        ivMedicineImage = (ImageView) findViewById(R.id.ivMImage);
        doctorNameTV = (TextView) findViewById(R.id.tvMDrName);
        detailsTv = (TextView) findViewById(R.id.tvMdetails);
        dateTV = (TextView) findViewById(R.id.tvMdate);

        ivMedicineImage.setImageBitmap(ImageConverter.getImage(mInfo.getPrecsiptionImage()));
        doctorNameTV.setText(mInfo.getDrName());
        detailsTv.setText(mInfo.getPrecsiptionDetails());
        dateTV.setText(mInfo.getPrecsiptionDate());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_medicine_info,menu);
        return true;

    }

    public void updateInfoMenu(MenuItem item) {
    }

    public void homeMenu(MenuItem item) {
        Intent intent = new Intent(this, DoctorList.class);
        startActivity(intent);
    }

   /* public void deleteItemMenu(MenuItem item) {
        if(dbMInfo.DeleteMedicineInfo(mInfo)){
            Intent intent = new Intent(this, DoctorDetails.class);
            startActivity(intent);
        }else {
            Toast.makeText(this,"Error ......",Toast.LENGTH_LONG).show();
        }
    }*/

    public void logoutMinfo(MenuItem item) {

    }
}
