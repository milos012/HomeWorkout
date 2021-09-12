package sbnz.integracija.example.models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import sbnz.integracija.example.enums.Equipment;
import sbnz.integracija.example.enums.PhysicalLevel;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//private String username;
	//private String password;
	
	@Column(name = "weight")
	private double weight;
	
	@Column(name = "height")
	private double height;
	
	@Column(name = "pl")
	private PhysicalLevel pl;
	
	@Column(name = "equipment")
	private ArrayList<Equipment> equipment;
	
	public User(long id, String username, String password, double weight, double height, PhysicalLevel pl,
			ArrayList<Equipment> equipment) {
		super();
		this.id = id;
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
