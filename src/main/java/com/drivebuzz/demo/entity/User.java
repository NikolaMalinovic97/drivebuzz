package com.drivebuzz.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_info_id")
	private UserInfo userInfo;
	
	@OneToMany(mappedBy="user",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					     CascadeType.DETACH, CascadeType.REFRESH})
	@JsonBackReference("offer-user")
	private List<Offer> offers;
	
	@OneToMany(mappedBy="user",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					     CascadeType.DETACH, CascadeType.REFRESH})
	@JsonBackReference
	private List<Demand> demands;
	
	@OneToMany(mappedBy="user",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					     CascadeType.DETACH, CascadeType.REFRESH})
	@JsonBackReference
	private List<Notification> notifications;
	
	@ManyToMany(fetch=FetchType.LAZY,
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					     CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="conversation_user",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="conversation_id")
			)
	@JsonIgnore
	private List<Conversation> conversations;
	
	/*@OneToMany(mappedBy="user",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					     CascadeType.DETACH, CascadeType.REFRESH})
	@JsonManagedReference
	private List<Message> messages;*/
		
	public User() {
		
	}

	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	
	public List<Demand> getDemands() {
		return demands;
	}

	public void setDemands(List<Demand> demands) {
		this.demands = demands;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public List<Conversation> getConversations() {
		return conversations;
	}

	public void setConversations(List<Conversation> conversations) {
		this.conversations = conversations;
	}
	
	/*public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}*/

	public void addOffer(Offer tempOffer) {
		
		if (offers == null) {
			offers = new ArrayList<>();
		}
		
		offers.add(tempOffer);
		
		tempOffer.setUser(this);
	}
	
	public void addDemand(Demand tempDemand) {
		
		if (demands == null) {
			demands = new ArrayList<>();
		}
		
		demands.add(tempDemand);
		
		tempDemand.setUser(this);
	}
	
	public void addNotification(Notification tempNotification) {
		
		if (notifications == null) {
			notifications = new ArrayList<>();
		}
		
		notifications.add(tempNotification);
		
		tempNotification.setUser(this);
	}
	
	/*public void addMessage(Message theMessage) {
		
		if (messages == null) {
			messages = new ArrayList<>();
		}
		
		messages.add(theMessage);
	}*/

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", userInfo="
				+ userInfo + "]";
	}
		
}
