package com.course.final02;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
    }

    public void getStudents(View view) {
        String[] columns = new String[]{"_id", "student_id", "name", "phone_number"};
        Cursor c = getContentResolver().query(MyContentProvider.CONTENT_URI, columns, null,
                null, null, null);
        if (c != null) {
            EditText editMultipleText =
                    findViewById(R.id.editTextTextPersonName4);
            editMultipleText.setText("");
            while (c.moveToNext()) {
                int id = c.getInt(0);
                String number = c.getString(1);
                String name = c.getString(2);
                String phone = c.getString(3);

                editMultipleText.append("id: " + id + "\n number:" + number + "\n name:" + name + "\n phone:" + phone + "\n ");
            }
            editMultipleText.append("\n Total : " + c.getCount());
            c.close();
        }
    }
}