package com.example.a123.tiawinlocation.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class locationDB extends SQLiteOpenHelper {
    static final String DbName = "TaiwinLocation";
    static final String TbName_1 = "Taipei";
    static final int version = 1;

    //各縣市表格
    static final String CREATE_TB_1 = "CREATE TABLE " + TbName_1 + " (id INTEGER PRIMARY KEY AUTOINCREMENT," + "lat TEXT NOT NULL,lot TEXT NOT NULL);";


    public locationDB(Context context) {
        super(context, DbName, null, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TB_1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
