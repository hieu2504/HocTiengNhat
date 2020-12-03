package vn.lucifer.hoctiengnhat.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.lucifer.hoctiengnhat.R;
import vn.lucifer.hoctiengnhat.adapter.WordAdapter;
import vn.lucifer.hoctiengnhat.database.DataBaseTranslate;
import vn.lucifer.hoctiengnhat.model.Word1;

public class VietNhatFragment extends Fragment {


    private ImageView imgSearch;
    private EditText edtNhap;
    private ImageView imgDelete;
    private RecyclerView lvList;
    DataBaseTranslate dataBaseHelper;


    private WordAdapter wordAdapter;

    private LinearLayoutManager linearLayoutManager;
    private List<Word1> wordList = new ArrayList<>();

    public VietNhatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_viet_nhat, container, false);
        imgSearch = (ImageView) view.findViewById(R.id.imgSearch);
        edtNhap = (EditText) view.findViewById(R.id.edtNhap);
        imgDelete = (ImageView) view.findViewById(R.id.imgDelete);
        lvList = (RecyclerView) view.findViewById(R.id.lvList);

        dataBaseHelper = new DataBaseTranslate(getContext());
        dataBaseHelper.createDataBase();

        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String word = edtNhap.getText().toString().trim();
                // kiểm tra nếu người dùng chưa nhập gì thì dừng lại và thông báo lỗi
                if (word.isEmpty()) {
                    edtNhap.setError("Vui lòng nhập dữ liệu !!!");
                    return;
                    // nếu chữ ko empty thì tiếp tục tìm kiếm và hiển thị danh sách kết quả lên list nếu có
                } else {
                    wordList = dataBaseHelper.searchVietNhat(word);
                    if(wordList.size()<=0){
                        Toast.makeText(getActivity(),"Không tìm thấy kết quả",Toast.LENGTH_SHORT).show();
                    }
//                    this.addAll(wordList);
                    wordAdapter = new WordAdapter(wordList, getContext());
                    linearLayoutManager = new LinearLayoutManager(getContext());
                    lvList.setAdapter(wordAdapter);
                    lvList.setLayoutManager(linearLayoutManager);
                    wordAdapter.notifyDataSetChanged();



                }


            }
        });
        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wordList.size() > 0) {
                    edtNhap.setText("");
                    wordList.clear();
                    wordAdapter.notifyDataSetChanged();
                } else {
                    edtNhap.setText("");
                }
            }
        });
        return view;

    }
}