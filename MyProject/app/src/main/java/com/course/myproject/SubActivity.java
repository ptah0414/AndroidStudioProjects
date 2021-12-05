package com.course.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        String name = getIntent().getStringExtra("name");
        String price = getIntent().getStringExtra("price");
        String url = getIntent().getStringExtra("url");

        byte[] arr = getIntent().getByteArrayExtra("image1");
        Bitmap image1 = BitmapFactory.decodeByteArray(arr, 0, arr.length);

        byte[] arr2 = getIntent().getByteArrayExtra("image2");
        Bitmap image2 = BitmapFactory.decodeByteArray(arr2, 0, arr2.length);

        setData(name, price, url, image1, image2);
    }

    private void setData(String name, String price, String url, Bitmap img1, Bitmap img2) {
        TextView data_name = findViewById(R.id.textView1);
        TextView data_information = findViewById(R.id.textView2);
        TextView data_url = findViewById(R.id.textView3);

        ImageView data_img1 = findViewById(R.id.imageView1);
        ImageView data_img2 = findViewById(R.id.imageView2);

        data_name.setText("상품: " + name);
        data_information.setText("가격: " + price);
        data_url.setText("페이지: " + url);
        data_img1.setImageBitmap(img1);
        data_img2.setImageBitmap(img2);
    }
}