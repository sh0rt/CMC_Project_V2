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
	public void testViewSchools() {
		ArrayList<School> schools = data1.getSchools();
		String temp = admin.viewSchools();
		for(int i = 0; i < schools.size(); i++) {
			assertTrue("View Schools is not working in AdminInterface", temp.contains(schools.get(i).getSchool()));
		}
	}

	@Test
	public void testViewSchoolWithValidID() {
		ArrayList<School> schools = data1.getSchools();
		String school = admin.viewSchool(1);
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(schools.get(1).getSchool()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(schools.get(1).getState()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(schools.get(1).getControl()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(1).getExpenses()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(schools.get(1).getLocation()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(1).getNumApplicants()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(1).getNumStudents()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(1).getPercentAdmitted()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(1).getAcademicScale()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(1).getPercentEnrolled()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(1).getPercentFemale()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(1).getPercentFinAid()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(1).getQualOfLife()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(1).getSatMath()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(1).getSatVerbal()));
		assertTrue("Valid ID school is not working in viewSchool()", school.contains(""+schools.get(1).getSocialscale()));
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
		assertTrue("add user passed",admin.addUser("Tyler", "weiss", "is", "cool", 'a').equals("Successfuly added Tyler to the system."));
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
		assertTrue("add user passed",admin.editUser("Tyler", "weiss", "is", "cool", 'a','a').equals("Succesfully made changes to Tyler."));
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
		assertTrue("deactivate user failed",admin.deactivateUser(1).equals("Succesfully deactivated John."));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testDeactivateUserInvalidIDNegative() {
		admin.deactivateUser(-3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testDeactivateUserInvalidIDZero() {
		admin.deactivateUser(0);
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
