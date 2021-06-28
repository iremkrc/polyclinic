package hospital;

import java.util.*;

public class Doctor {

	private String name;
	private int id;
	private int cost;
	private double income;
	private TreeMap<String, Patient> schedule;
	private ArrayList<Patient> patientList;

	private final static String[] time = {"09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30"};
	
	//Constructor
	public Doctor(String name, int id, int cost) {
		super();
		this.name = name;
		this.id = id;
		this.cost = cost;
		income = 0;
		patientList = new ArrayList<Patient>();
		schedule = new TreeMap<String, Patient>();
		for(String t: time) {
			schedule.put(t, null);
		}
	}
	
	//Getters
	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getCost() {
		return cost;
	}


	public double getIncome() {
		return income;
	}

	public TreeMap<String, Patient> getSchedule() {
		return schedule;
	}

	public ArrayList<Patient> getPatientList() {
		return patientList;
	}
	
	//This method is used for adding patients to schedule and patientList.
	public void addPatient(Patient p, String hour) {
		schedule.put(hour, p);
		patientList.add(p);
	}
	
	//This method returns a String which includes Doctor’s suggestions.
	public String treatment(Clinic c, Patient p) {
		Drug suggested = c.getDrugList().get(0);
		ArrayList<String> conflict = suggested.getConflictingDrugs();
		for(Drug x: p.getDrugHistory()) {
			if(conflict.contains(x.getName())) {
				suggested = c.getDrugList().get(1);
			}
		}
		p.addSuggestedDrug(suggested);
		p.addDrugHistory(suggested);

		double fee = cost + suggested.getPrice();
		p.addFee(fee);
		c.addProfit((double)cost/5 + (double)suggested.getPrice()/10);
		income += cost - (double)cost/5;

		String str = "Dr. " + this.name + " says: \nGet well soon, " + p.getName() + "! \nYou should take " + suggested.getName() + "\nFee: $" + fee;
		return str;
	}
	
	//This method returns a list consist of keys whose values are not null.
	public ArrayList<String> availableHours() {
		ArrayList<String> hours = new ArrayList<String>();
		for (Map.Entry<String, Patient> entry : schedule.entrySet()) {
			String k = entry.getKey();
			Patient v = entry.getValue();
			if(v==null) {
				hours.add(k);
			}
		}
		return hours;
	}

	@Override
	public String toString() {
		return "Dr. " + name + " ($" + cost + ")";
	}


}
