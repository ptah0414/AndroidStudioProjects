package com.course.final01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerView extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager myLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        myRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);

        // 아이템들을 목록으로 만들어 준다. 목록은 ArrayList 객체를사용한다.
        ArrayList<School> schoolsInfo = new ArrayList<>();
        schoolsInfo.add(new School("lee", "01010", "@@naver.com"));

        MyAdapter myAdapter = new MyAdapter(schoolsInfo);
        myRecyclerView.setAdapter(myAdapter);

    }
}