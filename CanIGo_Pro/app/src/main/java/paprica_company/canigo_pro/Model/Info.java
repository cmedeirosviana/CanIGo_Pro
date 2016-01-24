package paprica_company.canigo_pro.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Property;
import paprica_company.canigo_pro.Dao.DBAdapter;
import paprica_company.canigo_pro.Dao.Script_Info;

import android.graphics.drawable.Drawable;


public class Info {
    //--------------------------------------- Atributes: ------------------------------------------

    Drawable photo;
    String name;
    String birthDate;
    Boolean sex;
    User user;
    Style style;

    public User getUser() {return user; }

    public Drawable getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Boolean getSex() {
        return sex;
    }
    //------------------------------------ DB Constructor: ----------------------------------------

    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;
    private final Context mCtx;

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DBAdapter.DATABASE_NAME, null, DBAdapter.DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }
    //-------------------------------------- Builders: --------------------------------------------

    public Info(Context ctx) {
        this.mCtx = ctx;
    }
    //----------------------------------- Table DB Methods: ---------------------------------------
    public Info open() throws SQLException {
        this.mDbHelper = new DatabaseHelper(this.mCtx);
        this.mDb = this.mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        this.mDbHelper.close();
    }

    public long createInfo (Byte pphoto, String pname, String pbirthDate, Boolean psex, Long puser, Long pstyle)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(Script_Info.FeedEntry.COLUMN_DATEBIRTH, pbirthDate);
        initialValues.put(Script_Info.FeedEntry.COLUMN_IMAGE, pphoto);
        initialValues.put(Script_Info.FeedEntry.COLUMN_NAME, pname);
        initialValues.put(Script_Info.FeedEntry.COLUMN_SEX, psex);
        initialValues.put(Script_Info.FeedEntry.COLUMN_STYLE, pstyle);
        initialValues.put(Script_Info.FeedEntry.COLUMN_USER, puser);
        return this.mDb.insert(Script_Info.FeedEntry.TABLE_NAME, null, initialValues);
    }


    public boolean deleteInfo(long rowId) {

        return this.mDb.delete(Script_Info.FeedEntry.TABLE_NAME, Script_Info.FeedEntry._ID + "=" + rowId, null) > 0; //$NON-NLS-1$
    }


    public Cursor getAllInfos() {

        return this.mDb.query(Script_Info.FeedEntry.TABLE_NAME, new String[] { Script_Info.FeedEntry._ID,
                Script_Info.FeedEntry.COLUMN_DATEBIRTH, Script_Info.FeedEntry.COLUMN_IMAGE, Script_Info.FeedEntry.COLUMN_NAME,
                Script_Info.FeedEntry.COLUMN_STYLE, Script_Info.FeedEntry.COLUMN_USER, Script_Info.FeedEntry.COLUMN_SEX }, null, null, null, null, null);
    }


    public Cursor getInfo(long rowId) throws SQLException {

        Cursor mCursor =

                this.mDb.query(true, Script_Info.FeedEntry.TABLE_NAME, new String[] { Script_Info.FeedEntry._ID,
                        Script_Info.FeedEntry.COLUMN_DATEBIRTH, Script_Info.FeedEntry.COLUMN_IMAGE, Script_Info.FeedEntry.COLUMN_NAME,
                        Script_Info.FeedEntry.COLUMN_STYLE, Script_Info.FeedEntry.COLUMN_USER, Script_Info.FeedEntry.COLUMN_SEX}, Script_Info.FeedEntry._ID + "=" + rowId, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public boolean updateInfo(long rowId, Byte pphoto, String pname, String pbirthDate, Boolean psex, Long puser, Long pstyle) {
        ContentValues args = new ContentValues();
        args.put(Script_Info.FeedEntry.COLUMN_DATEBIRTH, pbirthDate);
        args.put(Script_Info.FeedEntry.COLUMN_IMAGE, pphoto);
        args.put(Script_Info.FeedEntry.COLUMN_NAME, pname);
        args.put(Script_Info.FeedEntry.COLUMN_SEX, psex);
        args.put(Script_Info.FeedEntry.COLUMN_STYLE, pstyle);
        args.put(Script_Info.FeedEntry.COLUMN_USER, puser);

        return this.mDb.update(Script_Info.FeedEntry.TABLE_NAME, args, Script_Info.FeedEntry._ID + "=" + rowId, null) > 0;
    }
    //------------------------------------ Class Methods: -----------------------------------------


}
