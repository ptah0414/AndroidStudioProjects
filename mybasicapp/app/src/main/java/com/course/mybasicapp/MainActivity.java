package com.course.mybasicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager myLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 리싸이클러 뷰에 레이아웃을 설정해 준다. 이 레이아웃은 xml 로 만들어 준 내용을 사용한다.
        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);

        // 아이템들을 목록으로 만들어 준다. 목록은 ArrayList 객체를 사용한다.
        ArrayList<School> schoolsInfo = new ArrayList<>();
        schoolsInfo.add(new School(R.drawable.dongguk, "동국대학교", "http://www.dongguk.edu/mbs/kr/index.jsp"));
        schoolsInfo.add(new School(R.drawable.snu, "서울대학교", "http://www.snu.ac.kr/index.html"));
        schoolsInfo.add(new School(R.drawable.yonsei, "연세대학교", "https://www.yonsei.ac.kr/sc/"));
        schoolsInfo.add(new School(R.drawable.korea, "고려대학교", "http://ㄹwww.korea.ac.kr/"));
        // 목록을 어댑터에 연결해 준다.
        MyAdapter myAdapter = new MyAdapter(schoolsInfo);
        // 어댑터를 뷰에 연결해 준다.
        myRecyclerView.setAdapter(myAdapter);

    }
}