package vn.lucifer.hoctiengnhat.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import vn.lucifer.hoctiengnhat.ui.katakana.KatakanaFragment;
import vn.lucifer.hoctiengnhat.ui.hiragana.HiraganaFragment;

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
                HiraganaFragment alphabetFragment = new HiraganaFragment();
                return alphabetFragment;
            case 1:
                KatakanaFragment katakanaFragment = new KatakanaFragment();
                return katakanaFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return countTab;
    }
}
