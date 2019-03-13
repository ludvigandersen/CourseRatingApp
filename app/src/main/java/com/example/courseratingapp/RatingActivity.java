package com.example.courseratingapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.courseratingapp.Model.Rating;

public class RatingActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private static final String TAG = "RatingActivity";

    TextView courseName, feedbackView, qualityView, relevansView, perfomanceView, preparationView, jobView, commentView;
    SeekBar feedbackBar, qualityBar, relevansBar, perfomanceBar, preparationBar, jobBar;
    EditText editComment;
    Button infoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        init();

        Bundle extras = getIntent().getExtras();
        String courseVal = extras.getString("courseName");

        if (courseVal != null) {
            courseName.setText(courseVal);
        }


    }

    public void submitRating(View view){
        Log.d(TAG, "submitRating: Has been called");

        Rating sentRating = new Rating();
        sentRating.setFeedback(feedbackBar.getProgress());
        sentRating.setExQuality(qualityBar.getProgress());
        sentRating.setRelevans(relevansBar.getProgress());
        sentRating.settPerfomance(perfomanceBar.getProgress());
        sentRating.settPreparation(preparationBar.getProgress());
        sentRating.setJobOpp(jobBar.getProgress());
        sentRating.setComment(editComment.getText().toString());

        Intent i = new Intent(this, SubmitActivity.class );
        i.putExtra("ratingData", sentRating);
        i.putExtra("courseName", courseName.getText());
        startActivity(i);


        //TODO: Implement onCLick function for rating a course & teacher
    }

    private void init() {
        //TextViews
        courseName = findViewById(R.id.courseName);
        feedbackView = findViewById(R.id.feedbackView);
        qualityView = findViewById(R.id.qualityView);
        relevansView = findViewById(R.id.relevansView);
        perfomanceView = findViewById(R.id.perfomanceView);
        preparationView = findViewById(R.id.preparationView);
        jobView = findViewById(R.id.jobView);
        commentView = findViewById(R.id.commentView);

        //SeekBars
        feedbackBar = findViewById(R.id.feedbackBar);
        qualityBar = findViewById(R.id.qualityBar);
        relevansBar = findViewById(R.id.relevansBar);
        perfomanceBar = findViewById(R.id.perfomanceBar);
        preparationBar = findViewById(R.id.preparationBar);
        jobBar = findViewById(R.id.jobBar);

        //EditText
        editComment = findViewById(R.id.editComment);

        //Buttons
        infoButton = findViewById(R.id.infoButton);

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

        switch (seekBar.getId()) {

            case R.id.feedbackBar:

                feedbackView.setText(getString(R.string.test, feedbackBar.getProgress()));
                break;

            case R.id.qualityBar:


                qualityView.setText(getString(R.string.test, qualityBar.getProgress()));
                break;
            case R.id.relevansBar:

                relevansView.setText(getString(R.string.test, relevansBar.getProgress()));
                break;

            case R.id.perfomanceBar:

                perfomanceView.setText(getString(R.string.test, perfomanceBar.getProgress()));
                break;

            case R.id.preparationBar:

                preparationView.setText(getString(R.string.test, preparationBar.getProgress()));
                break;
            case R.id.jobBar:

                jobView.setText(getString(R.string.test, jobBar.getProgress()));
                break;

        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public void conversionDialog(View view){
        Log.d(TAG, "conversionDialog: Has been called");
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(R.string.conversiontitle);

        alert.setMessage(R.string.conversioninfo).setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = alert.create();

        alertDialog.show();


    }
}
