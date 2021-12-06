package com.course.temp;

public class School {

    int image_id;
    int image_id2;
    String school_name;
    String school_price;
    String school_url;

    public School(int id, int id2, String name, String price, String url) {
        this.image_id = id;
        this.image_id2 = id2;
        this.school_name = name;
        this.school_price = price;
        this.school_url = url;
    }

    public int getImageID() {
        return image_id;
    }

    public int getImageID2() {
        return image_id2;
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
