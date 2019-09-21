package com.work.samples.task;

import com.work.engine.tasks.Task;

public class Task2 extends Task {
	
	@Override
	public void preExecute() {
		// TODO Auto-generated method stub
		System.out.println("This is inside the Task2");
		System.out.println("PreExecute");
	}

	@Override
	public void excute() {
		// TODO Auto-generated method stub
		System.out.println("Execute");
	}

	@Override
	public void PostExecute() {
		// TODO Auto-generated method stub
		System.out.println("PostExecute");
	}

	@Override
	public void cleanUp() {
		// TODO Auto-generated method stub
		System.out.println("CleanUp");
	}
	
	


}
