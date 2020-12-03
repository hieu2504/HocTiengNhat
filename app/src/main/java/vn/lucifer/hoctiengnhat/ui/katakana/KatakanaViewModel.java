package vn.lucifer.hoctiengnhat.ui.katakana;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class KatakanaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public KatakanaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}