package paprica_company.canigo_pro.Model;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import paprica_company.canigo_pro.Dao.DBAdapter;


public class User
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

    //-------------------------------- DB Stuff: --------------------------------------------------

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
    //-------------------------------------- Builders----------------------------------------------
    public User(Context ctx) {
        this.mCtx = ctx;
    }
    //---------------------------------- Table DB Methods------------------------------------------
    public User open() throws SQLException {
        this.mDbHelper = new DatabaseHelper(this.mCtx);
        this.mDb = this.mDbHelper.getWritableDatabase();
        return this;
    }

    /**
     * close return type: void
     */
    public void close() {
        this.mDbHelper.close();
    }

    /**
     * Create a new car. If the car is successfully created return the new
     * rowId for that car, otherwise return a -1 to indicate failure.
     *
     * @param name
     * @param model
     * @param year
     * @return rowId or -1 if failed
     */
    public long createCar(String name, String model, String year){
        ContentValues initialValues = new ContentValues();
        initialValues.put(NAME, name);
        initialValues.put(MODEL, model);
        initialValues.put(YEAR, year);
        return this.mDb.insert(DATABASE_TABLE, null, initialValues);
    }

    /**
     * Delete the car with the given rowId
     *
     * @param rowId
     * @return true if deleted, false otherwise
     */
    public boolean deleteCar(long rowId) {

        return this.mDb.delete(DATABASE_TABLE, ROW_ID + "=" + rowId, null) > 0; //$NON-NLS-1$
    }

    /**
     * Return a Cursor over the list of all cars in the database
     *
     * @return Cursor over all cars
     */
    public Cursor getAllCars() {

        return this.mDb.query(DATABASE_TABLE, new String[] { ROW_ID,
                NAME, MODEL, YEAR }, null, null, null, null, null);
    }

    /**
     * Return a Cursor positioned at the car that matches the given rowId
     * @param rowId
     * @return Cursor positioned to matching car, if found
     * @throws SQLException if car could not be found/retrieved
     */
    public Cursor getCar(long rowId) throws SQLException {

        Cursor mCursor =

                this.mDb.query(true, DATABASE_TABLE, new String[] { ROW_ID, NAME,
                        MODEL, YEAR}, ROW_ID + "=" + rowId, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    /**
     * Update the car.
     *
     * @param rowId
     * @param name
     * @param model
     * @param year
     * @return true if the note was successfully updated, false otherwise
     */
    public boolean updateCar(long rowId, String name, String model,
                             String year){
        ContentValues args = new ContentValues();
        args.put(NAME, name);
        args.put(MODEL, model);
        args.put(YEAR, year);

        return this.mDb.update(DATABASE_TABLE, args, ROW_ID + "=" + rowId, null) >0;
    }
    //------------------------------------ Class Methods-------------------------------------------
}
