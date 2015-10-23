package org.learning.webservices.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.learning.webservices.messenger.model.Message;
import org.learning.webservices.messenger.resources.beans.MessageFilterBean;
import org.learning.webservices.messenger.service.MessageService;

/**
 * Root resource (exposed at "myresource" path)
 */

@Singleton
//@ApplicationPath("/webapi/")
@Path("/messages")
public class MessageResource {

	MessageService msgService = new MessageService();

	/**
	 * Method handling HTTP GET requests. The returned object will be sent
	 * to the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	
	@GET
	@Path("/test")
	public String test(){
		System.out.println("Sairam thoroughly tested");
		return "Sairam thoroughly tested";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public List<Message> getMessageList(@BeanParam MessageFilterBean filterBean){
		if(filterBean.getYear() >0)
			return msgService.getAllMessagesInYear(filterBean.getYear());
		if(filterBean.getStart() > 0 && filterBean.getSize()> 0)
			return msgService.getMessagesPaginated(filterBean.getStart() , filterBean.getSize());
		else			
			return msgService.getAllMessages();

	}
	
	/*@Path("/newmessage")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message msg){
		System.out.println("Before adding message");
		return msgService.addMessage(msg);	
	}*/
	
	/*@Path("/newmessage")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMessage(Message msg) throws URISyntaxException{
		//System.out.println("Before adding message");
		Message newMessage = msgService.addMessage(msg);
		return Response.created(new URI("RestClientEx/webapi/messages/"+msg.getId()))
				.entity(newMessage)
				.build();
		
	}*/
	
	@Path("/newmessage")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMessage(Message msg, @Context UriInfo uriInfo) throws URISyntaxException{
		Message newMessage = msgService.addMessage(msg);
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(msg.getId())).build();
		return Response.created(uri)
				.entity(newMessage)
				.build();
		
	}
	
	@DELETE
	@Path("/deleteMessage/{messageId}")
	public void deleteMessage(@PathParam(value = "messageId")long index){
		System.out.println("Before deleting a message");
		msgService.removeMessage(index);	
	}

	@Path("/numberOfMessages")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public int getNumberOfMessages(){
		System.out.println("Inside getNumberOfMessages");
		return msgService.getAllMessages().size();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam(value = "messageId") long id){
		System.out.println("MessageId: "+id);
		return msgService.getMessage(id);
	}
	
	
	@PUT
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(Message message){
		return msgService.updateMessage(message);
	}
	

	@Path("/{messageId}/comments")
	public CommentResource comments(){
		return new CommentResource();
	}
	
	
}

