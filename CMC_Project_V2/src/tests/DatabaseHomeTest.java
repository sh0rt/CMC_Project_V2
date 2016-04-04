package tests;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;
import org.junit.Before;
import org.junit.Test;
import CMC_Classes.*;

public class DatabaseHomeTest {
	DataBaseHome database;
	User user1, user2, user3, enduser, frontUser;
	School school1, school2, school3;
	String[] emphasis;
	@Before
	public void setUp() throws Exception {
		database = new DataBaseHome();
		emphasis = new String[2];
		user1 = new User("Tyler", "Weiss", "tnweiss", "weiss", 'a','a');
		user2 = new User("T-$", "Weiss", "ball", "isLife", 'a','a');
		user3 = new User("T-Buckets", "Weiss", "get", "money", 'a','a');
		enduser = new User("end", "user","zzz", "yyy", 'a', 'a');
		frontUser = new User("front", "user","aaa", "bbb", 'a', 'a');
		/*
		database.addUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(), 
				user1.getPassword(), user1.getType());
		database.addUser(user2.getFirstName(), user2.getLastName(), user2.getUsername(), 
				user2.getPassword(), user2.getType());
		database.addUser(user3.getFirstName(), user3.getLastName(), user3.getUsername(), 
				user3.getPassword(), user3.getType());
				*/
		school1 = new School("Saint Johns University test","Minnesota", "SMALL-CITY", "PRIVATE", 5000, .5, 20,30,5000.0,.3,1000,.5,.3,4,3,5);
		school2 = new School("University of Minnesota Duluth test","Minnesota", "UNKNOWN", "STATE", 50000, .7, 20,30,5000.0,.3,1000,.5,.3,4,3,5);
		school3 = new School("zzzUniversity of Minnesota test","Minnesota", "URBAN", "UNKNOWN", 500000, .45, 20,30,5000.0,.3,1000,.5,.3,4,3,5);
		//String[] emphasis = new String[3];
		try{
		database.addSchool(school2.getSchool(),school2.getState(),school2.getLocation(),
				school2.getControl(),school2.getNumStudents(),school2.getPercentFemale(),
			    school2.getSatVerbal(),school2.getSatMath(),school2.getExpenses(),
				school2.getPercentFinAid(),school2.getNumApplicants(),school2.getPercentAdmitted(),
				school2.getPercentEnrolled(),school2.getAcademicScale(),school2.getSocialscale(),
				school2.getQualOfLife());
		database.addSchool(school3.getSchool(),school3.getState(),school3.getLocation(),
				school3.getControl(),school3.getNumStudents(),school3.getPercentFemale(),
			    school3.getSatVerbal(),school3.getSatMath(),school3.getExpenses(),
				school3.getPercentFinAid(),school3.getNumApplicants(),school3.getPercentAdmitted(),
				school3.getPercentEnrolled(),school3.getAcademicScale(),school3.getSocialscale(),
				school3.getQualOfLife());
		database.addUser(user2.getFirstName(), user2.getLastName(), user2.getUsername(), user2.getPassword(), user2.getType());
		database.addUser(user3.getFirstName(), user3.getLastName(), user3.getUsername(), user3.getPassword(), user3.getType());
		database.addUser(enduser.getFirstName(), enduser.getLastName(), enduser.getUsername(), enduser.getPassword(), enduser.getType());
		database.addUser(frontUser.getFirstName(), frontUser.getLastName(), frontUser.getUsername(), frontUser.getPassword(), frontUser.getType());
		}catch(IllegalArgumentException ex){
			try{
				database.addSchool(school3.getSchool(),school3.getState(),school3.getLocation(),
						school3.getControl(),school3.getNumStudents(),school3.getPercentFemale(),
					    school3.getSatVerbal(),school3.getSatMath(),school3.getExpenses(),
						school3.getPercentFinAid(),school3.getNumApplicants(),school3.getPercentAdmitted(),
						school3.getPercentEnrolled(),school3.getAcademicScale(),school3.getSocialscale(),
						school3.getQualOfLife());
				database.addUser(user2.getFirstName(), user2.getLastName(), user2.getUsername(), user2.getPassword(), user2.getType());
				database.addUser(user3.getFirstName(), user3.getLastName(), user3.getUsername(), user3.getPassword(), user3.getType());
				database.addUser(enduser.getFirstName(), enduser.getLastName(), enduser.getUsername(), enduser.getPassword(), enduser.getType());
				database.addUser(frontUser.getFirstName(), frontUser.getLastName(), frontUser.getUsername(), frontUser.getPassword(), frontUser.getType());
				}catch(IllegalArgumentException ex1){
					try{
						database.addUser(user2.getFirstName(), user2.getLastName(), user2.getUsername(), user2.getPassword(), user2.getType());
						database.addUser(user3.getFirstName(), user3.getLastName(), user3.getUsername(), user3.getPassword(), user3.getType());
						database.addUser(enduser.getFirstName(), enduser.getLastName(), enduser.getUsername(), enduser.getPassword(), enduser.getType());
						database.addUser(frontUser.getFirstName(), frontUser.getLastName(), frontUser.getUsername(), frontUser.getPassword(), frontUser.getType());
						}catch(IllegalArgumentException ex2){
							try{
								database.addUser(user3.getFirstName(), user3.getLastName(), user3.getUsername(), user3.getPassword(), user3.getType());
								database.addUser(enduser.getFirstName(), enduser.getLastName(), enduser.getUsername(), enduser.getPassword(), enduser.getType());
								database.addUser(frontUser.getFirstName(), frontUser.getLastName(), frontUser.getUsername(), frontUser.getPassword(), frontUser.getType());
								}catch(IllegalArgumentException ex3){
									try{
								    database.addUser(enduser.getFirstName(), enduser.getLastName(), enduser.getUsername(), enduser.getPassword(), enduser.getType());
									database.addUser(frontUser.getFirstName(), frontUser.getLastName(), frontUser.getUsername(), frontUser.getPassword(), frontUser.getType());
									}catch(IllegalArgumentException ex4){
									
								}
						    }
						}
				}
		}
	}
	//String school, String state, String location, String control, int numStudents,
	//double percentFemale, int satVerbal, int satMath, double expenses, double percentFinAid, int numApplicants,
	//double percentAdmitted, double percentEnrolled, int academicScale, int socialScale, int qualOflife
	//----------------------------------------------------Login----------------------------------------------------------
	@Test
	public void testLoginSuccess() {
		assertTrue("Login returned the incorrect username.",database.login("ball", "isLife").getUsername().equals(user2.getUsername()));
		assertTrue("Login returned the incorrect user password.",database.login("ball", "isLife").getPassword().equals(user2.getPassword()));
		assertTrue("Login returned the incorrect user first name.",database.login("ball", "isLife").getFirstName().equals(user2.getFirstName()));
		assertTrue("Login returned the incorrect user last name.",database.login("ball", "isLife").getLastName().equals(user2.getLastName()));
		assertTrue("Login returned the incorrect user type.",database.login("ball", "isLife").getType() == user2.getType());
	}
	@Test
	public void testIncorrectLoginUsername() {
		try{
			database.login("a","bbb").getUsername();
			fail("incorrect login username did not return null");
		}catch(NullPointerException ex){
			
		}
	}
	@Test
	public void testIncorrectLoginPassword() {
		try{
			database.login("aaa","b").getUsername();
			fail("incorrect login password did not return null");
		}catch(NullPointerException ex){
			
		}
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyLoginUsername() {
		database.login("", "weiss");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyLoginPassword() {
		database.login("tweiss", "");
	}
	//---------------------------------------------------addUser----------------------------------------------------------
	@Test
	public void testAddUser() {
		assertTrue("DatabaseHome encountered an error adding user.",database.addUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(), 
				user1.getPassword(), user1.getType()).getUsername().equals(user1.getUsername()));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddUserWithTypeNotAorS() {
		database.addUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(), 
				user1.getPassword(), 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddUserWithEmptyFirstname() {
		database.addUser("", user1.getLastName(), user1.getUsername(),user1.getPassword(), 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddUserWithEmptyLastname() {
		database.addUser(user1.getFirstName(), "", user1.getUsername(),user1.getPassword(), 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddUserWithEmptyUsername() {
		database.addUser(user1.getFirstName(), user1.getLastName(), "",user1.getPassword(), 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddUserWithEmptyPassword() {
		database.addUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(),"", 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddUserWithEmptyType() {
		database.addUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(),user1.getPassword(), ' ');
	}
	//-----------------------------------------------getUsers--------------------------------------------------------
	@Test
	public void testGetUsers() {
		assertTrue("getUsers encountered a problem (endUser).", database.getUsers().get(database.getUsers().size()-1).getUsername().equals(enduser.getUsername()));
		assertTrue("getUsers encountered a problem (frontUser).", database.getUsers().get(0).getUsername().equals(frontUser.getUsername()));
	}
	//-----------------------------------------------editUsers-------------------------------------------------------
	@Test
	public void testEditUser() {
		user3.setFirstName("t");
		assertTrue("DatabaseHome encountered an error editing user firstname",database.editUser("t", user3.getLastName(), user3.getUsername(), 
				user3.getPassword(), user3.getType() , 'a').getFirstName().equals(user3.getFirstName()));
		user3.setLastName("t");
		assertTrue("DatabaseHome encountered an error editing user lastname.",database.editUser(user3.getFirstName(), "t", user3.getUsername(), 
				user3.getPassword(), user3.getType(), 'a').getLastName().equals(user3.getLastName()));
		user3.setPassword("t");
		assertTrue("DatabaseHome encountered an error editing user password.",database.editUser(user3.getFirstName(), user3.getLastName(), user3.getUsername(), 
				"t", user3.getType(),'a').getPassword().equals(user3.getPassword()));
		user3.setType('s');
		assertTrue("DatabaseHome encountered an error editing user type.",database.editUser(user3.getFirstName(), user3.getLastName(), user3.getUsername(), 
				user3.getPassword(), 's','a').getType() == user3.getType());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithTypeNotAorS() {
		database.editUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(), 
				user1.getPassword(), 'f', 'a');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithEmptyFirstname() {
		database.editUser("", user1.getLastName(), user1.getUsername(),user1.getPassword(), 'f','a');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithEmptyLastname() {
		database.editUser(user1.getFirstName(), "", user1.getUsername(),user1.getPassword(), 'f','a');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithEmptyUsername() {
		database.editUser(user1.getFirstName(), user1.getLastName(), "",user1.getPassword(), 'f','a');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithEmptyPassword() {
		database.editUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(),"", 'f','a');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithEmptyType() {

		database.editUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(),user1.getPassword(), ' ', 'a');
	}
	//----------------------------------------------deactivate user---------------------------------------------------
	@Test
	public void testDeactivateUser() {
		user2.setStatus('d');
		assertTrue("Deactivation error.", database.deactivateUser(0).getUsername().equals(frontUser.getUsername()));
		assertTrue("Deactivation error.", database.deactivateUser(0).getStatus() == 'd');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testDeactivateUserFailsForNegativeInteger() {
		database.deactivateUser(-1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testDeactivateUserFailsForIntegerOutOfRange() {
		database.deactivateUser(database.getUsers().size());
	}
    //----------------------------------------------addSchool--------------------------------------------------------
	//String school, String state, String location, String control, int numStudents,
	//double percentFemale, int satVerbal, int satMath, double expenses, double percentFinAid, int numApplicants,
	//double percentAdmitted, double percentEnrolled, int academicScale, int socialScale, int qualOflife
	@Test
	public void testAddSchool(){
		assertTrue("add school method fault",database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife()).getName().equals("Saint Johns University test"));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyName(){
		database.addSchool("",school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyState(){
		database.addSchool(school1.getSchool(),"",school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyLocation(){
		database.addSchool(school1.getSchool(),school1.getState(),"",
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyControl(){
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				"",school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyNumStudents(){
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),0,school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptySatVerbal(){
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    0,school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptySatMath(){
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),0,school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyExpenses(){
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),0,
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyPercentFinAid(){
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				0,school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyNumApplicants(){
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),0,school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyPercentAdmitted(){
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),0,
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyPercentEnrolled(){
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				0,school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyAcademicScale(){
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),0,school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptySocialScale(){
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),0,
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyQualOfLife(){
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				0);
	}
	//-------------------------------------------------------edit school----------------------------------------------------------
	/*
	 * String school,String state, String location, String control, int numStudents, double percentFemale, double satVerbal, double satMath,
                           double expenses, double percentFinAid, int numApplicants, double percentAdmitted, double percentEnrolled, int academicScale,
                           int socialScale, int qualOflife, String[] emphasis, int id
	 */
	@Test
	public void testEditSchool(){
		String[] emphasis = new String[2];
		school3.setState("test");
		school3.setLocation("test");
		school3.setControl("test");
		school3.setNumStudents(1);
		school3.setPercentFemale(0.1);
		school3.setSatVerbal(300.0);
		school3.setSatMath(300.0);
		school3.setExpenses(1000.0);
		school3.setPercentFinAid(0.1);
		school3.setNumApplicants(1);
		school3.setPercentAdmitted(0.1);
		school3.setPercentEnrolled(0.1);
		school3.setAcademicScale(1);
		school3.setSocialscale(1);
		school3.setQualOfLife(1);
		school3.setEmphasis(emphasis);
		assertTrue("edit school method fault",database.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis,0).getState().equals("test"));
		assertTrue("edit school method fault",database.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis,0).getLocation().equals("test"));
		assertTrue("edit school method fault",database.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis,0).getControl().equals("test"));
		assertTrue("edit school method fault",database.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis,0).getNumStudents() == 1);
		assertTrue("edit school method fault",database.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis,0).getPercentFemale() == .1);
		assertTrue("edit school method fault",database.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis,0).getSatVerbal() == 300.0);
		assertTrue("edit school method fault",database.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis,0).getSatMath() == 300.0);
		assertTrue("edit school method fault",database.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis,0).getExpenses() == 1000.0);
		assertTrue("edit school method fault",database.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis,0).getPercentFinAid() == .1);
		assertTrue("edit school method fault",database.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis,0).getNumApplicants() == 1);
		assertTrue("edit school method fault",database.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis,0).getPercentAdmitted() == .1);
		assertTrue("edit school method fault",database.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis,0).getPercentEnrolled() == .1);
		assertTrue("edit school method fault",database.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis,0).getAcademicScale() == 1);
		assertTrue("edit school method fault",database.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis,0).getSocialscale() == 1);
		assertTrue("edit school method fault",database.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis,0).getQualOfLife() == 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithZeroNumStudents(){
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),0,school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativePercentFemale(){
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),-1.0,
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverPercentFemale(){
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),101.0,
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativeSatVerbal(){
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    -1.0,school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverSatVerbal(){
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    801.0,school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativeSatMath(){
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),-1.0,school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverSatMath(){
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),801.0,school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativeExpenses(){
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),-100.0,
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativePercentFinAid(){
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				-1.0,school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverPercentFinAid(){
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				101.0,school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativeApplicants(){
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),-1,school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativePercentAdmitted(){
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),-1.0,
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverPercentAdmitted(){
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),101.0,
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativePercentEnrolled(){
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				-1.0,school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverPercentEnrolled(){
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				101.0,school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithUnderAcademicScale(){
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),0,school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverAcademicScale(){
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),6,school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithUnderSocialScale(){
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),0,
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverSocialScale(){
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),6,
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithLowQualOfLife(){
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				0,emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithHighQualOfLife(){
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				6,emphasis,0);		
	}
	//-------------------------------------------getSchools-----------------------------------------
	@Test
	public void testGetSchools(){
		ArrayList<School> array = database.getSchools();
		assertTrue("School1 not found in getSchool2",array.get(0).getName().equals("ABILENE CHRISTIAN UNIVERSITY"));
		assertTrue("School1 not found in getSchool3",array.get(array.size()-1).getName().equals("zzzUniversity of Minnesota test"));	
	}
	//-----------------------------------------tearDown------------------------------------------------
	@After
	public void tearDown(){
		database.removeSchool(school2.getSchool());
		database.removeSchool(school3.getSchool());
		database.removeSchool(school1.getSchool());
		database.removeUser(user1.getUsername());
		database.removeUser(user2.getUsername());
		database.removeUser(user3.getUsername());
		database.removeUser(enduser.getUsername());
		database.removeUser(frontUser.getUsername());
	}
}
