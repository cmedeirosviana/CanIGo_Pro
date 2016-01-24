package paprica_company.canigo_pro.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;

import paprica_company.canigo_pro.Dao.DBAdapter;
import paprica_company.canigo_pro.Dao.Script_Battle;

/**
 * Created by Caio on 20/01/2016.
 */
public class Battle
{
    //--------------------------------------- Atributes: ------------------------------------------
    Drawable photo_1;
    Drawable photo_2;
    int vote_1;
    int vote_2;

    public Drawable getPhoto_1() {
        return photo_1;
    }

    public Drawable getPhoto_2() {
        return photo_2;
    }

    public int getVote_1() {
        return vote_1;
    }

    public int getVote_2() {
        return vote_2;
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


    public Battle(Context ctx) {
        this.mCtx = ctx;
    }
    //----------------------------------- Table DB Methods: ---------------------------------------
    public Battle open() throws SQLException {
        this.mDbHelper = new DatabaseHelper(this.mCtx);
        this.mDb = this.mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        this.mDbHelper.close();
    }

    public long createBattle( Byte pphoto_1, Byte pphoto_2, int pvote_1, int pvote_2 ){
        ContentValues initialValues = new ContentValues();
        initialValues.put(Script_Battle.FeedEntry.COLUMN_IMAGE1,pphoto_1);
        initialValues.put(Script_Battle.FeedEntry.COLUMN_IMAGE2, pphoto_2);
        initialValues.put(Script_Battle.FeedEntry.COLUMN_VOTE1, pvote_1);
        initialValues.put(Script_Battle.FeedEntry.COLUMN_VOTE2, pvote_2);
        return this.mDb.insert(Script_Battle.FeedEntry.TABLE_NAME, null, initialValues);
    }


    public boolean deleteBattle(long rowId) {

        return this.mDb.delete(Script_Battle.FeedEntry.TABLE_NAME, Script_Battle.FeedEntry._ID + "=" + rowId, null) > 0; //$NON-NLS-1$
    }


    public Cursor getAllBattles() {

        return this.mDb.query(Script_Battle.FeedEntry.TABLE_NAME, new String[] { Script_Battle.FeedEntry._ID,
                Script_Battle.FeedEntry.COLUMN_IMAGE1, Script_Battle.FeedEntry.COLUMN_IMAGE2, Script_Battle.FeedEntry.COLUMN_VOTE1, Script_Battle.FeedEntry.COLUMN_VOTE2}, null, null, null, null, null);
    }


    public Cursor getBattle(long rowId) throws SQLException {

        Cursor mCursor =

                this.mDb.query(true, Script_Battle.FeedEntry.TABLE_NAME, new String[] { Script_Battle.FeedEntry._ID,
                        Script_Battle.FeedEntry.COLUMN_IMAGE1, Script_Battle.FeedEntry.COLUMN_IMAGE2, Script_Battle.FeedEntry.COLUMN_VOTE1, Script_Battle.FeedEntry.COLUMN_VOTE2}, Script_Battle.FeedEntry._ID + "=" + rowId, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public boolean updateBattle(long rowId, Byte pphoto_1, Byte pphoto_2, int pvote_1, int pvote_2) {
        ContentValues args = new ContentValues();
        args.put(Script_Battle.FeedEntry.COLUMN_IMAGE1, pphoto_1);
        args.put(Script_Battle.FeedEntry.COLUMN_IMAGE2, pphoto_2);
        args.put(Script_Battle.FeedEntry.COLUMN_VOTE1, pvote_1);
        args.put(Script_Battle.FeedEntry.COLUMN_VOTE2, pvote_2);

        return this.mDb.update(Script_Battle.FeedEntry.TABLE_NAME, args, Script_Battle.FeedEntry._ID + "=" + rowId, null) > 0;
    }
    //------------------------------------ Class Methods: -----------------------------------------



}
