package vn.lucifer.hoctiengnhat.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AlphabetViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AlphabetViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}