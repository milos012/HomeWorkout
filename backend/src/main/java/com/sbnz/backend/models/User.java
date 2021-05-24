package com.sbnz.backend.models;

import java.util.ArrayList;

import enums.Equipment;
import enums.PhysicalLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private long id;
	private String username;
	private String password;
	private double weight;
	private double height;
	private PhysicalLevel pl;
	private ArrayList<Equipment> equipment;
	private ArrayList<Workout> pastWorkouts;
	
	public User(long id, String username, String password, double weight, double height, PhysicalLevel pl,
			ArrayList<Equipment> equipment) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.weight = weight;
		this.height = height;
		this.pl = pl;
		this.equipment = equipment;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public PhysicalLevel getPl() {
		return pl;
	}
	public void setPl(PhysicalLevel pl) {
		this.pl = pl;
	}
	public ArrayList<Equipment> getEquipment() {
		return equipment;
	}
	public void setEquipment(ArrayList<Equipment> equipment) {
		this.equipment = equipment;
	}
	public ArrayList<Workout> getPastWorkouts() {
		return pastWorkouts;
	}
	public void setPastWorkouts(ArrayList<Workout> pastWorkouts) {
		this.pastWorkouts = pastWorkouts;
	}
	
	
}
