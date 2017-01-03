package com.taskviewer.task;

import java.util.Comparator;

import static com.taskviewer.task.TaskSortCriterion.*;

/*
	Can sort by time, color group, priority, name
	Default sort by time -> priority ->  name -> color group
*/
//
public class TaskComparator implements Comparator<Task> {
	TaskSortCriterion[] sortOrder;

	public TaskComparator(TaskSortCriterion criterion) {
		switch (criterion) {
			case DEFAULT:
			case TIME:
				sortOrder = new TaskSortCriterion[] {TIME, PRIORITY, NAME, COLOR};
				break;
			case PRIORITY:
				sortOrder = new TaskSortCriterion[] {PRIORITY, TIME, NAME, COLOR};
				break;
			case NAME:
				sortOrder = new TaskSortCriterion[] {NAME, TIME, PRIORITY, COLOR};
				break;
			case COLOR:
				sortOrder = new TaskSortCriterion[] {COLOR, NAME, TIME, PRIORITY};
				break;
		}
	}

	private int compareInts(int a, int b) {
		return Integer.valueOf(a).compareTo(b);
	}

	public int compare(Task t0, Task t1) {
		for (TaskSortCriterion criterion : sortOrder) {
			switch (criterion) {
				case TIME:
					if (t0.time != t1.time) {
						return compareInts(t0.time, t1.time);
					}
					break;
				case PRIORITY:
					if (t0.priority != t1.priority) {
						return compareInts(t0.priority, t1.priority);
					}
					break;
				case NAME:
					if (t0.title.equals(t1.title)) {
						return t0.title.compareTo(t1.title);
					}
					break;
				case COLOR:
					if (t0.color != t1.color) {
						return compareInts(t0.color, t1.color);
					}
					break;
			}
		}

		return 0;
	}
}
