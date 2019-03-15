package com.example.courseratingapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RatingActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private static final String TAG = "RatingActivity";

    TextView courseName, feedbackView, qualityView, relevansView, perfomanceView, preparationView, jobView, commentView;
    SeekBar feedbackBar, qualityBar, relevansBar, perfomanceBar, preparationBar, jobBar;
    EditText editComment;
    Button infoButton;
    FirebaseFirestore db = FirebaseFirestore.getInstance();


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

        //TODO: Forsøg at sende Rating object til Firestore i stedet for seekbar værdier
        Rating sentRating = new Rating();
        sentRating.setFeedback(feedbackBar.getProgress());
        sentRating.setExQuality(qualityBar.getProgress());
        sentRating.setRelevans(relevansBar.getProgress());
        sentRating.settPerfomance(perfomanceBar.getProgress());
        sentRating.settPreparation(preparationBar.getProgress());
        sentRating.setJobOpp(jobBar.getProgress());
        sentRating.setComment(editComment.getText().toString());

        Map<String, Object> rating = new HashMap<>();
        rating.put("feedback", feedbackBar.getProgress());
        rating.put("quality", qualityBar.getProgress());
        rating.put("relevans", relevansBar.getProgress());
        rating.put("perfomance", perfomanceBar.getProgress());
        rating.put("preparation", preparationBar.getProgress());
        rating.put("opportunities", jobBar.getProgress());
        rating.put("comment", editComment.getText().toString());
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        db.collection("ratings").document("courses")
                .collection(courseName.getText().toString()).document(user.getEmail())
                .set(rating).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "onSuccess: succesfully written");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "onFailure: ",e );
            }
        });

        Intent i = new Intent(this, SubmitActivity.class );
        i.putExtra("ratingData", sentRating);
        i.putExtra("courseName", courseName.getText());
        startActivity(i);

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
