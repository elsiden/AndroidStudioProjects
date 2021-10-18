package com.example.bd_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

    }

//    public void onMyButtonClick(View view)
//    {
//        // выводим сообщение
//        Toast.makeText(this, "Зачем вы нажали?", Toast.LENGTH_SHORT).show();
//    }

    public void buttonClick(View view) {
//        File file = new File("/Users/vano41/AndroidStudioProjects/bd_1/file_lab_1");
        File file = super.getFilesDir();

        getInfo(file);
    }

    public void button2Click(View view) {
//        File file = new File("/Users/vano41/AndroidStudioProjects/bd_1/file_lab_1");
        File file = super.getCacheDir();

        getInfo(file);
    }

    public void button3Click(View view) {
//        File file = new File("/Users/vano41/AndroidStudioProjects/bd_1/file_lab_1");
        File file = super.getExternalFilesDir(null);

        getInfo(file);
    }

    public void button4Click(View view) {
//        File file = new File("/Users/vano41/AndroidStudioProjects/bd_1/file_lab_1");
        File file = super.getExternalCacheDir();

        getInfo(file);
    }

    public void button5Click(View view) {
//        File file = new File("/Users/vano41/AndroidStudioProjects/bd_1/file_lab_1");
        File file = Environment.getExternalStorageDirectory();

//        getInfo(file);
    }

    public void button6Click(View view) {
//        File file = new File("/Users/vano41/AndroidStudioProjects/bd_1/file_lab_1");
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