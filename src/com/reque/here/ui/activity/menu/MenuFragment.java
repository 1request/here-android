/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-7-25
 */
package com.reque.here.ui.activity.menu;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.reque.here.R;
import com.reque.here.ui.adapter.MenuAdapter;
import com.reque.here.ui.adapter.model.MenuItem;

/**
 *
 */
public class MenuFragment extends Fragment implements IMainSlidingMenu, OnItemClickListener {
	private static final String TAG = "MenuFragment";
	private MenuAdapter mMenuAdapter;
	private OnMenuItemClickListener mListener;
	private List<MenuItem> mItems;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return setupView(inflater);
	}

	private View setupView(LayoutInflater inflater) {
		View view = inflater.inflate(R.layout.fragment_menu, null);
		ListView list = (ListView) view.findViewById(R.id.menu_list);
		list.setOnItemClickListener(this);
		mMenuAdapter = new MenuAdapter(getActivity());
		list.setAdapter(mMenuAdapter);
		if (mItems != null) {
			setMenuItems(mItems);
		}
		return view;
	}

	private List<MenuItem> createTestData() {
		List<MenuItem> items = new ArrayList<MenuItem>(5);
		for (int i = 0; i < 5; i++) {
			MenuItem item = new MenuItem();
			item.title = "item" + i;
			items.add(item);
		}
		return items;
	}

	@Override
	public void setMenuItems(List<MenuItem> menuItems) {
		mItems = menuItems;
		if (mMenuAdapter != null) {
			mMenuAdapter.setMenuItems(menuItems);
			updateMenuItems();
		}
	}

	@Override
	public void setOnMenuItemClickListener(OnMenuItemClickListener l) {
		mListener = l;
	}

	@Override
	public void updateMenuItems() {
		mMenuAdapter.notifyDataSetChanged();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		if (mListener != null) {
			mListener.onMenuItemClick(mMenuAdapter.getItem(position));
		}
	}
}
