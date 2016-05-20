package com.grafixartist.androidn;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class DetailActivity extends AppCompatActivity {

    Avenger avenger;

    TextView name;
    ImageView img;
    VideoView videoView;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getIntent() != null) {
            avenger = getIntent().getParcelableExtra("avenger");


            name = (TextView) findViewById(R.id.detail_name);
            img = (ImageView) findViewById(R.id.detail_img);
            fab = (FloatingActionButton) findViewById(R.id.detail_pip);

            videoView = (VideoView) findViewById(R.id.detail_video);

            Log.d("img", "" + avenger.getPhoto());

            Glide
                    .with(this)
                    .load(avenger.getPhoto())
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(img);

            name.setText(avenger.getName());

        }

        MediaController mediaController = new MediaController(this);

        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        int width = dm.widthPixels;

        videoView.setMinimumWidth(width);
        videoView.setMinimumHeight(height);
        videoView.setMediaController(mediaController);

        videoView.setVideoURI(Uri.parse("https://www.youtube.com/embed/rD8lWtcgeyg"));
        videoView.start();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterPictureInPictureMode();
            }
        });


    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
        if (isInPictureInPictureMode) {
            // Hide controls
        } else {
            // Restore playback UI

        }
    }
}
