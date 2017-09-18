package com.cug.mvpdemo.login;

import android.text.TextUtils;

/**
 * Created by Administrator on 2017/3/10.
 */

public class LoginPresenter implements LoginContract.IPresenter {
	private LoginContract.IView viewLogin;
	private ILoginModel modelLogin;
	public LoginPresenter(LoginContract.IView iViewLogin){
		this.viewLogin = iViewLogin;
		viewLogin.setPresenter(this);
		modelLogin = new LoginModel();
	}

	private boolean checkInput(){
		if(TextUtils.isEmpty(viewLogin.getUserName())){
			viewLogin.showToast("userName can not be empty!");
			return false;
		}
		if(TextUtils.isEmpty(viewLogin.getPassword())){
			viewLogin.showToast("password can not be empty!");
			return false;
		}
		return true;
	}

	@Override
	public void login() {
		if(!checkInput()){
			return;
		}
		modelLogin.login(viewLogin.getUserName(), viewLogin.getPassword(), new LoginContract.HttpCallback() {
			@Override
			public void onHttpStart() {
				viewLogin.showToast("start...");
			}

			@Override
			public void onHttpSuccess(String msg) {
				viewLogin.showToast(msg);
			}

			@Override
			public void onHttpFail() {
				viewLogin.showToast("fail...");
			}
		});
	}
}
