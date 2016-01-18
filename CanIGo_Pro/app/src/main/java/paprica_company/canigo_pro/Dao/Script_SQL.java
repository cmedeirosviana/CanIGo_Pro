package paprica_company.canigo_pro.Dao;
import android.provider.BaseColumns;


public final class Script_SQL {

    public Script_SQL() {}

    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "CLIENT_LOGIN";
        public static final String COLUMN_LOGIN = "LOGIN";
        public static final String COLUMN_SENHA = "SENHA";
        public static final String COLUMN_EMAIL = "EMAIL";
    }

    private static final String TEXT_TYPE = " TEXT";
    //private static final String INTEGER_TYPE = " INTEGER";

    private static final String COMMA_SEP = ",";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + "(" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_LOGIN + TEXT_TYPE + COMMA_SEP +
                    FeedEntry.COLUMN_SENHA + TEXT_TYPE + COMMA_SEP +
                    FeedEntry.COLUMN_EMAIL + TEXT_TYPE +
                    " )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;



}
