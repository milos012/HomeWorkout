package com.sbnz.backend.facts;

import java.util.ArrayList;
import java.lang.Math;

import org.kie.api.definition.type.PropertyReactive;

import com.sbnz.backend.models.User;

import enums.BMICategory;
import enums.Equipment;
import enums.PhysicalLevel;

@PropertyReactive
public class UserInfo {
	
	private double weight;
	private double height;
	private PhysicalLevel pl;
	private ArrayList<Equipment> equipment;
	private BMICategory BMI;

	public UserInfo() {
		this.weight = 50;
		this.height = 150;
		this.pl = PhysicalLevel.BEGINNER;
	}
	
	public UserInfo(User u) {
		this.weight = u.getWeight();
		this.height = u.getHeight();
		this.pl = u.getPl();
		this.equipment = u.getEquipment();
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

	public BMICategory getBMI() {
		return BMI;
	}

	public void setBMI(BMICategory bMI) {
		BMI = bMI;
	}
	
	
}
