package com.example.courseratingapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class AuthActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private static final String TAG = "AuthActivity";

    Button signIn, signOut, createAccount;
    EditText editPassword, editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        init();

        mAuth = FirebaseAuth.getInstance();

    }



    @Override
    public void onStart() {
        Log.d(TAG, "onStart: has been called");
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser user) {
        Log.d(TAG, "updateUI: has been called");
        Intent i = new Intent(this, MainActivity.class);
        if (user != null) {
            startActivity(i);
        } else {
            signIn.setVisibility(View.VISIBLE);
            editEmail.setVisibility(View.VISIBLE);
            editPassword.setVisibility(View.VISIBLE);
            createAccount.setVisibility(View.VISIBLE);
            signOut.setVisibility(View.GONE);
        }


    }

    public void signOut() {
        mAuth.signOut();
        updateUI(null);
    }

    private void createAccount(String email, String password){
        Log.d(TAG, "createAccount: has been called");
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(AuthActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    private void signIn(String email, String password){
        Log.d(TAG, "signIn: has been called");
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(AuthActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    public void onClick(View v) {
        Log.d(TAG, "onClick: has been called");
        int i = v.getId();
        if (i == R.id.emailCreateAccountButton) {
            createAccount(editEmail.getText().toString(), editPassword.getText().toString());
        } else if (i == R.id.emailSignInButton) {
            signIn(editEmail.getText().toString(), editPassword.getText().toString());
        } else if (i == R.id.signOutButton) {
            signOut();
        }
    }


    private void init(){
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);

        signIn = findViewById(R.id.emailSignInButton);
        signOut = findViewById(R.id.signOutButton);
        createAccount = findViewById(R.id.emailCreateAccountButton);

    }


}
