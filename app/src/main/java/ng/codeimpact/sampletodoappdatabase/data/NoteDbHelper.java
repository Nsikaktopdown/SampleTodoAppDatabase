package ng.codeimpact.sampletodoappdatabase.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import ng.codeimpact.sampletodoappdatabase.model.Note_Item;

/**
 * Created by Nsikak  Thompson on 4/5/2017.
 */

public class NoteDbHelper extends SQLiteOpenHelper {

    private final static String LOG_TAG = NoteDbHelper.class.getSimpleName();

    // Database name
    private final static String DB_NAME = NoteContract.DATABASE_NAME;

    // Database Note
    private final static int DB_NOTE = 1;

    // Note table
    private final static String NOTE_TABLE_NAME = NoteContract.Note.TABLE_NAME;
    private final static String NOTE_ROW_ID = NoteContract.Note.ID;
    private final static String NOTE_ROW_TITLE = NoteContract.Note.NOTE_TITLE;
    private final static String NOTE_ROW_DESCRIPTION = NoteContract.Note.DESCRIPTION;


    // SQL statement to create the Version table
    private final static String NOTE_TABLE_CREATE =
            "CREATE TABLE " +
                    NOTE_TABLE_NAME + " (" +
                    NOTE_ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    NOTE_ROW_TITLE + " TEXT, " +
                    NOTE_ROW_DESCRIPTION + " TEXT, " + ");";

    public NoteDbHelper(Context context) {
        super(context, DB_NAME, null, DB_NOTE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Create Version table
        db.execSQL(NOTE_TABLE_CREATE);
        Log.i(LOG_TAG, "Creating table with query: " + NOTE_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + NOTE_TABLE_NAME);
        onCreate(db);

    }

    public void insertNote(Note_Item noteitem) {

        Log.i(LOG_TAG, "Added a Android version - " + noteitem.toString());

        // Get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // Create ContentValues to add data
        ContentValues contentValues = new ContentValues();
        contentValues.put(NOTE_ROW_TITLE, noteitem.getTitle());
        contentValues.put(NOTE_ROW_DESCRIPTION, noteitem.getDescription());


        // Insert data to table
        db.insert(NOTE_TABLE_NAME, // table name
                null,
                contentValues);

        // Remember to close the db
        db.close();
    }
}