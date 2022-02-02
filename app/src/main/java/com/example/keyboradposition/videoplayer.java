package com.example.keyboradposition;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.VideoView;

public class videoplayer extends AppCompatActivity {
    VideoView videoView;
    EditText editText_url;
    Button btn_ok;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoplayer);
        videoView = findViewById(R.id.viedoview);

//        videoView.setVideoPath("https://bestone-node-test.s3.ap-south-1.amazonaws.com/userUploads/jJQ3nH8W5IJ3o.mp4");
//        videoView.start();



                Uri videouri=Uri.parse("https://hdvideo9.com/files/download/id/2823");

//        Uri videouri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.r);
        videoView.setVideoURI(videouri);
        MediaController videocontroller=new MediaController(this);
       videocontroller.setAnchorView(this.videoView);
        videocontroller.requestFocus();
        videoView.setMediaController(videocontroller);
        videocontroller.setMediaPlayer(this.videoView);
        videoView.start();



//        MediaController videoMediaController = new MediaController(this);
//        videoMediaController.setMediaPlayer(videoView);
//        videoMediaController.setAnchorView(videoView);
//        videoView.setMediaController(videoMediaController);
//        videoMediaController.requestFocus();
//        videoView.start();
            }



}