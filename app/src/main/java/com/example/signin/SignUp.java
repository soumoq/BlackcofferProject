package com.example.signin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.*;

import java.util.concurrent.TimeUnit;
import java.util.zip.Inflater;

public class SignUp extends AppCompatActivity {

    private EditText phoneEditText;
    private EditText passwordEditText;

    private String phone;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar

        setContentView(R.layout.activity_sign_up);

        LoginButton loginButton = findViewById(R.id.login_button);
        loginButton.setLoginText("Sign in");


        phoneEditText = findViewById(R.id.phone_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);


        Button signUpPhone = findViewById(R.id.sign_up_phone);
        signUpPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = phoneEditText.getText().toString();
                password = passwordEditText.getText().toString();

                if (!phone.isEmpty() && !password.isEmpty()) {
                    Intent intent = new Intent(SignUp.this, Otp.class);
                    intent.putExtra("phone", phone);
                    intent.putExtra("password", password);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(SignUp.this,"Enter valid phone number or password",Toast.LENGTH_LONG).show();
                }
            }
        });

        TextView goLogin = findViewById(R.id.slogin);
        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUp.this, Login.class);
                startActivity(i);
            }
        });

    }


}