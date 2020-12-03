package vn.lucifer.hoctiengnhat.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import vn.lucifer.hoctiengnhat.model.TextHistory;

@Dao
public interface HistoryDAO {


    @Query("SELECT * FROM TextHistory ORDER BY name ASC ")
    List<TextHistory> getAllHistory();

    @Insert
    long[] insertHistory(TextHistory... textHistories);

    @Query("DELETE  FROM TextHistory")
    void deleteAll();
}
