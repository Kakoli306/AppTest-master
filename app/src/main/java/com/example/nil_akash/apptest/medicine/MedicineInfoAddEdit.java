package com.example.nil_akash.apptest.medicine;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nil_akash.apptest.R;
import com.example.nil_akash.apptest.database.DatabaseMedicineInfo;
import com.example.nil_akash.apptest.doctor.DoctorDetails;
import com.example.nil_akash.apptest.modelclass.DoctorInformation;
import com.example.nil_akash.apptest.modelclass.ImageConverter;
import com.example.nil_akash.apptest.modelclass.MedicineInformation;

import java.io.ByteArrayOutputStream;

public class MedicineInfoAddEdit extends AppCompatActivity {

    private ImageButton ibtnPic;
    private EditText drNameET;
    private TextView medicineDetailsET;
    private TextView priscriptionDateET;

    private MedicineInformation mInfo;
    private MedicineInformation mUpInfo;
    private DoctorInformation drInfo;
    private byte[] imageSrc;
    private DatabaseMedicineInfo dbMedicine;
    private String FLAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_info_add_edit);

        FLAG = getIntent().getStringExtra("flag");
        drInfo = (DoctorInformation) getIntent().getSerializableExtra("drData");

        dbMedicine = new DatabaseMedicineInfo(this);
        //mInfo = new MedicineInformation();

        ibtnPic = (ImageButton) findViewById(R.id.ibprecsiptionImage);
        drNameET = (EditText) findViewById(R.id.etprecsiptionDoctorName);
        medicineDetailsET = (TextView) findViewById(R.id.etprecsiptionDetails);
        priscriptionDateET = (TextView) findViewById(R.id.etdate);

        if(FLAG.equals("add")){
            drNameET.setText(drInfo.getDoctorName());
        }

        Toast.makeText(getApplicationContext(),drInfo.getDoctorId()+" "+drInfo.getDoctorName(),Toast.LENGTH_LONG).show();
    }

    //Image set on Image Button click
    public void addPrecsiption(View view) {
        Intent in = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        in.putExtra("crop", "true");
        in.putExtra("outputX", 100);
        in.putExtra("outputY", 150);
        in.putExtra("scale", true);
        in.putExtra("return-data", true);

        startActivityForResult(in, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {

            Bitmap bmp = (Bitmap) data.getExtras().get("data");

            //ibtnPic.setImageBitmap(bmp);
            imageSrc = ImageConverter.getBytes(bmp);
            bmp = ImageConverter.getImage(imageSrc);
            ibtnPic.setImageBitmap(bmp);
            ibtnPic.requestFocus();

        }
    }

    //add all medicine info button click
    public void addMedicineInfo(View view) {
        mUpInfo = new MedicineInformation(drInfo.getDoctorId(),medicineDetailsET.getText().toString(),
                priscriptionDateET.getText().toString(),imageSrc);

        if(FLAG.equals("add")){
            if(dbMedicine.InsertMedicineInfo(mUpInfo)){
                Toast.makeText(this,"Medicine add Successfully"+mUpInfo.getDoctorID(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), DoctorDetails.class);
                intent.putExtra("drData",drInfo);
                startActivity(intent);

            }else {
                Toast.makeText(this,"Error......",Toast.LENGTH_LONG).show();
            }
        }else {

        }

    }
}
