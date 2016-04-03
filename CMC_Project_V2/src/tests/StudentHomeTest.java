package tests;

import static org.junit.Assert.*;
import CMC_Classes.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentHomeTest {
	
	School sju = new School("SJU");
	User u;
	DataBaseHome database;

	@Before
	public void setUp() throws Exception {
		u = new User("Conor", "Lorsung", "clorsung", "password", 'A', 'y');
		StudentHome sh = new StudentHome(u, database);
	}

	@Test
	public void testGetUser() {
		Assert.assertTrue("User is u", sh.getUser().equals(u));
	}

	@Test
	public void testEditProfile() {
		sh.editProfile("C-Man", "LastName", "hardPass");
		Assert.assertTrue("u first name is C-Man", u.getFirstName().equals("C-Man"));
		Assert.assertTrue("u last name is LastName", u.getLastName().equals("LastName"));
		Assert.assertTrue("u password is hardPass", u.getPassword().equals("hardPass"));
	}

	@Test
	public void testGetSavedSchools() {
		sh.addSchool(sju);
		Assert.assertTrue("u saved schools is SJU", sh.getSavedSchools().equals(sju));
	}

	@Test
	public void testRemoveSchool() {
		Assert.assertTrue("sh removes school sju", sh.removeSchool(sju));
	}

	@Test
	public void testAddSchool() {
		Assert.assertTrue("u add school is true", sh.addSchool(sju).equals(true));
	}

	@Test
	public void testSearch() {
		Assert.assertTrue("Search yields Adelphi", sh.search("Adelphi").equals(ADELPHI));
	}

	@Test
	public void testGetRecommend() {
		Assert.assertTrue("getRecommend gets the recommended schools", sh.getRecommend().equals(recommend));
	}

	@Test
	public void testGetSearch() {
		Assert.assertTrue("Get search returns top 5 results.", sh.getSearch().equals(top5));
	}

	@Test
	public void testGetSearchID() {
		Assert.assertTrue("Get search ID is -1", sh.getSearchID(5).equals(4));
	}

}
