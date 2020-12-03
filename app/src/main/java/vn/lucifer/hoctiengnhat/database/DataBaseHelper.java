package vn.lucifer.hoctiengnhat.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import vn.lucifer.hoctiengnhat.model.Alphabet;
import vn.lucifer.hoctiengnhat.model.Gramma;
import vn.lucifer.hoctiengnhat.model.Word1;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static String TAG = "DataBaseHelper"; // Tag just for the LogCat window
    //destination path (location) of our database on device
    private static String DB_PATH = "";
    private static String DB_NAME = "grammar_data.db";// Database name
    private SQLiteDatabase mDataBase;
    private final Context mContext;

    // do đường dẫn ở phiên bản API > 17 thay đổi nên chúng ta cần kiểm tra nhé
    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, 2);// 1? Its database Version
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.mContext = context;
    }

    public void createDataBase() {
        //If the database does not exist, copy it from the assets.

        boolean mDataBaseExist = checkDataBase();
        if (!mDataBaseExist) {
            this.getReadableDatabase();
            this.close();
            try {
                //Copy the database from assests
                copyDataBase();
                Log.e(TAG, "createDatabase database created");
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    //Check that the database exists here: /data/data/your package/databases/Database Name
    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        Log.e("dbFile", dbFile + "   " + dbFile.exists());
        return dbFile.exists();
    }

    //Copy the database from assets
    private void copyDataBase() throws IOException {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    //Open the database, so we can query it
    public boolean openDataBase() throws SQLException {
        String mPath = DB_PATH + DB_NAME;
        //Log.v("mPath", mPath);
        mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return mDataBase != null;
    }

    @Override
    public synchronized void close() {
        if (mDataBase != null)
            mDataBase.close();
        super.close();
    }

    public List<Gramma> getAllGrammaN5(){
        List<Gramma> grammaList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String SQL= "SELECT id,lesson_id,name,uname,content,tag,favorite FROM grammar WHERE id<149";
        Cursor cursor = sqLiteDatabase.rawQuery(SQL,null);
        if(cursor !=null){
            if(cursor.getCount()>0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    Gramma gramma = new Gramma();

                    gramma.id = cursor.getInt(cursor.getColumnIndex("id"));
                    gramma.lesson_id=cursor.getInt(cursor.getColumnIndex("lesson_id"));
                    gramma.name=cursor.getString(cursor.getColumnIndex("name"));
                    gramma.uname = cursor.getString(cursor.getColumnIndex("uname"));
                    gramma.content=cursor.getString(cursor.getColumnIndex("content"));
                    gramma.tag=cursor.getString(cursor.getColumnIndex("tag"));
                    gramma.favorite=cursor.getInt(cursor.getColumnIndex("favorite"));
                    grammaList.add(gramma);

                    cursor.moveToNext();
                }
                cursor.close();
            }
        }
        return grammaList;
    }

    public List<Gramma> getAllGrammaN4(){
        List<Gramma> grammaList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String SQL= "SELECT id,lesson_id,name,uname,content,tag,favorite FROM grammar WHERE id>149";
        Cursor cursor = sqLiteDatabase.rawQuery(SQL,null);
        if(cursor !=null){
            if(cursor.getCount()>0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    Gramma gramma = new Gramma();

                    gramma.id = cursor.getInt(cursor.getColumnIndex("id"));
                    gramma.lesson_id=cursor.getInt(cursor.getColumnIndex("lesson_id"));
                    gramma.name=cursor.getString(cursor.getColumnIndex("name"));
                    gramma.uname = cursor.getString(cursor.getColumnIndex("uname"));
                    gramma.content=cursor.getString(cursor.getColumnIndex("content"));
                    gramma.tag=cursor.getString(cursor.getColumnIndex("tag"));
                    gramma.favorite=cursor.getInt(cursor.getColumnIndex("favorite"));
                    grammaList.add(gramma);

                    cursor.moveToNext();
                }
                cursor.close();
            }
        }
        return grammaList;
    }

    public List<Gramma> getAllGrammaN5Search(String search_content){
        List<Gramma> grammaList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String SQL= "SELECT id,lesson_id,name,uname,content,tag,favorite FROM grammar WHERE name LIKE "+"'%"+search_content+"%'";
        Cursor cursor = sqLiteDatabase.rawQuery(SQL,null);
        if(cursor !=null){
            if(cursor.getCount()>0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    Gramma gramma = new Gramma();

                    gramma.id = cursor.getInt(cursor.getColumnIndex("id"));
                    gramma.lesson_id=cursor.getInt(cursor.getColumnIndex("lesson_id"));
                    gramma.name=cursor.getString(cursor.getColumnIndex("name"));
                    gramma.uname = cursor.getString(cursor.getColumnIndex("uname"));
                    gramma.content=cursor.getString(cursor.getColumnIndex("content"));
                    gramma.tag=cursor.getString(cursor.getColumnIndex("tag"));
                    gramma.favorite=cursor.getInt(cursor.getColumnIndex("favorite"));
                    grammaList.add(gramma);

                    cursor.moveToNext();
                }
                cursor.close();
            }
        }
        return grammaList;
    }

    public List<Alphabet> getAllAlphabet() {
        List<Alphabet> alphabets = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String SQL = "SELECT * FROM Alphabet";
        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {

                    Alphabet alphabet = new Alphabet();

                    alphabet.id = cursor.getInt(cursor.getColumnIndex("id"));
                    alphabet.hiragana = cursor.getString(cursor.getColumnIndex("hiragana"));
                    alphabet.katakana = cursor.getString(cursor.getColumnIndex("katakana"));
                    alphabet.romari = cursor.getString(cursor.getColumnIndex("romari"));
                    alphabet.sound = cursor.getString(cursor.getColumnIndex("sound"));
                    alphabet.gif_hiragana = cursor.getString(cursor.getColumnIndex("gif_hiragana"));
                    alphabet.gif_katakana = cursor.getString(cursor.getColumnIndex("gif_katakana"));
                    alphabets.add(alphabet);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return alphabets;
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
