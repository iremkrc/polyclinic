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
import javax.swing.JTextArea;

import hospital.Clinic;
import hospital.Doctor;
import hospital.Patient;


public class TreatmentPanel extends JPanel implements MyInterface {

	private Clinic currentClinic;
	private Patient currentPatient;
	private JComboBox<Patient> patientBox = new JComboBox<Patient>();

	public TreatmentPanel() {
		setSize(500, 250);
		setBorder(BorderFactory.createTitledBorder("Treatment"));
		//This grid layout has 3 columns.
		setLayout(new GridLayout(0,3));

		//1st row of the grid layout.
		add(createLabel("Clinic: "));
		JComboBox<Clinic> clinicBox = new JComboBox<Clinic>(clinics);
		add(clinicBox);

		JButton select1 = createButton("Select");
		add(select1);
		select1.addActionListener(new ActionListener() {
			//When the select button is clicked, current clinic is setted as selected item from JComboBox, and current clinic's patients are added to patientBox.
			@Override
			public void actionPerformed(ActionEvent e) {
				patientBox.removeAllItems();
				currentClinic = (Clinic) clinicBox.getSelectedItem();
				for(Patient i: currentClinic.getPatientList()) {
					patientBox.addItem(i);
				}
			}
		});

		//2nd row of the grid layout.
		add(createLabel("Patient: "));
		add(patientBox);
		JButton select2 = createButton("Select");
		add(select2);
		select2.addActionListener(new ActionListener() {
			//When the select button is clicked, current patient is setted as selected item from JComboBox.
			@Override
			public void actionPerformed(ActionEvent e) {
				currentPatient = (Patient) patientBox.getSelectedItem();
			}
		});
		//3rd row of the grid layout.
		JButton treat = createButton("Go to the appointment");
		add(treat);
		JTextArea advice = new JTextArea();
		advice.setEditable(false);
		add(advice);
		treat.addActionListener(new ActionListener() {
			//When the Go to the appointment button is clicked, treatment method of the related doctor is called.
			@Override
			public void actionPerformed(ActionEvent e) {
				patientBox.removeAllItems();
				String text = currentClinic.findDoctor(currentPatient).treatment(currentClinic, currentPatient);
				advice.setText(text);
			}
		});
	}

	//Interface methods
	@Override
	public JLabel createLabel(String str) {
		return new JLabel(str);
	}

	@Override
	public JButton createButton(String str) {
		JButton btn = new JButton(str);
		btn.setBackground(Color.orange);
		return btn;
	}

}
