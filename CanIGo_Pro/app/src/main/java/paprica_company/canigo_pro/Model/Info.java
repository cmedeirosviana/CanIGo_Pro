package paprica_company.canigo_pro.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Property;
import paprica_company.canigo_pro.Dao.DBAdapter;
import android.graphics.drawable.Drawable;


public class Info {
    //--------------------------------------- Atributes: ------------------------------------------

    Drawable photo;
    String name;
    String birthDate;
    Boolean sex;
    User user;
    Style style;

    public User getUser() {return user; }

    public Drawable getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Boolean getSex() {
        return sex;
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

    public Info(Context ctx) {
        this.mCtx = ctx;
    }
    //----------------------------------- Table DB Methods: ---------------------------------------
    //------------------------------------ Class Methods: -----------------------------------------


}
