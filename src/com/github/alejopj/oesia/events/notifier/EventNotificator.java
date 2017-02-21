package com.github.alejopj.oesia.events.notifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.alejopj.oesia.entities.Event;
import com.github.alejopj.oesia.entities.EventType;
import com.github.alejopj.oesia.events.listeners.EventListener;

public class EventNotificator {
	
	private static Map<EventType, List<EventListener>> eventListeners =
			new HashMap<EventType, List<EventListener>>();
	
	public static void register(EventType eventType, EventListener eventListener) {
		
		List<EventListener> listeners = eventListeners.get(eventType);
		if (listeners != null) {
			listeners.add(eventListener);
		} else {
			listeners = new ArrayList<EventListener>();
			listeners.add(eventListener);
			eventListeners.put(eventType, listeners);
		}
	}

	public static void notify(Event event) {
		
		List<EventListener> listeners = eventListeners.get(event.getType());
		if (listeners != null) {
			for (EventListener listener : listeners) {
				listener.notify(event);
			}
		}
	}
}
