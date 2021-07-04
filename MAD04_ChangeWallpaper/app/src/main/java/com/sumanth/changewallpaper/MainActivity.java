package com.sumanth.changewallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import android.os.Bundle;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
	Timer myTimer = new Timer();  //to schedule the task
	WallpaperManager wpm;
	int[] images = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four};  // drawable images array
	int i = 0;  //to iterate through images

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		wpm = WallpaperManager.getInstance(this);

		findViewById(R.id.button).setOnClickListener(v -> {
			setWallpaper();
		});
	}

	public void setWallpaper() {
		myTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				if (i == 4)
					i = 0;         //to start from beginning of the array
				Drawable drawable = getResources().getDrawable(images[i++]);
				Bitmap wallpaper = ((BitmapDrawable) drawable).getBitmap();
				try {
					wpm.setBitmap(wallpaper);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}, 0, 30000);   // to repeat the TimerTask() for every 30 seconds
	}
}