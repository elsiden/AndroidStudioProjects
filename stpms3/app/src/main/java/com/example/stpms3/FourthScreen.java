package com.example.stpms3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FourthScreen extends AppCompatActivity {

    private TextView info;
    private ArrayAdapter<User> adapter;
    private List<User> users;
    ListView listView;
    private TextView savedInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_screen);

        Bundle arguments = getIntent().getExtras();
        info = findViewById(R.id.info3Text);
        info.setText(arguments.get("info").toString());

        listView = (ListView) findViewById(R.id.list);
        users = new ArrayList<User>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, users);
        listView.setAdapter(adapter);
        savedInfo = findViewById(R.id.savedInfo);
    }

    public void addUser(View view){
        String name = info.getText().toString();

        User user = new User(name);
        users.add(user);
        adapter.notifyDataSetChanged();
        savedInfo.setText("ADDED INFO");
    }

    public void save(View view){
        boolean result = JSONHelper.exportToJSON(this, users);
        if(result){
            Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Data not saved", Toast.LENGTH_LONG).show();
        }

    }

    public void showSaved(View view){
        users = JSONHelper.importFromJSON(this);
        if(users!=null){
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, users);
            listView.setAdapter(adapter);
            Toast.makeText(this, "Data restored", Toast.LENGTH_LONG).show();
            savedInfo.setText("SAVED INFO");
        }
        else{
            Toast.makeText(this, "Data not restored", Toast.LENGTH_LONG).show();
        }

    }
}