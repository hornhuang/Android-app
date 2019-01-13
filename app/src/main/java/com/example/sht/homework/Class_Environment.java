package com.example.sht.homework;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sht.homework.EnvironmentCenter.CSDN;
import com.example.sht.homework.EnvironmentCenter.IRemenber;
import com.example.sht.homework.EnvironmentCenter.Microsoft;
import com.example.sht.homework.EnvironmentCenter.Pexels;
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

        private List<Class_Environment> worldList = new ArrayList<>();

        private RollPagerView mRollViewPager;
        private  Class_Environment_Adapter adapter_bottom_2;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_environment,container,false);
            return view;
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            initWorldBottom();
            RecyclerView recyclerView_2 = (RecyclerView) getActivity().findViewById(R.id.recycler_bottom_view);
            StaggeredGridLayoutManager layoutManager_bottom_2 = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
            recyclerView_2.setLayoutManager(layoutManager_bottom_2);
            recyclerView_2.addItemDecoration(new SpaceItemDecoration(0));
            adapter_bottom_2 = new Class_Environment_Adapter(worldList);
            recyclerView_2.setAdapter(adapter_bottom_2);

            mRollViewPager = (RollPagerView) getActivity().findViewById(R.id.roll_view_pager);
            mRollViewPager.setPlayDelay(2000);
            mRollViewPager.setAnimationDurtion(500);
            mRollViewPager.setAdapter(new TestNormalAdapter());
            mRollViewPager.setHintView(new ColorPointHintView(getActivity(), Color.RED,Color.WHITE));


            TextView game = (TextView) getActivity().findViewById(R.id.environment_game);
            game.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent  = new Intent(getActivity(),Toolbar_game.class);
                    startActivity(intent);
                }
            });


            TextView hlju = (TextView) getActivity().findViewById(R.id.environment_hlju);
            hlju.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent  = new Intent(getActivity(),Toolbar_hlju.class);
                    startActivity(intent);
                }
            });


            ImageButton q = (ImageButton) getActivity().findViewById(R.id.multimedia_camera_rankings);
            q.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent  = new Intent(getActivity(),Microsoft.class);
                    startActivity(intent);
                }
            });
            q.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

            ImageButton a = (ImageButton) getActivity().findViewById(R.id.multimedia_camera_classification);
            a.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent  = new Intent(getActivity(),CSDN.class);
                    startActivity(intent);
                }
            });
            a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);


            ImageButton z = (ImageButton) getActivity().findViewById(R.id.multimedia_camera_special);
            z.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent  = new Intent(getActivity(),IRemenber.class);
                    startActivity(intent);
                }
            });
            z.setScaleType(ImageView.ScaleType.CENTER_INSIDE);


            ImageButton w = (ImageButton) getActivity().findViewById(R.id.multimedia_camera_mine);
            w.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent  = new Intent(getActivity(),Pexels.class);
                    startActivity(intent);
                }
            });
            w.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }

        private class TestNormalAdapter extends StaticPagerAdapter {

            private int[] imgs = {

                    R.drawable.enironment_circle_14st,

                    R.drawable.enironment_circle_7st,

                    R.drawable.nironment_circle_13st,

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
                        "美股反弹科技股领涨 亚马逊涨4.03%阿里巴...",R.drawable.enironment_circle_1st);
                worldList.add(xiaochou);
                Class_Environment guandao = new Class_Environment(
                        "口碑饿了么合并 阿里成立本地生活服务平台",R.drawable.enironment_circle_5st);
                worldList.add(guandao);
                Class_Environment xiahu = new Class_Environment(
                        "传特斯拉以近10亿元的价格获上海建厂用地",R.drawable.enironment_circle_2st);
                worldList.add(xiahu);
                Class_Environment lanmo = new Class_Environment(
                        "世界知识论坛：三七互娱杨军畅谈中国游戏...",R.drawable.enironment_circle_3st);
                worldList.add(lanmo);
                Class_Environment landiao = new Class_Environment(
                        "国务院新方案推动“互联网+”加快5G商用",R.drawable.enironment_circle_4st);
                worldList.add(landiao);
                Class_Environment hongyin = new Class_Environment(
                        "醒醒吧！AI妄想症 计算机比我们更聪明？",R.drawable.enironment_circle_10st);
                worldList.add(hongyin);
                Class_Environment renzidie = new Class_Environment(
                        "歌尔股份：虚拟现实产业增速放缓 但坚定长期发展战略",R.drawable.enironment_circle_12st);
                worldList.add(renzidie);
                Class_Environment meigui = new Class_Environment(
                        "小米不敌OPPO，上月销量将被OPPO超过！",R.drawable.enironment_circle_13st);
                worldList.add(meigui);
                Class_Environment paodan = new Class_Environment(
                        "9月手机品牌全球出货量排行：苹果超华为重回全球第二",R.drawable.enironment_circle_15st);
                worldList.add(paodan);
                Class_Environment yuemeidie = new Class_Environment(
                        "谷歌神经网络人声分离技术再突破！词错率低至23.4%",R.drawable.enironment_circle_6st);
                worldList.add(yuemeidie);
                Class_Environment yuemeidie1 = new Class_Environment(
                        "变革开始？谷歌在发布会上一次未提及Android",R.drawable.enironment_circle_7st);
                worldList.add(yuemeidie1);
                Class_Environment yuemeidie2 = new Class_Environment(
                        "微软将在上海设立微软亚洲研究院",R.drawable.enironment_circle_8st);
                worldList.add(yuemeidie2);
                Class_Environment yuemeidie3 = new Class_Environment(
                        "编程科普，C、C++、Java、PHP、Python分别用来开发什么？",R.drawable.enironment_circle_9st);
                worldList.add(yuemeidie3);
//                adapter_bottom_2.notifyDataSetChanged();

            }
        }

    }
}
