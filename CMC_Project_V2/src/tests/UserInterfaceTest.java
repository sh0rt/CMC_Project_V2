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
		assertTrue("Login returned the incorrect user.",user.login("ImadUser", "Edited").getFirstName().equals(user2.getFirstName()));
	}
	@Test
	public void testIncorrectLoginUsername() {
			assertTrue("incorrect username failed",user.login("Megan", "Edited").getFirstName().equals("x"));
	}
	@Test
	public void testIncorrectLoginPassword() {
		assertTrue("incorrect username failed",user.login("ImadUser", "Wrong!!").getFirstName().equals("x"));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyLoginUsername() {
		user.login("", "Megan1");
	}
	
}
