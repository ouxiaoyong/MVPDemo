package com.cug.mvpdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SoundEffectConstants;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/3/14.
 */

public class MyView extends TextView implements Checkable{
	private int[] checkState = {android.R.attr.state_checked};
	private boolean checked = false;
	public MyView(Context context) {
		super(context);
	}

	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected int[] onCreateDrawableState(int extraSpace) {
		int[] states = super.onCreateDrawableState(extraSpace + 1);
		if(isChecked()){
			mergeDrawableStates(states,checkState);
		}
		Log.d("ouxiaoyong","onCreateDrawableState extraSpace:"+extraSpace);
		for (int i = 0; i < states.length; i ++){
			Log.d("ouxiaoyong","states["+i+"]:"+states[i]);
		}
		return states;
	}

	@Override
	public void setChecked(boolean checked) {
		if(this.checked != checked){
			this.checked = checked;
			refreshDrawableState();
		}
	}

	@Override
	public boolean isChecked() {
		return checked;
	}

	@Override
	public void toggle() {
		setChecked(!checked);
	}

	@Override
	public boolean performClick() {
		Log.d("ouxiaoyong","performClick");
		toggle();

		final boolean handled = super.performClick();
		if (!handled) {
			// View only makes a sound effect if the onClickListener was
			// called, so we'll need to make one here instead.
			playSoundEffect(SoundEffectConstants.CLICK);
		}

		return handled;
	}
}
