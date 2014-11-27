package com.gonglei.networkmonitor;

import java.util.ArrayList;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.gonglei.networkmonitor.Constants.ConnectedState;

/**
 * ��������㲥����Ҫ��Manifest������
 * @author gonglei
 *
 */
public class NetworkStateBroadcastReceiver extends BroadcastReceiver {

	private static final String TAG = "NetworkStateBroadcastReceiver";
	//����״̬�������ϣ�ʹ��ǰ��Ҫ��ӵ��ü�����
	public static ArrayList<NetworkStateCallback> mListener = new ArrayList<NetworkStateCallback>();

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		NetworkInfo info = intent
				.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);

		if (mListener.size() > 0) {
			for (NetworkStateCallback listener : mListener) {
				if (info.isConnected()) {
					if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
						Log.i(TAG, "mobile connected!");
						listener.onConnected(ConnectedState.TYPE_MOBLE);
					} else if (info.getType() == ConnectivityManager.TYPE_WIFI) {
						Log.i(TAG, "wifi conntected!");
						listener.onConnected(ConnectedState.TYPE_WIFI);
					}
				} else {
					Log.i(TAG, "disconnect!");
					listener.onDisconnected();
				}

			}
		}

	}

}
