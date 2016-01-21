package paprica_company.canigo_pro.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;

import paprica_company.canigo_pro.Dao.DBAdapter;

public class Pin
{
    //--------------------------------------- Atributes: ------------------------------------------
    Drawable imagem;
    String folder;

    public Drawable getImagem() { return imagem; }

    public String getFolder() { return folder; }
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
    public Pin(Context ctx) {
        this.mCtx = ctx;
    }
    //----------------------------------- Table DB Methods: ---------------------------------------
    //------------------------------------ Class Methods: -----------------------------------------




}
