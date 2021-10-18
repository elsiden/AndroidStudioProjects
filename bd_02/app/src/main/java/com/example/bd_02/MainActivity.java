package com.example.bd_02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    TextView fileExist = (TextView)findViewById(R.id.fileExist);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExistBase("file_lab_4");
    }

    public void buttonClick(View view) {

    }

    private boolean ExistBase(String fname) {
        boolean rc = false;
        File f = new File(super.getFilesDir(), fname);
        if (rc = f.exists()) fileExist.setText("File exists?: yes");
        else {

            alertFileCreate(fname);
        }
        return rc;
    }

    public void alertFileCreate(String newFile) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Create File? " + newFile).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                fileExist.setText("File exists?: no. creating...");
            }
        });
        AlertDialog ad = b.create();
        ad.show();
    }

}