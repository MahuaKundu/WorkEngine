package com.work.engine.tasks;

public abstract class Task {
	
	public abstract void preExecute();
	public abstract void excute();
	public abstract void PostExecute();
	public abstract void cleanUp();
	

}
