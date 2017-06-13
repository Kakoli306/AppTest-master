package com.example.nil_akash.apptest.modelclass;

import java.io.Serializable;

/**
 * Created by NiL-AkAsH on 4/9/2017.
 */

public class DoctorInformation implements Serializable{
    private int doctorId;
    private String doctorName;
    private String doctorDetails;
    private String doctorMail;
    private String doctorPhone;
    private String doctorLocation;
    private String doctorLastMeetDate;
    private String doctorFirstMeetDate;

    public DoctorInformation() {
    }

    public DoctorInformation(int doctorId, String doctorName, String doctorDetails,
                             String doctorMail, String doctorPhone, String doctorLocation,
                             String doctorLastMeetDate, String doctorFirstMeetDate) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorDetails = doctorDetails;
        this.doctorMail = doctorMail;
        this.doctorPhone = doctorPhone;
        this.doctorLocation = doctorLocation;
        this.doctorLastMeetDate = doctorLastMeetDate;
        this.doctorFirstMeetDate = doctorFirstMeetDate;
    }

    public DoctorInformation(String doctorName, String doctorDetails, String doctorMail,
                             String doctorPhone, String doctorLocation, String doctorLastMeetDate,
                             String doctorFirstMeetDate) {
        this.doctorName = doctorName;
        this.doctorDetails = doctorDetails;
        this.doctorMail = doctorMail;
        this.doctorPhone = doctorPhone;
        this.doctorLocation = doctorLocation;
        this.doctorLastMeetDate = doctorLastMeetDate;
        this.doctorFirstMeetDate = doctorFirstMeetDate;
    }



    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorDetails() {
        return doctorDetails;
    }

    public void setDoctorDetails(String doctorDetails) {
        this.doctorDetails = doctorDetails;
    }

    public String getDoctorMail() {
        return doctorMail;
    }

    public void setDoctorMail(String doctorMail) {
        this.doctorMail = doctorMail;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public String getDoctorLocation() {
        return doctorLocation;
    }

    public void setDoctorLocation(String doctorLocation) {
        this.doctorLocation = doctorLocation;
    }

    public String getDoctorLastMeetDate() {
        return doctorLastMeetDate;
    }

    public void setDoctorLastMeetDate(String doctorLastMeetDate) {
        this.doctorLastMeetDate = doctorLastMeetDate;
    }

    public String getDoctorFirstMeetDate() {
        return doctorFirstMeetDate;
    }

    public void setDoctorFirstMeetDate(String doctorFirstMeetDate) {
        this.doctorFirstMeetDate = doctorFirstMeetDate;
    }
}
