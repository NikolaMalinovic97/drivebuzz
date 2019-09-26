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
import javax.persistence.Table;

@Entity
@Table(name="conversation")
public class Conversation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="last_activity_date")
	private String lastActivityDate;
	
	@Column(name="last_activity_time")
	private String lastActivityTime;
	
	@ManyToMany(fetch=FetchType.LAZY,
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					     CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="conversation_user",
			joinColumns=@JoinColumn(name="conversation_id"),
			inverseJoinColumns=@JoinColumn(name="user_id")
			)
	private List<User> users;
	
	/*@OneToMany(mappedBy="conversation",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					     CascadeType.DETACH, CascadeType.REFRESH})
	@JsonManagedReference
	private List<Message> messages;*/
	
	public Conversation() {
		
	}

	public Conversation(String lastActivityDate, String lastActivityTime) {
		this.lastActivityDate = lastActivityDate;
		this.lastActivityTime = lastActivityTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastActivityDate() {
		return lastActivityDate;
	}

	public void setLastActivityDate(String lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}

	public String getLastActivityTime() {
		return lastActivityTime;
	}

	public void setLastActivityTime(String lastActivityTime) {
		this.lastActivityTime = lastActivityTime;
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	/*public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}*/

	public void addUser(User theUser) {
		
		if (users == null) {
			users = new ArrayList<>();
		}
		
		users.add(theUser);
	}
	
	/*public void addMessage(Message theMessage) {
		
		if (messages == null) {
			messages = new ArrayList<>();
		}
		
		messages.add(theMessage);
	}*/
	
	@Override
	public String toString() {
		return "Conversation [id=" + id + ", lastActivityDate=" + lastActivityDate + ", lastActivityTime="
				+ lastActivityTime + "]";
	}
	
}
