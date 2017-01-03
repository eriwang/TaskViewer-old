package com.taskviewer.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.taskviewer.task.Task;
import com.taskviewer.task.TaskComparator;
import com.taskviewer.task.TaskSortCriterion;

import java.util.ArrayList;
import java.util.Collections;

public class TaskTableHelper extends SQLiteOpenHelper {
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "TaskTable.db";

	private static final String SQL_CREATE_ENTRIES =
			"CREATE TABLE " + TaskStrings.TABLE_NAME + " (" +
				TaskStrings._ID + " INTEGER PRIMARY KEY, " +
				TaskStrings.COL_NAME_TITLE + " TEXT, " +
				TaskStrings.COL_NAME_TIME + " INT, " +
				TaskStrings.COL_NAME_DESC + " TEXT, " +
				TaskStrings.COL_NAME_PRIORITY + " INT, " +
				TaskStrings.COL_NAME_COLOR + " INT)";

	private static final String SQL_DELETE_ENTRIES =
			"DROP TABLE IF EXISTS " + TaskStrings.TABLE_NAME;

	public TaskTableHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_ENTRIES);
	}

	@Override
	public void onOpen(SQLiteDatabase db) {}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

	public void insertNewTask(Task task) {
		SQLiteDatabase db = getWritableDatabase();
		db.insert(TaskStrings.TABLE_NAME, null, task.getTaskContentValues());
	}

	// TODO: only get some tasks at a time (i.e. WHERE clause)
	/*
		Can sort by time, color group, priority, name
		Default sort by time -> priority ->  name -> color group
	*/
	public ArrayList<Task> getAllTasks() {
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.query(TaskStrings.TABLE_NAME, null, null, null, null, null, null);

		ArrayList<Task> taskList = new ArrayList<>();
		while (cursor.moveToNext()) {
			taskList.add(getNextTaskFromCursor(cursor));
		}
		cursor.close();

		Collections.sort(taskList, new TaskComparator(TaskSortCriterion.DEFAULT));

		return taskList;
	}

	private Task getNextTaskFromCursor(Cursor cursor) {
		String title = cursor.getString(
				cursor.getColumnIndexOrThrow(TaskStrings.COL_NAME_TITLE));
		int time = cursor.getInt(
				cursor.getColumnIndexOrThrow(TaskStrings.COL_NAME_TIME));
		String desc = cursor.getString(
				cursor.getColumnIndexOrThrow(TaskStrings.COL_NAME_DESC));
		int priority = cursor.getInt(
				cursor.getColumnIndexOrThrow(TaskStrings.COL_NAME_PRIORITY));
		int color = cursor.getInt(
				cursor.getColumnIndexOrThrow(TaskStrings.COL_NAME_COLOR));
		return new Task(title, time, desc, priority, color);
	}
}
