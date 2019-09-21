package com.work.Sample;

import com.work.engine.WorkEngineCaller;
import com.work.samples.task.Task1;
import com.work.samples.task.Task2;

public class SampleRun {
	
	public static void main(String args[])
	{
		WorkEngineCaller wsc=new WorkEngineCaller();
		Task1 task1=new Task1();
		Task2 task2=new Task2();
		wsc.addTask(task1);
		wsc.addTask(task2);
		wsc.execute();
	}

}
