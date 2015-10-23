package org.learning.webservices.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


@Path("/injectDemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)

public class InjectResouceDemo {

	
	@GET
	@Path("/annotation")
	public String getParamsUsingAnnotation(@MatrixParam("param") String value,	
											@HeaderParam("headerParam") String headerParamValue,
											@CookieParam("name") String cookie){
		
		return "Matrix Param: "+value +" Header Param Value: "+headerParamValue + "Cookie Param: "+cookie;
	}
	
	@GET
	@Path("context")
	public String getParmasUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders header){
		return null;
		
	}
}