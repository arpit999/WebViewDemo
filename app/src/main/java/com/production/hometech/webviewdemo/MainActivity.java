package com.production.hometech.webviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void SimpleWebViewClick(View view) {

        startActivity(new Intent(this, SimpleWebView.class));
    }

    public void WebViewEventClick(View view) {

        startActivity(new Intent(this, WebviewEvent.class));
    }
}
