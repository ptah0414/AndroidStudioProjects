package com.course.temp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

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

    private void setData(String name, String price, String url, Bitmap image1, Bitmap image2) {
        TextView data_name = findViewById(R.id.textView2);
        TextView data_price = findViewById(R.id.textView3);
        TextView data_url = findViewById(R.id.textView4);

        ImageView data_image1 = findViewById(R.id.imageView2);
        ImageView data_image2 = findViewById(R.id.imageView3);

        data_name.setText(name);
        data_price.setText(price);
        data_url.setText(url);
        data_image1.setImageBitmap(image1);
        data_image2.setImageBitmap(image2);


    }
}