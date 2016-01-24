package paprica_company.canigo_pro.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import paprica_company.canigo_pro.Dao.DBAdapter;
import paprica_company.canigo_pro.Dao.Script_Panel;

/**
 * Created by Caio on 20/01/2016.
 */
public class Panel
{
    //--------------------------------------- Atributes: ------------------------------------------
    User user;
    String panelName;

    public User getUser() {
        return user;
    }

    public String getPanelName() {
        return panelName;
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
    public Panel(Context ctx) {
        this.mCtx = ctx;
    }
    //----------------------------------- Table DB Methods: ---------------------------------------
    public Panel open() throws SQLException {
        this.mDbHelper = new DatabaseHelper(this.mCtx);
        this.mDb = this.mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        this.mDbHelper.close();
    }

    public long createPanel(Long puser, String ppanelName){
        ContentValues initialValues = new ContentValues();
        initialValues.put(Script_Panel.FeedEntry.COLUMN_PANELNAME, ppanelName);
        initialValues.put(Script_Panel.FeedEntry.COLUMN_USER, puser);
        return this.mDb.insert(Script_Panel.FeedEntry.TABLE_NAME, null, initialValues);
    }


    public boolean deletePanel(long rowId) {

        return this.mDb.delete(Script_Panel.FeedEntry.TABLE_NAME, Script_Panel.FeedEntry._ID + "=" + rowId, null) > 0; //$NON-NLS-1$
    }


    public Cursor getAllPanels() {

        return this.mDb.query(Script_Panel.FeedEntry.TABLE_NAME, new String[] { Script_Panel.FeedEntry._ID,
                Script_Panel.FeedEntry.COLUMN_PANELNAME, Script_Panel.FeedEntry.COLUMN_USER }, null, null, null, null, null);
    }


    public Cursor getPanel (long rowId) throws SQLException {

        Cursor mCursor =

                this.mDb.query(true, Script_Panel.FeedEntry.TABLE_NAME, new String[] { Script_Panel.FeedEntry._ID,
                        Script_Panel.FeedEntry.COLUMN_PANELNAME, Script_Panel.FeedEntry.COLUMN_USER}, Script_Panel.FeedEntry._ID + "=" + rowId, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public boolean updatePanel(long rowId, Long puser, String ppanelName){
        ContentValues args = new ContentValues();
        args.put(Script_Panel.FeedEntry.COLUMN_USER, puser);
        args.put(Script_Panel.FeedEntry.COLUMN_PANELNAME, ppanelName);

        return this.mDb.update(Script_Panel.FeedEntry.TABLE_NAME, args, Script_Panel.FeedEntry._ID + "=" + rowId, null) >0;
    }
    //------------------------------------ Class Methods: -----------------------------------------



}
