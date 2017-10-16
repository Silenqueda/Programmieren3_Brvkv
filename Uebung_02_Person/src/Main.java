import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static List<Student> studentenliste;

	/**
	 * TODO: Fächer eintragen lassen und semniargruppe eintragen lassen
	 *
	 */

	public static void main(String[] args) {

		// Initialisiere ArrayList
		studentenliste = new ArrayList<Student>();

		// alle enums werden in eine Liste gespeichert
		enum_Kursname.addKursToList();

		Main main = new Main();
		main.start();
	}

	private void start() {
		userInput();

		// Liste der Studenten und alle ihren Attributen auf die Konsole
		// schreiben
		// printList(studentenliste);
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
				System.out.println("Choose student");
				do {
					printList(studentenliste);
					choice = scanner.nextInt();
					
					studentenliste.get(choice-1).addFach();
					// welchen kurs soll er wählen?
					
				} while(choice < 0 || choice > studentenliste.size());//Noch abfangen, dass es vom Typ int sein muss!
				userInput();
				break;
			}
		} while (choice < 0 || choice > 3);

	}

}
