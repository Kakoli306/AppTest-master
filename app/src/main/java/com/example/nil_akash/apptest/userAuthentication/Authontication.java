package com.example.nil_akash.apptest.userAuthentication;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.Gson;

/**
 * Created by NiL-AkAsH on 4/10/2017.
 */

public class Authontication {
    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String USERINFO_DB = "user_info";
    private static final String USERKEY = "user_key";
    public static UserInformation USERINFO;
    public static String USERNAME;
    public static String PASSWORD;

    public Authontication(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(USERINFO_DB,context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void addUser(UserInformation userInfo){      //user Add Method

        userInfo.setStatus("true");

        Gson gson = new Gson();
        String user = gson.toJson(userInfo);            //convert UserInformation Object to String
        editor.putString(USERKEY,user);
        editor.commit();
        UserInformation uInfo = this.getUSERINFO();
    }

    public boolean haveUser(){
        //user Get Method
        Gson gson = new Gson();
        String json = sharedPreferences.getString(USERKEY,""); //get object as a string
        if(json.equals("")){
            return false;
        }else{
            USERINFO = gson.fromJson(json,UserInformation.class); //convert String to Object
            return true;
        }
    }

    public UserInformation getUSERINFO(){                       //getUser object
        Gson gson = new Gson();
        String json = sharedPreferences.getString(USERKEY,"");
        USERINFO = gson.fromJson(json,UserInformation.class);

        return USERINFO;
    }

    public boolean isUser(String userId,String userPass){           //user Verification Method

        UserInformation uInfo;

        if(this.haveUser()){
            uInfo = this.getUSERINFO();
            if(userId.equals(uInfo.getUserId())&&userPass.equals(uInfo.getPassword())){
                return true;
            }else return false;
        }else return false;
    }
    public boolean userStatus(){
        if(this.getUSERINFO().isStatus().equals("true")) return true;
        else return false;
    }

    public void clear(){
        editor.clear();
        editor.commit();
    }

    public void updateInfo(){
        UserInformation uInfo = this.getUSERINFO();
        this.clear();
        uInfo.setStatus("false");
        this.addUser(uInfo);
    }
}
