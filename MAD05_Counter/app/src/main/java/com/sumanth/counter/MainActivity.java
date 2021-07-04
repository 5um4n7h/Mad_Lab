package com.sumanth.counter;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
	TextView tvCounter;
	int i = 1;
	Handler customHandler = new Handler();
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate (savedInstanceState);
		setContentView(R.layout.activity_main);
		tvCounter = findViewById(R.id.tvCounter);

		findViewById(R.id.btnStart).setOnClickListener(v -> customHandler.postDelayed(updateTimerThread, 0));
		findViewById(R.id.btnStop).setOnClickListener(v -> customHandler.removeCallbacks(updateTimerThread));
	}


	private final Runnable updateTimerThread = new Runnable() {
		@Override
		public void run() {
			tvCounter.setText(""+i);
			customHandler.postDelayed(this,1000);
			i++;
		}
	};
}

