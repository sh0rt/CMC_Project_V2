package CMC_Classes;
import java.util.*;

/**
 * User class
 * 
 * @author Tyler, Megan, Cassie, Connor
 * @verson 3/10/16
 *
 */
public class User {
	/**
	 * @idCount counts up one for each user
	 * @id specific user id
	 * @firstName user first name
	 * @lastName user last name
	 * @username users username
	 * @password users password
	 * @schools list of schools
	 * @type users type
	 * @status users status
	 */
	private static int idCount;
	public final int id;
	private String firstName, lastName, username, password;
	private ArrayList<School> schools;
	char type;
	char status;

	/**
	 * @param firstName
	 *            users first name
	 * @param lastName
	 *            users last name
	 * @param username
	 *            users username
	 * @param password
	 *            users password
	 * @param type
	 *            users type
	 * @param status
	 *            users status
	 * @param schools
	 *            an array list of users saved schools
	 */
	public User(String firstName, String lastName, String username, String password, char type, char status) {
		id = idCount++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.type = type;
		this.status = status;
		schools = new ArrayList<School>();
	}

	/**
	 * 
	 * @param firstName
	 *            is users first name
	 * @param lastName
	 *            is users last name
	 * @param username
	 *            is users username
	 * @param password
	 *            is users password
	 * @param type
	 *            is users type
	 * @param status
	 *            is users status
	 * @param schools
	 *            is users schools
	 */
	public void setVars(String firstName, String lastName, String username, String password, char type, char status) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	/**
	 * gets user type
	 * 
	 * @return users type
	 */
	public char getType() {
		return type;
	}

	/**
	 * sets users type
	 * 
	 * @param type
	 *            is users type
	 */
	public void setType(char type) {
		this.type = type;
	}

	/**
	 * gets users first name
	 * 
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * sets users first name
	 * 
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * gets users last name
	 * 
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * sets users status
	 * 
	 * @param status
	 *            is users status
	 */
	public void setStatus(char status) {
		this.status = status;
	}

	/**
	 * gets users status
	 * 
	 * @return users status
	 */
	public char getStatus() {
		return this.status;
	}

	/**
	 * sets users last name
	 * 
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * gets the username
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * sets the username
	 * 
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * gets the users password
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * sets the users password
	 * 
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * gets the users schools
	 * 
	 * @return the schools
	 */
	public ArrayList<School> getSchools() {
		return this.schools;
	}

	/**
	 * gets users saved schools
	 * 
	 * @param pointless
	 *            needed param
	 * @return array list of schools
	 */
	public ArrayList<School> getSchools(int pointless) {
		ArrayList<School> school = new ArrayList<School>();
		for (int i = 0; i < schools.size(); i++) {
			school.add(schools.get(i));
		}
		return schools;
	}

	/**
	 * sets users schools
	 * 
	 * @param schools
	 *            the schools to set
	 */
	public boolean setSchools(ArrayList<School> schools) {
		if(this.schools == schools)
			return true;
		else
			return false;
	}
	
	public boolean addSchool(School school){
		this.schools.add(school);
		return true;
	}
	

	/**
	 * gets user id
	 * 
	 * @return the id of the user
	 */
	public int getID() {
		return this.id;
	}


	/**
	 * gets users saved schools
	 * 
	 * @return null
	 */
	public ArrayList<School> getSavedSchools() {
		return schools;
	}
}
