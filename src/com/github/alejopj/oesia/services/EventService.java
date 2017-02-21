package com.github.alejopj.oesia.services;

import com.github.alejopj.oesia.entities.Event;

public interface EventService {

	long getTimeDeviceHasBeenOn(Event event);
	
	void processEvent(Event event);
	
	void processEvent(String event, long time);
}
