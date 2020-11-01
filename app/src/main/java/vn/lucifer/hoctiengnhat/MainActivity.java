package vn.lucifer.hoctiengnhat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import vn.lucifer.hoctiengnhat.adapter.PageAdapter;
import vn.lucifer.hoctiengnhat.database.AppDatabase;
import vn.lucifer.hoctiengnhat.database.DataBaseHelper;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    public static AppDatabase db;
    public static DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(this,
                AppDatabase.class, "DuAnDemo2.db").allowMainThreadQueries().build();

        dataBaseHelper = new DataBaseHelper(this);
        dataBaseHelper.createDataBase();
        tabLayout=findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Hiragana"));
        tabLayout.addTab(tabLayout.newTab().setText("Katakana"));


        final ViewPager viewPager=findViewById(R.id.viewpager);
        PageAdapter pageAdapter=new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}