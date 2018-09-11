package jockercode.parking.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import jockercode.parking.Pojo.Record;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class HelperDB extends SQLiteOpenHelper{
    public static final String DB="parking.db";
    public static final int Version=2;

    public HelperDB(Context context) {
        super(context, DB, null, Version);
    }
    static {
        cupboard().register(Record.class);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        cupboard().withDatabase(db).createTables();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        cupboard().withDatabase(db).upgradeTables();
    }
}
