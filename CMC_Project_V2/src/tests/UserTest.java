package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import CMC_Classes.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
public class UserTest {

	User user1, user2, user3;
	School sju;
	ArrayList<School> schools = new ArrayList<School>();

	@Before
	public void setUp() throws Exception {
		user1 = new User("Conor", "Lorsung", "clorsung", "password", 'A', 'y');
		user2 = new User("TheOther", "C-Lo", "another", "one", 'U', 'n');
		user3 = new User("Jeff", "Bullhorn", "jb", "password", 'A', 'y');
		sju = new School("Saint John's University", null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	
	@Test
	public void testGetUsername() {
		Assert.assertTrue("Get username for user1 is not working", user1.getUsername().equals("clorsung"));
		Assert.assertTrue("Get username for user2 is not working", user2.getUsername().equals("another"));
		Assert.assertTrue("Get username for user3 is not working", user3.getUsername().equals("jb"));	
	}
	
	@Test
	public void testSetUsername() {
		Assert.assertTrue("Username of user1 is not working", user1.getUsername().equals("clorsung"));
		user1.setUsername("Megan");
		Assert.assertTrue("Username of user1 is not working after new set", user1.getUsername().equals("Megan"));
		user1.setUsername("clorsung");
	}

	@Test
	public void testGetFirstName() {
		Assert.assertTrue("First name of user1 is Conor", user1.getFirstName().equals("Conor"));
		Assert.assertTrue("First name of user2 is TheOther", user2.getFirstName().equals("TheOther"));
		Assert.assertTrue("First name of user3 is Jeff", user3.getFirstName().equals("Jeff"));
	}

	@Test
	public void testSetVars() {
		Assert.assertTrue("First name of user1 is Conor", user1.getFirstName().equals("Conor"));
		user1.setVars("C-man", "Lorsung", "clorsung", "password", 'A', 'y');
		Assert.assertTrue("First name of user1 is C-man", user1.getFirstName().equals("C-man"));
	}

	@Test
	public void testGetType() {
		Assert.assertTrue("Type of user1 is A", user1.getType() == 'A');
		Assert.assertTrue("Type of user2 is U", user2.getType() == 'U');
		Assert.assertTrue("Type of user3 is A", user3.getType() == 'A');
	}

	@Test
	public void testSetType() {
		Assert.assertTrue("Type of user1 is A", user1.getType() == 'A');
		user1.setType('U');
		Assert.assertTrue("Type of user1 is U", user1.getType() == 'U');
		user1.setType('A');
	}

	@Test
	public void testSetFirstName() {
		Assert.assertTrue("First name of user2 is TheOther", user2.getFirstName().equals("TheOther"));
		user2.setFirstName("TheOnly");
		Assert.assertTrue("First name of user2 is TheOnly", user2.getFirstName().equals("TheOnly"));
	}

	@Test
	public void testGetLastName() {
		Assert.assertTrue("Last name of user3 is Bullhorn", user3.getLastName().equals("Bullhorn"));
	}

	@Test
	public void testSetLastName() {
		Assert.assertTrue("Last name of user3 is Bullhorn", user3.getLastName().equals("Bullhorn"));
		user3.setLastName("Foghorn");
		Assert.assertTrue("Last name of user3 is Foghorn", user3.getLastName().equals("Foghorn"));
	}

	@Test
	public void testGetStatus() {
		Assert.assertTrue("Type of user3 is y", user3.getStatus() == 'y');
		Assert.assertTrue("Type of user2 is n", user2.getStatus() == 'n');
	}

	@Test
	public void testSetStatus() {
		Assert.assertTrue("Type of user2 is n", user2.getStatus() == 'n');
		user2.setStatus('y');
		Assert.assertTrue("Type of user2 is y", user2.getStatus() == 'y');
	}

	@Test
	public void testGetPassword() {
		Assert.assertTrue("Password for user1 is password", user1.getPassword().equals("password"));
	}

	@Test
	public void testSetPassword() {
		Assert.assertTrue("Password for user1 is password", user1.getPassword().equals("password"));
		user1.setPassword("drowssap");
		Assert.assertTrue("Password for user1 is drowssap", user1.getPassword().equals("drowssap"));
		user1.setPassword("password");
	}

	@Test
	public void testSetSchools() {
		Assert.assertTrue("School added to schools.", user1.addSchool(sju));
	}
	
	@Test
	public void testGetSchools() {
		user1.addSchool(sju);
		Assert.assertTrue("Get School returns Saint John's University.", user1.getSchools().get(0).getName().contains
				("Saint John's"));
		//try{
		//user1.getSchools().get(0);
		//fail("getSchools failed");
		//}catch(IndexOutOfBoundsException ex){
			
		//}

	}

	@Test
	public void testGetID() {
		Assert.assertTrue("user1 ID is working", user1.getID() < user2.getID() && user2.getID() < user3.getID());

	}
}
