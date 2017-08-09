import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommandArg {

	ConnectMySQLJava dao = null;

	public CommandArg() {
		dao = new ConnectMySQLJava();
	}

	public boolean addPerson(String args[]) {
		Connection con = null;
		try {
			PreparedStatement ps = null;
			con = dao.createConnection();
			Regex r = new Regex();
			String query = "INSERT INTO person(firstName, lastName, middleName, telephone) VALUES (?, ?, ?, ?)";
			if (r.validateName(args[1]) && r.validateNumber(args[2])) {
				String name[] = { "", "", "" };
				int i = 0;
				String temp[] = r.getName(args[1]);
				if (temp != null) {
					for (String x : temp) {
						name[i] = x;
						i++;
					}
				} else {
					return false;
				}
				ps = con.prepareStatement(query);
				ps.setString(1, name[0]);
				ps.setString(2, name[1]);
				ps.setString(3, name[2]);
				ps.setString(4, args[2]);
				return ps.executeUpdate() == 1 ? true : false;
			} else {
				System.out.println("Invalid data!");
				return false;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		} finally {
			dao.close(con);
		}
	}

	public boolean deletePerson(String value) {
		Connection con = null;
		try {
			Regex r = new Regex();
			PreparedStatement st = null;
			String query = "";
			if (r.validateName(value)) {
				query = "DELETE FROM person WHERE firstName=?";
				value = r.getName(value)[0];
			} else if (r.validateNumber(value)) {
				query = "DELETE FROM person WHERE telephone=?";
			} else {
				return false;
			}
			con = dao.createConnection();
			st = con.prepareStatement(query);
			st.setString(1, value);
			return st.executeUpdate() == 1 ? true : false;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		} finally {
			dao.close(con);
		}
	}

	public void listPeople() {
		Connection con = null;
		try {
			ResultSet rs = null;
			Statement st = null;
			Person p = null;
			List<Person> list = new ArrayList<>();
			String query = "SELECT firstName, middleName, lastName, telephone FROM person";
			con = dao.createConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				p = new Person();
				p.setFirstName(rs.getString("firstName"));
				p.setMiddleName(rs.getString("middleName"));
				p.setLastName(rs.getString("lastName"));
				p.setTelephone(rs.getString("telephone"));
				list.add(p);
			}
			for (Person pl : list) {
				System.out.println(pl.toString());
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			dao.close(con);
		}
	}

	public static void main(String[] args) {
		String mode = args[0];
		CommandArg ca = new CommandArg();
		String message = "";
		if (mode.equals("ADD")) {
			message = ca.addPerson(args) ? "Exit code: 0" : "Exit code: 1";
		} else if (mode.equals("DEL")) {
			message = ca.deletePerson(args[1]) ? "Exit code: 0" : "Exit code: 1";
		} else if (mode.equals("LIST")) {
			ca.listPeople();
		} else {
			System.err.println("Invalid argument");
		}
		System.out.println(message);
	}

}
