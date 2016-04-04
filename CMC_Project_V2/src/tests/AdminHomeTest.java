package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CMC_Classes.DataBaseHome;
import CMC_Classes.AdminHome;
import CMC_Classes.School;
import CMC_Classes.User;
import CMC_Classes.UserHome;

public class AdminHomeTest {
	DataBaseHome database;
	AdminHome test;
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
		test = new AdminHome(UserHome.Login("tnweiss","weiss"));
	}
	//--------------------------------------get Schools-----------------------------------------
	@Test
	public void testGetSchools() {
		assertTrue("get Schools failed", test.getSchools().get(0) == null);
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
