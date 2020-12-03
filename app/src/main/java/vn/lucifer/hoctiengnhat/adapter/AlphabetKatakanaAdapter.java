package vn.lucifer.hoctiengnhat.adapter;

import android.content.Context;
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

public class AlphabetKatakanaAdapter extends RecyclerView.Adapter<AlphabetKatakanaAdapter.MyViewHolder> {

    Context mContext;
    List<Alphabet> list;
    int[] array = {36,38,46,48};

    public AlphabetKatakanaAdapter(Context mContext, List<Alphabet> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public AlphabetKatakanaAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alphabet_katakana, parent, false);
        AlphabetKatakanaAdapter.MyViewHolder vh = new AlphabetKatakanaAdapter.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AlphabetKatakanaAdapter.MyViewHolder holder, int position) {

        Alphabet a = list.get(position);

        holder.tvKa.setText(a.katakana);
        holder.tvRo_kata.setText(a.romari);

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

        private TextView tvKa;
        private TextView tvRo_kata;
        private CardView card_alphabet_kata;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvKa = itemView.findViewById(R.id.tvKa);
            tvRo_kata = itemView.findViewById(R.id.tvRo_kata);
            card_alphabet_kata = itemView.findViewById(R.id.card_alphabet_kata);

        }
    }
}
