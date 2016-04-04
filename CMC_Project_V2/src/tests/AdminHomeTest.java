package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import CMC_Classes.*;
import CMC_Classes.DataBaseHome;
import CMC_Classes.AdminHome;
import CMC_Classes.School;
import CMC_Classes.User;
import CMC_Classes.UserHome;

public class AdminHomeTest {

	User u;
	AdminHome ah;
	School s;
	DataBaseHome database;
	AdminHome test;
	User user1, user2, user3, enduser, frontUser;
	School school1, school2, school3;
	String[] emphasis;
/*	
	@Before
	public void init() {
		u = new User("Admin", "Adminingston", "a", "password", 'A', 'A');
		ah = new AdminHome(u);
		s = new School("Creative", "MN", null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	*/
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
		test = new AdminHome(UserHome.Login("tnweiss","weiss"));
	}
/*
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
	*/
	
	@Test
	public void testAddNewSchool() {
		assertTrue("Add new school worked succesfully",test.addNewSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),new String[3]).getSchool().equals(school1.getSchool()));
	}
	
	//--------------------------------------get Schools / users-----------------------------------------
	@Test
	public void testGetSchools() {
		assertTrue("get schools failed front",test.getSchools().get(0).getSchool().equals("ABILENE CHRISTIAN UNIVERSITY"));
		assertTrue("getSchools faile end",test.getSchools().get(test.getSchools().size() - 1).getSchool().equals("zzzUniversity of Minnesota test"));
	}
	@Test
	public void testGetUsers(){
		assertTrue("get users is broken", test.getUsers().get(0).getUsername().equals(frontUser.getUsername()));
	}
	@Test 
	public void testGetUser(){
		assertTrue("get user with id failed front", test.getUser(0).getUsername().equals(frontUser.getUsername()));
		assertTrue("get user with id failed end", test.getUser(test.getUsers().size()-1).getUsername().equals(enduser.getUsername()));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testGetNegativeUserFails(){
		test.getUser(-1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testGetOverUserFails(){
		test.getUser(test.getUsers().size());
	}
	//----------------------------------------------edit school------------------------------------------------
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
		assertTrue("edit school method fault",test.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis).getState().equals("test"));
		assertTrue("edit school method fault",test.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis).getLocation().equals("test"));
		assertTrue("edit school method fault",test.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis).getControl().equals("test"));
		assertTrue("edit school method fault",test.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis).getNumStudents() == 1);
		assertTrue("edit school method fault",test.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis).getPercentFemale() == .1);
		assertTrue("edit school method fault",test.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis).getSatVerbal() == 300.0);
		assertTrue("edit school method fault",test.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis).getSatMath() == 300.0);
		assertTrue("edit school method fault",test.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis).getExpenses() == 1000.0);
		assertTrue("edit school method fault",test.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis).getPercentFinAid() == .1);
		assertTrue("edit school method fault",test.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis).getNumApplicants() == 1);
		assertTrue("edit school method fault",test.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis).getPercentAdmitted() == .1);
		assertTrue("edit school method fault",test.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis).getPercentEnrolled() == .1);
		assertTrue("edit school method fault",test.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis).getAcademicScale() == 1);
		assertTrue("edit school method fault",test.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis).getSocialscale() == 1);
		assertTrue("edit school method fault",test.editSchool(school3.getName(),"test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis).getQualOfLife() == 1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithZeroNumStudents(){
		test.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),0,school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativePercentFemale(){
		test.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),-1.0,
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverPercentFemale(){
		test.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),101.0,
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativeSatVerbal(){
		test.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    -1.0,school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverSatVerbal(){
		test.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    801.0,school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativeSatMath(){
		test.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),-1.0,school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverSatMath(){
		test.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),801.0,school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativeExpenses(){
		test.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),-100.0,
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativePercentFinAid(){
		test.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				-1.0,school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverPercentFinAid(){
		test.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				101.0,school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativeApplicants(){
		test.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),-1,school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativePercentAdmitted(){
		test.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),-1.0,
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverPercentAdmitted(){
		test.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),101.0,
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativePercentEnrolled(){
		test.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				-1.0,school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverPercentEnrolled(){
		test.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				101.0,school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithUnderAcademicScale(){
		test.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),0,school1.getSocialscale(),
				school1.getQualOfLife(),emphasis);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverAcademicScale(){
		test.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),6,school1.getSocialscale(),
				school1.getQualOfLife(),emphasis);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithUnderSocialScale(){
		test.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),0,
				school1.getQualOfLife(),emphasis);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverSocialScale(){
		test.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),6,
				school1.getQualOfLife(),emphasis);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithLowQualOfLife(){
		test.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				0,emphasis);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithHighQualOfLife(){
		test.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				6,emphasis);		
	}
	//--------------------------------------------------add school-------------------------------------
	@Test
	public void testAddSchool(){
		assertTrue("add school method fault",test.addNewSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),school1.getEmphasis()).getName().equals("Saint Johns University test"));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddNewSchoolWithEmptyName(){
		test.addNewSchool("",school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),school1.getEmphasis());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddNewSchoolWithEmptyState(){
		test.addNewSchool(school1.getSchool(),"",school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),school1.getEmphasis());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddNewSchoolWithEmptyLocation(){
		test.addNewSchool(school1.getSchool(),school1.getState(),"",
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),school1.getEmphasis());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddNewSchoolWithEmptyControl(){
		test.addNewSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				"",school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),school1.getEmphasis());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddNewSchoolWithEmptyNumStudents(){
		test.addNewSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),0,school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),school1.getEmphasis());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddNewSchoolWithEmptySatVerbal(){
		test.addNewSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    0,school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),school1.getEmphasis());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddNewSchoolWithEmptySatMath(){
		test.addNewSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),0,school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),school1.getEmphasis());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddNewSchoolWithEmptyExpenses(){
		test.addNewSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),0,
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),school1.getEmphasis());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddNewSchoolWithEmptyPercentFinAid(){
		test.addNewSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				0,school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),school1.getEmphasis());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddNewSchoolWithEmptyNumApplicants(){
		test.addNewSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),0,school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),school1.getEmphasis());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddNewSchoolWithEmptyPercentAdmitted(){
		test.addNewSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),0,
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),school1.getEmphasis());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddNewSchoolWithEmptyPercentEnrolled(){
		test.addNewSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				0,school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),school1.getEmphasis());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddNewSchoolWithEmptyAcademicScale(){
		test.addNewSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),0,school1.getSocialscale(),
				school1.getQualOfLife(),school1.getEmphasis());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddNewSchoolWithEmptySocialScale(){
		test.addNewSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),0,
				school1.getQualOfLife(),school1.getEmphasis());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddNewSchoolWithEmptyQualOfLife(){
		test.addNewSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				0,school1.getEmphasis());
	}
	//--------------------------------------add user---------------------------------------------------
	@Test
	public void testAddUser() {
		assertTrue("AdminHome encountered an error adding user.",test.addNewUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(), 
				user1.getPassword(), user1.getType()).getUsername().equals(user1.getUsername()));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddNewUserWithTypeNotAorS() {
		test.addNewUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(), 
				user1.getPassword(), 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddNewUserWithEmptyFirstname() {
		test.addNewUser("", user1.getLastName(), user1.getUsername(),user1.getPassword(), 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddNewUserWithEmptyLastname() {
		test.addNewUser(user1.getFirstName(), "", user1.getUsername(),user1.getPassword(), 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddNewUserWithEmptyUsername() {
		test.addNewUser(user1.getFirstName(), user1.getLastName(), "",user1.getPassword(), 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddNewUserWithEmptyPassword() {
		test.addNewUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(),"", 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testaddNewUserWithEmptyType() {
		test.addNewUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(),user1.getPassword(), ' ');
	}
//--------------------------------------------------editUser-----------------------------------------------
	@Test
	public void testEditUser() {
		user3.setFirstName("t");
		assertTrue("AdminHome encountered an error editing user firstname",test.editUser("t", user3.getLastName(), user3.getUsername(), 
				user3.getPassword(), user3.getType() , 'a').getFirstName().equals(user3.getFirstName()));
		user3.setLastName("t");
		assertTrue("AdminHome encountered an error editing user lastname.",test.editUser(user3.getFirstName(), "t", user3.getUsername(), 
				user3.getPassword(), user3.getType(), 'a').getLastName().equals(user3.getLastName()));
		user3.setPassword("t");
		assertTrue("AdminHome encountered an error editing user password.",test.editUser(user3.getFirstName(), user3.getLastName(), user3.getUsername(), 
				"t", user3.getType(),'a').getPassword().equals(user3.getPassword()));
		user3.setType('s');
		assertTrue("AdminHome encountered an error editing user type.",test.editUser(user3.getFirstName(), user3.getLastName(), user3.getUsername(), 
				user3.getPassword(), 's','a').getType() == user3.getType());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithTypeNotAorS() {
		test.editUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(), 
				user1.getPassword(), 'f', 'a');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithEmptyFirstname() {
		test.editUser("", user1.getLastName(), user1.getUsername(),user1.getPassword(), 'f','a');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithEmptyLastname() {
		test.editUser(user1.getFirstName(), "", user1.getUsername(),user1.getPassword(), 'f','a');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithEmptyUsername() {
		test.editUser(user1.getFirstName(), user1.getLastName(), "",user1.getPassword(), 'f','a');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithEmptyPassword() {
		test.editUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(),"", 'f','a');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithEmptyType() {
		test.editUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(),user1.getPassword(), ' ', 'a');
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
