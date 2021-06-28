package gui;

import javax.swing.*;

import hospital.Clinic;
import hospital.Ophthalmology;
import hospital.Orthopedics;
import hospital.Psychiatry;
import hospital.Urology;

public interface MyInterface {
	
	//Interface has two static final instances and two abstract methods.
	public static final  String[] genders = {"Female", "Male"};
	public static final Clinic[] clinics = {new Ophthalmology(), new Urology(), new Orthopedics(), new Psychiatry()};
	public JLabel createLabel(String str);
	public JButton createButton(String str);
}
