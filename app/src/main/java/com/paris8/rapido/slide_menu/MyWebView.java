package com.paris8.rapido.slide_menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Rapido on 29/12/2016.
 */

public class MyWebView extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_layout);

        webView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://accounts.google.com/ServiceLogin?hl=fr");
        webView.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed(){
        if(webView.canGoBack())
            webView.goBack();
        else
            super.onBackPressed();
    }


}
