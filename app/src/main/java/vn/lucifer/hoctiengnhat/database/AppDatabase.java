package vn.lucifer.hoctiengnhat.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import vn.lucifer.hoctiengnhat.model.Alphabet;

@Database(entities = {Alphabet.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public abstract AlphabetDAO alphabetDAO();

    //từ vựng
    //ngữ pháp
    //nghe
    //kanji

}
