package org.learning.webservices.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.learning.webservices.messenger.model.Profile;
import org.learning.webservices.messenger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private ProfileService profileService =  new ProfileService();
	
	
	@GET
	public List<Profile> getProfiles(){
		return profileService.getAllMessages();
	}

	@POST
	public Profile addProfile(Profile prof){
		return profileService.addProfile(prof);
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfille(@PathParam("profileName") String profName ){
		return profileService.getProfile(profName);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile addProfile(@PathParam("profileName") String profName, Profile profile){
		profile.setProfileName(profName);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String profName){
		profileService.removeProfile(profName);
	}
	

}