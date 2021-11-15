package com.course.mybasicapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.course.mybasicapp.R;
import com.course.mybasicapp.School;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    // 레이아웃의 뷰 객체들과 연결고리 역할을 하는 inner 클래
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView myPicture;
        TextView myText;

        MyViewHolder(View view) {
            super(view);
            myPicture = view.findViewById(R.id.imageView);
            myText = view.findViewById(R.id.textView);
        }
    }

    // School 객체들을 담을 수 있는 리스트
    private ArrayList<School> mySchoolList;

    MyAdapter(ArrayList<School> schools) {
        this.mySchoolList = schools;
    }
    // 아래는 어댑터 클래스의 기본 기능이므로 오버라이드 해야 함. 리싸이클러의 각 행에 사용되는 레이아웃 xml 을 가져옴.

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(v);
    }

    // 리싸이클러에 보여지는 이미지와 문장들을 설정함.
    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.myPicture.setImageResource(mySchoolList.get(position).getImageID());
        myViewHolder.myText.setText(mySchoolList.get(position).getSchoolName());
    }

    @Override
    public int getItemCount() {
        return mySchoolList.size();
    }
}