package com.example.geminipro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            GeminiPro gp = new GeminiPro(this);
            gp.chatDiscussion();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}