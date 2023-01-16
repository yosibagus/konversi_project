package com.project.konversi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    Toast.makeText(MainActivity.this, "Berhasil Login", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this, KonversiActivity.class));
                } else {
                    Toast.makeText(MainActivity.this, "Gagal Login", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}