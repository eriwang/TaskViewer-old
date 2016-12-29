package com.taskviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.taskviewer.database.TaskTableHelper;

public class TaskViewActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task_view);
	}

	public void onButtonClick(View view) {
		TaskTableHelper t = new TaskTableHelper(this);
	}
}
