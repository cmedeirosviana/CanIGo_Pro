package paprica_company.canigo_pro.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;

import paprica_company.canigo_pro.Dao.DBAdapter;

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
    //------------------------------------ Class Methods: -----------------------------------------



}
