package com.example.firda.firdanurul_1202150274_studycase4;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListMahasiswa extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);
        setTitle("AsyncTask"); //set title pada tampilan layar
        listView = (ListView) findViewById(R.id.list_view); //memanggil atribut yang ada di layout
    }

    public void startTask(View view) {
        new myTask(listView).execute();
    }
    class myTask extends AsyncTask<String, Integer, String> {
        ListView listView;
        ArrayAdapter adapter;
        ArrayList<String> listName;
        ProgressDialog progress;

        //constructor saat asynctask diinisialisasi
        public myTask (ListView listMhs) {
            this.listView = listMhs;
            progress = new ProgressDialog(ListMahasiswa.this);
            listName = new ArrayList<>();
        }

        //method ketika proses asynctask belum dimulai
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //menampilkan proses dialog
            progress.setTitle("Loading Data");
            progress.setIndeterminate(true);
            progress.setProgress(0);
            progress.setMax(100);
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progress.setCancelable(true);
            progress.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel Process", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    progress.dismiss();
                    myTask.this.cancel(true);
                }
            });

            progress.show();
        }

        //method saat proses asynctask dijalankan
        @Override
        protected String doInBackground(String... strings) {
            adapter = new ArrayAdapter<>(ListMahasiswa.this, android.R.layout.simple_list_item_1, listName); //membuat adapter

            //menyimpan array pada sebuah variabel
            String[] mahasiswa = getResources().getStringArray(R.array.namaMhs);
            //perulangan untuk menyimpan array
            for (int m = 0; m < mahasiswa.length; m++) {
                final long persen = 100L * m / mahasiswa.length;
                final String nama = mahasiswa[m];
                try {
                    Runnable change = new Runnable() {
                        @Override
                        public void run() {
                            progress.setMessage((int) persen+"% - Adding "+nama);
                        }
                    };
                    runOnUiThread(change);
                    Thread.sleep(300);
                    listName.add(mahasiswa[m]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        //method sesudah asynctask sudah dijalankan
        @Override
        protected void onPostExecute(String hasil) {
            super.onPostExecute(hasil);
            listView.setAdapter(adapter);
            progress.dismiss();
        }
    }
}
