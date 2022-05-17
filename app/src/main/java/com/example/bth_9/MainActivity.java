package com.example.bth_9;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CONTACTS_ASK_PERMISSIONS = 1001;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_Control();
        add_Events();
    }

    private void add_Events() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLytMoManHinhDanhBa();
            }
        });
    }

    private void xuLytMoManHinhDanhBa() {
        Intent intent = new Intent(this,DanhBa.class);
        intent.setClassName("com.example.bth_9","com.example.bth_9.DanhBa");
        startActivity(intent);
    }

    private void add_Control() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
    }
}