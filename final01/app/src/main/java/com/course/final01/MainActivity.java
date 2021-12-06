package com.course.final01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void addStudent(View view) {
        ContentValues addValues = new ContentValues();
        addValues.put(MyContentProvider.NAME,
                ((EditText) findViewById(R.id.editTextTextPersonName)).getText().toString());
        addValues.put(MyContentProvider.STUDENT_ID,
                ((EditText) findViewById(R.id.editTextTextPersonName2)).getText().toString());
        addValues.put(MyContentProvider.PHONE,
                ((EditText) findViewById(R.id.editTextTextPersonName3)).getText().toString());

        getContentResolver().insert(MyContentProvider.CONTENT_URI, addValues);
        Toast.makeText(getBaseContext(),
                "Record Added", Toast.LENGTH_LONG).show();
    }
}