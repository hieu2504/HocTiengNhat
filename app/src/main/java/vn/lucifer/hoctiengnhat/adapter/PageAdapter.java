package vn.lucifer.hoctiengnhat.adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import vn.lucifer.hoctiengnhat.ui.dashboard.DashboardFragment;
import vn.lucifer.hoctiengnhat.ui.home.AlphabetFragment;

public class PageAdapter extends FragmentStatePagerAdapter {
    int countTab;
    public PageAdapter(@NonNull FragmentManager fm, int countTab) {
        super(fm);
        this.countTab=countTab;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Log.e("AAAAAAAAAA","0");
                AlphabetFragment alphabetFragment = new AlphabetFragment();
                return alphabetFragment;
            case 1:
                Log.e("AAAAAAAAAA","1");
                DashboardFragment dashboardFragment = new DashboardFragment();
                return dashboardFragment;
            default:
                Log.e("AAAAAAAAAA","zzzzzzzzzzzzzzzz");
                return null;
        }
    }

    @Override
    public int getCount() {
        return countTab;
    }
}
