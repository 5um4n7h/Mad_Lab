package com.sumanth.signupandsignin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {
	private String pass;
	public static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
	Pattern psPattern = Pattern.compile(PASSWORD_PATTERN);

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);

		Button signUp = findViewById(R.id.btnSignUp);
		EditText UserName = findViewById(R.id.etUsername);
		EditText Password = findViewById(R.id.etPassword);
		signUp.setOnClickListener(v -> {
			String uname = UserName.getText().toString();
			pass = Password.getText().toString();
			if (uname.isEmpty() || pass.isEmpty()) {
				Toast.makeText(this, "Username/Password can't be empty !", Toast.LENGTH_SHORT).show();
			}
			if (isValid()) {
				Bundle bundle = new Bundle();
				bundle.putString("username", uname);
				bundle.putString("password", pass);

				startActivity(new Intent(getApplicationContext(), SigninActivity.class).putExtras(bundle));
			}

		});
	}

	private Boolean isValid() {
		if (!psPattern.matcher(pass).matches()) {
			Toast.makeText(this, "Password is not strong !", Toast.LENGTH_SHORT).show();
			return false;
		} else
			return true;
	}
}