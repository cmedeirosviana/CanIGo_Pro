package paprica_company.canigo_pro.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;

import paprica_company.canigo_pro.Dao.DBAdapter;
import paprica_company.canigo_pro.Dao.Script_CommentVote;

/**
 * Created by Caio on 20/01/2016.
 */
public class CommentVote
{
    //--------------------------------------- Atributes: ------------------------------------------
    Drawable image;
    boolean voto;
    int n_comment;

    public Drawable getImage()
    {
        return image;
    }

    public int getN_comment()
    {
        return n_comment;
    }

    public boolean isVoto()
    {
        return voto;
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
    public CommentVote(Context ctx) {
        this.mCtx = ctx;
    }
    //----------------------------------- Table DB Methods: ---------------------------------------
    public CommentVote open() throws SQLException {
        this.mDbHelper = new DatabaseHelper(this.mCtx);
        this.mDb = this.mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        this.mDbHelper.close();
    }

    public long createCommentVote(Byte pimage, boolean pvoto, int pn_comment){
        ContentValues initialValues = new ContentValues();
        initialValues.put(Script_CommentVote.FeedEntry.COLUMN_IMAGE, pimage);
        initialValues.put(Script_CommentVote.FeedEntry.COLUMN_VOTE, pvoto);
        initialValues.put(Script_CommentVote.FeedEntry.COLUMN_NUMCOMMENT, pn_comment);
        return this.mDb.insert(Script_CommentVote.FeedEntry.TABLE_NAME, null, initialValues);
    }


    public boolean deleteCommentVote(long rowId) {

        return this.mDb.delete(Script_CommentVote.FeedEntry.TABLE_NAME, Script_CommentVote.FeedEntry._ID + "=" + rowId, null) > 0; //$NON-NLS-1$
    }


    public Cursor getAllCommentVotes() {

        return this.mDb.query(Script_CommentVote.FeedEntry.TABLE_NAME, new String[] { Script_CommentVote.FeedEntry._ID,
                Script_CommentVote.FeedEntry.COLUMN_IMAGE, Script_CommentVote.FeedEntry.COLUMN_NUMCOMMENT, Script_CommentVote.FeedEntry.COLUMN_VOTE }, null, null, null, null, null);
    }


    public Cursor getCommentVote(long rowId) throws SQLException {

        Cursor mCursor =

                this.mDb.query(true, Script_CommentVote.FeedEntry.TABLE_NAME, new String[] { Script_CommentVote.FeedEntry._ID,
                        Script_CommentVote.FeedEntry.COLUMN_IMAGE, Script_CommentVote.FeedEntry.COLUMN_NUMCOMMENT, Script_CommentVote.FeedEntry.COLUMN_VOTE}, Script_CommentVote.FeedEntry._ID + "=" + rowId, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public boolean updateCommentVote(long rowId, Byte pimage, boolean pvoto, int pn_comment) {
        ContentValues args = new ContentValues();
        args.put(Script_CommentVote.FeedEntry.COLUMN_IMAGE, pimage);
        args.put(Script_CommentVote.FeedEntry.COLUMN_VOTE, pvoto);
        args.put(Script_CommentVote.FeedEntry.COLUMN_NUMCOMMENT, pn_comment);

        return this.mDb.update(Script_CommentVote.FeedEntry.TABLE_NAME, args, Script_CommentVote.FeedEntry._ID + "=" + rowId, null) > 0;
    }
    //------------------------------------ Class Methods: -----------------------------------------




}
