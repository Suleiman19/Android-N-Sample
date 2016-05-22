package com.grafixartist.androidn;

import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    FrameLayout frame;
    RecyclerView recyclerView;
    AvengersAdapter adapter;

    TransitionDrawable transitionDrawable;

    private static final String TAG = "MainActivity";
    private static final int TRANSITION_DURATION = 400;

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate");

        frame = (FrameLayout) findViewById(R.id.frame_bg);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Avengers");

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DummyData dummyData = new DummyData(this);
        adapter = new AvengersAdapter(dummyData.populateAvengers(), this);

        recyclerView.setAdapter(adapter);

        if (isInMultiWindowMode()) {
            Toast.makeText(MainActivity.this, "Yay, Multi-Window!", Toast.LENGTH_SHORT).show();
        }

        adapter.SetOnItemClickListener(new AvengersAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // TODO: 5/15/16 handle click

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT | Intent.FLAG_ACTIVITY_NEW_TASK);

                // Fetch Avenger at position
                Avenger avenger = adapter.getAvengers().get(position);
                intent.putExtra("avenger", avenger);
                startActivity(intent);
            }
        });

    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }
}
