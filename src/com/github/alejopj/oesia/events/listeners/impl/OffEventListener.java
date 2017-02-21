package com.github.alejopj.oesia.events.listeners.impl;

import com.github.alejopj.oesia.entities.Event;
import com.github.alejopj.oesia.entities.EventType;
import com.github.alejopj.oesia.events.listeners.EventListener;
import com.github.alejopj.oesia.services.EventService;
import com.github.alejopj.oesia.services.impl.EventServiceImpl;

public class OffEventListener implements EventListener {

	private EventService eventService = EventServiceImpl.getInstance();
	
	@Override
	public void notify(Event event) {
		
		if (event.getType() == EventType.OFF) {
			long time = eventService.getTimeDeviceHasBeenOn(event);
			if (time >= 0) {
				String params = event.getParams() + " " + time;
				long currentTime = System.currentTimeMillis();
				Event ev = new Event(EventType.ALARM, params, currentTime);
				eventService.processEvent(ev);
			}
		}
	}
	
}
