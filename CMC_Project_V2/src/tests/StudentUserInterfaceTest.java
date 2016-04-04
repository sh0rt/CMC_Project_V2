package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import CMC_Classes.*;

public class StudentUserInterfaceTest {

	StudentUI sh;
	User u = new User("Joe", "Schmoe", "js", "password", 'U', 'a');
	School s = new School("Adelphi", null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	
	@Before
	public void init() {
		u.addSchool(s);
		sh = new StudentUI(u);
		sh.search("a", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
	}

	@Test
	public void testViewProfile() {
		Assert.assertTrue("View Profile of sh contains Joe Schmoe, js, password, Student, and active.",
				sh.viewProfile().contains("Joe") && sh.viewProfile().contains("Schmoe") &&
				sh.viewProfile().contains("js") && sh.viewProfile().contains("password") &&
				sh.viewProfile().contains("Student") && sh.viewProfile().contains("Active"));
	}
	
	@Test
	public void testEditProfile() {
		sh.editProfile("Joe", "Schmoe Jr.", "password");
		Assert.assertTrue("Edit profile of Joe Schmoe to Joe Schmoe Jr.", sh.viewProfile().contains("Schmoe Jr."));
	}
	
	@Test
	public void testViewSavedSchools() {
		//??? Waiting on DB
	}
	
	@Test
	public void testRemoveSchool() {
		//??? Waiting on DB
	}
	
	@Test
	public void testRecommendations() {
		//???
	}
	
	@Test
	public void testSearch() {
		Assert.assertTrue("Search yields Saint John's", sh.search("a",null,null,null,null,null,null,null,null,null
				,null,null,null,null,null,null,null).contains("University of Minnesota"));
	}
	
	@Test
	public void testViewExpandedSchool() {
		sh.viewExpandedSchool(0);
	}
	
	@Test
	public void testSaveSchool() {
		Assert.assertTrue("Save School contains University of Minnesota", sh.saveSchool(0).contains("University of Minnesota"));
	}
}
