/* *********** Pledge of Honor ***************************************************************************
 * I hereby certify that I have completed this programming assignment on my own
 * without any help from anyone else. The effort in the assignment thus belongs
 * completely to me. I did not search for a solution, or I did not consult to any program
 * written by other students or did not copy any program from other sources. I read and
 * followed the guidelines provided in the programming assignment.
 *
 * READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
 * SIGNATURE: Irem Karaca, 71879
 *
 ************************************************************************************************************/

package test;


import java.util.ArrayList;
import java.util.List;

import gui.AppointmentPanel;
import gui.InfoPanel;
import gui.MainFrame;
import gui.MyInterface;
import hospital.Clinic;
import hospital.Doctor;
import hospital.Patient;

public class Test {
	
	public static void main(String[] args) {
		
		MainFrame frame = new MainFrame("KU-HEALTH");
		
		
		Patient p1 = new Patient("Maria Miller", 98765432198L, 23, "Female");
		Patient p2 = new Patient("Jean Collins", 56984123255L, 57, "Female");
		Patient p3 = new Patient("Julia Cox", 78945544720L, 32, "Female");
		Patient p4 = new Patient("Alice Powell", 36598745214L, 25, "Female");
		Patient p5 = new Patient("Irene Bell", 77451547963L, 18, "Female");
		Patient p6 = new Patient("Michael Howard", 36481547963L, 25, "Male");
		Patient p7 = new Patient("Daniel Edwards", 56871547963L, 43, "Male");
		Patient p8 = new Patient("Chris Rogers", 78642547963L, 10, "Male");
		Patient p9 = new Patient("Carlos Martin", 95611547963L, 92, "Male");
		Patient p10 = new Patient("Fred Wilson", 18061547963L, 66, "Male");
		
		ArrayList<Patient> list = new ArrayList<Patient>(List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
		addMultiplePatient(list);
		
		makeAppointment(p1, MyInterface.clinics[0], MyInterface.clinics[0].getDoctorList().get(0), "09:00");
		makeAppointment(p6, MyInterface.clinics[0], MyInterface.clinics[0].getDoctorList().get(1), "09:30");
		makeAppointment(p2, MyInterface.clinics[1], MyInterface.clinics[1].getDoctorList().get(0), "10:00");
		makeAppointment(p7, MyInterface.clinics[1], MyInterface.clinics[1].getDoctorList().get(1), "10:30");
		makeAppointment(p3, MyInterface.clinics[2], MyInterface.clinics[2].getDoctorList().get(0), "11:00");
		makeAppointment(p8, MyInterface.clinics[2], MyInterface.clinics[2].getDoctorList().get(1), "11:30");
		makeAppointment(p4, MyInterface.clinics[2], MyInterface.clinics[2].getDoctorList().get(0), "13:00");
		makeAppointment(p9, MyInterface.clinics[3], MyInterface.clinics[3].getDoctorList().get(1), "13:30");
		makeAppointment(p5, MyInterface.clinics[3], MyInterface.clinics[3].getDoctorList().get(0), "14:00");
		makeAppointment(p10, MyInterface.clinics[3], MyInterface.clinics[3].getDoctorList().get(1), "14:30");
		
		
		frame.setVisible(true);
	}
	//This method is written for registering multiple patients at a time to system.
	private static void addMultiplePatient(ArrayList<Patient> arr) {
		for(Patient p: arr) {
			Patient.addToPatientList(p);
			AppointmentPanel.patientBox.addItem(p);
			InfoPanel.patientInfoBox.addItem(p);
		}
	}
	//This method is written for making appointments easily.
	private static void makeAppointment(Patient p, Clinic c, Doctor d, String h) {
		d.addPatient(p, h);
		c.addPatient(p);
	}
}
