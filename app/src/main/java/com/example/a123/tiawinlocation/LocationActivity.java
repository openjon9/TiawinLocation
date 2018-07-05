package com.example.a123.tiawinlocation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class LocationActivity extends AppCompatActivity {

    private GridView gridview;
    private LocationActivity context;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        context = this;
        findview();
        setlistview();
    }

    private void setlistview() {
        adapter = new ArrayAdapter<String>(context, R.layout.taiwin_item, R.id.item_text, getResources().getStringArray(R.array.TaiwinLocation));
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, LocationListActivity.class);
                intent.putExtra("country", parent.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
    }

    private void findview() {
        gridview = (GridView) findViewById(R.id.gridview);
    }
}
