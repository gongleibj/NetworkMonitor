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
 * 网络监听广播，需要在Manifest中配置
 * @author gonglei
 *
 */
public class NetworkStateBroadcastReceiver extends BroadcastReceiver {

	private static final String TAG = "NetworkStateBroadcastReceiver";
	//网络状态监听集合，使用前需要添加到该集合中
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
