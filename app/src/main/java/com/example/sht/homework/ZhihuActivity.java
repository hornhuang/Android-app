package com.example.sht.homework;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class ZhihuActivity extends Activity {
    private static long ExitTime = 0;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tieba);
        ActionBar actionBar=getActionBar();
        webView=new WebView(this);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://m.baidu.com/");

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);

        setContentView(webView);
        webView.setInitialScale(70);
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            if(System.currentTimeMillis()-ExitTime>2000){
                Toast.makeText(getApplicationContext(), "再按一次返回上级", Toast.LENGTH_SHORT).show();
                ExitTime=System.currentTimeMillis();
            }else{
                super.onBackPressed();
            }
        }
    }
}