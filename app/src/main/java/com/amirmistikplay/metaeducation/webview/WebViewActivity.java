package com.amirmistikplay.metaeducation.webview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.amirmistikplay.metaeducation.MainActivity;
import com.amirmistikplay.metaeducation.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class WebViewActivity extends AppCompatActivity {

    FloatingActionButton mFloatingButton;
    FloatingActionButton HomeButton;

    boolean isAllFabsVisible;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_browser_layout);
        Objects.requireNonNull(getSupportActionBar()).hide();

        mFloatingButton = findViewById(R.id.mainbutton);

        // find mini buttons
        HomeButton = findViewById(R.id.home);

        HomeButton.setVisibility(View.GONE);

        WebView webView = (WebView) findViewById (R.id.webView);
        webView.setWebViewClient(new WebViewClientOptions());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setUserAgentString(webSettings.getUserAgentString());
        webView.setWebContentsDebuggingEnabled(true);
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);

        webView.loadUrl("https://www.youtube.com/c/TutorOnlineRu12");

        // Cookie manager for the webview
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);

        isAllFabsVisible = false;

        mFloatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isAllFabsVisible){
                    HomeButton.show();

                    isAllFabsVisible = true;
                } else {
                    HomeButton.hide();

                    isAllFabsVisible = false;
                }
            }
        });
        HomeButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(WebViewActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
    }

    @Override
    public void onBackPressed(){
        WebView webView = (WebView) findViewById (R.id.webView);
        if(webView.canGoBack()){
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
