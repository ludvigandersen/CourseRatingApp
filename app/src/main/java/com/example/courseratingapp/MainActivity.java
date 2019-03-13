package com.example.courseratingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";


    Button androidButton, pythonButton, angularButton, CButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }





    public void onClickAndroid(View view){
        Log.d(TAG, "onClickAndroid: has been called");
        Intent i = new Intent(this, RatingActivity.class);
        i.putExtra("courseName", androidButton.getText());


        startActivity(i);

    }

    public void onClickPython(View view){
        Log.d(TAG, "onClickPython: has been called");
        Intent i = new Intent(this, RatingActivity.class);
        i.putExtra("courseName", pythonButton.getText());
        startActivity(i);

    }

    public void onClickAngular(View view){
        Log.d(TAG, "onClickAngular: has been called");
        Intent i = new Intent(this, RatingActivity.class);
        i.putExtra("courseName", angularButton.getText());
        startActivity(i);

    }

    public void onClickC(View view){
        Log.d(TAG, "onClickC: has been called");
        Intent i = new Intent(this, RatingActivity.class);
        i.putExtra("courseName", CButton.getText());
        startActivity(i);

    }


    private void init(){


        androidButton = findViewById(R.id.androidButtton);
        pythonButton = findViewById(R.id.pythonButton);
        angularButton = findViewById(R.id.angularButton);
        CButton = findViewById(R.id.cButton);

    }

}
