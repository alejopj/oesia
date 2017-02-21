package com.github.alejopj.oesia;

import com.github.alejopj.oesia.entities.EventType;
import com.github.alejopj.oesia.events.listeners.EventListener;
import com.github.alejopj.oesia.events.listeners.impl.AlarmEventListener;
import com.github.alejopj.oesia.events.listeners.impl.OffEventListener;
import com.github.alejopj.oesia.events.notifier.EventNotificator;
import com.github.alejopj.oesia.services.EventService;
import com.github.alejopj.oesia.services.InputService;
import com.github.alejopj.oesia.services.impl.EventServiceImpl;
import com.github.alejopj.oesia.services.impl.InputServiceImpl;

/*
 * Necesitamos diseñar un sistema que registre eventos y que bajo ante ciertos casos lance otros.
 *  
 * Los eventos, los sistemas de entrada/salida de eventos, la persistencia y la lógica sobre la
 * que generar nuevos eventos son temas que pueden variar con el tiempo.
 * 
 * Inicialmente, para este ejercicio, recibiremos eventos de encendido y apagado de mecanismos por
 * entrada estandar, se persistirán solo en memoria y enviaremos los eventos generados a la salida
 * estándar. Se generará un evento de "Alarma en dispositivo" cuando un mecanismo se apague
 * indicando los segundos que estuvo encendido.
 * 
 * Por ejemplo, para la siguientes entradas:
 *  
 * ON Device1
 * 
 * ON Device2
 * 
 * OFF Device1
 * 
 * Siendo cada línea un evento, la primera palabra de cada línea el tipo de evento y las siguientes
 * palabras los parámetros.
 * 
 * Se producirá la siguiente salida:
 * 
 * ALARM Device1 12
 * 
 * Se busca diseñar un sistema que sea fácilmente modificable.
 */
public class Main {
	
	private static InputService inputService = InputServiceImpl.getInstance();
	private static EventService eventService = EventServiceImpl.getInstance();
	
	static {
		registerEventListeners();
	};
	
	public static void main(String[] args) {
		
		String event = null;
		long time = 0;
		
		while (true) {
			event = inputService.readLine();
			time = System.currentTimeMillis();
			eventService.processEvent(event, time);
		}
	}
	
	private static void registerEventListeners() {
		
		EventListener alarmEventListener = new AlarmEventListener();
		EventListener offEventListener = new OffEventListener();
		EventNotificator.register(EventType.ALARM, alarmEventListener);
		EventNotificator.register(EventType.OFF, offEventListener);
	}

}
