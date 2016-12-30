package com.taskviewer.task;

import android.content.ContentValues;
import com.taskviewer.database.TaskStrings;

// TODO: Change types to actual time, color, etc.
public class Task {
	public Task(String _title, int _time, String _desc, int _priority, int _color) {
		title = _title;
		time = _time;
		desc = _desc;
		priority = _priority;
		color = _color;
	}

	private String title;
	private int time;
	private String desc;
	private int priority;
	private int color;

	public ContentValues getTaskContentValues() {
		ContentValues values = new ContentValues();
		values.put(TaskStrings.COL_NAME_TITLE, title);
		values.put(TaskStrings.COL_NAME_TIME, time);
		values.put(TaskStrings.COL_NAME_DESC, desc);
		values.put(TaskStrings.COL_NAME_PRIORITY, priority);
		values.put(TaskStrings.COL_NAME_COLOR, color);
		return values;
	}

	@Override
	public String toString() {
		return title;
	}
}