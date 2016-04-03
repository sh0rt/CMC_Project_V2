package tests;
import CMC_Classes.*;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdminInterfaceTest {
	AdminInterface admin;
	User user;
	DataBaseHome data1;


	@Before
	public void setUp() throws Exception {
		user =  UserHome.Login("ImadUser", "Edited");
		admin = new AdminInterface(user);
		data1 = new DataBaseHome();
		
	}

	@Test
	public void testAdminInterface() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewSchools() {
		ArrayList<School> schools = data1.getSchools();
		String temp = admin.viewSchools();
		for(int i = 0; i < schools.size(); i++) {
			assertTrue("View Schools is not working in AdminInterface", temp.contains(schools.get(i).getSchool()));
		}
	}

	@Test
	public void testEditSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddNewSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewSchoolWithValidID() {
		ArrayList<School> schools = data1.getSchools();
		String school = admin.viewSchool(0);
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(schools.get(0).getSchool()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(schools.get(0).getState()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(schools.get(0).getControl()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(0).getExpenses()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(schools.get(0).getLocation()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(0).getNumApplicants()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(0).getNumStudents()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(0).getPercentAdmitted()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(0).getAcademicScale()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(0).getPercentEnrolled()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(0).getPercentFemale()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(0).getPercentFinAid()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(0).getQualOfLife()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(0).getSatMath()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(0).getSatVerbal()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(0).getSocialscale()));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testViewSchoolWithInvalidID() {
		admin.viewSchool(-3);
	}

	@Test
	public void testAddUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeactivateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewUsers() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewUser() {
		fail("Not yet implemented");
	}

}
