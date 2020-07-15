package com.example.signin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class SignUpActivity extends AppCompatActivity {

    private EditText phoneEditText;
    private EditText passwordEditText;
    private SignInButton googleSignInButton;

    private String phone;
    private String password;

    private static final int RC_SIGN_IN = 9001;
    private GoogleSignInClient mGoogleSignInClient;
    private static final String TAG = "SignUpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar

        setContentView(R.layout.activity_sign_up);

        //edit facebook button
        LoginButton loginButton = findViewById(R.id.login_button);
        loginButton.setLoginText("Sign in");


        phoneEditText = findViewById(R.id.phone_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        final Button signUpPhone = findViewById(R.id.sign_up_phone);
        googleSignInButton = findViewById(R.id.sign_in_button1);

        //goto otp activity
        signUpPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = phoneEditText.getText().toString();
                password = passwordEditText.getText().toString();

                if (!phone.isEmpty() && !password.isEmpty()) {
                    if (phone.length() == 10) {
                        Intent intent = new Intent(SignUpActivity.this, OtpActivity.class);
                        phone = "+91" + phone;
                        intent.putExtra("phone", phone);
                        intent.putExtra("password", password);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(SignUpActivity.this, "Enter valid phone number", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(SignUpActivity.this, "Enter valid phone number or password", Toast.LENGTH_LONG).show();
                }
            }
        });

        //goto login activity
        TextView goLogin = findViewById(R.id.slogin);
        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        //start google signing in
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        googleSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (new InternetCheck().internetCheck(SignUpActivity.this))
                    signInGoogle();
                else
                    Toast.makeText(SignUpActivity.this, "Internet is not available", Toast.LENGTH_LONG).show();
            }
        });
    }



    // [START signIn google]
    private void signInGoogle() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    // [END signIn google]

    // [START handleSignInResult for google]
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Toast.makeText(this, "Sign in failed", Toast.LENGTH_LONG).show();
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            updateUI(null);
        }
    }
    // [END handleSignInResult for google]


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void updateUI(@Nullable GoogleSignInAccount account) {
        if (account != null) {
            Intent intent = new Intent(SignUpActivity.this, HomePageActivity.class);
            startActivity(intent);
            finish();
        } else {
        }
    }
}