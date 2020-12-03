package vn.lucifer.hoctiengnhat.presenter;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.List;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import vn.lucifer.hoctiengnhat.DrawHiraganaActivity;
import vn.lucifer.hoctiengnhat.R;
import vn.lucifer.hoctiengnhat.adapter.AlphabetHiraganaAdapter;
import vn.lucifer.hoctiengnhat.adapter.AlphabetKatakanaAdapter;
import vn.lucifer.hoctiengnhat.model.Alphabet;
import vn.lucifer.hoctiengnhat.view.AlphabetView;

public class AlphabetPresenter {

    private Context context;
    private AlphabetView alphabetView;
    private MediaPlayer mediaPlayer;
    private AlertDialog alertDialog;

    public AlphabetPresenter(Context context, AlphabetView alphabetView) {
        this.context = context;
        this.alphabetView = alphabetView;
    }

    public void loadRecycleview(RecyclerView recyclerView){
        List<Alphabet> list = alphabetView.getList();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 5));
        AlphabetHiraganaAdapter alphabetHiraganaAdapter = new AlphabetHiraganaAdapter(context, list);
        recyclerView.setAdapter(alphabetHiraganaAdapter);
    }

    public void loadRecycleview_kata(RecyclerView recyclerView){
        List<Alphabet> list = alphabetView.getList();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 5));
        AlphabetKatakanaAdapter alphabetKatakanaAdapter = new AlphabetKatakanaAdapter(context, list);
        recyclerView.setAdapter(alphabetKatakanaAdapter);
    }


    public void showDialog(final Alphabet a){
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        final View dialog = LayoutInflater.from(context).inflate(R.layout.dialog_alphabet_detail, null);
        builder.setView(dialog);


        TextView  alphabetCardviewTvOk;
        ImageView alphabetCardviewImgPronun;
        GifImageView alphabetCardviewTvHira1;
        Button btn_Tap_Viet;

        alphabetCardviewTvHira1 = dialog.findViewById(R.id.alphabet_cardview_tv_hira1);


        alphabetCardviewImgPronun =dialog.findViewById(R.id.alphabet_cardview_img_pronun);
        alphabetCardviewTvOk = dialog.findViewById(R.id.alphabet_cardview_tv_ok);
        btn_Tap_Viet = dialog.findViewById(R.id.alphabet_btnTapViet);


        getSound(a.sound);

        getGifImage(a.gif_hiragana, alphabetCardviewTvHira1);


        alphabetCardviewTvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        alphabetCardviewImgPronun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSound(a.sound);
            }
        });
        btn_Tap_Viet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, DrawHiraganaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Key_1", "hira"); // Truyền một String
                bundle.putString("Key_2", a.gif_katakana);                      // Truyền một Int
                bundle.putString("Key_4", a.gif_hiragana);                      // Truyền một Int
                bundle.putString("Key_3", a.romari);               // Truyền một Boolean
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();

    }

    public void showDialog_kata(final Alphabet a){
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        final View dialog = LayoutInflater.from(context).inflate(R.layout.dialog_alphabet_kata_detail, null);
        builder.setView(dialog);


        TextView  alphabet_kata_cardview_tv_ok;
        ImageView alphabet_kata_cardview_img_pronun;
        GifImageView alphabet_cardview_tv_kata;
        Button alphabet_kata_btnTapViet;

        alphabet_cardview_tv_kata = dialog.findViewById(R.id.alphabet_cardview_tv_kata);


        alphabet_kata_cardview_img_pronun =dialog.findViewById(R.id.alphabet_kata_cardview_img_pronun);
        alphabet_kata_cardview_tv_ok = dialog.findViewById(R.id.alphabet_kata_cardview_tv_ok);
        alphabet_kata_btnTapViet = dialog.findViewById(R.id.alphabet_kata_btnTapViet);


        getSound(a.sound);

        getGifImage(a.gif_katakana, alphabet_cardview_tv_kata);


        alphabet_kata_cardview_tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        alphabet_kata_cardview_img_pronun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSound(a.sound);
            }
        });
        alphabet_kata_btnTapViet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, DrawHiraganaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Key_1", "kata"); // Truyền một String
                bundle.putString("Key_2", a.gif_katakana);
                bundle.putString("Key_4", a.gif_hiragana);   // Truyền một Int
                bundle.putString("Key_3", a.romari);               // Truyền một Boolean
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();

    }

    public void getGifImage(String name, GifImageView imageView){
        try {
            AssetFileDescriptor afd = context.getAssets().openFd( "alphabet_gif/" + name + ".gif");

            final GifDrawable drawable = new GifDrawable(afd);

            drawable.start();
            drawable.setLoopCount(1);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                imageView.setImageDrawable(drawable);
            }
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public void getSound(String sound) {
        try {
            AssetFileDescriptor afd = context.getAssets().openFd("alphabet_sound/" + sound + ".mp3");

            mediaPlayer = new MediaPlayer();

            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mediaPlayer.prepare();
            mediaPlayer.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
