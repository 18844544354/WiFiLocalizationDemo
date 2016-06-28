package com.jqd.wifilocalizationdemo.model;

import java.util.HashMap;

import com.jqd.wifilocalizationdemo.file.FileManager;

/**
 * @author jiangqideng@163.com
 * @date 2016-6-29 ����12:50:59
 * @description ����Radio Map������bssid�����ȡ�����
 */
public class RadioMapModel {
	public float radioMap1[][];// �洢ָ�ƿ�
	public float radioMap2[][];
	public HashMap<String, Integer> bssids; // ��¼Bssid��˳����������
	public int N_fp = 0;// ָ�ƿ��ָ�Ƴ���
	public int M_fp = 0;// ָ�ƿ��ָ�Ƹ���

	private volatile static RadioMapModel radioMapModel = null;

	public static RadioMapModel getInstance() {
		if (radioMapModel == null) {
			synchronized (RadioMapModel.class) {
				if (radioMapModel == null) {
					radioMapModel = new RadioMapModel();
				}
			}
		}
		return radioMapModel;
	}

	public void init() {
		radioMap1 = getRadioMap("map1.txt");// ��һ��Radio map
		radioMap2 = getRadioMap("map2.txt");// �ڶ���Radio map
		bssids = getBssids("bssid.txt");// ��Ӧ��bssid
	}

	/**
	 * ��assets����ļ��ж�ȡ���ݣ�string���飬��һ��string����ÿ��ָ�Ƶĳ��ȣ��ڶ���string�����ж���������
	 * ������ת����float�ͣ��ŵ�һ����ά���� (ע�⣺����string���ɿո�ֿ�����Ҫ�лس�)
	 */
	private float[][] getRadioMap(String fileName) {
		float radioMap[][] = null;
		String[] strarray = new FileManager().readFileStrings(fileName);
		// ת����float
		N_fp = Integer.parseInt(strarray[0]);
		M_fp = Integer.parseInt(strarray[1]);
		radioMap = new float[M_fp][N_fp];
		int k = 2;
		for (int i = 0; i < M_fp; i++) {
			for (int j = 0; j < N_fp; j++) {
				try {
					radioMap[i][j] = Float.parseFloat(strarray[k]);
					k++;
				} catch (Exception e) {
				}
			}
		}
		return radioMap;
	}

	private HashMap<String, Integer> getBssids(String fileName) {
		HashMap<String, Integer> bssids = new HashMap<String, Integer>();
		String[] strarray = new FileManager().readFileStrings(fileName);
		for (int i = 0; i < strarray.length; i++) {
			bssids.put(strarray[i], i);
		}
		return bssids;
	}
}
