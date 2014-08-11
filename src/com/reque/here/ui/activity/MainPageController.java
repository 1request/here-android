/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-8-8
 */
package com.reque.here.ui.activity;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;

import com.reque.here.R;
import com.reque.here.ui.activity.friends.FriendsFragment;
import com.reque.here.ui.activity.hotspots.HotspotsFragment;
import com.reque.here.ui.activity.menu.IMainSlidingMenu;
import com.reque.here.ui.activity.menu.IMainSlidingMenu.OnMenuItemClickListener;
import com.reque.here.ui.activity.message.MessageFragment;
import com.reque.here.ui.activity.other.SettingFragment;
import com.reque.here.ui.adapter.model.MenuItem;
import com.reque.utils.Log;

/**
 * 主界面中的页面切换控制器
 */
public class MainPageController implements OnMenuItemClickListener {
	private static final String TAG = "MainPageController";
	private static final int MENU_ID_FRIENDS = 0x01;
	private static final int MENU_ID_MESSAGE = 0x02;
	private static final int MENU_ID_HOTSPOTS = 0x03;
	private static final int MENU_ID_SETTING = 0x04;

	private FragmentActivity mActivity;
	private IMainSlidingMenu mSlidingMenu;
	private int mContentFrameId = -1;
	private SparseArray<BaseFragment> mFragments;
	private BaseFragment mCurrFragment;

	/**
	 * 
	 */
	public MainPageController(FragmentActivity activity) {
		mActivity = activity;
		mFragments = new SparseArray<BaseFragment>(5);
	}

	public void init(IMainSlidingMenu slidingMenu, int resId) {
		mSlidingMenu = slidingMenu;
		mContentFrameId = resId;
		initMenuItems();
	}

	private void initMenuItems() {
		if (mSlidingMenu == null) {
			return;
		}
		mSlidingMenu.setOnMenuItemClickListener(this);

		List<MenuItem> items = new ArrayList<MenuItem>(4);
		MenuItem friends = new MenuItem();
		friends.title = mActivity.getString(R.string.my_friends);
		friends.iconRes = R.drawable.ic_sliding_friends;
		friends.id = MENU_ID_FRIENDS;
		items.add(friends);

		MenuItem msg = new MenuItem();
		msg.title = mActivity.getString(R.string.my_messages);
		msg.iconRes = R.drawable.ic_sliding_msg;
		msg.id = MENU_ID_MESSAGE;
		items.add(msg);

		MenuItem device = new MenuItem();
		device.title = mActivity.getString(R.string.hotspots);
		device.iconRes = R.drawable.ic_sliding_local;
		device.id = MENU_ID_HOTSPOTS;
		items.add(device);

		MenuItem set = new MenuItem();
		set.title = mActivity.getString(R.string.settings);
		set.iconRes = R.drawable.ic_sliding_setting;
		set.id = MENU_ID_SETTING;
		items.add(set);

		mSlidingMenu.setMenuItems(items);
		mSlidingMenu.setOnMenuItemClickListener(this);
		showContentFragment(items.get(1).id);
	}

	private void showContentFragment(int id) {
		Log.e(TAG, "showContentFragment id: " + id + " mContentFrameId: " + mContentFrameId);
		if (mContentFrameId < 0) {
			return;
		}

		BaseFragment contentFragment = mFragments.get(id);
		if (contentFragment == null) {
			contentFragment = createContentFragment(id);
			if (contentFragment != null) {
				mFragments.put(id, contentFragment);
			} else {
				return;
			}
		}

		if (contentFragment.equals(mCurrFragment)) {
			Log.d(TAG, "the same fragment");
			return;
		}

		FragmentTransaction ft = mActivity.getSupportFragmentManager().beginTransaction();

		if (mCurrFragment != null) {
			ft.remove(mCurrFragment);
		}
		ft.add(mContentFrameId, contentFragment).commit();
		mCurrFragment = contentFragment;
	}

	private BaseFragment createContentFragment(int id) {
		switch (id) {
		case MENU_ID_FRIENDS:
			return new FriendsFragment();
		case MENU_ID_HOTSPOTS:
			return new HotspotsFragment();
		case MENU_ID_MESSAGE:
			return new MessageFragment();
		case MENU_ID_SETTING:
			return new SettingFragment();
		}
		return null;
	}

	@Override
	public void onMenuItemClick(MenuItem item) {
		showContentFragment(item.id);
	}
}
