package com.example.gbandroidcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ConfigActivity extends AppCompatActivity {

        private static final String KEY_RESULT = "KEY_RESULT";

        static Config config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);


        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBack = new Intent(ConfigActivity.this, MainActivity.class);
                startActivity(intentBack);
            }
        });
        findViewById(R.id.btn_dark).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                config = Config.dark;
                Toast.makeText(ConfigActivity.this, "dark", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.btn_light).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                config = Config.light;
                Toast.makeText(ConfigActivity.this, "light", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(config == Config.dark){
                    Intent intentResult = new Intent();
                    setResult(0, intentResult);
                    finish();
                }else if(config == Config.light){
                    Intent intentResult = new Intent();
                    setResult(1, intentResult);
                    finish();
                }
            }
        });

    }
}