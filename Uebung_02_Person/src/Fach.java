
public class Fach {

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

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public enum_Kursname getK_name() {
		return k_name;
	}

	public void setK_name(enum_Kursname k_name) {
		this.k_name = k_name;
	}

	public enum_Studiengang getStudiengang() {
		return studiengang;
	}

	public void setStudiengang(enum_Studiengang studiengang) {
		this.studiengang = studiengang;
	}

	public String toString() {
		String output = "";
		output += "Semester: " + this.semester + System.lineSeparator();
		output += "Studiengang: " + this.studiengang + System.lineSeparator();
		output += "Kurs: " + this.k_name + System.lineSeparator();

		return output;
	}

}
