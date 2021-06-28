package hospital;

import java.util.*;

public class Clinic {

	private ArrayList<Doctor> doctorList;
	private ArrayList<Drug> drugList;
	private double profit;
	private String name;
	private ArrayList<Patient> patientList;

	//Constructor
	public Clinic() {
		doctorList = new ArrayList<Doctor>();
		drugList = new ArrayList<Drug>();
		patientList = new ArrayList<Patient>();
		profit = 0;
		name = "";
	}

	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//This method returns the arraylist sorted.
	public ArrayList<Patient> getPatientList() {
		Collections.sort(patientList);
		return patientList;
	}
	public ArrayList<Doctor> getDoctorList() {
		return doctorList;
	}
	public ArrayList<Drug> getDrugList() {
		return drugList;
	}

	public double getProfit() {
		return profit;
	}


	//Add methods: These methods take an appropriate object as a parameter and add it to the corresponding list.
	public void addPatient(Patient p) {
		patientList.add(p);
	}

	public void addDoctor(Doctor d) {
		doctorList.add(d);
	}
	public void addDrug(Drug d) {
		drugList.add(d);
	}
	//This method increases profit by the number taken as a parameter.
	public void addProfit(double num) {
		profit += num;
	}

	//This method returns Doctor who the Patient made an appointment with.
	public Doctor findDoctor(Patient p) {
		if(getDoctorList().get(0).getPatientList().contains(p)) {
			return getDoctorList().get(0);
		}else {
			return getDoctorList().get(1);
		}
	}
	@Override
	public String toString() {
		return name;
	}	

}
