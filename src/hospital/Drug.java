package hospital;

import java.util.*;

public class Drug {
	
	private String name;
	private int price;
	private ArrayList<String> conflictingDrugs;
	
	//Constructor
	public Drug(String name, int price, ArrayList<String> conflictingDrugs) {
		super();
		this.name = name;
		this.price = price;
		this.conflictingDrugs = conflictingDrugs;
	}
	
	//Getters
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public ArrayList<String> getConflictingDrugs() {
		return conflictingDrugs;
	}
	
	@Override
	public String toString() {
		return "Drug: " + name + " ($" + price + ")";
	}
	
	
}
