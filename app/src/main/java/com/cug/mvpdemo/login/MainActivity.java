package com.cug.mvpdemo.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cug.mvpdemo.R;

public class MainActivity extends AppCompatActivity implements LoginContract.IView {
	private LoginContract.IPresenter presenterLogin;
	private EditText user;
	private EditText pwd;
	private Button btnLogin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		user = (EditText) findViewById(R.id.userName);
		pwd = (EditText) findViewById(R.id.password);
		btnLogin = (Button) findViewById(R.id.btnLogin);
		btnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				presenterLogin.login();
			}
		});
		new LoginPresenter(this);
	}

	@Override
	public CharSequence getUserName() {
		return user.getText().toString();
	}

	@Override
	public CharSequence getPassword() {
		return pwd.getText().toString();
	}

	@Override
	public void showToast(final CharSequence text) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT).show();
			}
		});
	}


	@Override
	public void startActivityInner(Intent intent) {
		startActivity(intent);
	}

	@Override
	public void setPresenter(LoginContract.IPresenter iPresenter) {
		presenterLogin = iPresenter;
	}
}
