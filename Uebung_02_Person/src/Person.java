import java.util.Scanner;

public class Person {
	private Scanner scanner = new Scanner(System.in);

	private String name;
	private String v_name;
	private String geb_date;

	public Person() {
		this.name = addName();
		this.v_name = addV_Name();
		this.geb_date = addB_Date();
	}

	private String addName() {
		System.out.println("Enter your surname:");
		return scanner.next();
	}

	private String addV_Name() {
		System.out.println("Enter your name:");
		return scanner.next();
	}

	private String addB_Date() {
		System.out.println("Enter your date of birth:");
		return scanner.next();
	}

	public String toString() {
		String output = "";
		output += "Name: " + this.name + System.lineSeparator();
		output += "Vorname: " + this.v_name + System.lineSeparator();
		output += "Geburtsdatum: " + this.geb_date + System.lineSeparator();
		return output;
	}

}
