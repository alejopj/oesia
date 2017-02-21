package com.github.alejopj.oesia.entities;

public enum EventType {

	ALARM, OFF, ON, UNDEFINED;
	
	public static EventType fromString(String type) {
		try {
			return EventType.valueOf(type);
		} catch (Exception e) {
			return UNDEFINED;
		}
	}
}
