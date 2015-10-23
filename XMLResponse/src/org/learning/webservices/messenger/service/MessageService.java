package org.learning.webservices.messenger.service;

import java.util.ArrayList;
import java.util.List;

import org.learning.webservices.messenger.model.Message;

public class MessageService {
	
	
	public List<Message> getAllMessages(){
		Message msg1 = new Message(1, "Sairam", "SaiBaba");
		Message msg2 = new Message(2, "Achinthya Rama", "SaiBaba");
		
		List<Message> list = new ArrayList<Message>();
		list.add(msg1);
		list.add(msg2);
		return list;
		
	}
	
	
}
