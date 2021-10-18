package com.example.bd6_files_test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        Button priviteBtn=findViewById(R.id.ptivateBtn);
        txtShow = findViewById(R.id.textview);

    }
    public void openText(View view) {
        // getFilesDir при сохранении
        // /data/user/0/rudenia.fit.bstu.bd6/files/BD6.txt
        try {
            FileInputStream fileInput =openFileInput("\\data\\data\\com.example.bd6\\files\\fileLab6Public");
            InputStreamReader reader = new InputStreamReader(fileInput);
            BufferedReader buffer = new BufferedReader(reader);
            // cчитанные строки
            StringBuffer strBuffer = new StringBuffer();
            String lines;
            while ((lines=buffer.readLine())!= null){
                strBuffer.append(lines + "\n");
            }
            txtShow.setText(strBuffer.toString());
        } catch (FileNotFoundException e) {
            Toast.makeText(this, "error1", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "error2", Toast.LENGTH_SHORT).show();
        }
    }
}