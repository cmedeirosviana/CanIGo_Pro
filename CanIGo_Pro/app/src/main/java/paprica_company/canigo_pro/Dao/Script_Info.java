package paprica_company.canigo_pro.Dao;
import android.provider.BaseColumns;


public final class Script_Info {

    public Script_Info() {}

    public static abstract class FeedEntry implements BaseColumns
    {

        public static final String TABLE_NAME = "INFO";
        public static final String STYLE_REF = "style_id";
        public static final String USER_REF = "user_id";
        public static final String COLUMN_STYLE= " FOREIGN KEY(style_id) REFERENCES STYLE(id),";
        public static final String COLUMN_USER = "FOREIGN KEY(user_id) REFERENCES USER(id),";
        public static final String COLUMN_IMAGE = "IMAGE";
        public static final String COLUMN_DATEBIRTH = "DATEBIRTH";
        public static final String COLUMN_NAME = "NAME";
        public static final String COLUMN_SEX = "SEX";

    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String BLOB = " BLOB";


    private static final String COMMA_SEP = ",";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + "(" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.STYLE_REF + INTEGER_TYPE + COMMA_SEP +
                    FeedEntry.USER_REF + INTEGER_TYPE + COMMA_SEP +
                    FeedEntry.COLUMN_STYLE +
                    FeedEntry.COLUMN_USER +
                    FeedEntry.COLUMN_IMAGE + BLOB + COMMA_SEP +
                    FeedEntry.COLUMN_DATEBIRTH + TEXT_TYPE + COMMA_SEP +
                    FeedEntry.COLUMN_NAME + TEXT_TYPE + COMMA_SEP +
                    FeedEntry.COLUMN_SEX + INTEGER_TYPE +
                    " )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;



}
