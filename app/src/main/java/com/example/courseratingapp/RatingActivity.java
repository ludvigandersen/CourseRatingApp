package com.example.courseratingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class RatingActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private static final String TAG = "RatingActivity";
    TextView courseName, feedbackView, qualityView, relevansView, perfomanceView, preparationView, jobView;
    SeekBar feedbackBar, qualityBar, relevansBar, perfomanceBar, preparationBar, jobBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        init();

        Bundle extras = getIntent().getExtras();
        String courseVal = extras.getString("courseName");

        if(courseVal != null){
            courseName.setText(courseVal);
        }


    }





    private void init(){
        //TextViews
        courseName = findViewById(R.id.courseName);
        feedbackView = findViewById(R.id.feedbackView);
        qualityView = findViewById(R.id.qualityView);
        relevansView = findViewById(R.id.relevansView);
        perfomanceView = findViewById(R.id.perfomanceView);
        preparationView = findViewById(R.id.preparationView);
        jobView = findViewById(R.id.jobView);

        //SeekBars
        feedbackBar = findViewById(R.id.feedbackBar);
        qualityBar = findViewById(R.id.qualityBar);
        relevansBar = findViewById(R.id.relevansBar);
        perfomanceBar = findViewById(R.id.perfomanceBar);
        preparationBar = findViewById(R.id.preparationBar);
        jobBar = findViewById(R.id.jobBar);

        //SeekBar listeners
        feedbackBar.setOnSeekBarChangeListener(this);
        qualityBar.setOnSeekBarChangeListener(this);
        relevansBar.setOnSeekBarChangeListener(this);
        perfomanceBar.setOnSeekBarChangeListener(this);
        preparationBar.setOnSeekBarChangeListener(this);
        jobBar.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()){

            case R.id.feedbackBar:
                feedbackView.setText("" + feedbackBar.getProgress());
                break;

            case R.id.qualityBar:
                qualityView.setText("" + qualityBar.getProgress());
                break;
            case R.id.relevansBar:
                relevansView.setText("" + relevansBar.getProgress());
                break;
            case R.id.perfomanceBar:
                perfomanceView.setText("" + perfomanceBar.getProgress());
                break;
            case R.id.preparationBar:
                preparationView.setText("" + preparationBar.getProgress());
                break;
            case R.id.jobBar:
                jobView.setText("" + jobBar.getProgress());
                break;


        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
