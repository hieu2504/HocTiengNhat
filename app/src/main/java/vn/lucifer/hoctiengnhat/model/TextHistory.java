package vn.lucifer.hoctiengnhat.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class TextHistory {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name="time")
    public String time;

    @ColumnInfo(name ="name")
    public String name;

    public TextHistory( String time, String name) {
        this.time = time;
        this.name = name;
    }
}
