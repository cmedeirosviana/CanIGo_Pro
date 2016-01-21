package paprica_company.canigo_pro.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import paprica_company.canigo_pro.Dao.DBAdapter;

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
    //------------------------------------ Class Methods: -----------------------------------------

}
