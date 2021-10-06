package com.example.dawdexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.database.DbHelper;

public class ListProductActivity extends AppCompatActivity {

    private DbHelper Db;
    private Cursor c;
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Db = new DbHelper(this);
        ListView lvUser = findViewById(R.id.lvProduct);

        c = Db.getAllUser();

        adapter = new SimpleCursorAdapter(this, R.layout.item_product, c,
                new String[]{DbHelper.ID, DbHelper.NAME, DbHelper.QUANTITY},
                new int[]{R.id.tvId, R.id.tvName, R.id.tvQuantity},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        lvUser.setAdapter(adapter);
        lvUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = (Cursor) adapter.getItem(position);
                int _id = cursor.getInt(cursor.getColumnIndex(DbHelper.ID));
                String name = cursor.getString(cursor.getColumnIndex(DbHelper.NAME));
                String gender = cursor.getString(cursor.getColumnIndex(DbHelper.QUANTITY));

                Intent intent = new Intent(String.valueOf(ListProductActivity.this));
                intent.putExtra(DbHelper.ID, _id);
                intent.putExtra(DbHelper.NAME, name);
                intent.putExtra(DbHelper.QUANTITY, quantity);
            }
        });
    }
}