package com.example.bd_04;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText lastname;
    private TextView fileContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.nameText);
        lastname = (EditText)findViewById(R.id.lastnameText);
        fileContent = (TextView)findViewById(R.id.fileContent);

        ExistBase("file_lab_4");
    }

    private boolean ExistBase(String fnamed) {
        boolean rc = false;
        File f = new File(super.getFilesDir(), fnamed);
        if (rc = f.exists()) Log.d("Log_02", "File: " + fnamed + " exist");
        else {
            alertFileCreate(fnamed);
        }
        return rc;
    }

    public void alertFileCreate(String newFile) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Create File? " + newFile).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("Log_02", "Creating file: " + newFile);
                createFile(newFile);
            }
        });
        AlertDialog ad = b.create();
        ad.show();
    }

    public void createFile(String fname) {
        File f = new File(super.getFilesDir(), fname);
        try {
            f.createNewFile();
            Log.d("Log_02", "File: " + fname + " created");
        } catch (IOException e) {
            Log.d("Log_02", "File: " + fname + "not created");
        }
    }

    //TODO добавление текста в файл
    public void enterButton(View view) {
        String str = " " + name.getText().toString() + " " + lastname.getText().toString();
        try {
            FileOutputStream fileOutput = openFileOutput("file_lab_4", MODE_APPEND);
            fileOutput.write(str.getBytes());
            fileOutput.close();
            name.setText("");
            lastname.setText("");

            Log.d("Log_02", "File writed");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO вывод текста из файла
    public void buttonClickFileContents(View view){
        try {
            FileInputStream fileInput = openFileInput("file_lab_4");
            InputStreamReader reader = new InputStreamReader(fileInput);
            BufferedReader buffer = new BufferedReader(reader);
            // cчитанные строки
            StringBuffer strBuffer = new StringBuffer();
            String lines;
            while ((lines=buffer.readLine())!= null){
                strBuffer.append(lines + "\n");
            }
            fileContent.setText("String in file: " + strBuffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}