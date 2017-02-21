package com.github.alejopj.oesia.entities;

public class Event {

	private EventType type;
	private String params;
	private long time;
	
	public Event(String event, long time) {
		
		String type = event.trim().split(" ")[0];
		this.type = EventType.fromString(type);
		this.params = type.length() < event.trim().length() ?
				event.substring(type.length()).trim() : "";
		this.time = time;
	}
	
	public Event(EventType type, String params, long time) {
		this.type = type;
		this.params = params;
		this.time = time;
	}
	
	public EventType getType() {
		return type;
	}
	
	public void setType(EventType type) {
		this.type = type;
	}
	
	public String getParams() {
		return params;
	}
	
	public void setParams(String params) {
		this.params = params;
	}
	
	public long getTime() {
		return time;
	}
	
	public void setTime(long time) {
		this.time = time;
	}
}
