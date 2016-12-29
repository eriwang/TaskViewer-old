package com.taskviewer.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

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
	public void onOpen(SQLiteDatabase db) {
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

	public void insertNewTask(Task task) {
		SQLiteDatabase db = getWritableDatabase();
		db.insert(TaskStrings.TABLE_NAME, null, task.getTaskContentValues());
	}

	public static class TaskStrings implements BaseColumns {
		static final String TABLE_NAME = "tasks";
		static final String COL_NAME_TITLE = "title";
		static final String COL_NAME_TIME = "time";
		static final String COL_NAME_DESC = "description";
		static final String COL_NAME_PRIORITY = "priority";
		static final String COL_NAME_COLOR = "color";
	}
}
