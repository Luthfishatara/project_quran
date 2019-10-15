package com.example.myquran;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailAudio extends AppCompatActivity {

    String url;
    WebView webku;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_audio);

        webku = findViewById(R.id.webku);


        url = getIntent().getStringExtra("Server");

        webku.loadUrl(url);
        webku.setWebViewClient(new WebViewClient());
    }
}
