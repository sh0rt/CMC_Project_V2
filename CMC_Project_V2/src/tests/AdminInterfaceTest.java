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
		User =  Userhome.Login("ImadUser", "Edited");
		admin = new AdminInterface();
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
		School school = admin.getSchools().get(ID);
		String temp = admin.viewSchool();
		assertTrue("Valid ID school is not working in viewSchool()", temp.contains(school.getName()&&school.getState()&&school.getControl()&&school.getEmphasis()
				&&school.getExpenses()&&school.getLocation()&&school.getNumApplicants()&&school.getNumStudents()&&school.getPercentAdmitted()&&school.getAcademicScale()
				&&school.getPercentEnrolled()&&school.getPercentFemale()&&school.getPercentFinAid()&&school.getQualOfLife()&&school.getSatMath()&&school.getSatVerbal()
				&&school.getSocialscale()));
	}
	
	@Test
	public void testViewSchoolWithInvalidID() {
		School school = admin.getSchools().get(ID);
		String temp =  admin.viewSchool(ID);
		assertTrue("Invalid ID school is not working in viewSchool()", temp.contains())
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
