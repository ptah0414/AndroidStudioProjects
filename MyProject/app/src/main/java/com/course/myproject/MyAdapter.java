package com.course.myproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

    private ArrayList<CatItems> myCatItemsList;

    MyAdapter(ArrayList<CatItems> catItems) {
        this.myCatItemsList = catItems;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position){
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.myPicture.setImageResource(myCatItemsList.get(position).getImageID());
        myViewHolder.myText.setText(myCatItemsList.get(position).getCatItemName());

        myViewHolder.myPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, SubActivity.class);

                intent.putExtra("name", myCatItemsList.get(position).getCatItemName());
                intent.putExtra("price", myCatItemsList.get(position).getCat_item_price());
                intent.putExtra("url", myCatItemsList.get(position).getURL());

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap sendBitmap = BitmapFactory.decodeResource(context.getResources(), myCatItemsList.get(position).getImageID());
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.JPEG, 50, stream);
                byte[] byteArray = stream.toByteArray();
                intent.putExtra("image1", byteArray);

                Bitmap sendBitmap2 = BitmapFactory.decodeResource(context.getResources(), myCatItemsList.get(position).getImageID2());
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
                Intent intent = new Intent(context, SubActivity.class);

                intent.putExtra("name", myCatItemsList.get(position).getCatItemName());
                intent.putExtra("price", myCatItemsList.get(position).getCat_item_price());
                intent.putExtra("url", myCatItemsList.get(position).getURL());

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap sendBitmap = BitmapFactory.decodeResource(context.getResources(), myCatItemsList.get(position).getImageID());
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.JPEG, 50, stream);
                byte[] byteArray = stream.toByteArray();
                intent.putExtra("image1", byteArray);

                Bitmap sendBitmap2 = BitmapFactory.decodeResource(context.getResources(), myCatItemsList.get(position).getImageID2());
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
        return myCatItemsList.size();
    }

}