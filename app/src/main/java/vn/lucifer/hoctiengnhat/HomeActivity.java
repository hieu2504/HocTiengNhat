package vn.lucifer.hoctiengnhat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import vn.lucifer.hoctiengnhat.activity.GrammaActivity;
import vn.lucifer.hoctiengnhat.activity.TranslateActivity;
import vn.lucifer.hoctiengnhat.database.AppDatabase;
import vn.lucifer.hoctiengnhat.database.DataBaseHelper;
import vn.lucifer.hoctiengnhat.database.DataBaseTranslate;

public class HomeActivity extends AppCompatActivity {

    Button button,button2,button3;
    public static AppDatabase db;
    public static DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, TranslateActivity.class);
                startActivity(intent);

            }
        });
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, GrammaActivity.class);
                startActivity(intent);
            }
        });
        db = Room.databaseBuilder(this,
                AppDatabase.class, "DuAnDemo2.db").allowMainThreadQueries().build();

        dataBaseHelper = new DataBaseHelper(this);

        dataBaseHelper.createDataBase();
    }
}