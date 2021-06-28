package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import hospital.Clinic;
import hospital.Doctor;
import hospital.Patient;

public class InfoPanel extends JPanel implements MyInterface {

	private Doctor currentDr;
	private Clinic currentCli;
	private Patient currentPat;
	public static JComboBox<Patient> patientInfoBox;

	public InfoPanel() {
		setSize(500, 250);
		setBorder(BorderFactory.createTitledBorder("Calculation"));
		//This grid layout has 3 columns.
		setLayout(new GridLayout(0,3));


		//1st and 2nd rows of the grid layout. These rows are related to Doctors.
		ArrayList<Doctor> drList = new ArrayList<Doctor>();
		for(Clinic c: clinics) {
			drList.addAll(c.getDoctorList());
		}
		JTextArea drCalc = new JTextArea();
		drCalc.setEditable(false);
		JComboBox<Doctor> doctorBox = new JComboBox<Doctor>(drList.toArray(new Doctor[0]));
		add(createLabel("Doctor: "));
		add(doctorBox);
		JButton select1 = createButton("Select");
		select1.addActionListener(new ActionListener() {
			//When the select button is clicked, current doctor is setted as selected item from JComboBox.
			@Override
			public void actionPerformed(ActionEvent e) {
				currentDr = (Doctor) doctorBox.getSelectedItem();
			}
		});
		add(select1);

		JButton sch = createButton("Print Schedule");
		sch.addActionListener(new ActionListener() {
			//When print schedule button is clicked, the schedule is printed in both JTextArea and console. 
			@Override
			public void actionPerformed(ActionEvent e) {
				drCalc.setText(currentDr.getSchedule().toString());
				System.out.println(currentDr.getSchedule().toString());
			}
		});
		add(sch);

		JButton income = createButton("Calculate Total Income");
		income.addActionListener(new ActionListener() {
			//When calculate total income button is clicked, current doctor’s getIncome method is called, and printed to the JTextArea.
			@Override
			public void actionPerformed(ActionEvent e) {
				String incomeText = "$" + String.valueOf(currentDr.getIncome());
				drCalc.setText(incomeText);
			}
		});
		add(income);
		add(drCalc);


		//3rd and 4th rows of the grid layout. These rows are related to Clinics.
		add(createLabel("Clinic: "));
		JComboBox<Clinic> clinicBox = new JComboBox<Clinic>(clinics);
		add(clinicBox);
		JButton select2 = createButton("Select");
		select2.addActionListener(new ActionListener() {
			//When the select button is clicked, current clinic is setted as selected item from JComboBox.
			@Override
			public void actionPerformed(ActionEvent e) {
				currentCli = (Clinic) clinicBox.getSelectedItem();
			}
		});
		add(select2);
		JTextArea cliCalc1 = new JTextArea();
		cliCalc1.setEditable(false);

		//This textArea is not functional. It is only used for arrange the layout.
		JTextArea cliCalc2 = new JTextArea();
		cliCalc2.setEditable(false);

		JButton profit = createButton("Calculate Total Profit");
		profit.addActionListener(new ActionListener() {
			//When calculate total profit button is clicked, current clinic's getProfit method is called, and printed to the JTextArea.
			@Override
			public void actionPerformed(ActionEvent e) {
				String profitText = "$" + String.valueOf(currentCli.getProfit());
				cliCalc1.setText(profitText);
			}
		});
		add(profit);
		add(cliCalc1);
		add(cliCalc2);


		//5th and 6th rows of the grid layout. These rows are related to Patients.
		add(createLabel("Patient: "));
		Patient[] patients = Patient.getPatientList().toArray(new Patient [0]);

		patientInfoBox = new JComboBox<Patient>(patients);
		add(patientInfoBox);
		JButton select3 = createButton("Select");
		select3.addActionListener(new ActionListener() {
			//When the select button is clicked, current patient is setted as selected item from JComboBox.
			@Override
			public void actionPerformed(ActionEvent e) {
				currentPat = (Patient) patientInfoBox.getSelectedItem();
			}
		});
		add(select3);

		JTextArea patCalc = new JTextArea();
		patCalc.setEditable(false);

		JButton info = createButton("Print Information");
		info.addActionListener(new ActionListener() {
			//When the print information button is clicked, all information about the current patient is printed in both JTextField and console.
			@Override
			public void actionPerformed(ActionEvent e) {
				String infoText = currentPat.toString() + ", total fee = $" + currentPat.getFee();
				patCalc.setText(infoText);
				System.out.println(infoText);
			}
		});
		add(info);

		JButton drug = createButton("Print Drug History");
		drug.addActionListener(new ActionListener() {
			//When the print drug history button is clicked, drug history of the current patient is printed in both JTextField and console.
			@Override
			public void actionPerformed(ActionEvent e) {
				patCalc.setText(currentPat.getDrugHistory().toString());
				System.out.println(currentPat.getDrugHistory().toString());
			}
		});
		add(drug);
		add(patCalc);

	}
	//Interface methods
	@Override
	public JLabel createLabel(String str) {
		return new JLabel(str);
	}

	@Override
	public JButton createButton(String str) {
		JButton btn = new JButton(str);
		btn.setBackground(Color.cyan);
		return btn;
	}
}
