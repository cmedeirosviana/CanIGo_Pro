package paprica_company.canigo_pro.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;

import paprica_company.canigo_pro.Dao.DBAdapter;

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
    //------------------------------------ Class Methods: -----------------------------------------



}
