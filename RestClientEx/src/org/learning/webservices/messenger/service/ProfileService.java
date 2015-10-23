package org.learning.webservices.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.learning.webservices.messenger.database.DatabaseClass;
import org.learning.webservices.messenger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put("Satya Sai", new Profile(23,"Satya Sai", "Sathya Sai Baba", "God"));
	}
	
	public List<Profile> getAllMessages(){
		return new ArrayList<Profile>(profiles.values());
		
	}

	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile prof){
		System.out.println("Adding the Profile");
		prof.setId(profiles.size() + 1);
		profiles.put(prof.getProfileName(), prof);
		return prof;
	}
	
	public Profile updateProfile(Profile prof){
		
		if(prof.getProfileName().isEmpty())
			return null;
		else{
			profiles.put(prof.getProfileName(), prof);
		}
		return prof;
	}
	
	public void removeProfile(String profileName){
		profiles.remove(profileName);
	}
}
