package vn.lucifer.hoctiengnhat.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import vn.lucifer.hoctiengnhat.R;
import vn.lucifer.hoctiengnhat.database.AppDatabase;
import vn.lucifer.hoctiengnhat.model.TextHistory;
import vn.lucifer.hoctiengnhat.model.Word1;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordHolder> {

    private List<Word1> wordList;
    private Context context;
    private TextHistory textHistory;
    public static AppDatabase db;
    Dialog dialog;

    public WordAdapter(List<Word1> wordList, Context context) {
        this.wordList = wordList;
        this.context = context;
        db = Room.databaseBuilder(context,
                AppDatabase.class, "DuAnDemo2.db").allowMainThreadQueries().build();
    }

    @NonNull
    @Override
    public WordHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.word, parent, false);

        return new WordHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordHolder holder, int position) {

        final Word1 word = wordList.get(position);
        holder.tvMean.setText(word.mean_word);
        holder.tvSpell.setText(word.spell_word);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder
                        = new AlertDialog.Builder(context);
                View v = LayoutInflater.from(context).inflate(R.layout.dialog_word, null);
                builder.setView(v);
                builder.setCancelable(false);

                SimpleDateFormat f = new SimpleDateFormat("HH:mm , dd/MM/yyyy");
                String time = f.format(Calendar.getInstance().getTime());
                String name = word.mean_word;
                textHistory = new TextHistory(time, name);
                long[] a = db.historyDAO().insertHistory(textHistory);
                Log.e("aaaaaa",a[0] + "");
                TextView tvOriginWord;
                TextView tvSpellWord;
                TextView tvMeanWord;
                TextView tvType;
                TextView tvContentExample;
                TextView tvSpellExample;
                TextView tvMeanExample;
                TextView tvClose;

                tvOriginWord = (TextView) v.findViewById(R.id.tvOrigin_Word);
                tvSpellWord = (TextView) v.findViewById(R.id.tvSpell_Word);
                tvMeanWord = (TextView) v.findViewById(R.id.tvMean_Word);
                tvType = (TextView) v.findViewById(R.id.tvType);
                tvContentExample = (TextView) v.findViewById(R.id.tvContent_Example);
                tvSpellExample = (TextView) v.findViewById(R.id.tvSpell_Example);
                tvMeanExample = (TextView) v.findViewById(R.id.tvMean_Example);
                tvClose = v.findViewById(R.id.tvClose);
                tvOriginWord.setText(word.origin_word);
                tvSpellWord.setText(word.spell_word);
                tvMeanWord.setText(word.mean_word);
                tvType.setText(word.type_word);
                tvContentExample.setText(word.content_example);
                tvSpellExample.setText(word.spell_example);
                tvMeanExample.setText(word.mean_example);
                tvClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

//                Html.fromHtml(word.html)
                AlertDialog alertDialog1 = builder.create();
                alertDialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog = alertDialog1;
                alertDialog1.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    public class WordHolder extends RecyclerView.ViewHolder {
        public TextView tvMean;
        public TextView tvSpell;
        public WordHolder(@NonNull View itemView) {
            super(itemView);

            tvMean = (TextView) itemView.findViewById(R.id.tvMean);
            tvSpell = (TextView) itemView.findViewById(R.id.tvSpell);
        }
    }
}
