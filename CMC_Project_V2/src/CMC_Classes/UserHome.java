package CMC_Classes;
/** UserHome
 * @authors Megan Pekarek, Cassie Meyer, Tyler Weiss, Conor Lorsung
 * @version March 15th, 2016
 */


/**
 * Constructor for User Home
 */
public class UserHome {

	private DataBaseHome database;

	/**
	 * Database of users
	 * 
	 * @param database
	 */
	public UserHome(DataBaseHome database) {
		this.database = database;
	}
	
	public UserHome() {
		this.database = new DataBaseHome();
	}
	/**
	 * Logs user on with parameters
	 * 
	 * @param username,
	 *            password
	 * @return successful login
	 */
	public User login(String username, String password) {
		return database.login(username, password);
	}
	/**
	 * Logs user on with parameters
	 * 
	 * @param username,
	 *            password
	 * @return successful login
	 */
	public static User Login(String username, String password) {
		DataBaseHome db = new DataBaseHome();
		return db.login(username, password);
	}
}
