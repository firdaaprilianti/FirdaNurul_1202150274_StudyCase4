package com.example.firda.firdanurul_1202150274_studycase4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("AsyncTask");
    }

    public void mahasiswa(View view) {
        //untuk berpindah ke aktivitas mahasiswa//
        Intent a = new Intent(this, ListMahasiswa.class);
        startActivity(a);


    }

    public void gambar(View view) {

        //untuk berpindah ke aktivitas mahasiswa//
        Intent b = new Intent(this, CariGambar.class);
        startActivity(b);
    }
}
