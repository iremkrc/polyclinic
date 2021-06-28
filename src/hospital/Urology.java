package hospital;

import java.util.ArrayList;
import java.util.List;

public class Urology extends Clinic {

	public Urology() {
		super();
		addDoctor(new Doctor("Lisa Cuddy", 2, 99));
		addDoctor(new Doctor("James Wilson", 4, 70));
		addDrug(new Drug("B", 17, new ArrayList<String>(List.of("Vicodin", "A"))));
		addDrug(new Drug("E", 29, new ArrayList<String>()));
		setName("Urology");
	}
	
	
}
