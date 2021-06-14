package com.sumanth.signupandsignin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicInteger;

public class SigninActivity extends AppCompatActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signin);

		String uname;
		String pass;
		AtomicInteger counter = new AtomicInteger();
		Button SignIn = findViewById(R.id.btnSignIn);
		EditText UserName = findViewById(R.id.etUsername);
		EditText Password = findViewById(R.id.etPassword);

		Bundle bundle = getIntent().getExtras();
		uname = bundle.getString("username");
		pass = bundle.getString("password");
		SignIn.setOnClickListener(v -> {

				if (UserName.getText().toString().equals(uname)&&Password.getText().toString().equals(pass)){
						startActivity(new Intent(getApplicationContext(),LoginSuccessActivity.class));
				}else {
					Toast.makeText(this,"Username/Password is invalid",Toast.LENGTH_SHORT).show();
					if(counter.getAndIncrement()==2){
						Toast.makeText(this,"Max attempts reached !",Toast.LENGTH_SHORT).show();
						SignIn.setEnabled(false);
					}
				}
		});
	}
}