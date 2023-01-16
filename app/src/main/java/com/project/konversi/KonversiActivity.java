package com.project.konversi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class KonversiActivity extends AppCompatActivity {

    CardView btnConvert, cardHasil, next, ulang;
    LinearLayout konfirmasi;
    EditText edtugas, edhadir, eduts, eduas;
    TextView edakhir, edhuruf, tmpHadir, tmpTugas, tmpUts, tmpUas;
    Double vtugas, vhadir, vuts, vuas,vakhir;
    String vhuruf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konversi);

        cardHasil = findViewById(R.id.cardHasil);
        edtugas=(EditText)findViewById(R.id.nilaiTugas);
        edhadir=(EditText)findViewById(R.id.nilaiHadir);
        eduts=(EditText)findViewById(R.id.nilaiUts);
        eduas=(EditText)findViewById(R.id.nilaiUas);
        edakhir=findViewById(R.id.tmpNilaiAkhir);
        edhuruf=findViewById(R.id.tmpNilaiHuruf);
        tmpHadir = findViewById(R.id.tmpKehadiran);
        tmpTugas = findViewById(R.id.tmpTugas);
        tmpUts = findViewById(R.id.tmpUts);
        tmpUas= findViewById(R.id.tmpUas);
        btnConvert = findViewById(R.id.btnConvert);
        konfirmasi = findViewById(R.id.konfirmasi);
        next = findViewById(R.id.btnLanjut);
        ulang = findViewById(R.id.btnUlang);

        cardHasil.setVisibility(View.GONE);
        konfirmasi.setVisibility(View.GONE);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                konversi();
            }
        });

        ulang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardHasil.setVisibility(View.GONE);
                konfirmasi.setVisibility(View.GONE);
                tmpHadir.setText("");
                tmpTugas.setText("");
                tmpUas.setText("");
                tmpUts.setText("");
                edakhir.setText("");
                edhuruf.setText("");
                Toast.makeText(KonversiActivity.this, "Masukkan Nilai Kembali", Toast.LENGTH_LONG).show();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KonversiActivity.this, SelesaiActivity.class));
            }
        });

    }

    private void konversi() {
        cardHasil.setVisibility(View.VISIBLE);
        konfirmasi.setVisibility(View.VISIBLE);
        vtugas=Double.parseDouble(edtugas.getText().toString());
        vhadir=Double.parseDouble(edhadir.getText().toString());
        vuts=Double.parseDouble(eduts.getText().toString());
        vuas=Double.parseDouble(eduas.getText().toString());

        vakhir = (0.15 * vhadir) + (0.25 * vtugas) + (0.25 * vuts) + (0.35 * vuas);
        if (vakhir >= 90 && vakhir <=100){
            vhuruf="A";
        }
        else if (vakhir >=80 && vakhir <=89){
            vhuruf="B";
        }
        else if (vakhir >=70 && vakhir <=79){
            vhuruf="C";
        }
        else if (vakhir >=60 && vakhir <=69){
            vhuruf="D";
        }
        else {
            vhuruf="E";
        }

        tmpHadir.setText(String.valueOf(vhadir));
        tmpTugas.setText(String.valueOf(vtugas));
        tmpUas.setText(String.valueOf(vuas));
        tmpUts.setText(String.valueOf(vuts));
        edakhir.setText("Nilai Akhir "+vakhir);
        edhuruf.setText("Index Nilai "+vhuruf);
        edtugas.setText("");
        edhadir.setText("");
        eduts.setText("");
        eduas.setText("");
    }
}