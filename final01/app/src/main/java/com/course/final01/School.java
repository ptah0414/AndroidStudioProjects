package com.course.final01;

public class School {
    String school_name;
    String school_price;
    String school_url;

    public School(String name, String price, String url) {
        this.school_name = name;
        this.school_price = price;
        this.school_url = url;
    }

    public String getSchoolName() {
        return school_name;
    }

    public String getSchoolPrice() {
        return school_price;
    }

    public String getSchoolURL() {
        return school_url;
    }
}


