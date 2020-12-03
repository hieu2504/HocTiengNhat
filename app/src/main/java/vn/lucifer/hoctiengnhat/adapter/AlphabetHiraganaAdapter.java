package vn.lucifer.hoctiengnhat.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.lucifer.hoctiengnhat.R;
import vn.lucifer.hoctiengnhat.model.Alphabet;

public class AlphabetHiraganaAdapter extends RecyclerView.Adapter<AlphabetHiraganaAdapter.MyViewHolder> {

    Context mContext;
    List<Alphabet> list;
    int[] array = {36,38,46,48};

    public AlphabetHiraganaAdapter(Context mContext, List<Alphabet> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public AlphabetHiraganaAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alphabet, parent, false);
         MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AlphabetHiraganaAdapter.MyViewHolder holder, final int position) {

        Alphabet a = list.get(position);

        holder.tvHi.setText(a.hiragana);
        holder.tvRo.setText(a.romari);

        if(position==array[0]){
            holder.itemView.setVisibility(View.GONE);
            return;
        }else if(position==array[1]) {
            holder.itemView.setVisibility(View.GONE);
            return;
        }else if(position==array[2]){
            holder.itemView.setVisibility(View.GONE);
            return;
        } else if(position==array[3]){
            holder.itemView.setVisibility(View.GONE);
            return;
        }else {
            holder.itemView.setVisibility(View.VISIBLE);
            return;
        }



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvHi;
        private TextView tvRo;
        private CardView card_alphabet;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvHi = itemView.findViewById(R.id.tvHi);
            tvRo = itemView.findViewById(R.id.tvRo);
            card_alphabet = itemView.findViewById(R.id.card_alphabet);

        }
    }
}
