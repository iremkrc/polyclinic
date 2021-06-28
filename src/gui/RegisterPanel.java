package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hospital.Patient;

public class RegisterPanel extends JPanel implements MyInterface {

	private JTextField nameField;
	private JTextField idField;
	private JTextField ageField;

	public RegisterPanel() {
		setSize(500, 250);
		setBorder(BorderFactory.createTitledBorder("Registration"));
		//This grid layout has 2 columns.
		setLayout(new GridLayout(0,2));

		nameField = new JTextField(10);
		idField = new JTextField(10);
		ageField = new JTextField(10);
		JComboBox<String> genderBox = new JComboBox<String>(genders);

		JButton save = createButton("Register");

		save.addActionListener(new ActionListener() {
			// When register button is clicked, a Patient is created with the information taken from JTextFields and JCombobox.
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				long id = Long.parseLong(idField.getText());
				int age = Integer.parseInt(ageField.getText());
				String gender = genderBox.getSelectedItem().toString();

				Patient patient = new Patient(name, id, age, gender);
				Patient.addToPatientList(patient);
				AppointmentPanel.patientBox.addItem(patient);
				InfoPanel.patientInfoBox.addItem(patient);
				nameField.setText("");
				idField.setText("");
				ageField.setText("");
			}
		});
		//1st row of the grid layout
		add(createLabel("Name: "));
		add(nameField);
		
		//2nd row of the grid layout
		add(createLabel("ID/TCKN: "));
		add(idField);
		
		//3rd row of the grid layout
		add(createLabel("Age: "));
		add(ageField);
		
		//4th row of the grid layout
		add(createLabel("Gender: "));
		add(genderBox);
		
		//5th row of the grid layout
		add(save);


	}
	//Interface methods
	@Override
	public JLabel createLabel(String str) {
		return new JLabel(str);
	}

	@Override
	public JButton createButton(String str) {
		JButton btn = new JButton(str);
		btn.setBackground(Color.red);
		return btn;
	}
}
