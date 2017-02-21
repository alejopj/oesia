package com.github.alejopj.oesia.repositories;

import com.github.alejopj.oesia.entities.Event;

public interface EventRepository {

	long getTimeDeviceHasBeenOn(Event event);
	
	void register(Event event);
}
