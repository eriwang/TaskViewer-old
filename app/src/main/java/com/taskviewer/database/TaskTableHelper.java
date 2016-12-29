package com.taskviewer.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class TaskTableHelper extends SQLiteOpenHelper {
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "TaskTable.db";

	private static final String SQL_CREATE_ENTRIES =
			"CREATE TABLE " + TaskEntry.TABLE_NAME + " (" +
				TaskEntry._ID + " INTEGER PRIMARY KEY, " +
				TaskEntry.COL_NAME_TITLE + " TEXT, " +
				TaskEntry.COL_NAME_TIME + " TEXT, " +
				TaskEntry.COL_NAME_DESC + " TEXT, " +
				TaskEntry.COL_NAME_PRIORITY + " INT, " +
				TaskEntry.COL_NAME_COLOR + " INT)";

	private static final String SQL_DELETE_ENTRIES =
			"DROP TABLE IF EXISTS " + TaskEntry.TABLE_NAME;

	private TaskTableHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_ENTRIES);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

	public static class TaskEntry implements BaseColumns {
		public static final String TABLE_NAME = "tasks";
		public static final String COL_NAME_TITLE = "title";
		public static final String COL_NAME_TIME = "time";
		public static final String COL_NAME_DESC = "description";
		public static final String COL_NAME_PRIORITY = "priority";
		public static final String COL_NAME_COLOR = "color";
	}
}
