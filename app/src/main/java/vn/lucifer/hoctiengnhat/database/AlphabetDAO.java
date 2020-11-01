package vn.lucifer.hoctiengnhat.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import vn.lucifer.hoctiengnhat.model.Alphabet;

@Dao
public interface AlphabetDAO {

    @Query("SELECT * FROM Alphabet")
    List<Alphabet> getALLBCC();

    @Insert
    long[] insertBCC(Alphabet... bccs);

    @Update
    int updateBCC(Alphabet bcc);

    @Delete
    int deleteBCC(Alphabet bcc);

    @Query("Delete from Alphabet")
    int delAll();

}
