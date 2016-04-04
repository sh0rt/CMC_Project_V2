package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import CMC_Classes.*;

public class AdminHomeTest {

	User u;
	AdminHome ah;
	School s;
	@Before
	public void init() {
		u = new User("Admin", "Adminingston", "a", "password", 'A', 'A');
		ah = new AdminHome(u);
		s = new School("Creative", "MN", null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	@Test
	public void testGetSchools() {
		Assert.assertTrue("Name of school 2 is ADELPHI",
				ah.getSchools().get(2).getName().equals("ADELPHI"));
		Assert.assertTrue("Name of school 104 is ST JOHNS UNIVERSITY", 
				ah.getSchools().get(104).getName().equals("ST JOHNS UNIVERSITY"));
		Assert.assertTrue("Name of school 180 is YANKTOWN COLLEGE", 
				ah.getSchools().get(180).getName().equals("YANKTOWN COLLEGE"));
	}

	@Test
	public void testGetUsers() {
		Assert.assertTrue("Name of user 1 is John User",ah.getUsers().get(1).getFirstName().equals("John"));
		Assert.assertTrue("Name of user 2 is Lynn", ah.getUsers().get(2).getFirstName().equals("Lynn"));
	}
	
	@Test
	public void testEditSchool() {
		//???
	}
	
	@Test
	public void testAddNewSchool() {
		
	}
	
}
