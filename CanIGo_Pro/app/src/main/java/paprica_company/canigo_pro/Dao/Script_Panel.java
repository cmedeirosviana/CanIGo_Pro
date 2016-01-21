package paprica_company.canigo_pro.Dao;
import android.provider.BaseColumns;


public final class Script_Panel {

    public Script_Panel() {}

    public static abstract class FeedEntry implements BaseColumns
    {

        public static final String TABLE_NAME = "PANEL";
        public static final String USER_REF = "user_id";
        public static final String COLUMN_USER = "FOREIGN KEY(user_id) REFERENCES USER(id),";
        public static final String COLUMN_PANELNAME = "PANELNAME";

    }


    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";


    private static final String COMMA_SEP = ",";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + "(" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.USER_REF + INTEGER_TYPE + COMMA_SEP +
                    FeedEntry.COLUMN_USER +
                    FeedEntry.COLUMN_PANELNAME + TEXT_TYPE +
                    " )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;



}
