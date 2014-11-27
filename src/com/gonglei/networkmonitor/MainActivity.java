package com.gonglei.networkmonitor;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

	private Button button;
	private WifiManager wifiManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		button = (Button) findViewById(R.id.btn);
		//获得WifiManager对象
		wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		if (wifiManager.isWifiEnabled()) {
			button.setText("close wifi");
		}else{
			button.setText("open wifi");
		}
	}

	public void onDoWifi(View view) {
		if (wifiManager.isWifiEnabled()) {
			wifiManager.setWifiEnabled(false);
			button.setText("open wifi");
		}else{
			wifiManager.setWifiEnabled(true);
			button.setText("close wifi");
		}
	}
}
