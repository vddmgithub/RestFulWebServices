package org.learning.webservices.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.Sides;

import org.learning.webservices.messenger.database.DatabaseClass;
import org.learning.webservices.messenger.exception.DataNotFoundException;
import org.learning.webservices.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put((long) 1, new Message(1, "Sairam", "Sathya Sai"));
		messages.put((long) 2, new Message(2, "Shiva Shakthi", "Shiva Shambo"));
	}
	
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
		
	}
	
	public List<Message> getAllMessagesInYear(int year){
		List<Message> list = new ArrayList<>();
		Calendar cal  = Calendar.getInstance();
		
		for(Message msg : messages.values()){
			cal.setTime(msg.getCreated());
			
			if(cal.get(Calendar.YEAR) == year)
				list.add(msg);
		}
		return list;
	}
	
	public List<Message> getMessagesPaginated(int start, int size){
		
		List<Message> list = new ArrayList<>(messages.values());
		
		if( (start + size) > list.size()){
			return list.subList(start, list.size());
		}
		return list.subList(start, start+size);
	}
	

	//Without execption or error handling.
	//
	/*public Message getMessage(long id){
		return messages.get(id);
	}*/
	
	public Message getMessage(long id){
		Message msg = messages.get(id);
		if(msg == null)
			throw new DataNotFoundException("Message with id: "+id+ " doesn't exist");
		return msg;
	}
	
	public Message addMessage(Message msg){
		System.out.println("Adding the message");
		msg.setId(messages.size() + 1);
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message updateMessage(Message msg){
		
		if(msg.getId() < 0)
			return null;
		else{
			messages.put(msg.getId(), msg);
		}
		return msg;
	}
	
	public void removeMessage(long id){
		messages.remove(id);
	}

}
