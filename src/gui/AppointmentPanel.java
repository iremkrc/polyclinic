package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hospital.Clinic;
import hospital.Doctor;
import hospital.Patient;


public class AppointmentPanel extends JPanel implements MyInterface {


	public static JComboBox<Patient> patientBox;
	public JComboBox<Doctor> doctorBox = new JComboBox<Doctor>();
	public JComboBox<String> timeBox = new JComboBox<String>();
	private Patient currentPatient;
	private Clinic currentClinic;
	private Doctor currentDr;
	private String currentTime;

	public AppointmentPanel() {
		setSize(500, 250);
		setBorder(BorderFactory.createTitledBorder("Appointment"));
		//This grid layout has 3 columns.
		setLayout(new GridLayout(0,3));

		//1st row of grid layout.
		add(createLabel("Patient: "));
		patientBox = new JComboBox<Patient>(Patient.getPatientList().toArray(new Patient[0]));
		add(patientBox);
		JButton select1 = createButton("Select");
		select1.addActionListener(new ActionListener() {
			//When the select button is clicked, current patient is setted as selected item from JComboBox.
			@Override
			public void actionPerformed(ActionEvent e) {
				currentPatient = (Patient) patientBox.getSelectedItem();
			}
		});
		add(select1);

		//2nd row of grid layout.
		add(createLabel("Clinic: "));
		JComboBox<Clinic> clinicBox = new JComboBox<Clinic>(clinics);
		add(clinicBox);

		JButton select2 = createButton("Select");
		add(select2);
		select2.addActionListener(new ActionListener() {
			//When the select button is clicked, current clinic is setted as selected item from JComboBox.
			@Override
			public void actionPerformed(ActionEvent e) {
				currentClinic = (Clinic) clinicBox.getSelectedItem();
				for(Doctor i: currentClinic.getDoctorList()) {
					doctorBox.addItem(i);
				}
			}
		});


		//3rd row of grid layout.
		add(createLabel("Doctor: "));
		add(doctorBox);
		JButton select3 = createButton("Select");
		select3.addActionListener(new ActionListener() {
			//When the select button is clicked, current doctor is setted as selected item from JComboBox.
			@Override
			public void actionPerformed(ActionEvent e) {
				currentDr = (Doctor) doctorBox.getSelectedItem();
				timeBox.removeAllItems();
				for(String i: currentDr.availableHours()) {
					timeBox.addItem(i);
				}
			}
		});
		add(select3);

		//4th row of grid layout.
		add(createLabel("Time: "));
		add(timeBox);
		JButton select4 = createButton("Select");
		select4.addActionListener(new ActionListener() {
			//When the select button is clicked, current time is setted as selected item from JComboBox.
			@Override
			public void actionPerformed(ActionEvent e) {
				currentTime = (String) timeBox.getSelectedItem();
			}
		});
		add(select4);

		//5th row of grid layout.
		JButton make = createButton("Make an appointment");
		make.addActionListener(new ActionListener() {
			//When the Make an appointment button is clicked, current patient gets an appointment from current doctor.
			@Override
			public void actionPerformed(ActionEvent e) {
				currentDr.addPatient(currentPatient, currentTime);
				currentClinic.addPatient(currentPatient);
				doctorBox.removeAllItems();
				timeBox.removeAllItems();
			}
		});
		add(make);
	}

	//Interface methods
	@Override
	public JLabel createLabel(String str) {
		return new JLabel(str);
	}

	@Override
	public JButton createButton(String str) {
		JButton btn = new JButton(str);
		btn.setBackground(Color.pink);
		return btn;
	}

}
