package edu.mum.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity(name = "users")
  public class User implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
    private Long id = null;

	@Column(name = "IS_ADMIN")
	private boolean admin = false;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "FIRSTNAME")
     private String firstName;

	@Column(name = "lastLogin", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date lastLogin;

	@Column(name = "LASTNAME")
     private String lastName;


	@Column(name = "RATING")
     private int rating = 0;


     
     @Version
     private int version = 0;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

}