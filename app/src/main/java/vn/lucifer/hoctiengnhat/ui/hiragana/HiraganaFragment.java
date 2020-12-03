package vn.lucifer.hoctiengnhat.ui.hiragana;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.lucifer.hoctiengnhat.DrawHiraganaActivity;
import vn.lucifer.hoctiengnhat.HomeActivity;
import vn.lucifer.hoctiengnhat.ItemClickSupport;
import vn.lucifer.hoctiengnhat.MainActivity;
import vn.lucifer.hoctiengnhat.R;
import vn.lucifer.hoctiengnhat.adapter.AlphabetHiraganaAdapter;
import vn.lucifer.hoctiengnhat.model.Alphabet;
import vn.lucifer.hoctiengnhat.presenter.AlphabetPresenter;
import vn.lucifer.hoctiengnhat.view.AlphabetView;

public class HiraganaFragment extends Fragment implements AlphabetView {

    private HiraganaViewModel hiraganaViewModel;
    MediaPlayer mediaPlayer;
    AlertDialog alertDialog;
    private RecyclerView alphabetRecycleView;
    private List<Alphabet> list;
    private AlphabetHiraganaAdapter alphabetHiraganaAdapter;
    private AlphabetPresenter presenter;


    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        hiraganaViewModel =
                ViewModelProviders.of(this).get(HiraganaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        hiraganaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });

        presenter = new AlphabetPresenter(getActivity(), this);

        alphabetRecycleView = (RecyclerView) root.findViewById(R.id.alphabet_recycleView);
        presenter.loadRecycleview(alphabetRecycleView);

        ItemClickSupport.addTo(alphabetRecycleView).setOnItemClickListener(
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

//        Intent intent=new Intent(getActivity(), DrawHiraganaActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putString("Key_1", "hira"); // Truyền một String
//        bundle.putString("Key_2", getList().get(i).gif_katakana);                      // Truyền một Int
//        bundle.putString("Key_4", getList().get(i).gif_hiragana);                      // Truyền một Int
//        bundle.putString("Key_3", getList().get(i).romari);               // Truyền một Boolean
//        intent.putExtras(bundle);
//        startActivity(intent);
        presenter.showDialog(getList().get(i));
    }
}