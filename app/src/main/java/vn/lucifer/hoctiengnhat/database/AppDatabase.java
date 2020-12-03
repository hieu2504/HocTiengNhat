package vn.lucifer.hoctiengnhat.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import vn.lucifer.hoctiengnhat.model.Alphabet;
import vn.lucifer.hoctiengnhat.model.TextHistory;

@Database(entities = {TextHistory.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {


    public abstract HistoryDAO historyDAO();
    //từ vựng
    //ngữ pháp
    //nghe
    //kanji

}

