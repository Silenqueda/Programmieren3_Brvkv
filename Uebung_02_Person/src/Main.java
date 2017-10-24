import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static List<Student> studentenliste;

	/**
	 * TODO: Wenn Studiengang gesetzt, kann kein weiterer gesetzt werden. Wenn
	 * kurs bereits belegt kann der selbe nicht erneut gewählt werden
	 */

	public static void main(String[] args) {

		// Initialisiere ArrayList
		studentenliste = new ArrayList<Student>();

		// alle enums werden in eine Liste gespeichert
		enum_Kursname.addKursToList();
		enum_Studiengang.addStudiengangToList();

		Main main = new Main();
		main.start();
	}

	private void start() {
		userInput();

	}

	private void bakeAStudent() {
		Student s = new Student();
		studentenliste.add(s);
	}

	private void printList(List<Student> l) {
		for (int i = 0; i < l.size(); i++) {
			System.out.println("[" + (i + 1) + "]\n" + l.get(i).toString());
		}
	}

	private void menu() {
		System.out.println("[1] add student");
		System.out.println("[2] print students to console");
		if (studentenliste.size() > 0) {
			System.out.println("[3] add Fach to student");
			System.out.println("[4] print students with same Fach");
		} else {
			System.out.println("[3] print students with same Fach");
		}

		System.out.println("[0] quit program");
	}

	private void userInput() {
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			menu();
			choice = scanner.nextInt();

			switch (choice) {
			case 0:
				System.out.println("Bye");
				System.exit(0);
				break;
			case 1:
				bakeAStudent();
				userInput();
				break;
			case 2:
				printList(studentenliste);
				userInput();
				break;
			case 3:
				do {
					System.out.println("Choose student");
					printList(studentenliste);
					choice = scanner.nextInt();
				} while (choice < 1 || choice > studentenliste.size());
				// welchen kurs soll er wählen?
				studentenliste.get(choice - 1).addFach();

				userInput();
				break;
			case 4:

				/**
				 * Frage User nach welchem Studiengang gesucht werden soll via
				 * enum_Studiengang.getList() User scuht via Scanner aus und
				 * studentenliste wird einmal durchgelaufen und wenn treffer,
				 * dann auf Konsole.
				 */

				do {
					System.out.println("Nach welchem Studiengang soll gelistet werden?");
					enum_Studiengang.printStudiengangList();
					choice = scanner.nextInt();

				} while (choice < 1 || choice > enum_Studiengang.getList().size());

				String studiengang = enum_Studiengang.getList().get(choice - 1).toString();

				printStudentsWithSpecificCourse(studiengang);

				break;
			}
		} while (choice < 0 || choice > 3);
	}

	/**
	 * prints all students with the given course of studies
	 * 
	 * @param searchTerm
	 */
	private void printStudentsWithSpecificCourse(String searchTerm) {

		for (Student s : this.studentenliste) {
			for (int i = 0; i < s.getFaecher_list().size(); i++) {
				if (s.getFaecher_list().get(i).getStudiengang().name().contentEquals(searchTerm)) {
					System.out.println(s.toString());
				}
			}
		}

	}

}
