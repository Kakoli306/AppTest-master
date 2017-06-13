package com.example.nil_akash.apptest.userAuthentication;

import java.io.Serializable;

/**
 * Created by NiL-AkAsH on 4/10/2017.
 */

public class UserInformation implements Serializable {
    private String userFullName;
    private String userId;
    private String password;
    private String userMail;
    private String userPhone;
    private String status;

    public UserInformation(String userFullName, String userId, String password, String userMail, String userPhone) {
        this.userFullName = userFullName;
        this.userId = userId;
        this.password = password;
        this.userMail = userMail;
        this.userPhone = userPhone;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
