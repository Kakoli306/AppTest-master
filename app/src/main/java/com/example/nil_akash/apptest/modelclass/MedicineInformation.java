package com.example.nil_akash.apptest.modelclass;

import java.io.Serializable;

/**
 * Created by NiL-AkAsH on 4/9/2017.
 */

public class MedicineInformation  implements Serializable{
    private int precsiptionId;
    private String drName;
    private int doctorID;
    private String precsiptionDetails;
    private String precsiptionDate;
    private byte[] precsiptionImage;

    public MedicineInformation() {
    }

    public MedicineInformation(int doctorID, String precsiptionDetails, String precsiptionDate, byte[] precsiptionImage) {
        this.doctorID = doctorID;
        this.precsiptionDetails = precsiptionDetails;
        this.precsiptionDate = precsiptionDate;
        this.precsiptionImage = precsiptionImage;
    }

    public MedicineInformation(String precsiptionDetails, String precsiptionDate, byte[] precsiptionImage) {
        this.precsiptionDetails = precsiptionDetails;
        this.precsiptionDate = precsiptionDate;
        this.precsiptionImage = precsiptionImage;
    }

    public MedicineInformation(int doctorID, String drName, String precsiptionDetails, String precsiptionDate, byte[] precsiptionImage) {
        this.drName = drName;
        this.doctorID = doctorID;
        this.precsiptionDetails = precsiptionDetails;
        this.precsiptionDate = precsiptionDate;
        this.precsiptionImage = precsiptionImage;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getPrecsiptionDetails() {
        return precsiptionDetails;
    }

    public void setPrecsiptionDetails(String precsiptionDetails) {
        this.precsiptionDetails = precsiptionDetails;
    }

    public String getPrecsiptionDate() {
        return precsiptionDate;
    }

    public void setPrecsiptionDate(String precsiptionDate) {
        this.precsiptionDate = precsiptionDate;
    }

    public byte[] getPrecsiptionImage() {
        return precsiptionImage;
    }

    public void setPrecsiptionImage(byte[] precsiptionImage) {
        this.precsiptionImage = precsiptionImage;
    }
    public String getDrName() {
        return drName;
    }

    public void setDrName(String drName) {
        this.drName = drName;
    }

    public int getPrecsiptionId() {
        return precsiptionId;
    }

    public void setPrecsiptionId(int precsiptionId) {
        this.precsiptionId = precsiptionId;
    }
}
