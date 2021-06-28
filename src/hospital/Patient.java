package hospital;

import java.util.*;

public class Patient implements Comparable<Patient> {
	
	private String name;
	private int age;
	private long tckn;
	private String gender;
	private ArrayList<Drug> drugHistory;
	private ArrayList<Drug> suggestedDrugs;
	private double fee;
	private static ArrayList<Patient> patientList = new ArrayList<Patient>();
	
	//Constructor
	public Patient(String name, long tckn, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.tckn = tckn;
		this.gender = gender;
		drugHistory = new ArrayList<Drug>();
		suggestedDrugs = new ArrayList<Drug>();
		fee = 0;
	}
	
	
	//Getters
	public static ArrayList<Patient> getPatientList() {
		Collections.sort(patientList);
		return patientList;
	}
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public long getTckn() {
		return tckn;
	}

	public String getGender() {
		return gender;
	}
	
	public double getFee() {
		return fee;
	}

	public ArrayList<Drug> getDrugHistory() {
		return drugHistory;
	}

	public ArrayList<Drug> getSuggestedDrugs() {
		return suggestedDrugs;
	}
	
	//Add methods: These methods take an appropriate object as a parameter and add it to the corresponding list.
	public void addSuggestedDrug(Drug d) {
		suggestedDrugs.add(d);
	}
	public void addDrugHistory(Drug d) {
		drugHistory.add(d);
	}
	public static void addToPatientList(Patient p) {
		patientList.add(p);
	}
	//This method increases fee by the number taken as a parameter.
	public void addFee(double num) {
		fee += num;
	}
	
	@Override
	public String toString() {
		return name + ", " + age + ", " + gender + ", id = " + tckn;
	}
	//This method compares two Patients by their ages, then genders.
	@Override
	public int compareTo(Patient i) {
		if(age>i.getAge()) return 1;
		else if(age<i.getAge()) return -1;
		else if(gender=="Male") return 1;
		else if(gender=="Female") return -1;
		return 0;
	}
	
}

