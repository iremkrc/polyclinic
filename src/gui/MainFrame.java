package gui;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	private RegisterPanel registerPanel;
	private AppointmentPanel appointmentPanel;
	private TreatmentPanel treatmentPanel;
	private InfoPanel infoPanel;
	
	public MainFrame(String title) {
		// MainFrame uses GridLayout to add components. The frame size is 1000*500. 
		super(title);
		setLayout(new GridLayout(0, 2));
		Container c = getContentPane();
		setSize(1000, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		registerPanel = new RegisterPanel();
		c.add(registerPanel);
		appointmentPanel = new AppointmentPanel();
		c.add(appointmentPanel);
		treatmentPanel = new TreatmentPanel();
		c.add(treatmentPanel);
		infoPanel = new InfoPanel();
		c.add(infoPanel);
		
	}
}
