package com.jqd.wifilocalizationdemo.util;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.net.wifi.ScanResult;

import com.jqd.wifilocalizationdemo.model.WiFiDataManager;
import com.jqd.wifilocalizationdemo.ui.MainActivity;

/**
 * @author jiangqideng@163.com
 * @date 2016-6-29 ����12:54:09
 * @description �������õĺ���
 */
public class TransformUtil {
	public float[] scanResults2vector(List<ScanResult> scanResults,
			HashMap<String, Integer> bssids) {
		// ����rssScan����
		float rssScan[] = new float[229];
		int bsscount = 0;
		if (scanResults != null) {
			// ��ʼ��
			for (int i = 0; i < rssScan.length; i++) {
				rssScan[i] = -200;
			}
			for (int j = 0; j < scanResults.size(); j++) {
				String bssid = scanResults.get(j).BSSID;
				if (bssids.containsKey(bssid)) {
					int idx = bssids.get(bssid);
					rssScan[idx] = scanResults.get(j).level;
					bsscount++;
				}
			}
		}
		if (bsscount < MainActivity.mainactivity.Wifi_Num_Min) {
			WiFiDataManager.getInstance().isNormal = false;
		} else {
			WiFiDataManager.getInstance().isNormal = true;
		}
		return rssScan;
	}

	/**
	 * �����ֻ��ķֱ��ʴ� dp �ĵ�λ ת��Ϊ px(����)
	 */
	public static float dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (dpValue * scale + 0.5f);
	}
}
