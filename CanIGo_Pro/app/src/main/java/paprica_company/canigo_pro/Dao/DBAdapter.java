package paprica_company.canigo_pro.Dao;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBAdapter {

    public static final String DATABASE_NAME = "DataBase_CanIGo"; //$NON-NLS-1$

    public static final int DATABASE_VERSION = 1;

    private static Context context;
    private static DBAdapter sInstance;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        this.DBHelper = new DatabaseHelper(this.context);
    }

    public static synchronized DBAdapter getinstance()
    {
        if (sInstance == null)
        {
            sInstance = new DBAdapter(context);
        }
        return sInstance;
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(Script_User.FeedEntry.TABLE_NAME);
            db.execSQL(Script_Style.FeedEntry.TABLE_NAME);
            db.execSQL(Script_Pin.FeedEntry.TABLE_NAME);
            db.execSQL(Script_Photo.FeedEntry.TABLE_NAME);
            db.execSQL(Script_Panel.FeedEntry.TABLE_NAME);
            db.execSQL(Script_Info.FeedEntry.TABLE_NAME);
            db.execSQL(Script_CommentVote.FeedEntry.TABLE_NAME);
            db.execSQL(Script_Battle.FeedEntry.TABLE_NAME);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion)
        {
            // Adding any table mods to this guy here
        }
    }

    public DBAdapter open() throws SQLException
    {
        this.db = this.DBHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        this.DBHelper.close();
    }
}