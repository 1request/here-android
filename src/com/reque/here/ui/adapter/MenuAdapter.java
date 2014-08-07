/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-7-25
 */
package com.reque.here.ui.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.reque.here.R;
import com.reque.here.ui.adapter.model.MenuItem;

/**
 *
 */
public class MenuAdapter extends BaseAdapter {
	private static final String TAG = "MenuAdapter";
	private Context mContext;
	private List<MenuItem> mMenuItems;

	/**
	 * 
	 */
	public MenuAdapter(Context context) {
		mContext = context;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		mMenuItems = menuItems;
	}

	@Override
	public int getCount() {
		return mMenuItems != null ? mMenuItems.size() : 0;
	}

	@Override
	public MenuItem getItem(int position) {
		return mMenuItems != null && position < mMenuItems.size() ? mMenuItems.get(position) : null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			convertView = View.inflate(mContext, R.layout.menu_list_item, null);
			viewHolder = new ViewHolder();
			viewHolder.title = (TextView) convertView.findViewById(R.id.menu_item_title);
			viewHolder.icon = (ImageView) convertView.findViewById(R.id.menu_item_icon);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		if (viewHolder == null) {
			return convertView;
		}

		MenuItem item = getItem(position);
		if (item != null) {
			viewHolder.title.setText(item.title);
			viewHolder.icon.setImageResource(item.iconRes);
		}
		return convertView;
	}

	class ViewHolder {
		TextView title;
		ImageView icon;
	}

}
