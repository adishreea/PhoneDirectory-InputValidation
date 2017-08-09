
public class MainProgram {

	public static void main(String[] args) {
		Regex r = new Regex();
		// Testing all the acceptable cases
		String names[] = { "Bruce Schneier", "Schneier, Bruce", "Schneier, Bruce Wayne", "O'Malley, John F.",
				"John O'Malley-Smith", "Cher" };
		String numbers[] = { "12345", "(703)111-2121", "123-1234", "+1(703)111-2121", "+32 (21) 212-2324",
				"1(703)123-1234", "011 701 111 1234", "12345.12345", "011 1 703 111 1234" };

		System.out.println("Validating Numbers");
		for (String num : numbers) {
			String message = r.validateNumber(num) ? "PASSED" : "FAILED";
			System.out.println(message + " -> " + num);
		}

		System.out.println("Validating Names");
		for (String name : names) {
			String message = r.validateName(name) ? "PASSED" : "FAILED";
			System.out.println(message + " -> " + name);
		}

		String invalidNames[] = { "Ron O’’Henry", "Ron O’Henry-Smith-Barnes", "L33t Hacker",
				"<Script>alert(“XSS”)</Script>", "Brad Everett Samuel Smith", "select * from users;" };
		System.out.println("Testing invalid names");
		for (String name : invalidNames) {
			String message = r.validateName(name) ? "PASSED" : "FAILED";
			System.out.println(message + " -> " + name);
		}

		String invalidNumbers[] = { "123", "1/703/123/1234", "Nr 102-123-1234", "<script>alert(“XSS”)</script>",
				"7031111234", "+1234 (201) 123-1234", "(001) 123-1234", "+01 (703) 123-1234",
				"(703) 123-1234 ext 204" };
		System.out.println("Testing invalid numbers");
		for (String num : invalidNumbers) {
			String message = r.validateNumber(num) ? "PASSED" : "FAILED";
			System.out.println(message + " -> " + num);
		}

	}
}
