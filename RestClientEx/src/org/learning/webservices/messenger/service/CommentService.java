package org.learning.webservices.messenger.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.learning.webservices.messenger.database.DatabaseClass;
import org.learning.webservices.messenger.model.Comment;
import org.learning.webservices.messenger.model.Message;

public class CommentService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(Long msgId){
		Map<Long, Comment> comments = messages.get(msgId).getComments();
		return (ArrayList<Comment>) comments.values();
	}
	
	public Comment getComment(Long msgId, Long commentId){
		Map<Long, Comment> comments = messages.get(msgId).getComments();
		return comments.get(commentId);
	}
	
	public Comment addComment(Long msgId, Comment comment){
		Map<Long, Comment> comments = messages.get(msgId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment UpdateComment(long messageId, Comment comment){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if(comment.getId() == 0)
			return null;
		else{
			comments.put(comment.getId(), comment);
		}
		return comment;
	}
	
	public Comment removeComment(long msgId, long commentId){
		Map<Long, Comment> comments = messages.get(msgId).getComments();
		return comments.remove(commentId);
	}
}
