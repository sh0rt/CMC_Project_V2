package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import CMC_Classes.*;
public class UserInterfaceTest {
	UserInterface user;
	User user2;
	UserHome home;
	
	@Before
	public void setUp() throws Exception {
		user = new UserInterface();
	//ImadUser edited, 
		home = new UserHome();
		user2 = UserHome.Login("ImadUser", "Edited");
	}
//-----------------------------------------------------------------login--------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testLoginSuccess() {
		assertTrue("Login returned the incorrect user.",user.login("ImadUser", "Edited").equals(user2));
	}
	@Test
	public void testIncorrectLoginUsername() {
		assertTrue("Login returned a user that is was not supposed to (incorrect username).",user.login("Megan", "Edited").equals(null));
	}
	@Test
	public void testIncorrectLoginPassword() {
		assertTrue("Login returned a user that is was not supposed to (incorrect password).",user.login("ImadUser", "CMC").equals(null));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyLoginUsername() {
		user.login("", "Megan1");
	}
	
}
