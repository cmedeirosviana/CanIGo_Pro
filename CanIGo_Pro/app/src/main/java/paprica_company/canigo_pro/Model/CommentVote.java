package paprica_company.canigo_pro.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;

import paprica_company.canigo_pro.Dao.DBAdapter;

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
    //------------------------------------ Class Methods: -----------------------------------------




}
