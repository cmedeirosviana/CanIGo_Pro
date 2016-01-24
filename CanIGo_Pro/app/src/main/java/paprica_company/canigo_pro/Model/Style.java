package paprica_company.canigo_pro.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import paprica_company.canigo_pro.Dao.DBAdapter;
import paprica_company.canigo_pro.Dao.Script_Style;

/**
 * Created by Luana on 18/01/2016.
 */
public class Style {
    //--------------------------------------- Atributes: ------------------------------------------
    Boolean sexInterest;
    Boolean punk;
    Boolean boho;
    Boolean classic;
    Boolean cool;
    Boolean glam;
    Boolean ladyLike;
    Boolean hippieChic;
    Boolean rocker;
    Boolean sexy;
    Boolean geek;
    Boolean vintage;
    Boolean activeWear;
    Boolean casual;
    Boolean romantic;
    Boolean gothic;
    Boolean beachWear;

    public Boolean getSexInterest() {
        return sexInterest;
    }

    public Boolean getPunk() {
        return punk;
    }

    public Boolean getBoho() {
        return boho;
    }

    public Boolean getClassic() {
        return classic;
    }

    public Boolean getCool() {
        return cool;
    }

    public Boolean getGlam() {
        return glam;
    }

    public Boolean getLadyLike() {
        return ladyLike;
    }

    public Boolean getHippieChic() {
        return hippieChic;
    }

    public Boolean getRocker() {
        return rocker;
    }

    public Boolean getSexy() {
        return sexy;
    }

    public Boolean getGeek() {
        return geek;
    }

    public Boolean getVintage() {
        return vintage;
    }

    public Boolean getActiveWear() {
        return activeWear;
    }

    public Boolean getCasual() {
        return casual;
    }

    public Boolean getRomantic() {
        return romantic;
    }

    public Boolean getGothic() {
        return gothic;
    }

    public Boolean getBeachWear() {
        return beachWear;
    }

    //-------------------------------------- DB Stuff: --------------------------------------------
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
    public Style(Context ctx) {
        this.mCtx = ctx;
    }
    //----------------------------------- Table DB Methods: ---------------------------------------
    public Style open() throws SQLException {
        this.mDbHelper = new DatabaseHelper(this.mCtx);
        this.mDb = this.mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        this.mDbHelper.close();
    }

    public long createStyle(Boolean psexInterest, Boolean ppunk, Boolean pboho, Boolean pclassic, Boolean pcool,
            Boolean pglam, Boolean pladyLike, Boolean phippieChic, Boolean procker, Boolean psexy,
            Boolean pgeek, Boolean pvintage, Boolean pactiveWear, Boolean pcasual, Boolean promantic,
            Boolean pgothic, Boolean pbeachWear){
        ContentValues initialValues = new ContentValues();
        initialValues.put(Script_Style.FeedEntry.COLUMN_ACTIVEWEAR, pactiveWear);
        initialValues.put(Script_Style.FeedEntry.COLUMN_BEACHWEAR, pbeachWear);
        initialValues.put(Script_Style.FeedEntry.COLUMN_BOHO, pboho);
        initialValues.put(Script_Style.FeedEntry.COLUMN_CASUAL, pcasual);
        initialValues.put(Script_Style.FeedEntry.COLUMN_CLASSIC, pclassic);
        initialValues.put(Script_Style.FeedEntry.COLUMN_COOL, pcool);
        initialValues.put(Script_Style.FeedEntry.COLUMN_GETSEXINTEREST, psexInterest);
        initialValues.put(Script_Style.FeedEntry.COLUMN_GLAM, pglam);
        initialValues.put(Script_Style.FeedEntry.COLUMN_HIPPIECHIC, phippieChic);
        initialValues.put(Script_Style.FeedEntry.COLUMN_LADYLIKE, pladyLike);
        initialValues.put(Script_Style.FeedEntry.COLUMN_PUNK, ppunk);
        initialValues.put(Script_Style.FeedEntry.COLUMN_ROMANTIC, promantic);
        initialValues.put(Script_Style.FeedEntry.COLUMN_VINTAGE, pvintage);
        initialValues.put(Script_Style.FeedEntry.COLUMN_ROCKER, procker);
        initialValues.put(Script_Style.FeedEntry.COLUMN_SEXY, psexy);
        initialValues.put(Script_Style.FeedEntry.COLUMN_GOTHIC, pgothic);
        initialValues.put(Script_Style.FeedEntry.COLUMN_GEEK, pgeek);
        return this.mDb.insert(Script_Style.FeedEntry.TABLE_NAME, null, initialValues);
    }


    public boolean deleteStyle(long rowId) {

        return this.mDb.delete(Script_Style.FeedEntry.TABLE_NAME, Script_Style.FeedEntry._ID + "=" + rowId, null) > 0; //$NON-NLS-1$
    }


