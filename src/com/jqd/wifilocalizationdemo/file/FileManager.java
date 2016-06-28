package com.jqd.wifilocalizationdemo.file;

import java.io.IOException;
import java.io.InputStream;

import android.widget.Toast;

import com.jqd.wifilocalizationdemo.ui.MainActivity;
import com.jqd.wifilocalizationdemo.ui.SplashActivity;

/**
 * @author jiangqideng@163.com
 * @date 2016-6-29 ����12:50:32
 * @description ��ȡ�ļ�
 */
public class FileManager {
	public String[] readFileStrings(String fileName) {
		try {
			InputStream in;
			in = SplashActivity.splashActivity.getResources().getAssets()
					.open(fileName);
			int length = in.available();
			byte[] buffer = new byte[length];
			in.read(buffer);
			in.close();
			String txtString = new String(buffer);
			String[] strarray = txtString.split(" ");
			return strarray;
		} catch (IOException e) {
			Toast.makeText(MainActivity.mainactivity, "�ļ���ȡʧ��",
					Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
		return null;
	}
}
