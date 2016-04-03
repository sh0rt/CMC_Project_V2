package tests;

import static org.junit.Assert.*;
import CMC_Classes.*;
import org.junit.Before;
import org.junit.Test;

public class UserHomeTest {
	private UserHome userhome;
	@Before
	public void setUp() throws Exception {
	  userhome = new UserHome();
	}

	@Test
	public void testLogin() {
		assertTrue("user is logged in", userhome.login("ImadUser", "Edited").getUsername().equals("ImadUser") );
	}
}
