package sbnz.integracija.example.facts;

import java.util.ArrayList;
import java.lang.Math;

import org.kie.api.definition.type.PropertyReactive;

import sbnz.integracija.example.enums.BMICategory;
import sbnz.integracija.example.enums.Equipment;
import sbnz.integracija.example.enums.PhysicalLevel;
import sbnz.integracija.example.models.User;

@PropertyReactive
public class UserInfo {
	
	private double weight;
	private double height;
	private PhysicalLevel pl;
	private ArrayList<Equipment> equipment;
	private BMICategory BMI;
	private double BMIbroj;

	public UserInfo() {
		//this.weight = 50;
		//this.height = 150;
		this.pl = PhysicalLevel.BEGINNER;
	}
	
	public UserInfo(User u) {
		this.weight = u.getWeight();
		this.height = u.getHeight();
		this.pl = u.getPl();
		this.equipment = u.getEquipment();
	}

	public double getBMIbroj() {
		return BMIbroj;
	}

	public void setBMIbroj(double weight, double height) {
		this.BMIbroj = (weight / height/height)*10000;
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
