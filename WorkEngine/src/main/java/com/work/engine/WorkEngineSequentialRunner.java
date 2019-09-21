package com.work.engine;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.work.engine.states.RequestState;
import com.work.engine.states.TaskState;
import com.work.engine.status.RequestStatus;
import com.work.engine.status.TaskStatus;
import com.work.engine.tasks.Task;

public class WorkEngineSequentialRunner implements Runnable {
	
	private Queue<Task> tasks;
	private RequestStatus requestStatus;
	
	public WorkEngineSequentialRunner(Queue<Task> tasks, RequestStatus requestStatus) {
		// TODO Auto-generated constructor stub
		this.tasks=tasks;
		this.requestStatus= requestStatus;
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
		TaskStatus currentTaskStatus=null;
		requestStatus.setRequestState(RequestState.RUNNING);
		while(!tasks.isEmpty()){
			try {
			currentTask=tasks.poll();
			currentTaskStatus=new TaskStatus(currentTask.getClass().getSimpleName(), TaskState.RUNNING);
			requestStatus.getTasks().add(currentTaskStatus);
			currentTask.preExecute();
			
			currentTask.excute();
			currentTask.PostExecute();
			currentTaskStatus.setTaskState(TaskState.COMPLETED);
			}
			catch(Exception ex)
			{
				currentTaskStatus.setTaskState(TaskState.FAILED);
				currentTask.cleanUp();
				requestStatus.setRequestState(RequestState.FAILED);
				break;
			}
		}
		if(requestStatus.getRequestState()==RequestState.RUNNING) {
			requestStatus.setRequestState(RequestState.COMPLETED);
		}
	}
	
	public RequestStatus getRequestStatus()
	{
		return requestStatus;
	}

	
}

