package com.github.alejopj.oesia.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import com.github.alejopj.oesia.entities.Event;
import com.github.alejopj.oesia.entities.EventType;
import com.github.alejopj.oesia.repositories.EventRepository;

public class EventRepositoryImpl implements EventRepository {
	
	private static EventRepositoryImpl repository = new EventRepositoryImpl();
	private static List<Event> events = new ArrayList<Event>();

	private EventRepositoryImpl() {
		// Singleton.
	}
	
	public static EventRepositoryImpl getInstance() {
		return repository;
	}
	
	@Override
	public long getTimeDeviceHasBeenOn(Event event) {
		
		long time = -1;
		
		if (event.getType() != EventType.OFF) {
			// Not a switch off device event.
			return time;
		}
		
		int index = events.indexOf(event);
		Event e = null;
		
		for (int i = index - 1; i > -1; i--) {
			
			if (i == -1 && time < 0) {
				// Device has never been on.
				return time;
			}
			
			if (i == -1 && time >= 0) {
				// Device has been on for 'time' seconds.
				return time;
			}
			
			e = events.get(i);
			if (e.getParams() == event.getParams()) {
				// Same device.
				if (e.getType() == EventType.OFF) {
					if (time < 0) {
						// Device has already been switched off.
						return time;
					} else {
						// Device has been on for 'time' seconds.
						return time;
					}
				}
				if (e.getType() == EventType.ON) {
					// Device was switched on at least this time.
					time = (event.getTime() - e.getTime()) / 1000;
				}
			}
		}
		
		return time;
	}
	
	@Override
	public void register(Event event) {
		
		events.add(event);
	}

}
