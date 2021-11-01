package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {
    // 안드로이드 앱에서는 상속을 통해 기본적인 기능을 가지는 앱들에 추가적인 기능 또는 디자인적인 요소들을 추가한다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_mesage);

        Intent intent = getIntent(); // intent 가져옴
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE); // string 가져옴

        TextView textView = findViewById(R.id.textView);
        textView.setText(message); // 화면에 보여줌

    }
}