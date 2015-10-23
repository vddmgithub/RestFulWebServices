package org.learning.webservices.messenger.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {

	private int id;
	public int getId() {
		return id;
	}
	
	public void setId(int idNumber) {
		id = idNumber;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	private String profileName;
	private String firstName;
	private String lastName;
	private Date created;
	
	
	public Profile(){
		
	}

	public Profile(int nId,String profileName, String firstName, String lastName) {
		id= nId;
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
