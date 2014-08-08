/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-7-21
 */
package com.reque.here.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

import com.reque.here.R;
import com.reque.here.ui.activity.menu.IMainSlidingMenu;
import com.reque.here.ui.activity.menu.IMainSlidingMenu.OnMenuItemClickListener;
import com.reque.here.ui.activity.menu.MenuFragment;
import com.reque.here.ui.adapter.model.MenuItem;
import com.reque.widget.slidingmenu.SlidingActivityBase;
import com.reque.widget.slidingmenu.SlidingActivityHelper;
import com.reque.widget.slidingmenu.SlidingMenu;

/**
 * 主界面
 */
public class MainActivity extends ActionBarActivity implements SlidingActivityBase {
	private static final String TAG = "MainActivity";

	private SlidingActivityHelper mHelper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mHelper = new SlidingActivityHelper(this);
		mHelper.onCreate(savedInstanceState);

		setBehindContentView(R.layout.menu_layout);
		setContentView(R.layout.content_layout);

		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

		MenuFragment menuFragment = new MenuFragment();
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.add(R.id.menu_frame, menuFragment).commit();

		MainPageController pageController = new MainPageController(this);
		pageController.init(menuFragment, R.id.content_frame);

		initActionBar();
	}

	private void initActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_titlebar));
		actionBar.setIcon(R.drawable.ic_title_here);
		actionBar.setTitle(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onPostCreate(android.os.Bundle)
	 */
	@Override
	public void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mHelper.onPostCreate(savedInstanceState);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#findViewById(int)
	 */
	@Override
	public View findViewById(int id) {
		View v = super.findViewById(id);
		if (v != null)
			return v;
		return mHelper.findViewById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onSaveInstanceState(android.os.Bundle)
	 */
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		mHelper.onSaveInstanceState(outState);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#setContentView(int)
	 */
	@Override
	public void setContentView(int id) {
		setContentView(getLayoutInflater().inflate(id, null));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#setContentView(android.view.View)
	 */
	@Override
	public void setContentView(View v) {
		setContentView(v, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#setContentView(android.view.View,
	 * android.view.ViewGroup.LayoutParams)
	 */
	@Override
	public void setContentView(View v, LayoutParams params) {
		super.setContentView(v, params);
		mHelper.registerAboveContentView(v, params);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivityBase#
	 * setBehindContentView(int)
	 */
	public void setBehindContentView(int id) {
		setBehindContentView(getLayoutInflater().inflate(id, null));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivityBase#
	 * setBehindContentView(android.view.View)
	 */
	public void setBehindContentView(View v) {
		setBehindContentView(v, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivityBase#
	 * setBehindContentView(android.view.View,
	 * android.view.ViewGroup.LayoutParams)
	 */
	public void setBehindContentView(View v, LayoutParams params) {
		mHelper.setBehindContentView(v, params);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivityBase#getSlidingMenu
	 * ()
	 */
	public SlidingMenu getSlidingMenu() {
		return mHelper.getSlidingMenu();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivityBase#toggle()
	 */
	public void toggle() {
		mHelper.toggle();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivityBase#showAbove()
	 */
	public void showContent() {
		mHelper.showContent();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivityBase#showBehind()
	 */
	public void showMenu() {
		mHelper.showMenu();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivityBase#showSecondaryMenu
	 * ()
	 */
	public void showSecondaryMenu() {
		mHelper.showSecondaryMenu();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivityBase#
	 * setSlidingActionBarEnabled(boolean)
	 */
	public void setSlidingActionBarEnabled(boolean b) {
		mHelper.setSlidingActionBarEnabled(b);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onKeyUp(int, android.view.KeyEvent)
	 */
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		boolean b = mHelper.onKeyUp(keyCode, event);
		if (b)
			return b;
		return super.onKeyUp(keyCode, event);
	}

}
