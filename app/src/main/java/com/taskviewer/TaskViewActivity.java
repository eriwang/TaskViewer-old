package com.taskviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.taskviewer.database.TaskTableHelper;
import com.taskviewer.task.Task;

import java.util.ArrayList;

public class TaskViewActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task_view);
	}

	public void onCreateDataClick(View view) {
		TaskTableHelper taskTable = new TaskTableHelper(this);
		taskTable.insertNewTask(new Task("test", 0, null, 0, 0));
		System.out.println("Clicked create data button");
	}

	public void onShowDataClick(View view) {
		TaskTableHelper taskTable = new TaskTableHelper(this);
		ArrayList<Task> taskList = taskTable.getAllTasks();

		for (Task task : taskList) {
			System.out.println("Got task: " + task);
		}
	}
}
