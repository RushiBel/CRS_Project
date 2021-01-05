package com.orendasoftware.crs.domain.data.model;

public class QuarantineRecord {
    Integer id;
    String name;
    String mobileNo;
    String type;
    String status;
    String startDate;
    String endDate;

    public QuarantineRecord(Integer id, String name, String mobileNo, String type, String status, String startDate, String endDate) {
        this.id = id;
        this.name = name;
        this.mobileNo = mobileNo;
        this.type = type;
        this.status = status;
        this.startDate= startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
