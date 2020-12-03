package vn.lucifer.hoctiengnhat.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import vn.lucifer.hoctiengnhat.R;
import vn.lucifer.hoctiengnhat.adapter.GrammaAdapter;
import vn.lucifer.hoctiengnhat.adapter.GrammaN4Adapter;
import vn.lucifer.hoctiengnhat.database.DataBaseHelper;
import vn.lucifer.hoctiengnhat.model.Gramma;

public class SearchGrammaActivity extends AppCompatActivity {

    private RecyclerView rcv_Gramma_Search;
    private GrammaAdapter grammaAdapter;
    private List<Gramma> grammaList;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_gramma);

        dataBaseHelper=new DataBaseHelper(this);
        rcv_Gramma_Search=findViewById(R.id.rcv_Gramma_Search);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv_Gramma_Search.setLayoutManager(linearLayoutManager);
        rcv_Gramma_Search.setFocusable(false);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) getApplicationContext().getSystemService(Context.SEARCH_SERVICE);
        androidx.appcompat.widget.SearchView searchView = null;
        if (searchItem != null) {
            searchView = (androidx.appcompat.widget.SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(SearchGrammaActivity.this.getComponentName()));
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                public boolean onQueryTextChange(String newText) {
                    grammaList=dataBaseHelper.getAllGrammaN5Search(newText);
                    grammaAdapter=new GrammaAdapter(SearchGrammaActivity.this,grammaList);
                    rcv_Gramma_Search.setAdapter(grammaAdapter);
                    return true;
                }

                public boolean onQueryTextSubmit(String query) {

                    return true;
                }
            });
        }
        searchItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {

                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                SearchGrammaActivity.super.onBackPressed();
                return true;
            }
        });
        searchItem.expandActionView();
        return super.onCreateOptionsMenu(menu);
    }
}