package com.example.lenovo.rpl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button buttonmasuk;
    ImageView logouin;
    Animation frombottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonmasuk = findViewById(R.id.buttonmasuk);
        buttonmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent login = new Intent(MainActivity.this,Login.class);
            startActivity(login);
            }
        });

        logouin= findViewById(R.id.logouin);
        frombottom = AnimationUtils.loadAnimation(this,R.anim.frombottom);
        logouin.setAnimation(frombottom);
    }
}
