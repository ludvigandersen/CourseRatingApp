package com.example.courseratingapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class AuthActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private static final String TAG = "AuthActivity";
    EditText editPassword, editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        init();
        mAuth = FirebaseAuth.getInstance();

        //https://github.com/firebase/quickstart-android/blob/af0ce4d301dcaa877ac33b654ef62e473989c963/auth/app/src/main/java/com/google/firebase/quickstart/auth/java/EmailPasswordActivity.java#L91-L112
        //https://firebase.google.com/docs/auth/android/email-link-auth
        //https://console.firebase.google.com/project/course-rating-9735c/authentication/providers
        onStart();


    }



    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
        Intent i = new Intent(this, MainActivity.class);


        startActivity(i);

    }

    private void createAccount(String email, String password){

    }

    private void init(){
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
    }


}
