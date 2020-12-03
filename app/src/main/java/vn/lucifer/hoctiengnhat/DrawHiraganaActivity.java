package vn.lucifer.hoctiengnhat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pl.droidsonroids.gif.GifImageView;
import vn.lucifer.hoctiengnhat.model.Alphabet;
import vn.lucifer.hoctiengnhat.presenter.AlphabetPresenter;
import vn.lucifer.hoctiengnhat.presenter.PaintView;
import vn.lucifer.hoctiengnhat.view.AlphabetView;

public class DrawHiraganaActivity extends AppCompatActivity implements AlphabetView {

    Button  btn_eye_draw,btn_brush_draw, btn_earser_draw, btn_clear_draw;
    private PaintView paintView;
    private GifImageView alphabet_gif;
    private AlphabetPresenter alphabetPresenter;
    private TextView tv_Ro_draw;
    String img_gif_katana,text_katana,img_gif_hira;

   static String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_hiragana);
        btn_eye_draw = findViewById(R.id.btn_eye_draw);
        btn_brush_draw = findViewById(R.id.btn_brush_draw);
        btn_earser_draw = findViewById(R.id.btn_eraser_draw);
        btn_clear_draw = findViewById(R.id.btn_clear_draw);
        tv_Ro_draw = findViewById(R.id.tv_Ro_draw);
        alphabet_gif=findViewById(R.id.alphabet_gif);
        alphabetPresenter=new AlphabetPresenter(this,this);


        paintView = new PaintView(this);
        paintView = findViewById(R.id.paint_view);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        paintView.init(metrics);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            id = bundle.getString("Key_1", "");
            img_gif_katana = bundle.getString("Key_2", "");
            text_katana = bundle.getString("Key_3", "");
            img_gif_hira = bundle.getString("Key_4","");
        }



        //Log.e("aaaaaaaa",img_gif_hira);
        if(id.equals("kata")){
            alphabetPresenter.getGifImage(img_gif_katana,alphabet_gif);
        }else {
            alphabetPresenter.getGifImage(img_gif_hira,alphabet_gif);
        }
        tv_Ro_draw.setText(text_katana);

        final Drawable eye_on = this.getResources().getDrawable(R.drawable.ic_baseline_remove_red_eye_24);
        final Drawable eye_off = this.getResources().getDrawable(R.drawable.ic_baseline_visibility_off_24);
        btn_eye_draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(alphabet_gif.getVisibility()==View.GONE){
                    alphabet_gif.setVisibility(View.VISIBLE);
                    if(id.equals("kata")){
                        alphabetPresenter.getGifImage(img_gif_katana,alphabet_gif);
                    }else {
                        alphabetPresenter.getGifImage(img_gif_hira,alphabet_gif);
                    }
                   // alphabetPresenter.getGifImage(img_gif_katana,alphabet_gif);
                    btn_eye_draw.setCompoundDrawablesWithIntrinsicBounds(eye_off,null,null,null);
                }else {
                    alphabet_gif.setVisibility(View.GONE);
                    btn_eye_draw.setCompoundDrawablesWithIntrinsicBounds(eye_on,null,null,null);
                }
            }
        });

        btn_brush_draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintView.pen();
            }
        });
        btn_earser_draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintView.eraser(true);
            }
        });
        btn_clear_draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintView.clear();
            }
        });


    }

    @Override
    public List<Alphabet> getList() {
        return null;
    }

    @Override
    public void clickItem(int i) {

    }
}