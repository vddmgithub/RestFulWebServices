package org.learning.resource;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Singleton
//@ApplicationPath("/webapi/")
@Path("/messages")
public class MyResource {
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	System.out.println("Sairam");
        return "Got it!";
    }
}
