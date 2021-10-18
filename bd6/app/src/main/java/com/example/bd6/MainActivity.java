package com.example.bd6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText surname;
    EditText phone;
    EditText birthDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExistBase("fileLab6Public");
        ExistBase("fileLab6Private");
    }

    private final static String FILE_NAME = "bdLab6.txt";
    private File getExternalPath() {
        return new File(getExternalFilesDir(null), FILE_NAME);
    }

    public void filePublicClick(View view) {
        name = findViewById(R.id.nameTxt);
        surname = findViewById(R.id.surnameTxt);
        phone = findViewById(R.id.phoneTxt);
        birthDate = findViewById(R.id.dateBirthTxt);

        String txt=name.getText().toString() + " " +
                surname.getText().toString() + " " +
                phone.getText().toString() + " " +
                birthDate.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(getExternalPath());
            fos.write(txt.getBytes());
            Toast.makeText(this, "File saved", Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally {
            try {
                if(fos!=null)
                    fos.close();
            }
            catch(IOException ex){

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void filePrivateClick(View view) {
        name = findViewById(R.id.nameTxt);
        surname = findViewById(R.id.surnameTxt);
        phone = findViewById(R.id.phoneTxt);
        birthDate = findViewById(R.id.dateBirthTxt);

        if (!name.getText().toString().isEmpty() &&
                !surname.getText().toString().isEmpty() &&
                !phone.getText().toString().isEmpty() &&
                !birthDate.getText().toString().isEmpty()) {
            String str = name.getText().toString() + " " +
                    surname.getText().toString() + " " +
                    phone.getText().toString() + " " +
                    birthDate.getText().toString() + "\n";
            try {
                FileOutputStream fileOutput = openFileOutput("fileLab6Private", MODE_PRIVATE);
                fileOutput.write(str.getBytes());
                fileOutput.close();

                name.setText("");
                surname.setText("");
                phone.setText("");
                birthDate.setText("");

                Log.d("Log_02", "File writed");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean ExistBase(String file) {
        boolean rc = false;
        File f = new File(super.getFilesDir(), file);
        if (rc = f.exists()) Log.d("Log_02", "File: " + file + " exist");
        else {
            createFile(file);
        }
        return rc;
    }

    public void createFile(String file) {
        File f = new File(super.getFilesDir(), file);
        try {
            f.createNewFile();
            Log.d("Log_02", "File: " + file + " created");
        } catch (IOException e) {
            Log.d("Log_02", "File: " + file + "not created");
        }
    }
}