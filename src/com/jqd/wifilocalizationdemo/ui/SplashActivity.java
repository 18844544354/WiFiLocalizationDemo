package com.jqd.wifilocalizationdemo.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.jqd.wifilocalizationdemo.model.RadioMapModel;

/**
 * @author jiangqideng@163.com
 * @date 2016-6-29 ����12:53:22
 * @description ��ӭ���棬����ü��룬�������غ�ʱ��RadioMap
 */
public class SplashActivity extends Activity {
	public static SplashActivity splashActivity;
	private final long SPLASH_LENGTH = 400;
	Handler handler = new Handler();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash);
		splashActivity = this;
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				RadioMapModel.getInstance().init();
				Intent intent = new Intent(SplashActivity.this,
						MainActivity.class);
				SplashActivity.this.startActivity(intent);
				SplashActivity.this.finish();
			}
		}, SPLASH_LENGTH);// 2�����ת
	}
}
