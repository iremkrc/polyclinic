package hospital;

import java.util.ArrayList;
import java.util.List;

public class Ophthalmology extends Clinic {

	public Ophthalmology() {
		super();
		addDoctor(new Doctor("Robert Chase", 6, 105));
		addDoctor(new Doctor("Remy Hadley", 13, 45));
		addDrug(new Drug("A", 15, new ArrayList<String>(List.of("Vicodin", "B"))));
		addDrug(new Drug("D", 20, new ArrayList<String>()));
		setName("Ophthalmology");
	}

}
