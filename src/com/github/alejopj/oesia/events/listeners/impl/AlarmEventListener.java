package com.github.alejopj.oesia.events.listeners.impl;

import com.github.alejopj.oesia.entities.Event;
import com.github.alejopj.oesia.entities.EventType;
import com.github.alejopj.oesia.events.listeners.EventListener;
import com.github.alejopj.oesia.services.OutputService;
import com.github.alejopj.oesia.services.impl.OutputServiceImpl;

public class AlarmEventListener implements EventListener {

	private OutputService outputService = OutputServiceImpl.getInstance();
	
	@Override
	public void notify(Event event) {
		
		if (event.getType() == EventType.ALARM) {
			String line = event.getType().toString() + " " + event.getParams();
			outputService.writeLine(line);
		}
	}
	
}
