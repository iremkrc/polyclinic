package hospital;

import java.util.ArrayList;
import java.util.List;

public class Psychiatry extends Clinic {

	public Psychiatry() {
		super();
		addDoctor(new Doctor("Eric Foreman", 3, 80));
		addDoctor(new Doctor("Amber Volakis", 24, 45));
		addDrug(new Drug("C", 28, new ArrayList<String>(List.of("Vicodin"))));
		addDrug(new Drug("G", 30, new ArrayList<String>()));
		setName("Psychiatry");
	}
	
	

}
