package org.learning.webservices.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.learning.webservices.messenger.model.Message;
import org.learning.webservices.messenger.model.Profile;

public class DatabaseClass {

	/*
	 * Stub for Database and it is declared so that every class/ object can access these.
	 */
	
	private static Map<Long, Message> messages = new HashMap();
	private static Map<String, Profile> profiles = new HashMap();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	
}
