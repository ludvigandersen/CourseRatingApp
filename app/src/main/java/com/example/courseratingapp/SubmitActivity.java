package com.example.courseratingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.courseratingapp.Model.Rating;

public class SubmitActivity extends AppCompatActivity {

    private static final String TAG = "SubmitActivity";


    TextView feedbackRating, qualityRating, relevansRating, tperfomanceRating, tprepRating, jobOppRating, commentRating, courseRated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        init();
        Intent intent = getIntent();
        Rating rating = intent.getParcelableExtra("ratingData");
        String course = intent.getStringExtra("courseName");


        if (rating != null) {
            courseRated.setText(getString(R.string.ratings, course));
            feedbackRating.setText(getString(R.string.submitted, rating.getFeedback(), getLetterGrade(rating.getFeedback())));
            qualityRating.setText(getString(R.string.submitted, rating.getExQuality(), getLetterGrade(rating.getExQuality())));
            relevansRating.setText(getString(R.string.submitted, rating.getRelevans(), getLetterGrade(rating.getRelevans())));
            tperfomanceRating.setText(getString(R.string.submitted, rating.gettPerfomance(), getLetterGrade(rating.gettPerfomance())));
            tprepRating.setText(getString(R.string.submitted, rating.gettPreparation(), getLetterGrade(rating.gettPreparation())));
            jobOppRating.setText(getString(R.string.submitted, rating.getJobOpp(), getLetterGrade(rating.getJobOpp())));
            commentRating.setText(rating.getComment());

        }


    }

    public String getLetterGrade(int i) {
        Log.d(TAG, "getLetterGrade: Has been called");
        if (i > 90) {
            return "A";
        } else if (i < 90 && i > 80 ) {
            return "B";
        } else if(i < 80 && i > 70 ){
            return "C";
        } else if(i < 70 && i > 60){
            return "D";
        } else if (i < 60 && i > 50){
            return "E";
        } else {
            return "Failed";
        }

    }


    //TODO: Make method for sending email with rated values


    public void init() {

        //TextViews
        feedbackRating = findViewById(R.id.feedbackRating);
        qualityRating = findViewById(R.id.qualityRating);
        relevansRating = findViewById(R.id.relevansRating);
        tperfomanceRating = findViewById(R.id.tperfomanceRating);
        tprepRating = findViewById(R.id.tprepRating);
        jobOppRating = findViewById(R.id.jobOppRating);
        commentRating = findViewById(R.id.commentRating);
        courseRated = findViewById(R.id.courseRated);

    }
}
