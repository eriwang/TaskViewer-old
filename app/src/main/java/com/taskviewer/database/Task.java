package com.taskviewer.database;

import android.content.ContentValues;

public class Task {
	private String title;
	private int time;
	private String desc;
	private int priority;
	private int color;

	public ContentValues getTaskContentValues() {
		ContentValues values = new ContentValues();
		values.put(TaskTableHelper.TaskStrings.COL_NAME_TITLE, title);
		values.put(TaskTableHelper.TaskStrings.COL_NAME_TIME, time);
		values.put(TaskTableHelper.TaskStrings.COL_NAME_TITLE, title);
		values.put(TaskTableHelper.TaskStrings.COL_NAME_TITLE, title);
		values.put(TaskTableHelper.TaskStrings.COL_NAME_TITLE, title);
		return values;
	}
}