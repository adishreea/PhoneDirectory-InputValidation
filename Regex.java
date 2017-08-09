
public class Regex {
	public static final String p1 = "[A-Z]{1}+[a-z]{1,}"; // for first name, middle name and last name
	public static final String mn1 = "[A-Z]{1}+\\.";	//for middle initial
	public static final String ln1 = "[A-Z]{1}[a-z]{0,}+\\'{0,1}" + p1 + "\\-" + p1; //for last names with ' and -
	public static final String ln2 = "[A-Z]{1}+\\'" + p1; 
	public static final String p2 = "^" + p1 + "\\s(" + ln1 + "||" + p1 + ")$";
	public static final String p3 = "^(" + ln1 + "||" + p1 + ")+,+\\s" + p1 + "$";
	public static final String p4 = "^(" + ln1 + "||" + p1 + ")+,+\\s+" + p1 + "\\s+(" + p1 + "||" + mn1 + ")$";
	public static final String p5 = "^(" + ln2 + "||" + p1 + ")+,+\\s+" + p1 + "\\s+(" + p1 + "||" + mn1 + ")$";

	public static final String t1 = "^[0-9]{5}$";
	public static final String t2 = "^[0-9]{3}+\\-{1}+[0-9]{4}$";
	public static final String t3 = "^\\+{0,1}+[0-9]{0,3}+\\({1}+[1-9]{1}+[0-9]{2}+\\){1}+[0-9]{3}+\\-{1}+[0-9]{4}$";
	public static final String t4 = "^\\+{1}+[0-9]{1,3}+\\s+\\({1}+[0-9]{2}+\\){1}+\\s+[0-9]{3}+\\-{1}+[0-9]{4}$";
	public static final String t5 = "^[0-9]{5}+\\.+[0-9]{5}$";
	public static final String t6 = "^[0-9]{3}+\\s+[0-9]{1}+\\s+[0-9]{3}+\\s+[0-9]{3}+\\s+[0-9]{4}$";
	public static final String t7 = "^[0-9]{3}+\\s+[0-9]{3}+\\s+[0-9]{3}+\\s+[0-9]{4}$";

	public boolean validateName(String name) {
		if (name.matches(p1) || name.matches(p2) || name.matches(p3) || name.matches(p4) || name.matches(p5)) {
			// matches the format of a person's name
			return true;
		} else {
			return false;
		}
	}

	public String[] getName(String name) {
		String names[];
		if (name.matches(p2)) {
			names = name.split("\\s");
		} else if (name.matches(p3) || name.matches(p4) || name.matches(p5)) {
			names = name.split(",\\s|\\s");
		} else if (name.matches(p1)) {
			names = name.split("\\s");
		} else {
			names = new String[0];
		}
		String temp[] = new String[names.length];

		if (names.length == 1 || names.length == 2) {
			temp = names;
		} else if (names.length == 3) {
			temp[0] = names[1];
			temp[1] = names[0];
			temp[2] = names[2];
		} else {
			temp = null;
		}
		return temp;
	}

	public boolean validateNumber(String name) {
		if (name.matches(t1) || name.matches(t2) || name.matches(t3) || name.matches(t4) || name.matches(t5)
				|| name.matches(t6) || name.matches(t7)) {
			// matches the format of a person's telephone number
			return true;
		} else {
			return false;
		}
	}
}
