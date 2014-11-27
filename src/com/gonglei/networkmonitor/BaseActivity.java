package com.gonglei.networkmonitor;

import com.gonglei.networkmonitor.Constants.ConnectedState;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Activity基类，某Activity若要监听网络则要继承该基类。
 * @author gonglei
 *
 */
public class BaseActivity extends Activity implements NetworkStateCallback{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		NetworkStateBroadcastReceiver.mListener.add(this);//添加监听事件
	}

	@Override
	public void onConnected(ConnectedState type) {
		// TODO Auto-generated method stub
		if(type == ConnectedState.TYPE_MOBLE){
			Toast.makeText(this, "Connected mobile", Toast.LENGTH_SHORT).show();
		}else if(type == ConnectedState.TYPE_WIFI){
			Toast.makeText(this, "Connected wifi", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Network is Disconnected", Toast.LENGTH_SHORT).show();
	}

}
