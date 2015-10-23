package org.learning.webservices.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.learning.webservices.messenger.model.Comment;
import org.learning.webservices.messenger.service.CommentService;

@Path("/")  //This path param is not mandatory
public class CommentResource {

	CommentService commentService = new CommentService();
	
	@GET
	public String test(){
		return "Inside Sub Resource";
	}
	
	@GET
	@Path("/{commentId}")
	public String test2(@PathParam("messageId") long msgId,@PathParam("commentId") long commentId){
		return "MessageId: "+msgId +" \nInside get comments "+commentId;
	}
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId ){
		return commentService.getAllComments(messageId);
	}
	
	@POST
	public Comment addComment(@PathParam("messageId")long messageId, Comment comment){
		return commentService.addComment(messageId, comment);
	}
	
	@PUT
	@Path("{/comment}")
	public Comment updateComment(@PathParam("messageId") long messageId, Comment comment){
		return commentService.UpdateComment(messageId, comment);	
	}
	
	@GET
	public Comment deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId){
		return commentService.removeComment(messageId, commentId);
	}
	
	@GET
	@Path("{/commentId}")
	public Comment getComment(@PathParam("messageId")long messageId, @PathParam("commentId") long commentId){
		return commentService.getComment(messageId, commentId);
	}
}

