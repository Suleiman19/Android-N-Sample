package com.grafixartist.androidn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class DetailActivity extends AppCompatActivity {

    Avenger avenger;

    TextView name;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getIntent() != null) {
            avenger = getIntent().getParcelableExtra("avenger");


            name = (TextView) findViewById(R.id.detail_name);
            img = (ImageView) findViewById(R.id.detail_img);

            Log.d("img", "" + avenger.getPhoto());

            Glide
                    .with(this)
                    .load(avenger.getPhoto())
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(img);

            name.setText(avenger.getName());

        }


    }
}
