package sbnz.integracija.example.dto;

import java.util.ArrayList;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import sbnz.integracija.example.enums.Equipment;
import sbnz.integracija.example.enums.PhysicalLevel;
import sbnz.integracija.example.models.User;

@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private long id;
	private double weight;
	private double height;
	private PhysicalLevel pl;
	private ArrayList<Equipment> equipment;
	
	public UserDTO(double weight, double height, PhysicalLevel pl, ArrayList<Equipment> equipment) {
		super();
		this.weight = weight;
		this.height = height;
		this.pl = pl;
		this.equipment = equipment;
	}
	
	public UserDTO(User u) {
		this.id = u.getId();
		this.weight = u.getWeight();
		this.height = u.getHeight();
		this.pl = u.getPl();
		this.equipment = u.getEquipment();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	

}
