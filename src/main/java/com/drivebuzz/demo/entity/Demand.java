package com.drivebuzz.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="demand")
public class Demand {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="departure_place")
	private String departurePlace;
	
	@Column(name="destination_place")
	private String destinationPlace;
	
	@Column(name="time_created")
	private String timeCreated;
	
	@Column(name="date_created")
	private String dateCreated;
	
	@Column(name="active")
	private boolean active;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="user_id")
	private User user;
	
	public Demand() {
		
	}

	public Demand(String departurePlace, String destinationPlace, String timeCreated, String dateCreated,
				  boolean active) {
		this.departurePlace = departurePlace;
		this.destinationPlace = destinationPlace;
		this.timeCreated = timeCreated;
		this.dateCreated = dateCreated;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeparturePlace() {
		return departurePlace;
	}

	public void setDeparturePlace(String departurePlace) {
		this.departurePlace = departurePlace;
	}

	public String getDestinationPlace() {
		return destinationPlace;
	}

	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}

	public String getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(String timeCreated) {
		this.timeCreated = timeCreated;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Demand [id=" + id + ", departurePlace=" + departurePlace + ", destinationPlace=" + destinationPlace
				+ ", timeCreated=" + timeCreated + ", dateCreated=" + dateCreated + ", active=" + active + ", user="
				+ user + "]";
	}
	
	
}
