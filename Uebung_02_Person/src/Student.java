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

	private String addMatr_Nr() {
		System.out.println("Enter your Matrikelnummer:");
		return scanner.next();
	}

	private String adds_gr() {
		System.out.println("Enter your Seminargruppe:");
		return scanner.next();
	}

	public Fach addFach() throws IllegalArgumentException {
		// TODO: darf keine doppelte Belegung beinhalten.
		Scanner scanner = new Scanner(System.in);
		int auswahl;

		do {
			System.out.println("Welches Fach wird belegt?");
			// enum_Kursname.printKursList(); -> wird in Fach selber gefragt

			faecher_list.add(new Fach());

			System.out.println("[0] kein Fach belegen");
			auswahl = scanner.nextInt();
			if (auswahl == 0) {
				break;
			}

		} while (auswahl < 0 || auswahl > enum_Kursname.getList().size());

		return null;
	}

	public String toString() {
		String output = "";

		output += super.toString();
		output += "Matrikelnummer: " + this.matr_nr + System.lineSeparator();
		output += "Seminargruppe: " + this.seminargruppe + System.lineSeparator();

		for (Object s : this.faecher_list) {
			output += "\t" + s;
		}
		return output;
	}
}