    public Cursor getAllStyles() {

        return this.mDb.query(Script_Style.FeedEntry.TABLE_NAME, new String[] { Script_Style.FeedEntry._ID,
                Script_Style.FeedEntry.COLUMN_ACTIVEWEAR, Script_Style.FeedEntry.COLUMN_BEACHWEAR, Script_Style.FeedEntry.COLUMN_BOHO,
                Script_Style.FeedEntry.COLUMN_CASUAL, Script_Style.FeedEntry.COLUMN_CLASSIC, Script_Style.FeedEntry.COLUMN_COOL,
                Script_Style.FeedEntry.COLUMN_GETSEXINTEREST, Script_Style.FeedEntry.COLUMN_GLAM, Script_Style.FeedEntry.COLUMN_HIPPIECHIC,
                Script_Style.FeedEntry.COLUMN_LADYLIKE, Script_Style.FeedEntry.COLUMN_PUNK, Script_Style.FeedEntry.COLUMN_ROMANTIC,
                Script_Style.FeedEntry.COLUMN_VINTAGE, Script_Style.FeedEntry.COLUMN_ROCKER, Script_Style.FeedEntry.COLUMN_SEXY,
                Script_Style.FeedEntry.COLUMN_GOTHIC, Script_Style.FeedEntry.COLUMN_GEEK}, null, null, null, null, null);

    }


    public Cursor getStyle(long rowId) throws SQLException {

        Cursor mCursor =

                this.mDb.query(true, Script_Style.FeedEntry.TABLE_NAME, new String[] { Script_Style.FeedEntry._ID,
                        Script_Style.FeedEntry.COLUMN_ACTIVEWEAR, Script_Style.FeedEntry.COLUMN_BEACHWEAR, Script_Style.FeedEntry.COLUMN_BOHO,
                        Script_Style.FeedEntry.COLUMN_CASUAL, Script_Style.FeedEntry.COLUMN_CLASSIC, Script_Style.FeedEntry.COLUMN_COOL,
                        Script_Style.FeedEntry.COLUMN_GETSEXINTEREST, Script_Style.FeedEntry.COLUMN_GLAM, Script_Style.FeedEntry.COLUMN_HIPPIECHIC,
                        Script_Style.FeedEntry.COLUMN_LADYLIKE, Script_Style.FeedEntry.COLUMN_PUNK, Script_Style.FeedEntry.COLUMN_ROMANTIC,
                        Script_Style.FeedEntry.COLUMN_VINTAGE, Script_Style.FeedEntry.COLUMN_ROCKER, Script_Style.FeedEntry.COLUMN_SEXY,
                        Script_Style.FeedEntry.COLUMN_GOTHIC, Script_Style.FeedEntry.COLUMN_GEEK}, Script_Style.FeedEntry._ID + "=" + rowId, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public boolean updateStyle(long rowId, Boolean psexInterest, Boolean ppunk, Boolean pboho, Boolean pclassic, Boolean pcool,
                             Boolean pglam, Boolean pladyLike, Boolean phippieChic, Boolean procker, Boolean psexy,
                             Boolean pgeek, Boolean pvintage, Boolean pactiveWear, Boolean pcasual, Boolean promantic,
                             Boolean pgothic, Boolean pbeachWear){
        ContentValues args = new ContentValues();
        args.put(Script_Style.FeedEntry.COLUMN_ACTIVEWEAR, pactiveWear);
        args.put(Script_Style.FeedEntry.COLUMN_BEACHWEAR, pbeachWear);
        args.put(Script_Style.FeedEntry.COLUMN_BOHO, pboho);
        args.put(Script_Style.FeedEntry.COLUMN_CASUAL, pcasual);
        args.put(Script_Style.FeedEntry.COLUMN_CLASSIC, pclassic);
        args.put(Script_Style.FeedEntry.COLUMN_COOL, pcool);
        args.put(Script_Style.FeedEntry.COLUMN_GETSEXINTEREST, psexInterest);
        args.put(Script_Style.FeedEntry.COLUMN_GLAM, pglam);
        args.put(Script_Style.FeedEntry.COLUMN_HIPPIECHIC, phippieChic);
        args.put(Script_Style.FeedEntry.COLUMN_LADYLIKE, pladyLike);
        args.put(Script_Style.FeedEntry.COLUMN_PUNK, ppunk);
        args.put(Script_Style.FeedEntry.COLUMN_ROMANTIC, promantic);
        args.put(Script_Style.FeedEntry.COLUMN_VINTAGE, pvintage);
        args.put(Script_Style.FeedEntry.COLUMN_ROCKER, procker);
        args.put(Script_Style.FeedEntry.COLUMN_SEXY, psexy);
        args.put(Script_Style.FeedEntry.COLUMN_GOTHIC, pgothic);
        args.put(Script_Style.FeedEntry.COLUMN_GEEK, pgeek);

        return this.mDb.update(Script_Style.FeedEntry.TABLE_NAME, args, Script_Style.FeedEntry._ID + "=" + rowId, null) >0;
    }
    //------------------------------------ Class Methods: -----------------------------------------

}
