package com.course.final01;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    public class MyViewHolder extends RecyclerView.ViewHolder {
        MyViewHolder(View view) {
            super(view);
            myText = view.findViewById(R.id.textView);
            myText2 = view.findViewById(R.id.textView2);
            myText3 = view.findViewById(R.id.textView3);
        }
    }

    private ArrayList<School> mySchoolList;

    MyAdapter(ArrayList<School> schools) {
        this.mySchoolList = schools;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.myText2.setText(mySchoolList.get(position).getSchoolPrice());
        myViewHolder.myText3.setText(mySchoolList.get(position).getSchoolURL());

        // phone
        myViewHolder.myText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("tel:01025571649"));
                context.startActivity(intent);
            }
        });

        // email
        myViewHolder.myText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
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

    @Override
    public int getItemCount() {
        return mySchoolList.size();
    }

}
