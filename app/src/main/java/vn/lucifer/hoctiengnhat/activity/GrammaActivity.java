package vn.lucifer.hoctiengnhat.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.viewpager.widget.ViewPager;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import vn.lucifer.hoctiengnhat.R;
import vn.lucifer.hoctiengnhat.adapter.ViewPagerAdapter;
import vn.lucifer.hoctiengnhat.adapter.ViewPagerGrammaAdapter;
import vn.lucifer.hoctiengnhat.ui.GrammaN3Fragment;
import vn.lucifer.hoctiengnhat.ui.GrammaN4Fragment;
import vn.lucifer.hoctiengnhat.ui.GrammaN5Fragment;
import vn.lucifer.hoctiengnhat.ui.NhatVietFragment;
import vn.lucifer.hoctiengnhat.ui.VietNhatFragment;

public class GrammaActivity extends AppCompatActivity {


    private TabLayout tabLayout_Gramma;
    private ViewPager viewPager_Gramma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gramma);
        viewPager_Gramma=findViewById(R.id.viewPager_Gramma);
        tabLayout_Gramma=findViewById(R.id.tabLayout_Gramma);
        ViewPagerGrammaAdapter adapter = new ViewPagerGrammaAdapter(getSupportFragmentManager());
        adapter.addFrm(new GrammaN5Fragment(), "N5");
        adapter.addFrm(new GrammaN4Fragment(), "N4");
        adapter.addFrm(new GrammaN3Fragment(), "N3");
        viewPager_Gramma.setAdapter(adapter);
        tabLayout_Gramma.setupWithViewPager(viewPager_Gramma);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.gramma_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.search);

        searchItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(GrammaActivity.this,SearchGrammaActivity.class);
                startActivity(intent);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);




//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.options_menu, menu);
//        MenuItem searchMenuItem = menu.findItem( R.id.search ); // get my MenuItem with placeholder submenu
//        //searchMenuItem.expandActionView();
//
//        SearchView searchView= (SearchView) searchMenuItem.getActionView();
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//            @Override
//            public boolean onQueryTextChange(String newText) {
//
//                return true;
//            }
//        });
//        //MenuItem searchItem = menu.findItem(R.id.search);
//
////        searchItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
////            @Override
////            public boolean onMenuItemClick(MenuItem menuItem) {
////                Toast.makeText(GrammaActivity.this,"aaa",Toast.LENGTH_SHORT).show();
////                return true;
////            }
////        });
//        return true;
    }
}