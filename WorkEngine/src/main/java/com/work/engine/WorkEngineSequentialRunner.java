package com.work.engine;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.work.engine.tasks.Task;

public class WorkEngineSequentialRunner implements Runnable {
	
	private Queue<Task> tasks;
	public WorkEngineSequentialRunner(Queue<Task> tasks) {
		// TODO Auto-generated constructor stub
		this.tasks=tasks;
	}
	public void run() {
		// TODO Auto-generated method stub
		execute();
	}
	
	public void execute()
	{
		//ExecutorService executor = Executors.newFixedThreadPool(10);
		//executor.execute(tasks);
		Task currentTask=null;
		while(!tasks.isEmpty()){
			try {
			currentTask=tasks.poll();
			currentTask.preExecute();
			currentTask.excute();
			currentTask.PostExecute();
			}
			catch(Exception ex)
			{
				currentTask.cleanUp();
			}
		}
	}

	
}

