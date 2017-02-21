package com.github.alejopj.oesia.services.impl;

import com.github.alejopj.oesia.entities.Event;
import com.github.alejopj.oesia.entities.EventType;
import com.github.alejopj.oesia.events.notifier.EventNotificator;
import com.github.alejopj.oesia.repositories.EventRepository;
import com.github.alejopj.oesia.repositories.impl.EventRepositoryImpl;
import com.github.alejopj.oesia.services.EventService;

public class EventServiceImpl implements EventService {
	
	private static EventServiceImpl service = new EventServiceImpl();
	private EventRepository repository = EventRepositoryImpl.getInstance();

	private EventServiceImpl() {
		// Singleton.
	}
	
	public static EventServiceImpl getInstance() {
		return service;
	}
	
	@Override
	public long getTimeDeviceHasBeenOn(Event event) {
		
		return repository.getTimeDeviceHasBeenOn(event);
	}
	
	@Override
	public void processEvent(Event event) {
		
		if (event.getType() != EventType.UNDEFINED) {
			repository.register(event);
			EventNotificator.notify(event);
		}
	}
	
	@Override
	public void processEvent(String event, long time) {
		
		Event ev = new Event(event, time);
		this.processEvent(ev);
	}
	
}
