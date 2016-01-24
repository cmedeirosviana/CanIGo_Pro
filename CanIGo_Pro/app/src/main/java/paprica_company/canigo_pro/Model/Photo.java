package paprica_company.canigo_pro.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;

import paprica_company.canigo_pro.Dao.DBAdapter;
import paprica_company.canigo_pro.Dao.Script_Photo;

public class Photo
{
    //--------------------------------------- Atributes: ------------------------------------------
    Drawable image;
    Style style;
    User user;
    int votes_pos;
    int votes_neg;

    public User getUser() {
        return user;
    }

    public Drawable getImage() {
        return image;
    }

    public Style getStyle() {
        return style;
    }

    public int getVotes_pos() {
        return votes_pos;
    }

    public int getVotes_neg() {
        return votes_neg;
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

    public Photo(Context ctx) {
        this.mCtx = ctx;
    }
    //----------------------------------- Table DB Methods: ---------------------------------------
    public Photo open() throws SQLException {
        this.mDbHelper = new DatabaseHelper(this.mCtx);
        this.mDb = this.mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        this.mDbHelper.close();
    }

    String TABLE_NAME = "PHOTO";
    String COLUMN_STYLE = "style_id";
    String COLUMN_USER = "user_id";
    String COLUMN_IMAGE = "IMAGE";
    String COLUMN_VOTESPOS = "VOTESPOS";
    String COLUMN_VOTESNEG = "VOTESNEG";
    public long createPhoto(Byte pimage, int pstyle, int puser, int pvotes_pos, int pvotes_neg){
        ContentValues initialValues = new ContentValues();
        initialValues.put(Script_Photo.FeedEntry.COLUMN_STYLE, pstyle);
        initialValues.put(Script_Photo.FeedEntry.COLUMN_USER, puser);
        initialValues.put(Script_Photo.FeedEntry.COLUMN_IMAGE, pimage);
        initialValues.put(Script_Photo.FeedEntry.COLUMN_VOTESPOS, pvotes_pos);
        initialValues.put(Script_Photo.FeedEntry.COLUMN_VOTESNEG, pvotes_neg);
        return this.mDb.insert(Script_Photo.FeedEntry.TABLE_NAME, null, initialValues);
    }


    public boolean deletePhoto(long rowId) {

        return this.mDb.delete(Script_Photo.FeedEntry.TABLE_NAME, Script_Photo.FeedEntry._ID + "=" + rowId, null) > 0; //$NON-NLS-1$
    }


    public Cursor getAllPhotos() {

        return this.mDb.query(Script_Photo.FeedEntry.TABLE_NAME, new String[] { Script_Photo.FeedEntry._ID,
                Script_Photo.FeedEntry.COLUMN_STYLE, Script_Photo.FeedEntry.COLUMN_USER, Script_Photo.FeedEntry.COLUMN_IMAGE,
                Script_Photo.FeedEntry.COLUMN_VOTESPOS, Script_Photo.FeedEntry.COLUMN_VOTESNEG}, null, null, null, null, null);
    }


    public Cursor getPhoto(long rowId) throws SQLException {

        Cursor mCursor =

                this.mDb.query(true, Script_Photo.FeedEntry.TABLE_NAME, new String[] { Script_Photo.FeedEntry._ID,
                        Script_Photo.FeedEntry.COLUMN_STYLE, Script_Photo.FeedEntry.COLUMN_USER, Script_Photo.FeedEntry.COLUMN_IMAGE,
                        Script_Photo.FeedEntry.COLUMN_VOTESPOS, Script_Photo.FeedEntry.COLUMN_VOTESNEG}, Script_Photo.FeedEntry._ID + "=" + rowId, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public boolean updatePhoto(long rowId, Byte pimage, int pstyle, int puser, int pvotes_pos, int pvotes_neg){
        ContentValues args = new ContentValues();
        args.put(Script_Photo.FeedEntry.COLUMN_STYLE, pstyle);
        args.put(Script_Photo.FeedEntry.COLUMN_USER, puser);
        args.put(Script_Photo.FeedEntry.COLUMN_VOTESNEG, pvotes_neg);
        args.put(Script_Photo.FeedEntry.COLUMN_IMAGE, pimage);
        args.put(Script_Photo.FeedEntry.COLUMN_VOTESPOS, pvotes_pos);

        return this.mDb.update(Script_Photo.FeedEntry.TABLE_NAME, args, Script_Photo.FeedEntry._ID + "=" + rowId, null) >0;
    }
    //------------------------------------ Class Methods: -----------------------------------------



}
