package com.cug.mvpdemo.login;

import android.content.Intent;

import com.cug.mvpdemo.base.IBaseView;

/**
 * Created by Administrator on 2017/3/10.
 */

public interface LoginContract {

	interface IView extends IBaseView<IPresenter> {
		CharSequence getUserName();
		CharSequence getPassword();
		void showToast(CharSequence text);
		void startActivityInner(Intent intent);
	}

	interface IPresenter{
		void login();
	}

	interface HttpCallback{
		void onHttpStart();
		void onHttpSuccess(String msg);
		void onHttpFail();
	}
}
