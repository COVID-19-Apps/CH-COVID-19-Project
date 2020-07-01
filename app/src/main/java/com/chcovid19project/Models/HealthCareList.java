package com.chcovid19project.Models;

public class HealthCareList {

    String sno, name, type;

    public HealthCareList() {
    }

    public HealthCareList(String sno, String name, String type) {
        this.sno = sno;
        this.name = name;
        this.type = type;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
