package vn.lucifer.hoctiengnhat.ui.katakana;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.lucifer.hoctiengnhat.HomeActivity;
import vn.lucifer.hoctiengnhat.ItemClickSupport;
import vn.lucifer.hoctiengnhat.MainActivity;
import vn.lucifer.hoctiengnhat.R;
import vn.lucifer.hoctiengnhat.adapter.AlphabetHiraganaAdapter;
import vn.lucifer.hoctiengnhat.adapter.AlphabetKatakanaAdapter;
import vn.lucifer.hoctiengnhat.model.Alphabet;
import vn.lucifer.hoctiengnhat.presenter.AlphabetPresenter;
import vn.lucifer.hoctiengnhat.ui.hiragana.HiraganaViewModel;
import vn.lucifer.hoctiengnhat.view.AlphabetView;

public class KatakanaFragment extends Fragment implements AlphabetView {

    private KatakanaViewModel katakanaViewModel;
    MediaPlayer mediaPlayer;
    AlertDialog alertDialog;
    private RecyclerView alphabet_kata_recycleView;
    private List<Alphabet> list;
    private AlphabetKatakanaAdapter alphabetKatakanaAdapter;
    private AlphabetPresenter presenter;
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        katakanaViewModel =
                ViewModelProviders.of(this).get(KatakanaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        katakanaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });

        presenter = new AlphabetPresenter(getActivity(), this);

        alphabet_kata_recycleView = (RecyclerView) root.findViewById(R.id.alphabet_kata_recycleView);
        presenter.loadRecycleview_kata(alphabet_kata_recycleView);

        ItemClickSupport.addTo(alphabet_kata_recycleView).setOnItemClickListener(
                new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        clickItem(position);
                    }
                });

        return root;
    }

    public List<Alphabet> getList() {
        return HomeActivity.dataBaseHelper.getAllAlphabet();
    }

    public void clickItem(int i) {
        presenter.showDialog_kata(getList().get(i));
    }
}