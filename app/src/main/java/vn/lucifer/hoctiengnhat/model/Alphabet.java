package vn.lucifer.hoctiengnhat.model;


public class Alphabet {

    public int id;

    public String hiragana;

    public String katakana;

    public String romari;

    public String sound;

    public String gif_hiragana;

    public String gif_katakana;

    public Alphabet(){

    }
    public Alphabet(int id, String hiragana, String katakana, String romari, String sound, String gif_hiragana, String gif_katakana) {
        this.id = id;
        this.hiragana = hiragana;
        this.katakana = katakana;
        this.romari = romari;
        this.sound = sound;
        this.gif_hiragana = gif_hiragana;
        this.gif_katakana = gif_katakana;
    }
}
