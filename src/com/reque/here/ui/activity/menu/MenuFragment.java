/*
 * @project :MaiTii
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
import android.widget.ListView;

import com.reque.here.R;
import com.reque.here.ui.adapter.MenuAdapter;
import com.reque.here.ui.adapter.model.MenuItem;

/**
 *
 */
public class MenuFragment extends Fragment {
	private static final String TAG = "MenuFragment";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		ListView view = (ListView) inflater.inflate(R.layout.menu_list_layout, null);
		MenuAdapter adapter = new MenuAdapter(getActivity());
		view.setAdapter(adapter);
		adapter.setMenuItems(createTestData());
		adapter.notifyDataSetChanged();
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
}
