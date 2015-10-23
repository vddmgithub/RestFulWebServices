package org.learning.webservices.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.learning.webservices.messenger.model.ErrorMessage;


@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		// TODO Auto-generated method stub
		ErrorMessage msg = new ErrorMessage(exception.getMessage(), 404, "http://javabrains.kaushik.org");
		return Response.status(Status.NOT_FOUND)
				.entity(msg)
				.build();
	}

}
