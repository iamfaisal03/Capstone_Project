package com.globallogic.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "owner")

public class Owner {
  
  @Id
  @Email
  @NotNull
  private String ownerEmail;
  @NotNull
  private String ownerPassword;
  private String userRole;

  public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getOwnerPassword() {
		return ownerPassword;
	}

	public void setOwnerPassword(String ownerPassword) {
		this.ownerPassword = ownerPassword;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}