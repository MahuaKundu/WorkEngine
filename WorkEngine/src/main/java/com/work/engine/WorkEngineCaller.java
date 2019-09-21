package com.work.engine;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import com.work.engine.tasks.Task;

public class WorkEngineCaller {
	
	private Queue<Task> tasks;
	
	public WorkEngineCaller() {
		// TODO Auto-generated constructor stub
		
		tasks=new LinkedList<Task>();
	}
	
	public boolean addTask(Task task)
	{
		if(tasks.contains(task)){
			return false;
			
				}
		tasks.add(task);
		return true;
	}
	
	public void execute()
	{

     ExecutorService executor = Executors.newFixedThreadPool(10);
     WorkEngineSequentialRunner wers=new WorkEngineSequentialRunner(tasks);
     executor.execute(wers);
     executor.shutdown();
	}

}
