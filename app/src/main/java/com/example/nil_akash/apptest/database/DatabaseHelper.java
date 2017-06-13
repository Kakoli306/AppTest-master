package com.example.nil_akash.apptest.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by NiL-AkAsH on 4/10/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME="db_doctor_info";

    //Doctor table information

    public static final String TABLE_DOCTOR_INFORMATION = "tbl_doctor_info";
    public static final String COL_DOCTOR_ID = "col_doctor_id";
    public static final String COL_DOCTOR_NAME = "col_doctor_name";
    public static final String COL_DOCTOR_DETAILS = "col_doctor_details";
    public static final String COL_DOCTOR_MAIL = "col_doctor_mail";
    public static final String COL_DOCTOR_PHONE = "col_doctor_phone";
    public static final String COL_DOCTOR_LOCATION = "col_doctor_location";
    public static final String COL_DOCTOR_FIRST_MEET = "col_doctor_first_meet";
    public static final String COL_DOCTOR_LAST_MEET = "col_doctor_last_meet";

    private static final String DROP_DOCTOR_TABLE = "DROP TABLE IF EXISTS "+TABLE_DOCTOR_INFORMATION;
    //Doctor table create
    private static final String CREATE_DOCTOR_TABLE = "create table "+TABLE_DOCTOR_INFORMATION +" ( "+
            COL_DOCTOR_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COL_DOCTOR_NAME + " text, "+ COL_DOCTOR_DETAILS+" text,"+COL_DOCTOR_MAIL+" text, "+COL_DOCTOR_PHONE+" text, "+
            COL_DOCTOR_LOCATION + " text, "+ COL_DOCTOR_FIRST_MEET + " text, "+COL_DOCTOR_LAST_MEET+" text);";


    //Medicine table information
    public static final String TABLE_MEDICINE_INFORMATION = "tbl_medicine_info";
    public static final String COL_MEDICINE_ID = "col_medicine_id";
    public static final String COL_PRESCRIPTION_DETAILS =  "col_prescription_details";
    public static final String COL_PRESCRIPTION_DATE = "clo_prescription_date";
    public static final String COL_PRESCRIPTION_IMAGE = "col_prescription_image";

    private static final String DROP_MEDICINE_TABLE = "DROP TABLE IF EXISTS "+TABLE_MEDICINE_INFORMATION;
    //Medicine table create
    private static final String CREATE_MEDICINE_TABLE = "create table "+TABLE_MEDICINE_INFORMATION + " ( "+
            COL_MEDICINE_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_DOCTOR_ID+" integer, "+COL_PRESCRIPTION_DETAILS+" text, "+
            COL_PRESCRIPTION_DATE+ " text, "+COL_PRESCRIPTION_IMAGE+" blob );";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DOCTOR_TABLE);            //doctor table create
        db.execSQL(CREATE_MEDICINE_TABLE);          //medicine table create
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_DOCTOR_TABLE);
        db.execSQL(DROP_MEDICINE_TABLE);
        onCreate(db);
    }
}
