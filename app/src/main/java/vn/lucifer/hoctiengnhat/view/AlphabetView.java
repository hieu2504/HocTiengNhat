package vn.lucifer.hoctiengnhat.view;

import java.util.List;

import vn.lucifer.hoctiengnhat.model.Alphabet;

public interface AlphabetView {

    List<Alphabet> getList();

    void clickItem(int i);
}
