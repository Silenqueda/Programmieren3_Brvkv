import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends Person {

	private Scanner scanner = new Scanner(System.in);

	private String matr_nr;
	private String seminargruppe;
	private List<Fach> faecher_list = new ArrayList<Fach>();

	public Student() {
		super();
		this.matr_nr = addMatr_Nr();
		this.seminargruppe = adds_gr();

	}

	public List<Fach> getFaecher_list() {
		return faecher_list;
	}

	private String addMatr_Nr() {
		System.out.println("Enter your Matrikelnummer:");
		return scanner.next();
	}

	private String adds_gr() {
		System.out.println("Enter your Seminargruppe:");
		return scanner.next();
	}

	public void addFach() throws IllegalArgumentException {
		// TODO: darf keine doppelte Belegung beinhalten.

		System.out.println("Welches Fach wird belegt?");
		// enum_Kursname.printKursList(); -> wird in Fach selber gefragt

		// TODO!
		// Fach f = new Fach();
		//
		// for (int i = 0; i < faecher_list.size(); i++) {
		//
		//
		// if(faecher_list.get(i).getStudiengang() != null ) {
		//
		// }
		// }
		if (faecher_list.size() == 0) {
			faecher_list.add(new Fach());
		} else {
			// Fach f = new Fach();
			// f.setStudiengang(this.);
			// if() {

		}

	}
	
	

	public String toString() {
		String output = "";

		output += super.toString();
		output += "Matrikelnummer: " + this.matr_nr + System.lineSeparator();
		output += "Seminargruppe: " + this.seminargruppe + System.lineSeparator();

		for (Object s : this.faecher_list) {
			output += s;
		}
		return output;
	}
}
