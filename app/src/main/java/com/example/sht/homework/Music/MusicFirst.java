package com.example.sht.homework.Music;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sht.homework.R;

public class MusicFirst extends AppCompatActivity  {
        private MediaPlayer mediaPlayer = new MediaPlayer();
        private Button play,pause,stop;//播放 暂停/继续 停止 按钮
        private boolean isPause=false;//是否暂停

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_music_first);
            play = (Button)findViewById(R.id.play);
            pause = (Button)findViewById(R.id.pause);
            stop = (Button)findViewById(R.id.stop);
            play=(Button) findViewById(R.id.play);
            mediaPlayer=MediaPlayer.create(MusicFirst.this, R.raw.zuiguangzhe);
            stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    mediaPlayer.stop();
                    pause.setEnabled(false);
                    stop.setEnabled(false);
                    play.setEnabled(true);
                }
            });
            pause.setOnClickListener(new View.OnClickListener() {



                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    if(mediaPlayer.isPlaying()&&!isPause){
                        mediaPlayer.pause();
                        isPause=true;
                        play.setEnabled(true);
                    }else{
                        mediaPlayer.start();
                        isPause=false;
                        play.setEnabled(false);
                    }
                }
            });
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {



                @Override

                public void onCompletion(MediaPlayer arg0) {
                    // TODO Auto-generated method stub
                    play();//重新开始播放
                }
            });
//        if (ContextCompat.checkSelfPermission(PlayAudioTest.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(PlayAudioTest.this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE }, 1);
//        } else {
//            initMediaPlayer();//初始化MediaPlayer
//        }
            play.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    play();
                    if(isPause){
                        isPause=false;
                    }
                }
            });
        }

        private void play(){
            try{
                mediaPlayer.reset();
                mediaPlayer=MediaPlayer.create(MusicFirst.this, R.raw.zuiguangzhe);//重新设置要播放的音频
                mediaPlayer.start();//开始播放
                play.setEnabled(false);
                pause.setEnabled(true);
                stop.setEnabled(true);
            }catch(Exception e){
                e.printStackTrace();//输出异常信息
            }
        }

//    private void initMediaPlayer(){
//        try {
//            File file = new File(Environment.getExternalStorageDirectory(), "music.mp3");
//            mediaPlayer.setDataSource(file.getPath());//指定音频文件的路径
//            mediaPlayer.prepare();//让MediaPlayer进入到准备状态
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        switch (requestCode){
//            case 1:
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                    initMediaPlayer();
//                } else {
//                    Toast.makeText(this, "拒绝权限将无法使用程序", Toast.LENGTH_SHORT).show();
//                    finish();
//                }
//                break;
//            default:
//                break;
//        }
//    }

        //    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.play:
//                if (!mediaPlayer.isPlaying()){
//                    mediaPlayer.start();//开始播放
//                }
//                break;
//            case R.id.pause:
//                if (mediaPlayer.isPlaying()){
//                    mediaPlayer.pause();//暂停播放
//                }
//                break;
//            case R.id.stop:
//                if (mediaPlayer.isPlaying()){
//                    mediaPlayer.reset();//停止播放
//                    initMediaPlayer();
//                }
//                break;
//            default:
//                break;
//        }
//
//    }
        protected void onDestroy() {
            // TODO Auto-generated method stub
            if(mediaPlayer.isPlaying()){
                mediaPlayer.stop();
            }
            mediaPlayer.release();//释放资源
            super.onDestroy();

        }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (mediaPlayer != null){
//            mediaPlayer.stop();
//            mediaPlayer.release();
//        }
//    }
}
