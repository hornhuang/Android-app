package com.example.sht.homework;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sht.homework.Class_Environment_Adapter;
import com.example.sht.homework.EnvironmentCenter.CSDN;
import com.example.sht.homework.EnvironmentCenter.IRemenber;
import com.example.sht.homework.EnvironmentCenter.Microsoft;
import com.example.sht.homework.EnvironmentCenter.Pexels;
import com.example.sht.homework.R;
import com.example.sht.homework.SpaceItemDecoration;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.ArrayList;
import java.util.List;

public class Class_Environment {

    private String name;
    private int imageId;

    public Class_Environment(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return  imageId;
    }

    public static class Environment extends Fragment {


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
            View view = inflater.inflate(R.layout.activity_environment,container,false);
            return view;
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            mRollViewPager = (RollPagerView) getActivity().findViewById(R.id.roll_view_pager);
            mRollViewPager.setPlayDelay(2000);
            mRollViewPager.setAnimationDurtion(500);
            mRollViewPager.setAdapter(new TestNormalAdapter());
            mRollViewPager.setHintView(new ColorPointHintView(getActivity(), Color.YELLOW,Color.WHITE));


            initWorldBottom();
            RecyclerView recyclerView_2 = (RecyclerView) getActivity().findViewById(R.id.recycler_bottom_view);
            StaggeredGridLayoutManager layoutManager_bottom_2 = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
            recyclerView_2.setLayoutManager(layoutManager_bottom_2);
            recyclerView_2.addItemDecoration(new SpaceItemDecoration(10));
            Class_Environment_Adapter adapter_bottom_2 = new Class_Environment_Adapter(worldList);
            recyclerView_2.setAdapter(adapter_bottom_2);

            ImageButton q = (ImageButton) getActivity().findViewById(R.id.multimedia_camera_rankings);
            q.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent  = new Intent(getActivity(),Microsoft.class);
                    startActivity(intent);
                }
            });

            ImageButton a = (ImageButton) getActivity().findViewById(R.id.multimedia_camera_classification);
            a.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent  = new Intent(getActivity(),CSDN.class);
                    startActivity(intent);
                }
            });

            ImageButton z = (ImageButton) getActivity().findViewById(R.id.multimedia_camera_special);
            z.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent  = new Intent(getActivity(),IRemenber.class);
                    startActivity(intent);
                }
            });

            ImageButton w = (ImageButton) getActivity().findViewById(R.id.multimedia_camera_mine);
            w.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent  = new Intent(getActivity(),Pexels.class);
                    startActivity(intent);
                }
            });

        }

        private class TestNormalAdapter extends StaticPagerAdapter {

            private int[] imgs = {

                    R.drawable.enironment_circle_14st,

                    R.drawable.enironment_circle_7st,

                    R.drawable.enironment_circle_13st,

                    R.drawable.enironment_circle_11st,

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

        private void initWorldBottom() {
            for (int i = 0 ;i < 1; i++){
                Class_Environment xiaochou = new Class_Environment(
                        "  严重雾霾污染影响生活",R.drawable.enironment_circle_1st);
                worldList.add(xiaochou);
                Class_Environment guandao = new Class_Environment(
                        "土地荒漠化求退耕还林",R.drawable.enironment_circle_5st);
                worldList.add(guandao);
                Class_Environment xiahu = new Class_Environment(
                        "超额排放化工废料严重污染土地",R.drawable.enironment_circle_2st);
                worldList.add(xiahu);
                Class_Environment lanmo = new Class_Environment(
                        "工业排放严重超标重金属危害健康",R.drawable.enironment_circle_3st);
                worldList.add(lanmo);
                Class_Environment landiao = new Class_Environment(
                        "杭州举办低碳减排会议",R.drawable.enironment_circle_4st);
                worldList.add(landiao);
                Class_Environment hongyin = new Class_Environment(
                        "食品浪费严重中央倡导光盘行动",R.drawable.enironment_circle_10st);
                worldList.add(hongyin);
                Class_Environment renzidie = new Class_Environment(
                        "温室气体过量排放导致气候异常",R.drawable.enironment_circle_12st);
                worldList.add(renzidie);
                Class_Environment meigui = new Class_Environment(
                        "温室气体过量排放导致气候异常",R.drawable.enironment_circle_13st);
                worldList.add(meigui);
                Class_Environment paodan = new Class_Environment(
                        "使得造成水土流失",R.drawable.enironment_circle_15st);
                worldList.add(paodan);
                Class_Environment yuemeidie = new Class_Environment(
                        "滥砍滥伐土地荒漠化",R.drawable.enironment_circle_6st);
                worldList.add(yuemeidie);
                Class_Environment yuemeidie1 = new Class_Environment(
                        "中东部地区土地干裂",R.drawable.enironment_circle_7st);
                worldList.add(yuemeidie1);
                Class_Environment yuemeidie2 = new Class_Environment(
                        "过度捕捞海洋生物",R.drawable.enironment_circle_8st);
                worldList.add(yuemeidie2);
                Class_Environment yuemeidie3 = new Class_Environment(
                        "农药使用严重超标",R.drawable.enironment_circle_9st);
                worldList.add(yuemeidie3);

            }
        }



    }
}
