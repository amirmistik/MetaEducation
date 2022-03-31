package com.amirmistikplay.metaeducation.webview;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewClientOptions extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        return false;
    }
}
