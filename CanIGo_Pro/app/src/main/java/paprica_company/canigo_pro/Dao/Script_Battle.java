package paprica_company.canigo_pro.Dao;
import android.provider.BaseColumns;


public final class Script_Battle {

    public Script_Battle() {}

    public static abstract class FeedEntry implements BaseColumns
    {

        public static final String TABLE_NAME = "VOTE";
        public static final String COLUMN_IMAGE1 = "IMAGE1";
        public static final String COLUMN_IMAGE2 = "IMAGE2";
        public static final String COLUMN_VOTE1 = "VOTE1";
        public static final String COLUMN_VOTE2 = "VOTE2";

    }


    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String BLOB = " BLOB";


    private static final String COMMA_SEP = ",";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + "(" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_IMAGE1 + BLOB + COMMA_SEP +
                    FeedEntry.COLUMN_IMAGE2 + BLOB + COMMA_SEP +
                    FeedEntry.COLUMN_VOTE1 + INTEGER_TYPE + COMMA_SEP +
                    FeedEntry.COLUMN_VOTE2 + INTEGER_TYPE +
                    " )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;



}
