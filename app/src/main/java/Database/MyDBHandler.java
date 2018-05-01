package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Adrian on 2018-05-01.
 */

public class MyDBHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Stocks.db";
    public static final String TABLE_NAME = "stocks_table";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "PRICE";

    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("create table "+ TABLE_NAME + " (NAME TEXT, PRICE INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
onCreate(db);
    }
    public boolean insertData (String name, int price){
            SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,price);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;

    }
}
