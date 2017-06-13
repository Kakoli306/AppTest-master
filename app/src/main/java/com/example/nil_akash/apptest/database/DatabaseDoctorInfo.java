package com.example.nil_akash.apptest.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nil_akash.apptest.modelclass.DoctorInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NiL-AkAsH on 4/10/2017.
 */

public class DatabaseDoctorInfo {
    private Context context;
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public DatabaseDoctorInfo(Context context) {
        this.context = context;
        dbHelper = new DatabaseHelper(context);
    }

    private void open(){
        db = dbHelper.getWritableDatabase();
    }

    private void close(){
        db.close();
    }

    public boolean InsertDoctorInfo(DoctorInformation drInfo){
        this.open();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COL_DOCTOR_NAME,drInfo.getDoctorName().toString());
        values.put(DatabaseHelper.COL_DOCTOR_DETAILS,drInfo.getDoctorDetails().toString());
        values.put(DatabaseHelper.COL_DOCTOR_MAIL,drInfo.getDoctorMail().toString());
        values.put(DatabaseHelper.COL_DOCTOR_PHONE,drInfo.getDoctorPhone().toString());
        values.put(DatabaseHelper.COL_DOCTOR_FIRST_MEET,drInfo.getDoctorFirstMeetDate().toString());
        values.put(DatabaseHelper.COL_DOCTOR_LAST_MEET,drInfo.getDoctorLastMeetDate().toString());
        values.put(DatabaseHelper.COL_DOCTOR_LOCATION,drInfo.getDoctorLocation().toString());

        long tmp = db.insert(DatabaseHelper.TABLE_DOCTOR_INFORMATION,null,values);
        this.close();
        if(tmp>0) return true;
        else return false;
    }

    public boolean UpdateDoctorInfo(DoctorInformation drInfo){
        this.open();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COL_DOCTOR_NAME,drInfo.getDoctorName().toString());
        values.put(DatabaseHelper.COL_DOCTOR_DETAILS,drInfo.getDoctorDetails().toString());
        values.put(DatabaseHelper.COL_DOCTOR_MAIL,drInfo.getDoctorMail().toString());
        values.put(DatabaseHelper.COL_DOCTOR_PHONE,drInfo.getDoctorPhone().toString());
        values.put(DatabaseHelper.COL_DOCTOR_FIRST_MEET,drInfo.getDoctorFirstMeetDate().toString());
        values.put(DatabaseHelper.COL_DOCTOR_LAST_MEET,drInfo.getDoctorLastMeetDate().toString());
        values.put(DatabaseHelper.COL_DOCTOR_LOCATION,drInfo.getDoctorLocation().toString());

        final String WHERE = DatabaseHelper.COL_DOCTOR_ID+" = "+drInfo.getDoctorId(); // where commend

        long tmp = db.update(DatabaseHelper.TABLE_DOCTOR_INFORMATION,values,WHERE,null); //update doctor info where doctor id match
        this.close();

        if(tmp>0) return true;
        else return false;
    }

    public boolean DeleteDoctorInfo(DoctorInformation drInfo){
        this.open();

        final String WHERE = DatabaseHelper.COL_DOCTOR_ID+" = "+drInfo.getDoctorId();
        long tmp = db.delete(DatabaseHelper.TABLE_DOCTOR_INFORMATION,WHERE,null);
        this.close();
        if(tmp>0) return  true;
        else return false;
    }

    public DoctorInformation SearchByDrId(int drId){
        this.open();
        String WHERE = DatabaseHelper.COL_DOCTOR_ID + " = "+drId;
        DoctorInformation drinfo;
        Cursor cursor = db.query(DatabaseHelper.TABLE_DOCTOR_INFORMATION,null,WHERE,null,null,null,null);
        cursor.moveToFirst();
        if(cursor.getCount()==1){
            drinfo = new DoctorInformation();
            drinfo.setDoctorId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_DOCTOR_ID)));
            drinfo.setDoctorName(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DOCTOR_NAME)));
            drinfo.setDoctorDetails(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DOCTOR_DETAILS)));
            drinfo.setDoctorMail(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DOCTOR_MAIL)));
            drinfo.setDoctorPhone(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DOCTOR_PHONE)));
            drinfo.setDoctorLocation(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DOCTOR_LOCATION)));
            drinfo.setDoctorFirstMeetDate(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DOCTOR_FIRST_MEET)));
            drinfo.setDoctorLastMeetDate(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DOCTOR_LAST_MEET)));
        }else {
            drinfo = new DoctorInformation();
            drinfo.setDoctorName("Not Working");
        }
        return drinfo;
    }

    public List<DoctorInformation> getDrInfo(){
        List<DoctorInformation> dInfoList = new ArrayList<>();

        this.open();
        Cursor cursor = db.query(DatabaseHelper.TABLE_DOCTOR_INFORMATION,null,null,null,null,null,null);

        cursor.moveToFirst();
        for(int i=0;i<cursor.getCount();i++){
            DoctorInformation drinfo = new DoctorInformation();
            drinfo.setDoctorId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_DOCTOR_ID)));
            drinfo.setDoctorName(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DOCTOR_NAME)));
            drinfo.setDoctorDetails(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DOCTOR_DETAILS)));
            drinfo.setDoctorMail(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DOCTOR_MAIL)));
            drinfo.setDoctorPhone(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DOCTOR_PHONE)));
            drinfo.setDoctorLocation(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DOCTOR_LOCATION)));
            drinfo.setDoctorFirstMeetDate(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DOCTOR_FIRST_MEET)));
            drinfo.setDoctorLastMeetDate(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DOCTOR_LAST_MEET)));

            dInfoList.add(drinfo);
            cursor.moveToNext();
        }
        cursor.close();
        this.close();
        return dInfoList;
    }

}
