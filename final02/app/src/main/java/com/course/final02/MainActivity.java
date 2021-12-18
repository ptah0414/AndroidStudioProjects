package com.course.final02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        b1 = (Button) findViewById(R.id.button);
//
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Context context = v.getContext();
//
//                Intent intent = new Intent(context, Details.class);
//                context.startActivity(intent);
//            }
//        });
    }

    public void addStudent(View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, RecyclerView.class);
        context.startActivity(intent);

//        ContentValues addValues = new ContentValues();
//        addValues.put(MyContentProvider.NAME,
//                ((EditText) findViewById(R.id.editTextTextPersonName)).getText().toString());
//        addValues.put(MyContentProvider.STUDENT_ID,
//                ((EditText) findViewById(R.id.editTextTextPersonName2)).getText().toString());
//        addValues.put(MyContentProvider.PHONE,
//                ((EditText) findViewById(R.id.editTextTextPersonName3)).getText().toString());
//
//        getContentResolver().insert(MyContentProvider.CONTENT_URI, addValues);
//        Toast.makeText(getBaseContext(),
//                "Record Added", Toast.LENGTH_LONG).show();

    }
}