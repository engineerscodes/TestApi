package com.example.testapi;

public class districtmodel
{   private String dname,dactive,dcases,ddeaths,drecovered;
    public districtmodel(String dname) {
        this.dname = dname;

    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

}
