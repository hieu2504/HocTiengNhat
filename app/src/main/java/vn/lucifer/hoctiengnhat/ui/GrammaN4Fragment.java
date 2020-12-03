package vn.lucifer.hoctiengnhat.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vn.lucifer.hoctiengnhat.R;
import vn.lucifer.hoctiengnhat.adapter.GrammaN4Adapter;
import vn.lucifer.hoctiengnhat.adapter.GrammaN5Adapter;
import vn.lucifer.hoctiengnhat.database.DataBaseHelper;
import vn.lucifer.hoctiengnhat.model.Gramma;


public class GrammaN4Fragment extends Fragment {

    private RecyclerView rcv_Gramma_N4;
    private GrammaN4Adapter grammaAdapter;
    private List<Gramma> grammaList;
    DataBaseHelper dataBaseHelper;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gramma_n4, container, false);
        dataBaseHelper=new DataBaseHelper(getActivity());
        rcv_Gramma_N4=rootView.findViewById(R.id.rcv_Gramma_N4);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rcv_Gramma_N4.setLayoutManager(linearLayoutManager);
        rcv_Gramma_N4.setFocusable(false);
        grammaList=dataBaseHelper.getAllGrammaN4();
        grammaAdapter=new GrammaN4Adapter(getActivity(),grammaList);
        rcv_Gramma_N4.setAdapter(grammaAdapter);
        return rootView;
    }
}