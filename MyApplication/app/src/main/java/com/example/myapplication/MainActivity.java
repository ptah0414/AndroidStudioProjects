package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myapplication";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // AppcompatActivity의 디폴트 인스턴스 생성
        setContentView(R.layout.activity_main); // R.layout -> resource의 ㅣayout
    }

    public void sendMessage(View view) {    // 버튼을 눌렀을 때 동작을 정의
        Intent intent = new Intent(this, DisplayMessageActivity.class); // 1. intent 생성
        EditText editText = (EditText)findViewById(R.id.editTextTextPersonName); // 텍스트 받음
        String message = editText.getText().toString(); // 텍스트를 message에 넣음
        intent.putExtra(EXTRA_MESSAGE, message); // 2. intent에 내용 넣음(다음 페이지에 보여줄 메세지)
        startActivity(intent); // 3. intent에 해당하는 화면 실행
    }
}
