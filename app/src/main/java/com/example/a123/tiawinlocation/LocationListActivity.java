package com.example.a123.tiawinlocation;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a123.tiawinlocation.Class.location;
import com.example.a123.tiawinlocation.DB.locationDB;

import java.util.ArrayList;
import java.util.List;

public class LocationListActivity extends AppCompatActivity {

    private String country;
    private LocationListActivity context;
    private ListView listview;
    private List<location> list = new ArrayList<>();
    private locationDB dbHelper;
    private SQLiteDatabase db;
    private listAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);
        context = this;
        findview();
        setlistview();
        country = getIntent().getStringExtra("country");
        setTitle(country);


        dbHelper = new locationDB(this);
        db = dbHelper.getWritableDatabase();

    }

    private void setlistview() {
        adapter = new listAdapter(context, list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showlistDialog();
            }
        });
    }

    private void showlistDialog() {
        new AlertDialog.Builder(context)
                .setTitle("選擇")
                .setItems(new CharSequence[]{"修改", "刪除"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                Toast.makeText(context, "修改", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(context, "刪除", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                })
                .show();
    }

    private void findview() {
        listview = (ListView) findViewById(R.id.listview);

    }


}
