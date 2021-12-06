package com.course.temp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView myPicture;
        TextView myText;

        MyViewHolder(View view) {
            super(view);
            myPicture = view.findViewById(R.id.imageView);
            myText = view.findViewById(R.id.textView);
        }
    }

    private ArrayList<School> mySchoolList;

    MyAdapter(ArrayList<School> schools) {
        this.mySchoolList = schools;
    }

    // 아래는 어댑터 클래스의 기본 기능이므로 오버라이드 해야 함.
    // 리싸이클러의 각 행에 사용되는 레이아웃 xml 을 가져옴.
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(v);
    }

    // 리싸이클러에 보여지는 이미지와 문장들을 설정함.
    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.myPicture.setImageResource(mySchoolList.get(position).getImageID());
        myViewHolder.myText.setText(mySchoolList.get(position).getSchoolName());

        myViewHolder.myPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, Details.class);

                intent.putExtra("name", mySchoolList.get(position).getSchoolName());
                intent.putExtra("price", mySchoolList.get(position).getSchoolPrice());
                intent.putExtra("url", mySchoolList.get(position).getSchoolURL());

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;

                Bitmap sendBitmap = BitmapFactory.decodeResource(context.getResources(), mySchoolList.get(position).getImageID());
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.JPEG, 50, stream);
                byte[] byteArray = stream.toByteArray();
                intent.putExtra("image1", byteArray);

                Bitmap sendBitmap2 = BitmapFactory.decodeResource(context.getResources(), mySchoolList.get(position).getImageID2());
                ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
                sendBitmap2.compress(Bitmap.CompressFormat.JPEG, 50, stream2);
                byte[] byteArray2 = stream2.toByteArray();
                intent.putExtra("image2", byteArray2);

                context.startActivity(intent);
            }
        });

        myViewHolder.myText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();

                Intent intent = new Intent(context, Details.class);

                intent.putExtra("name", mySchoolList.get(position).getSchoolName());
                intent.putExtra("price", mySchoolList.get(position).getSchoolPrice());
                intent.putExtra("url", mySchoolList.get(position).getSchoolURL());

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;

                Bitmap sendBitmap = BitmapFactory.decodeResource(context.getResources(), mySchoolList.get(position).getImageID());
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.JPEG, 50, stream);
                byte[] byteArray = stream.toByteArray();
                intent.putExtra("image1", byteArray);

                Bitmap sendBitmap2 = BitmapFactory.decodeResource(context.getResources(), mySchoolList.get(position).getImageID2());
                ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
                sendBitmap2.compress(Bitmap.CompressFormat.JPEG, 50, stream2);
                byte[] byteArray2 = stream2.toByteArray();
                intent.putExtra("image2", byteArray2);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mySchoolList.size();
    }
}

