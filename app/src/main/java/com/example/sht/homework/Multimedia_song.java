package com.example.sht.homework;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sht.homework.Music.MusicFirst;
import com.example.sht.homework.Music.MusicForth;
import com.example.sht.homework.Music.MusicSecond;
import com.example.sht.homework.Music.MusicThird;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.ArrayList;
import java.util.List;


public class Multimedia_song extends Fragment {

    private MediaPlayer mediaPlayer = new MediaPlayer();
    private Button play,pause,stop;//播放 暂停/继续 停止 按钮
    private boolean isPause=false;//是否暂停

    public int time=3000;

    private ViewPager viewPager;

    private int[] imageResIds;

    private ArrayList<ImageView> imageViewList;

    private LinearLayout ll_point_container;

    private String[] contentDescs;

    private TextView tv_desc;

    private int previousSelectedPosition = 0;

    public boolean isRunning = true;

    private List<Class_Environment> worldList = new ArrayList<>();

    private RollPagerView mRollViewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.multimedia_song,container,false);
        return view;
    }


    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setContentView(R.layout.multimedia_song);

        mRollViewPager = (RollPagerView) getActivity().findViewById(R.id.roll_view_pager_song);
        mRollViewPager.setPlayDelay(2000);
        mRollViewPager.setAnimationDurtion(500);
        mRollViewPager.setAdapter(new TestNormalAdapter());
        mRollViewPager.setHintView(new ColorPointHintView(getActivity(), Color.YELLOW,Color.WHITE));

        Button photo = (Button) getActivity().findViewById(R.id.music_1st);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getActivity(),MusicFirst.class);
                startActivity(intent);
            }
        });

        Button eat = (Button) getActivity().findViewById(R.id.music_2st);
        eat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getActivity(),MusicSecond.class);
                startActivity(intent);
            }
        });
        Button game = (Button) getActivity().findViewById(R.id.music_3st);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getActivity(),MusicThird.class);
                startActivity(intent);
            }
        });
        Button hlju = (Button) getActivity().findViewById(R.id.music_4st);
        hlju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getActivity(),MusicForth.class);
                startActivity(intent);
            }
        });
        }
    private class TestNormalAdapter extends StaticPagerAdapter {

        private int[] imgs = {

                R.drawable.music_cicle_1st,

                R.drawable.music_cicle_2st,

                R.drawable.music_cicle_3st,

                R.drawable.music_cicle_4st,

                R.drawable.music_cicle_5st,

                R.drawable.music_cicle_6st,

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
