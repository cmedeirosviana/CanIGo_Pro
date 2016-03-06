package paprica_company.canigo_pro.Model;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import paprica_company.canigo_pro.Dao.DBAdapter;
import paprica_company.canigo_pro.Dao.Script_User;


public class User extends DBAdapter
{
    //-------------------------------- Atributes:--------------------------------------------------
    String login;
    String psw;
    String email;

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return psw;
    }

    public String getEmail() {
        return email;
    }

    //-------------------------------------- Builders----------------------------------------------
    public User(String name, String email, String year) {
        open();
        createUser(name, email, year);
        close();
    }

    private User(Cursor mCursor) {
        this.login = mCursor.getString(1);
        this.psw = mCursor.getString(2);
        this.email = mCursor.getString(3);
    }

    //---------------------------------- Table DB Methods------------------------------------------

    private long createUser(String name, String email, String year)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(Script_User.FeedEntry.COLUMN_LOGIN, name);
        initialValues.put(Script_User.FeedEntry.COLUMN_EMAIL, email);
        initialValues.put(Script_User.FeedEntry.COLUMN_PWD, year);
        return db.insert(Script_User.FeedEntry.TABLE_NAME, null, initialValues);
    }

    public boolean deleteUser(long rowId) {

        return db.delete(Script_User.FeedEntry.TABLE_NAME, Script_User.FeedEntry._ID + "=" + rowId, null) > 0; //$NON-NLS-1$
    }


    public static void getAllUsers() {
        open();
        Cursor mCursor = db.query(Script_User.FeedEntry.TABLE_NAME, Script_User.COLUMNS, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
            User pUser = new User(mCursor);
        }
        close();
    }


    public static User getUser(String pEmail) throws SQLException {
        open();
        User pUser = null;
        String[] args = { pEmail };
        Cursor mCursor = db.query(Script_User.FeedEntry.TABLE_NAME, Script_User.COLUMNS, Script_User.FeedEntry.COLUMN_EMAIL+"=?", args, null,null,null);
        if (mCursor != null) {
            mCursor.moveToFirst();
            pUser = new User(mCursor);
        }
        close();
        return pUser;
    }

    public boolean updateUser(long rowId, String name, String model,
                             String year){
        ContentValues args = new ContentValues();
        args.put(Script_User.FeedEntry.COLUMN_LOGIN, name);
        args.put(Script_User.FeedEntry.COLUMN_EMAIL, model);
        args.put(Script_User.FeedEntry.COLUMN_PWD, year);

        return this.db.update(Script_User.FeedEntry.TABLE_NAME, args, Script_User.FeedEntry._ID + "=" + rowId, null) >0;
    }
    //------------------------------------ Class Methods-------------------------------------------
}
