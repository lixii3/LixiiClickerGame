package com.gioco.poket_click;

public abstract class ClickEvent {
	private final String name;
	
	public ClickEvent(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void start();
	
	public abstract void stop();
	
	public void repeat(int times)
	{
		while (times > 0)
		{
			start();
			times--;
		}
	}
}
