/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-7-31
 */
package com.reque.here.ui.activity.menu;

import java.util.List;

import com.reque.here.ui.adapter.model.MenuItem;

/**
 *
 */
public interface IMainSlidingMenu {
	void setMenuItems(List<MenuItem> menuItems);

	void setOnMenuItemClickListener(OnMenuItemClickListener l);

	void updateMenuItems();

	public interface OnMenuItemClickListener {
		void onMenuItemClick(MenuItem item);
	}
}
