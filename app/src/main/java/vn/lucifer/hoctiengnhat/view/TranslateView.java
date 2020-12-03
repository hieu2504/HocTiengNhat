package vn.lucifer.hoctiengnhat.view;

import androidx.viewpager.widget.ViewPager;

public interface TranslateView {
    void createBottomSheetBehavior();
    void onClickFab();
    void addTab(ViewPager viewPager);
    void getData();
    void deleteHistory();
}
