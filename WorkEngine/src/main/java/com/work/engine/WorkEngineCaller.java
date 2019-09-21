package com.work.engine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import com.work.engine.service.ExecutorPool;
import com.work.engine.states.RequestState;
import com.work.engine.status.RequestStatus;
import com.work.engine.status.TaskStatus;
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
	
	public String execute()
	{
		String requestId=Math.random()+"";
		List<TaskStatus>taskStatus=new ArrayList<TaskStatus>();
		RequestStatus rs=new RequestStatus(requestId, RequestState.READY, taskStatus);
		WorkEngineSequentialRunner wers=new WorkEngineSequentialRunner(tasks,rs);
		ExecutorPool.EXECUTOR.getExecutor().execute(wers);
		System.out.println("RequestStatus ***************"+wers.getRequestStatus());
		return requestId;
	}

}
