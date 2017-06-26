package com.production.hometech.webviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Date;

public class WebviewEvent extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_event);

        webView = (WebView) findViewById(R.id.wv_event);

        webView.setWebViewClient(new Callback());

        loadTime();
    }

    /**
     * One hook into the WebView activity is via setWebViewClient(), which takes an
     instance of a WebViewClient implementation as a parameter. The supplied callback
     object will be notified of a wide range of events, ranging from when parts of a page
     have been retrieved (onPageStarted(), etc.) to when you, as the host application,
     need to handle certain user- or circumstance-initiated events, such as:
     1. onTooManyRedirects()
     2. onReceivedHttpAuthRequest()
     3. etc.
     A common hook will be shouldOverrideUrlLoading(), where your callback is
     passed a URL (plus the WebView itself) and you return true if you will handle the
     request or false if you want default handling (e.g., actually fetch the Web page
     referenced by the URL). In the case of a feed reader application, for example, you
     will probably not have a full browser with navigation built into your reader, so if the
     user clicks a URL, you probably want to use an Intent to ask Android to load that
     page in a full browser. But, if you have inserted a “fake” URL into the HTML,
     representing a link to some activity-provided content, you can update the WebView
     yourself.

     */

    /**
     * There is also a WebChromeClient that you can register with a WebView via a call to
     setWebChromeClient(). This object will be called when various things occur in the
     WebView that might pertain to a browser’s “chrome” (i.e., the things outside the
     HTML rendering area). For example, onJSAlert() will be called on your
     WebChromeClient when JavaScript code calls alert().
     */

    private class Callback extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

            loadTime();
//            return (false);
            return (true);
        }
    }

    /**
     * Here, we load a simple Web page into the browser (loadTime()) that consists of the
     current time, made into a hyperlink to a fake URL. We also attach an instance of a
     WebViewClient subclass, providing our implementation of
     shouldOverrideUrlLoading(). In this case, no matter what the URL, we want to just
     reload the WebView via loadTime().
     */
    private void loadTime() {


        /**
         * Note that we are using a DateUtils utility class supplied by Android for formatting
         our date and time. The big advantage of using DateUtils is that this class is aware of
         the user’s settings for how they prefer to see the date and time (e.g., 12- versus
         24-hour mode).
         */
        String page = "<html><body><a href='"+getString(R.string.stackoverflow)+"'>" + DateUtils.formatDateTime(this, new Date().getTime(), DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_TIME)+ "</a></body></html>";

        webView.loadData(page,"text/html","UTF-8");

    }

}
