package com.example.bd3;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

    }

    public void buttonClick(View view) {
        File file = super.getFilesDir();

        getInfo(file);
    }

    public void button2Click(View view) {
        File file = super.getCacheDir();

        getInfo(file);
    }

    public void button3Click(View view) {
        File file = super.getExternalFilesDir(null);

        getInfo(file);
    }

    public void button4Click(View view) {
        File file = super.getExternalCacheDir();

        getInfo(file);
    }

    public void button5Click(View view) {
        File file = Environment.getExternalStorageDirectory();

        getInfo(file);
    }

    public void button6Click(View view) {
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        getInfo(file);
    }

    public void getInfo(File file) {
        String fileEnv = Environment.getExternalStorageState();

        TextView absolute = (TextView)findViewById(R.id.absolute);
        absolute.setText("Absolute: " + file.getAbsolutePath());

        TextView name = (TextView)findViewById(R.id.name);
        name.setText("Name: " + file.getName());

        TextView path = (TextView)findViewById(R.id.path);
        path.setText("Path: " + file.getPath());

        TextView readWrite = (TextView)findViewById(R.id.readWrite);
        readWrite.setText("Read/Write: " + file.canRead() + "/" + file.canWrite());

        TextView external = (TextView)findViewById(R.id.external);
        external.setText("External: " + fileEnv);
    }
}