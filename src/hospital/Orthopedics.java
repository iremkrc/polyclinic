package hospital;

import java.util.ArrayList;
import java.util.List;

public class Orthopedics extends Clinic {

	public Orthopedics() {
		super();
		addDoctor(new Doctor("Gregory House", 1, 150));
		addDoctor(new Doctor("Allison Cameron", 5, 70));
		addDrug(new Drug("Vicodin", 9, new ArrayList<String>(List.of("C", "A", "B"))));
		addDrug(new Drug("F", 11, new ArrayList<String>()));
		setName("Orthopedics");
	}
}
