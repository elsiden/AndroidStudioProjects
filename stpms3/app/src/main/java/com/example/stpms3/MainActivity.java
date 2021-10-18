package com.example.stpms3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String[] studys = {"High", "Middle", "Low"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner studySpinner = (Spinner) findViewById(R.id.studySpinner);
        ArrayAdapter<String> adapterStudy = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, studys);
        adapterStudy.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        studySpinner.setAdapter(adapterStudy);

        ExistBase("data.json");
    }

    //TODO диалоговое окно для создания файла в памятиs
    public void Dialog(String fname){
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Необходимо создать файл" + " " + fname).setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("Log_02", "Создание файла" + fname);
            }
        });
        AlertDialog ad = b.create();
        ad.show();


    }
    //TODO проверка наличия файла в памяти
    private boolean ExistBase(String fname){
        boolean rc =false;
        File f = new File(super.getFilesDir(),fname);
        if (rc = f.exists()) Log.d("Log_02","Файл"+fname + "существует");
        else {
            Log.d("Log_02","Файл"+fname+"не найден");
            Dialog(fname);
            CreateFile(fname);

        }
        return rc;

    }
    //TODO создание файла в памяти
    public  void CreateFile(String fname){
        File f = new File(super.getFilesDir(),fname);
        try{
            f.createNewFile();
            Log.d("Log_02","Файл"+fname+"Создан");
        }
        catch (IOException e) {
            Log.d("Log_02","Файл"+fname+ "Не создан");
        }
    }

    public void nextBtnClick (View view) {
        EditText name = findViewById(R.id.nameInput);
        EditText email = findViewById(R.id.emailInput);
        Spinner study = findViewById(R.id.studySpinner);
        CheckBox workExp = findViewById(R.id.workCheckBox);
        TextView exepText = findViewById(R.id.exepText);

        Intent intent = new Intent(this, SecondScreen.class);
        try {
            if (!name.getText().toString().isEmpty() && !email.getText().toString().isEmpty()) {
                if(workExp.isChecked()) {
                    intent.putExtra("info", name.getText().toString() +
                            "\n" + email.getText().toString() + "\n" +
                            study.getSelectedItem().toString() + "\nWith work experience\n");
                } else {
                    intent.putExtra("info", name.getText().toString() +
                            "\n" + email.getText().toString() + "\n" +
                            study.getSelectedItem().toString() + "\nWithout work experience\n");
                }
                exepText.setText("");
                startActivity(intent);
            } else {
                exepText.setText("Fill all fields");
            }

        } catch (Exception e) {
            exepText.setText("Error");
        }
    }

    public void email(View v) {
        TextView exepText = findViewById(R.id.exepText);

        EditText email=(EditText)findViewById(R.id.emailInput);
        String toDial=email.getText().toString();
        Intent intent = new Intent (Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{toDial});
        intent.putExtra(Intent.EXTRA_SUBJECT, "hello. this is a message sent from STPMS 4 BSTU");
        intent.setPackage("com.google.android.gm");
        if (intent.resolveActivity(getPackageManager())!=null) {
            startActivity(intent);
            exepText.setText("");
        }
        else
            exepText.setText("G-mail not installed");
    }

}