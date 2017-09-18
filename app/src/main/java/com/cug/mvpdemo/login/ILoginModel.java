package com.cug.mvpdemo.login;

/**
 * Created by Administrator on 2017/3/9.
 */

public interface ILoginModel {
	void login(CharSequence user, CharSequence passw,LoginContract.HttpCallback callback);
}
