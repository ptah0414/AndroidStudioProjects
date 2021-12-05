package com.course.myproject;

public class CatItems {

    int image_id;
    int image_id2;
    String cat_item_name;
    String cat_item_price;
    String cat_item_url;

    public CatItems(int id, int id2, String name, String url, String price) {
        this.image_id = id;
        this.image_id2 = id2;
        this.cat_item_name = name;
        this.cat_item_price = price;
        this.cat_item_url = url;
    }

    public int getImageID() {
        return image_id;
    }

    public int getImageID2() {
        return image_id2;
    }

    public String getCatItemName() {
        return cat_item_name;
    }

    public String getCat_item_price() {
        return cat_item_price;
    }

    public String getURL(){
        return cat_item_url;
    }
}
