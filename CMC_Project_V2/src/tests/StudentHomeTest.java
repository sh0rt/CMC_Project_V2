package tests;

import static org.junit.Assert.*;
import CMC_Classes.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentHomeTest {
	
	School sju;
	User u;
	StudentHome sh;
	
	@Before
	public void setUp() throws Exception {
		u = new User("Conor", "Lorsung", "clorsung", "password", 'A', 'y');
		sh = new StudentHome(u);
		sju = new School("SJU","Minnesota", "Collegeville","Private", 5000, 20.0, 50.0, 50, 5000 , 20.0, 200, .45, .30, 2, 3, 4);
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
		assertTrue("u saved schools is SJU", sh.getSavedSchools().get(0).getName().equals("SJU"));
	}

	@Test
	public void testRemoveSchool() {
		sh.addSchool(sju);
		assertTrue("sh removes school sju", sh.removeSchool(sju).getName().equals("SJU"));
	}

	@Test
	public void testAddSchool() {
		assertTrue("u add school is true", sh.addSchool(sju).getName().equals("SJU"));
	}

	@Test
	public void testSearch() {
		//System.out.println(sh.search("ARIZONA",null,null,null,null,null,null,null,null,null
		//		,null,null,null,null,null,null,null)[0].getName());
		assertTrue("Search yields Adelphi", sh.search("ARIZONA",null,null,null,null,null,null,null,null,null
				,null,null,null,null,null,null,null)[0].getName().contains("ARIZONA STATE"));
	}

	@Test
	public void testGetRecommend() {
		sh.search("a", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		assertTrue("getRecommend gets the recommended schools", sh.getRecommend()[0].getName().contains("University of Minnesota"));
	}

	@Test
	public void testGetSearch() {
		sh.search( null, "MINNESOTA", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null)[0].getName();
		assertTrue("Get search returns top 5 results.", sh.getSearch()[0].getName().equals("AUGSBURG"));
	}

	@Test
	public void testGetSearchID() {
		assertTrue("Get search ID is -1", sh.getSearchID(1) == 0);
	}

}
