package com.github.alejopj.oesia.events.listeners;

import com.github.alejopj.oesia.entities.Event;

public interface EventListener {

	void notify(Event event);
}
