package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.login.widget.LoginButton;

public class SignUpActivity extends AppCompatActivity {

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
                    Intent intent = new Intent(SignUpActivity.this, OtpActivity.class);
                    phone="+91"+phone;
                    intent.putExtra("phone", phone);
                    intent.putExtra("password", password);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(SignUpActivity.this,"Enter valid phone number or password",Toast.LENGTH_LONG).show();
                }
            }
        });

        TextView goLogin = findViewById(R.id.slogin);
        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

    }


}