package com.example.dawdexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.database.DbHelper;

public class MainActivity extends AppCompatActivity {

    private EditText edName;
    private EditText edDes;
    private Button btAdd;
    private Spinner spinner;
    private DbHelper db;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        db = new DbHelper(this);
        db.getReadableDatabase();
    }

    private void initView() {
        edName = findViewById(R.id.edName);
        edDes = findViewById(R.id.edDes);
        btAdd = findViewById(R.id.btRegister);
        checkBox = findViewById(R.id.ck);
        btAdd.setOnClickListener(this);

        String[] gender = {"Male", "Female", "Unknown"};
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gender);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}