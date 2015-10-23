package org.learning.webservices.messenger;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.learning.webservices.messenger.model.Message;
import org.learning.webservices.messenger.service.MessageService;

/**
 * Root resource (exposed at "myresource" path)
 */

@Singleton
//@ApplicationPath("/webapi/")
@Path("/messages")
public class MyResource {

	MessageService msgService = new MessageService();

	/**
	 * Method handling HTTP GET requests. The returned object will be sent
	 * to the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	/*@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	System.out.println("Sairam");
        return "Got it!";
    }*/

	@GET
	@Produces(MediaType.APPLICATION_XML)

	public List<Message> getMessageList(){
		return msgService.getAllMessages();

	}

	@Path("/numberOfMessages")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public int getNumberOfMessages(){
		return msgService.getAllMessages().size();
	}

}

