package com.cug.mvpdemo.login;

import com.cug.mvpdemo.net.HttpTools;

/**
 * Created by Administrator on 2017/3/9.
 */

public class LoginModel implements ILoginModel {
	@Override
	public void login(CharSequence user, CharSequence passw,LoginContract.HttpCallback callback) {
		HttpTools.httpPost(null, callback);
	}
}
