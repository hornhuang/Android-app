package com.example.sht.homework;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
public class Chat extends Fragment {

    @Nullable

//    WebView webView;
//    private long exitTime = 0;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_chat, container, false);
    }


    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        replaceFragment(new Multimedia_Farm());
//        webView = (WebView) getActivity().findViewById(R.id.qwe);
//        webView.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }
//        });
//        webView.loadUrl("http://m.cctv.com/");
//        webView.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
//                    if (webView != null && webView.canGoBack()) {
//                        webView.goBack();
//                        return true;
//                    }
//                }
//                if (keyCode == KeyEvent.KEYCODE_BACK
//                        && event.getAction() == KeyEvent.ACTION_DOWN) {
//
//                    if ((System.currentTimeMillis() - exitTime) > 2000) {
//                        Toast.makeText(getActivity(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
//                        exitTime = System.currentTimeMillis();
//                    } else {
//                        getActivity().finish();
//                        System.exit(0);
//                    }
//                    return true;
//                }
//                return false;
//            }
//
//        });
        Button imageView1 = (Button)getActivity().findViewById(R.id.button_1);
        imageView1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                replaceFragment(new Multimedia_Farm());
            }
        });
        Button imageView2 = (Button)getActivity().findViewById(R.id.button_2);
        imageView2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                replaceFragment(new Multimedia_Video());
            }
        });
        Button imageView3 = (Button)getActivity().findViewById(R.id.button_3);
        imageView3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                replaceFragment(new JingDong());
            }
        });

        Button imageView4 = (Button)getActivity().findViewById(R.id.button_4);
        imageView4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                replaceFragment(new TaoBao());
            }
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.chat_fragment,fragment);
        transaction.commit();
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onStop(){
        super.onStop();
    }

    @Override
    public void onStart(){
        super.onStart();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }
}
