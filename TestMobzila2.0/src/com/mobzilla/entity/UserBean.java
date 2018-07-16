package com.mobzilla.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="users_table")
@SequenceGenerator(name="user_id",sequenceName="user_seq")
public class UserBean {
	
	
	
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int userId;
	
	@Column(name="userf_name")
	private String userFirstName;

	@Column(name="userl_name")
	private String userLastName;
	
	@Id
	@Column(name="user_email")
	private String userEmail;
	
	@Column(name="user_pass")
	private String userPass;
	
	@Column(name="user_contact")
	private String userContact;
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER, cascade={javax.persistence.CascadeType.ALL})
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<AddressBean> address;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	

}
