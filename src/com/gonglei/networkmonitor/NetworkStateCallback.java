package com.gonglei.networkmonitor;

/**
 * 
 * 网络监听事件
 * @author gonglei
 * 
 */
public interface NetworkStateCallback {

	/**
	 * 网络已连接
	 * 
	 * @param type
	 */
	void onConnected(Constants.ConnectedState type);

	/**
	 * 网络未连接
	 */
	void onDisconnected();

}
