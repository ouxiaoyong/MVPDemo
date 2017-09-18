package com.cug.mvpdemo.net;

import com.cug.mvpdemo.login.LoginContract;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/9.
 */

public class HttpTools {

	public static void httpGet(Map<String,String> params){

	}

	public static void httpPost(Map<String,String> params, final LoginContract.HttpCallback callback){
		new Thread(new Runnable() {
			@Override
			public void run() {
				if(callback != null){
					callback.onHttpStart();
				}

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if(callback != null){
					callback.onHttpSuccess("请求成功");
				}

			}
		}).start();
	}
}
