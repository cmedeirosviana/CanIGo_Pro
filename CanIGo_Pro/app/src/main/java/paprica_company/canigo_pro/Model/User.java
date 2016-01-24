package paprica_company.canigo_pro.Model;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import paprica_company.canigo_pro.Dao.DBAdapter;
import paprica_company.canigo_pro.Dao.Script_User;


public class User
{
    //-------------------------------- Atributes:--------------------------------------------------
    String login;
    String psw;
    String email;

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return psw;
    }

    public String getEmail() {
        return email;
    }

    //-------------------------------- DB Stuff: --------------------------------------------------

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
    //-------------------------------------- Builders----------------------------------------------
    public User(Context ctx) {
        this.mCtx = ctx;
    }
    //---------------------------------- Table DB Methods------------------------------------------
    public User open() throws SQLException {
        this.mDbHelper = new DatabaseHelper(this.mCtx);
        this.mDb = this.mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        this.mDbHelper.close();
    }

    public long createUser(String name, String model, String year){
        ContentValues initialValues = new ContentValues();
        initialValues.put(Script_User.FeedEntry.COLUMN_LOGIN, name);
        initialValues.put(Script_User.FeedEntry.COLUMN_EMAIL, model);
        initialValues.put(Script_User.FeedEntry.COLUMN_PWD, year);
        return this.mDb.insert(Script_User.FeedEntry.TABLE_NAME, null, initialValues);
    }


    public boolean deleteUser(long rowId) {

        return this.mDb.delete(Script_User.FeedEntry.TABLE_NAME, Script_User.FeedEntry._ID + "=" + rowId, null) > 0; //$NON-NLS-1$
    }


    public Cursor getAllUsers() {

        return this.mDb.query(Script_User.FeedEntry.TABLE_NAME, new String[] { Script_User.FeedEntry._ID,
                Script_User.FeedEntry.COLUMN_LOGIN, Script_User.FeedEntry.COLUMN_EMAIL, Script_User.FeedEntry.COLUMN_PWD }, null, null, null, null, null);
    }


    public Cursor getUser(long rowId) throws SQLException {

        Cursor mCursor =

                this.mDb.query(true, Script_User.FeedEntry.TABLE_NAME, new String[] { Script_User.FeedEntry._ID,
                        Script_User.FeedEntry.COLUMN_EMAIL, Script_User.FeedEntry.COLUMN_LOGIN, Script_User.FeedEntry.COLUMN_PWD}, Script_User.FeedEntry._ID + "=" + rowId, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public boolean updateUser(long rowId, String name, String model,
                             String year){
        ContentValues args = new ContentValues();
        args.put(Script_User.FeedEntry.COLUMN_LOGIN, name);
        args.put(Script_User.FeedEntry.COLUMN_EMAIL, model);
        args.put(Script_User.FeedEntry.COLUMN_PWD, year);

        return this.mDb.update(Script_User.FeedEntry.TABLE_NAME, args, Script_User.FeedEntry._ID + "=" + rowId, null) >0;
    }
    //------------------------------------ Class Methods-------------------------------------------
}
