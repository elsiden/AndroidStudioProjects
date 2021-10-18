package com.example.stpms3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

public class SecondScreen extends AppCompatActivity {
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        Bundle arguments = getIntent().getExtras();

        info = findViewById(R.id.infoText);
        info.setText(arguments.get("info").toString());

    }

    public void nextBtnClick (View view) {
        EditText school = findViewById(R.id.schoolText);
        EditText faculty = findViewById(R.id.facultyText);
        EditText phone = findViewById(R.id.phoneInput);
        TextView error = findViewById(R.id.errorText);

        Intent intent = new Intent(this, ThirdScreen.class);
        try {
            if(!school.getText().toString().isEmpty() && !faculty.getText().toString().isEmpty() && !phone.getText().toString().isEmpty()) {
                intent.putExtra("info", info.getText() + school.getText().toString() + "\n" +
                        faculty.getText().toString() + "\n" + phone.getText().toString() + "\n");
                error.setText("");
                startActivity(intent);
            } else {
                error.setText("Fill all fields");
            }
        } catch (Exception e) {
            error.setText("Error");
        }
    }

    public void call(View v) {

        EditText number=(EditText)findViewById(R.id.phoneInput);
        String toDial="tel:"+number.getText().toString();
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(toDial)));
    }
}