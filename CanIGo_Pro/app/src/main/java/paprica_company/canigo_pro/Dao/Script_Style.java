package paprica_company.canigo_pro.Dao;
import android.provider.BaseColumns;


public final class Script_Style {

    public Script_Style() {}

    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "STYLE";
        public static final String COLUMN_GETSEXINTEREST = "GETSEXINTEREST";
        public static final String COLUMN_PUNK = "PUNK";
        public static final String COLUMN_BOHO = "BOHO";
        public static final String COLUMN_CLASSIC = "CLASSIC";
        public static final String COLUMN_COOL = "COOL";
        public static final String COLUMN_GLAM = "GLAM";
        public static final String COLUMN_LADYLIKE = "LADYLIKE";
        public static final String COLUMN_HIPPIECHIC = "HIPPIECHIC";
        public static final String COLUMN_ROCKER = "ROCKER";
        public static final String COLUMN_SEXY = "SEXY";
        public static final String COLUMN_VINTAGE = "VINTAGE";
        public static final String COLUMN_ACTIVEWEAR = "ACTIVEWEAR";
        public static final String COLUMN_CASUAL = "CASUAL";
        public static final String COLUMN_ROMANTIC = "ROMANTIC";
        public static final String COLUMN_BEACHWEAR = "BEACHWEAR";
        public static final String COLUMN_GOTHIC = "GOTHIC";
        public static final String COLUMN_GEEK = "GEEK";

        private static final String TEXT_TYPE = " TEXT";
        private static final String INTEGER_TYPE = " INTEGER";

        private static final String COMMA_SEP = ",";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + FeedEntry.TABLE_NAME + "(" +
                        FeedEntry._ID + " INTEGER PRIMARY KEY," +
                        FeedEntry.COLUMN_GETSEXINTEREST + INTEGER_TYPE + COMMA_SEP +
                        FeedEntry.COLUMN_PUNK + INTEGER_TYPE + COMMA_SEP +
                        FeedEntry.COLUMN_BOHO + INTEGER_TYPE + COMMA_SEP +
                        FeedEntry.COLUMN_CLASSIC + INTEGER_TYPE + COMMA_SEP +
                        FeedEntry.COLUMN_COOL + INTEGER_TYPE + COMMA_SEP +
                        FeedEntry.COLUMN_GLAM + INTEGER_TYPE + COMMA_SEP +
                        FeedEntry.COLUMN_LADYLIKE + INTEGER_TYPE + COMMA_SEP +
                        FeedEntry.COLUMN_HIPPIECHIC + INTEGER_TYPE + COMMA_SEP +
                        FeedEntry.COLUMN_ROCKER + INTEGER_TYPE + COMMA_SEP +
                        FeedEntry.COLUMN_SEXY + INTEGER_TYPE + COMMA_SEP +
                        FeedEntry.COLUMN_VINTAGE + INTEGER_TYPE + COMMA_SEP +
                        FeedEntry.COLUMN_ACTIVEWEAR + INTEGER_TYPE + COMMA_SEP +
                        FeedEntry.COLUMN_CASUAL + INTEGER_TYPE + COMMA_SEP +
                        FeedEntry.COLUMN_ROMANTIC + INTEGER_TYPE + COMMA_SEP +
                        FeedEntry.COLUMN_GOTHIC + INTEGER_TYPE + COMMA_SEP +
                        FeedEntry.COLUMN_GEEK + INTEGER_TYPE + COMMA_SEP +
                        FeedEntry.COLUMN_BEACHWEAR + INTEGER_TYPE +
                        " )";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;
    }

}
