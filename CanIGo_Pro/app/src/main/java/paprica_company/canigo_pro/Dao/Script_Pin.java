package paprica_company.canigo_pro.Dao;
import android.provider.BaseColumns;


public final class Script_Pin {

    public Script_Pin() {}

    public static abstract class FeedEntry implements BaseColumns

    {
        public static final String TABLE_NAME = "PIN";
        public static final String COLUMN_IMAGE = "IMAGE";
        public static final String COLUMN_FOLDER = "FOLDER";

    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String BLOB = " BLOB";

    private static final String COMMA_SEP = ",";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + "(" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_IMAGE + BLOB + COMMA_SEP +
                    FeedEntry.COLUMN_FOLDER + TEXT_TYPE + COMMA_SEP +

                    " )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;



}
