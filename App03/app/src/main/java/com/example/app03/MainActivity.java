package com.example.app03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // dummy 실행하는 루틴
    // 시스템에 DummyService.class를 실행하겠다는 것을 intent를 통해 알려줌
    public void startService(View view){
        startService(new Intent(getBaseContext(), DummyService.class));
    }

    public void stopService(View view){
        stopService(new Intent(getBaseContext(), DummyService.class));
    }
}