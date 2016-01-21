package paprica_company.canigo_pro.Dao;
import android.provider.BaseColumns;


public final class Script_CommentVote {

    public Script_CommentVote() {}

    public static abstract class FeedEntry implements BaseColumns
    {

        public static final String TABLE_NAME = "VOTE";
        public static final String COLUMN_IMAGE = "IMAGE";
        public static final String COLUMN_NUMCOMMENT = "NUMCOMMENT";
        public static final String COLUMN_VOTE = "VOTE";

    }


    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String BLOB = " BLOB";


    private static final String COMMA_SEP = ",";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + "(" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_IMAGE + BLOB + COMMA_SEP +
                    FeedEntry.COLUMN_NUMCOMMENT + INTEGER_TYPE + COMMA_SEP +
                    FeedEntry.COLUMN_VOTE + TEXT_TYPE +
                    " )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;



}
