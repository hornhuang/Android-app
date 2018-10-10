package com.example.sht.homework;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Find extends AppCompatActivity {
    private WebView webView;
    private long exitTime=0;
    private ImageView imageView;
    int image[] = new int[]{
            R.drawable.weather_a,
            R.drawable.weather_b,
    };
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        final WebView webView = (WebView) findViewById(R.id.lvyou);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://m.cncn.com/");
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
                    if (webView != null && webView.canGoBack()) {
                        webView.goBack();
                        return true;
                    }
                }
                if (keyCode == KeyEvent.KEYCODE_BACK
                        && event.getAction() == KeyEvent.ACTION_DOWN) {

                    if ((System.currentTimeMillis() - exitTime) > 2000) {
                        Toast.makeText(getApplicationContext(), "再按一次返回上级", Toast.LENGTH_SHORT).show();
                        exitTime = System.currentTimeMillis();
                    } else {
                        finish();
                        System.exit(0);
                    }
                    return true;
                }
                return false;
            }

        });

        Button textView1 = ( Button) findViewById(R.id.fin_side_taobao);
        textView1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Find.this,TaoBao.class);
                startActivity(intent);
            }
        });
        Button textView2 = ( Button) findViewById(R.id.fin_side_jingdong);
        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Find.this, JingDong.class);
                startActivity(intent);
            }
        });

        Button textView4 = ( Button) findViewById(R.id.fin_side_tieba);
        textView4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Find.this, TiebaActivity.class);
                startActivity(intent);
            }
        });
        Button textView5 =  (Button) findViewById(R.id.fin_side_zhidao);
        textView5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Find.this, ZhihuActivity.class);
                startActivity(intent);
            }
        });
        final ImageView imageView = (ImageView) findViewById(R.id.tianqi);
        imageView.setImageResource(image[0]);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(image[++count%image.length]);
            }
        });

    }
}
