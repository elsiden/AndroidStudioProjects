package com.example.stpms3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class ThirdScreen extends AppCompatActivity {

    private TextView info;
    static final int GALLERY_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_screen);

        Bundle arguments = getIntent().getExtras();
        info = findViewById(R.id.info2Text);
        info.setText(arguments.get("info").toString());

        Button button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
            }
        });
    }

    public void nextBtnClick (View view) {
        EditText sallary = findViewById(R.id.sallaryInput);
        TextView fail = findViewById(R.id.fail2Text);

        Intent intent = new Intent(this, FourthScreen.class);
        try {
            if(!sallary.getText().toString().isEmpty()) {
                intent.putExtra("info", info.getText() + sallary.getText().toString() + "\n");
                fail.setText("");
                startActivity(intent);
            } else {
                fail.setText("Fill all fields");
            }
        } catch (Exception e) {
            fail.setText("Error");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        Bitmap bitmap = null;
        ImageView imageAv = (ImageView) findViewById(R.id.imageAv);

        switch (requestCode) {
            case GALLERY_REQUEST:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = imageReturnedIntent.getData();
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    imageAv.setImageBitmap(bitmap);
                }
        }

    }


}