package com.globallogic.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "guest")
public class Guest {
      @Id
      @Email
      @NotNull
      private String guestEmail;
      @NotNull
      private String guestPassword;
      private String userRole;
      public String getGuestEmail() {
  		return guestEmail;
  	}

  	public void setGuestEmail(String guestEmail) {
  		this.guestEmail = guestEmail;
  	}

  	public String getGuestPassword() {
  		return guestPassword;
  	}

  	public void setGuestPassword(String guestPassword) {
  		this.guestPassword = guestPassword;
  	}

  	public String getUserRole() {
  		return userRole;
  	}

  	public void setUserRole(String userRole) {
  		this.userRole = userRole;
  	}

  	@Override
  	public String toString() {
  		return "Guest [guestEmail=" + guestEmail + ", guestPassword=" + guestPassword + ", userRole=" + userRole + "]";
  	}

  }
	

	  