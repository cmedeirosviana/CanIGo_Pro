package paprica_company.canigo_pro.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import paprica_company.canigo_pro.Dao.DBAdapter;
import paprica_company.canigo_pro.Dao.Script_Pin;


public class Pin
{
    //--------------------------------------- Atributes: ------------------------------------------
    byte[] imagem;
    String folder;

    public byte[] getImagem() { return imagem; }

    public String getFolder() { return folder; }
    //------------------------------------ DB Constructor: ----------------------------------------
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    private final Context mCtx;

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DBAdapter.DATABASE_NAME, null, DBAdapter.DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
        }
    }

    //-------------------------------------- Builders: --------------------------------------------
    public Pin(String pfolder, byte[] pimage)
    {
        this.mCtx = DBAdapter.getContext();
        open();
        createPin(pfolder, pimage);
        close();
    }
    //----------------------------------- Table DB Methods: ---------------------------------------
    public Pin open() throws SQLException
    {
        this.mDbHelper = new DatabaseHelper(this.mCtx);
        this.mDb = this.mDbHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        this.mDbHelper.close();
    }

    public long createPin(String pfolder, byte[] pimage)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(Script_Pin.FeedEntry.COLUMN_FOLDER, pfolder);
        initialValues.put(Script_Pin.FeedEntry.COLUMN_IMAGE, pimage);
        return this.mDb.insert(Script_Pin.FeedEntry.TABLE_NAME, null, initialValues);
    }


    public boolean deletePin(long rowId)
    {

        return this.mDb.delete(Script_Pin.FeedEntry.TABLE_NAME, Script_Pin.FeedEntry._ID + "=" + rowId, null) > 0; //$NON-NLS-1$
    }


    public Cursor getAllPins()
    {

        return this.mDb.query(Script_Pin.FeedEntry.TABLE_NAME, new String[] { Script_Pin.FeedEntry._ID,
                Script_Pin.FeedEntry.COLUMN_FOLDER, Script_Pin.FeedEntry.COLUMN_IMAGE}, null, null, null, null, null);
    }


    public Cursor getPin(long rowId) throws SQLException
    {

        Cursor mCursor =

                this.mDb.query(true, Script_Pin.FeedEntry.TABLE_NAME, new String[] { Script_Pin.FeedEntry._ID,
                        Script_Pin.FeedEntry.COLUMN_IMAGE, Script_Pin.FeedEntry.COLUMN_FOLDER}, Script_Pin.FeedEntry._ID + "=" + rowId, null, null, null, null, null);
        if (mCursor != null)
        {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public boolean updatePin(long rowId, String name, String model,
                              String year)
    {
        ContentValues args = new ContentValues();
        args.put(Script_Pin.FeedEntry.COLUMN_IMAGE, name);
        args.put(Script_Pin.FeedEntry.COLUMN_FOLDER, model);

        return this.mDb.update(Script_Pin.FeedEntry.TABLE_NAME, args, Script_Pin.FeedEntry._ID + "=" + rowId, null) >0;
    }
    //------------------------------------ Class Methods: -----------------------------------------




}
