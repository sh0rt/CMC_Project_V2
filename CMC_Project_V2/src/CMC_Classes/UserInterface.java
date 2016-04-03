package CMC_Classes;
/** UserInterface
 * @authors Megan Pekarek, Cassie Meyer, Tyler Weiss, Conor Lorsung
 * @version March 15th, 2016
 */

/**
 * Constructs User Interface
 *
 */
public class UserInterface {
	UserHome user;
	public static final User INCORRECT = new User("x", "x", "x", "x", 'x', 'x');

	public UserInterface() {
		user = new UserHome();
	}

	/**
	 * 
	 * @param username,
	 *            password
	 * @return user login or incorrect if username/password are not recognized
	 */
	public User login(String username, String password) {
		if (user.login(username, password) != null)
			return user.login(username, password);
		else
			return INCORRECT;
	}

}
