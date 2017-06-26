package com.production.hometech.webviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SimpleWebView extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_web_view);

        webView = (WebView) findViewById(R.id.wv_simple);
//by default, JavaScript is turned off in WebView widgets.
        webView.getSettings().setJavaScriptEnabled(true);

//        This webViewclient is for we can open link in our browser rather then android system webview
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(getString(R.string.stackoverflow));

                return true;
            }
        });

        webView.loadUrl(getString(R.string.stackoverflow));

//        Instead of loadUrl(), you can also use loadData().
        webView.loadData(getString(R.string.html_content),"text/html","UTF-8");

/**
 * There is also a loadDataWithBaseURL() method. This takes, among other
 parameters, the “base URL” to use when resolving relative URLs in the HTML. Any
 relative URL (e.g., <img src="images/foo.png">) will be interpreted as being
 relative to the base URL supplied to loadDataWithBaseURL(). If you find that you
 have content that refuses to load properly with loadData(), try
 loadDataWithBaseURL() with a null base URL, as sometimes that works better, for
 unknown reasons.
 */
        webView.loadDataWithBaseURL(getString(R.string.stackoverflow),getString(R.string.html_content_two),"text/html","UTF-8",getString(R.string.stackoverflow));



    }
}
