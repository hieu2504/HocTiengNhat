package vn.lucifer.hoctiengnhat.ui.hiragana;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HiraganaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HiraganaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}