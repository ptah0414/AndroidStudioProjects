package com.course.temp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager myLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);

        // 아이템들을 목록으로 만들어 준다. 목록은 ArrayList 객체를사용한다.
        ArrayList<School> schoolsInfo = new ArrayList<>();
        schoolsInfo.add(new School(R.drawable.tower1, R.drawable.tower2, "캣타워", "10000", "http://www.dongguk.edu/mbs/kr/index.jsp"));
        schoolsInfo.add(new School(R.drawable.matt1, R.drawable.matt2, "매트", "20000", "http://www.snu.ac.kr/index.html"));
        schoolsInfo.add(new School(R.drawable.tub1, R.drawable.tub2, "욕조", "30000", "https://www.yonsei.ac.kr/sc/"));
        schoolsInfo.add(new School(R.drawable.balm1, R.drawable.balm2, "밤", "40000", "http://www.korea.ac.kr/"));
        // 목록을 어댑터에 연결해 준다.
        MyAdapter myAdapter = new MyAdapter(schoolsInfo);
        // 어댑터를 뷰에 연결해 준다.
        myRecyclerView.setAdapter(myAdapter);


        Button b1, b2, b3;

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);

        // phone
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel: 01025571649"));
                startActivity(intent);
            }
        });

        // email
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

        // map
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://maps.google.com/maps?q=" + "동국대학교 신공학관");
                //Uri uri = Uri.parse("http://maps.google.com/maps?q=" + 37.55827 + "," + 126.998425);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    protected void sendEmail() {
        String[] TO = {"ptah0414@naver.com"};
        String[] CC = {"ptah0414@naver.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "이메일연습해봐요");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "이메일 연습 1, 이메일 연습 2");

        try {
            startActivity(Intent.createChooser(emailIntent, "이메일 보내기..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "이메일 클라이언트가 없네요", Toast.LENGTH_SHORT).show();
        }
    }

}