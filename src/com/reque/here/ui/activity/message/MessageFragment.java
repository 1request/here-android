/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-7-31
 */
package com.reque.here.ui.activity.message;

import java.io.File;
import java.io.IOException;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.reque.here.R;
import com.reque.here.core.business.message.MessageController;
import com.reque.here.core.settings.AppSetting;
import com.reque.here.ui.activity.BaseFragment;
import com.reque.utils.Log;

/**
 * 留言界面
 */
public class MessageFragment extends BaseFragment implements OnClickListener, OnLongClickListener, OnTouchListener {
	private static final String TAG = "MessageFragment";
	private MessageController mMsgController;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mMsgController = new MessageController();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return setupView(inflater);
	}

	private View setupView(LayoutInflater inflater) {
		View view = inflater.inflate(R.layout.fragment_message, null);
		Button leaveMsg = (Button) view.findViewById(R.id.leave_msg);
		leaveMsg.setOnClickListener(this);
		leaveMsg.setOnLongClickListener(this);
		leaveMsg.setOnTouchListener(this);
		
		View head = view.findViewById(R.id.head);
		View nickName = view.findViewById(R.id.nickname);
		
		head.setOnClickListener(this);
		nickName.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.leave_msg:
			mMsgController.playRecord();
			break;
		case R.id.head:
			mMsgController.uploadRecord();
			break;
		case R.id.nickname:
			mMsgController.testGetRecord();
			break;
		default:
			break;
		}
	}

	@Override
	public boolean onLongClick(View v) {
		switch (v.getId()) {
		case R.id.leave_msg:
			mMsgController.startRecord();
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (v.getId() == R.id.leave_msg
				&& (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL)) {
			mMsgController.finishRecord();
		}
		return false;
	}
}
