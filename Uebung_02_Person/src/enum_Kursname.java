import java.util.ArrayList;
import java.util.List;

public enum enum_Kursname {

	Webentwicklung, Statik, Programmieren, Mathematik, Mobile_Anwendungen;

	private static List<enum_Kursname> list = new ArrayList<enum_Kursname>();

	public static void printKursList() {
		int counter = 1;
		for (enum_Kursname item : list) {
			System.out.println("[" + counter + "] " + item);
			counter++;
		}
		counter = 1;
	}

	public static List<enum_Kursname> getList() {
		return list;
	}

	public static void addKursToList() {
		list.add(Webentwicklung);
		list.add(Statik);
		list.add(Programmieren);
		list.add(Mathematik);
		list.add(Mobile_Anwendungen);
	}
}
