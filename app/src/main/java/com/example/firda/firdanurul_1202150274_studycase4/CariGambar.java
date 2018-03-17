package com.example.firda.firdanurul_1202150274_studycase4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class CariGambar extends AppCompatActivity {
    ImageView gmbr;
    EditText sumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_gambar);
        setTitle("AsyncTask"); //set title pada tampilan

        //memanggil variabel yang ada pada layout
        sumber = (EditText) findViewById(R.id.editText);
        gmbr = (ImageView) findViewById(R.id.image);

    }

    public void cariGambar(View view) {

        Picasso.with(CariGambar.this).load(sumber.getText().toString()).placeholder(R.mipmap.ic_launcher_round).error(R.mipmap.ic_launcher).into(gmbr);
    }
}