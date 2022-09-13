package com.text.orchard.vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicles")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="vehicle_name")
	private String vehicleName;
	@Column(name="type_vehicle")
	private int typeVehicle;
	@Column(name="state")
	private String state;
	@Column(name="city")
	private String city;
	
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(String vehicleName, int typeVehicle, String state, String city) {
		super();
		this.vehicleName = vehicleName;
		this.typeVehicle = typeVehicle;
		this.state = state;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public int getTypeVehicle() {
		return typeVehicle;
	}

	public void setTypeVehicle(int typeVehicle) {
		this.typeVehicle = typeVehicle;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
	
	

}
