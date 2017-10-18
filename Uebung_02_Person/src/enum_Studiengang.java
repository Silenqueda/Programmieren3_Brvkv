import java.util.ArrayList;
import java.util.List;

public enum enum_Studiengang {

	Angewandte_Informatik, Mathematik, Medieninformatik, Architektur, Geschichtswissenschaften;

	private static List<enum_Studiengang> list = new ArrayList<enum_Studiengang>();

	public static List<enum_Studiengang> getList() {
		return list;
	}

	public static void printStudiengangList() {
		int counter = 1;
		for (enum_Studiengang item : list) {
			System.out.println("[" + counter + "] " + item);
			counter++;
		}
		counter = 1;
	}

	public static void addStudiengangToList() {
		list.add(Angewandte_Informatik);
		list.add(Mathematik);
		list.add(Medieninformatik);
		list.add(Architektur);
		list.add(Geschichtswissenschaften);
	}

}
