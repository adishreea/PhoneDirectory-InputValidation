public class Person {
	
	//instance variables of Person class
	private int idPerson;
	private String firstName;
	private String middleName;
	private String lastName;
	private String telephone;

	//mutator methods
	public void setidPerson(int idPerson) {
		this.idPerson = idPerson;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	//Accessor methods
	public int getidPerson() {
		return idPerson;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getTelephone() {
		return telephone;
	}

	public String toString() {
		return "Person [First Name: " + firstName + ", Middle Name: " + middleName + ", Last Name: " + lastName
				+ ", Telephone#: " + telephone + "]";
	}
}