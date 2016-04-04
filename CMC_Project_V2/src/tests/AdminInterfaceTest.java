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
	public void testViewSchoolInvalidIDNegative() {
		admin.viewSchool(-3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testViewSchoolInvalidIDZero() {
		admin.viewSchool(0);
	}

	@Test
	public void testAddUser() {
		fail("Not yet implemented");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddUserInvalidFirstName() {
		admin.addUser("", "Rahal", "ImadUser", "Edited", 'u');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddUserInvalidLastName() {
		admin.addUser("Imad", "", "ImadUser", "Edited", 'u');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddUserInvalidUsername() {
		admin.addUser("Imad", "Rahal", "", "Edited", 'u');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddUserInvalidPassword() {
		admin.addUser("Imad", "Rahal", "ImadUser", "", 'u');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddUserInvalidType() {
		admin.addUser("Imad", "Rahal", "ImadUser", "Edited", ' ');
	}

	@Test
	public void testEditUser() {
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserInvalidFirstName() {
		admin.editUser("", "Rahal", "ImadUser", "Edited", 'u', 'Y');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserInvalidLastName() {
		admin.editUser("Imad", "", "ImadUser", "Edited", 'u', 'Y');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserInvalidUsername() {
		admin.editUser("Imad", "Rahal", "", "Edited", 'u', 'Y');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserInvalidPassword() {
		admin.editUser("Imad", "Rahal", "ImadUser", "", 'u', 'Y');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserInvalidType() {
		admin.editUser("Imad", "Rahal", "ImadUser", "Edited", ' ', 'Y');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserInvalidStatus() {
		admin.editUser("Imad", "Rahal", "ImadUser", "Edited", 'u', ' ');
	}


	@Test
	public void testDeactivateUser() {
		fail("Not yet implemented");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testDeactivateUserInvalidIDNegative() {
		admin.deactivateUser(-3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testDeactivateUserInvalidIDZero() {
		admin.deactivateUser(0);
	}

	@Test
	public void testViewUsers() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewUser() {
		fail("Not yet implemented");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testViewUserInvalidIDNegative() {
		admin.viewUser(-3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testViewUserInvalidIDZero() {
		admin.viewUser(0);
	}

}
