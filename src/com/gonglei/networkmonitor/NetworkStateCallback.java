package com.gonglei.networkmonitor;

/**
 * 
 * ��������¼�
 * @author gonglei
 * 
 */
public interface NetworkStateCallback {

	/**
	 * ����������
	 * 
	 * @param type
	 */
	void onConnected(Constants.ConnectedState type);

	/**
	 * ����δ����
	 */
	void onDisconnected();

}
