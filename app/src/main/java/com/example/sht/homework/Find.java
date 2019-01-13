package com.example.sht.homework;


import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sht.homework.EnvironmentCenter.CSDN;
import com.example.sht.homework.EnvironmentCenter.IRemenber;
import com.example.sht.homework.EnvironmentCenter.Microsoft;
import com.example.sht.homework.EnvironmentCenter.Pexels;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.ArrayList;
import java.util.List;


public class Find extends Fragment {



        public int time=3000;

        private List<Class_Environment> worldList = new ArrayList<>();

        private RollPagerView mRollViewPager;
    @Nullable

//    WebView webView;
//    private long exitTime = 0;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_find
                , container, false);
    }


    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRollViewPager = (RollPagerView) getActivity().findViewById(R.id.roll_view_pager);
        mRollViewPager.setPlayDelay(2000);
        mRollViewPager.setAnimationDurtion(500);
        mRollViewPager.setAdapter(new TestNormalAdapter());
        mRollViewPager.setHintView(new ColorPointHintView(getActivity(), Color.YELLOW,Color.WHITE));


        ImageButton q = (ImageButton) getActivity().findViewById(R.id.find_csdn);
        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getActivity(),Microsoft.class);
                startActivity(intent);
            }
        });
        q.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        ImageButton a = (ImageButton) getActivity().findViewById(R.id.find_niuke);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getActivity(),CSDN.class);
                startActivity(intent);
            }
        });
        a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);


        ImageButton z = (ImageButton) getActivity().findViewById(R.id.find_chinaunix);
        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getActivity(),IRemenber.class);
                startActivity(intent);
            }
        });
        z.setScaleType(ImageView.ScaleType.CENTER_INSIDE);


        ImageButton w = (ImageButton) getActivity().findViewById(R.id.find_itpub);
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getActivity(),Pexels.class);
                startActivity(intent);
            }
        });
        w.setScaleType(ImageView.ScaleType.CENTER_INSIDE);



        ImageButton q1 = (ImageButton) getActivity().findViewById(R.id.find_51cto);
        q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getActivity(),Microsoft.class);
                startActivity(intent);
            }
        });
        q1.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        ImageButton a1 = (ImageButton) getActivity().findViewById(R.id.find_落伍者);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getActivity(),CSDN.class);
                startActivity(intent);
            }
        });
        a1.setScaleType(ImageView.ScaleType.CENTER_INSIDE);


        ImageButton z1 = (ImageButton) getActivity().findViewById(R.id.find_蓝色理想);
        z1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getActivity(),IRemenber.class);
                startActivity(intent);
            }
        });
        z1.setScaleType(ImageView.ScaleType.CENTER_INSIDE);


        ImageButton w1 = (ImageButton) getActivity().findViewById(R.id.find_it写作社区);
        w1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getActivity(),Pexels.class);
                startActivity(intent);
            }
        });
        w1.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        Button see = (Button) getActivity().findViewById(R.id.go_to_see);
        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getActivity(),JqActivity.class);
                startActivity(intent);
            }
        });
        w1.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

    }

        private class TestNormalAdapter extends StaticPagerAdapter {

            private int[] imgs = {

                    R.drawable.mine_1,

                    R.drawable.mine_2,

                    R.drawable.mine_3,

                    R.drawable.mine_4,

            };

            @Override
            public View getView(ViewGroup container, int position) {
                ImageView view = new ImageView(container.getContext());
                view.setImageResource(imgs[position]);
                view.setScaleType(ImageView.ScaleType.CENTER_CROP);
                view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return view;

            }

            @Override
            public int getCount() {
                return imgs.length;
            }

        }


}
