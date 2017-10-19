import java.util.Scanner;

public class Fach {

	private Scanner scanner = new Scanner(System.in);
	private int semester;
	private enum_Kursname k_name;
	private enum_Studiengang studiengang;

	public Fach(int semester, enum_Kursname k_name, enum_Studiengang studiengang) {
		this.semester = semester;
		this.k_name = k_name;
		this.studiengang = studiengang;
	}

	/**
	 * default Constructor
	 */
	public Fach() {
		this.addStudiengang();
		this.addSemester();
		this.addKurs();
	}

	/**
	 * Kopierkonstruktor
	 */
	public Fach(Fach f) {
		this(f.getSemester(), f.getK_name(), f.getStudiengang());
	}

	public int getSemester() {
		return semester;
	}

	public void addSemester() {
		int auswahl;
		do {
			System.out.println("Welches Semester?");
			auswahl = scanner.nextInt();
		} while (auswahl < 1);
		this.semester = auswahl;
	}

	public enum_Kursname getK_name() {
		return this.k_name;
	}

	public void addKurs() {
		int auswahl;
		do {
			System.out.println("Welcher Kurs soll belegt werden?");
			enum_Kursname.printKursList();
			auswahl = scanner.nextInt() - 1;

		} while (auswahl < 0 || auswahl > enum_Kursname.getList().size());
		this.k_name = enum_Kursname.getList().get(auswahl);
	}

	public enum_Studiengang getStudiengang() {
		return studiengang;
	}

	public void addStudiengang() {
		int auswahl;
		do {
			System.out.println("Welcher Studiengang?");
			enum_Studiengang.printStudiengangList();
			auswahl = scanner.nextInt() - 1;
		} while (auswahl < 0 || auswahl > enum_Studiengang.getList().size());
		this.studiengang = enum_Studiengang.getList().get(auswahl);
	}

	public String toString() {
		String output = "";
		output += "Semester: " + this.semester + System.lineSeparator();
		output += "Studiengang: " + this.studiengang + System.lineSeparator();
		output += "Kurs: " + this.k_name + System.lineSeparator();
		return output;
	}

}
