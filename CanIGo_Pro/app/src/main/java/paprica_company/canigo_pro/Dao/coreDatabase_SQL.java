package paprica_company.canigo_pro.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Caio on 18/01/2016.
 */

public class coreDatabase_SQL extends SQLiteOpenHelper {
    private static Context content;

    private static coreDatabase_SQL sInstance;

    private static final String DATABASE_NAME = "DataBase_Login.db";
    private static final int DATABASE_VERSION = 1;

    public static synchronized coreDatabase_SQL getInstance() {

          if (sInstance == null)
          {
            sInstance = new coreDatabase_SQL(content);
        }
        return sInstance;
    }
        private coreDatabase_SQL(Context context)
        {
            super(context, "CLIENT_LOGIN", null, DATABASE_VERSION);
            content=context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(Script_SQL.SQL_CREATE_ENTRIES);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(Script_SQL.SQL_DELETE_ENTRIES);
            onCreate(db);
        }
        @Override
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }
        public void clientInsert(String login,String pwd,String email)
        {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put(Script_SQL.FeedEntry.COLUMN_LOGIN, login);
            values.put(Script_SQL.FeedEntry.COLUMN_PWD, pwd);
            values.put(Script_SQL.FeedEntry.COLUMN_EMAIL, email);

            long newRowId;
            newRowId = db.insert(
                    Script_SQL.FeedEntry.TABLE_NAME,
                    null,
                    values);
        }

        public Cursor query_data()
        {
            SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

            Cursor cursor = sqLiteDatabase.query(Script_SQL.FeedEntry.TABLE_NAME, null, null, null, null, null, null);
            return cursor;
        }

}

