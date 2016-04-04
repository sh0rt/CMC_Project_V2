import static org.junit.Assert.*;
import java.util.*;
import org.junit.Before;
import org.junit.Test;
import de
public class DatabaseHomeTest {
	DataBaseHome database;
	User user1, user2, user3;
	School school1, school2, school3;

	@Before
	public void setUp() throws Exception {
		database = new DataBaseHome();
		user1 = new User("Tyler", "Weiss", "tnweiss", "weiss", 'a');
		user2 = new User("T-$", "Weiss", "ball", "isLife", 'a');
		user3 = new User("T-Buckets", "Weiss", "get", "money", 'a');
		/*
		database.addUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(), 
				user1.getPassword(), user1.getType());
		database.addUser(user2.getFirstName(), user2.getLastName(), user2.getUsername(), 
				user2.getPassword(), user2.getType());
		database.addUser(user3.getFirstName(), user3.getLastName(), user3.getUsername(), 
				user3.getPassword(), user3.getType());
				*/
		school1 = new School("Saint Johns University","Minnesota", "SMALL-CITY", "PRIVATE", 5000, .5, 20,30,5000.0,.3,1000,.5,.3,4,3,5);
		school2 = new School("University of Minnesota Duluth","Minnesota", "UNKNOWN", "STATE", 50000, .7, 20,30,5000.0,.3,1000,.5,.3,4,3,5);
		school3 = new School(("University of Minnesota","Minnesota", "URBAN", "UNKNOWN", 500000, .45, 20,30,5000.0,.3,1000,.5,.3,4,3,5));
		String[] emphasis = new String[3];
		database.addSchool(school2.getSchool(),school2.getState(),school2.getLocation(),
				school2.getControl(),school2.getNumStudents(),school2.getPercentFemale(),
			    school2.getSatVerbal(),school2.getSatMath(),school2.getExpenses(),
				school2.getPercentFinAid(),school2.getNumApplicants(),school2.getPercentAdmitted(),
				school2.getPercentEnrolled(),school2.getAcademicScale(),school2.getSocialscale(),
				school2.getQualOfLife())
		database.addSchool(school3.getSchool(),school3.getState(),school3.getLocation(),
				school3.getControl(),school3.getNumStudents(),school3.getPercentFemale(),
			    school3.getSatVerbal(),school3.getSatMath(),school3.getExpenses(),
				school3.getPercentFinAid(),school3.getNumApplicants(),school3.getPercentAdmitted(),
				school3.getPercentEnrolled(),school3.getAcademicScale(),school3.getSocialscale(),
				school3.getQualOfLife())
	}
	//----------------------------------------------------Login----------------------------------------------------------
	@Test
	public void testLoginSuccess() {
		assertTrue("Login returned the incorrect user.",database.login("tnweiss", "weiss").equals(user1));
	}
	@Test
	public void testIncorrectLoginUsername() {
		assertTrue("Login returned a user that is was not supposed to (incorrect username).",database.login("tweiss", "weiss").equals(null));
	}
	@Test
	public void testIncorrectLoginPassword() {
		assertTrue("Login returned a user that is was not supposed to (incorrect password).",database.login("tweiss", "eiss").equals(null));
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
		user1.setFirstName("t");
		assertTrue("DatabaseHome encountered an error changing users first name.",database.addUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(), 
				user1.getPassword(), user1.getType()).equals(user1));
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
		database.addUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(),user1.getPassword(), '');
	}
	//-----------------------------------------------getUsers--------------------------------------------------------
	@Test
	public void testGetUsers() {
		assertTrue("getUsers encountered a problem (user1).", database.getUsers().get(0).equals(user1));
		assertTrue("getUsers encountered a problem (user2).", database.getUsers().get(1).equals(user2));
		assertTrue("getUsers encountered a problem (user3).", database.getUsers().get(2).equals(user3));
	}
	//-----------------------------------------------editUsers-------------------------------------------------------
	@Test
	public void testEditUser() {
		user1.setFirstName("t");
		assertTrue("DatabaseHome encountered an error editing user firstname",database.editUser("t", user1.getLastName(), user1.getUsername(), 
				user1.getPassword(), user1.getType()).equals(user1));
		user1.setLastName("t");
		assertTrue("DatabaseHome encountered an error editing user lastname.",database.editUser(user1.getFirstName(), "t", user1.getUsername(), 
				user1.getPassword(), user1.getType()).equals(user1));
		user1.setUsername("t");
		assertTrue("DatabaseHome encountered an error editing user username.",database.editUser(user1.getFirstName(), user1.getLastName(), " ", 
				user1.getPassword(), user1.getType()).equals(user1));
		user1.setPassword("t");
		assertTrue("DatabaseHome encountered an error editing user password.",database.editUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(), 
				"t", user1.getType()).equals(user1));
		user1.setType('s');
		assertTrue("DatabaseHome encountered an error editing user type.",database.editUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(), 
				user1.getPassword(), 's').equals(user1));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithTypeNotAorS() {
		database.editUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(), 
				user1.getPassword(), 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithEmptyFirstname() {
		database.editUser("", user1.getLastName(), user1.getUsername(),user1.getPassword(), 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithEmptyLastname() {
		database.editUser(user1.getFirstName(), "", user1.getUsername(),user1.getPassword(), 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithEmptyUsername() {
		database.editUser(user1.getFirstName(), user1.getLastName(), "",user1.getPassword(), 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithEmptyPassword() {
		database.editUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(),"", 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithEmptyType() {

		database.editUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(),user1.getPassword(), '');
	}
	//----------------------------------------------deactivate user---------------------------------------------------
<<<<<<< HEAD
	@Test
	public void testDeactivateUser() {
		user2.setStatus('d');
		assertTrue("Deactivation error.", database.deactivateUser(0).equals(user2));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testDeactivateUserFailsForNegativeInteger() {
		database.deactivateUser(-1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testDeactivateUserFailsForIntegerOutOfRange() {
		database.deactivateUser(7);
	}
    //----------------------------------------------addSchool--------------------------------------------------------
	@Test
	public void testAddSchool{
		assertTrue("add school method fault",database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife()).equals(school1));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyName{
		database.addSchool("",school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyState{
		database.addSchool(school1.getSchool(),"",school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyLocation{
		database.addSchool(school1.getSchool(),school1.getState(),"",
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyControl{
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				"",school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyNumStudents{
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),"",school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyPercentFemale{
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),"",
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptySatVerbal{
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    "",school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptySatMath{
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),"",school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyExpenses{
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),"",
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyPercentFinAid{
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				"",school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyNumApplicants{
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),"",school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyPercentAdmitted{
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),"",
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyPercentEnrolled{
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				"",school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyAcademicScale{
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),"",school1.getSocialscale(),
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptySocialScale{
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),"",
				school1.getQualOfLife());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmptyQualOfLife{
		database.addSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				"");
	}
	//-------------------------------------------------------edit school----------------------------------------------------------
	/*
	 * String school,String state, String location, String control, int numStudents, double percentFemale, double satVerbal, double satMath,
                           double expenses, double percentFinAid, int numApplicants, double percentAdmitted, double percentEnrolled, int academicScale,
                           int socialScale, int qualOflife, String[] emphasis, int id
	 */
	@Test
	public void testEditSchool{
		school1.setState("test");
		school1.setLocation("test");
		school1.setControl("test");
		school1.setNumStudents(1);
		school1.setPercentFemale(0.1);
		school1.setSatVerbal(300.0);
		school1.setSatMath(300.0);
		school1.setExpenses(1000.0);
		school1.setPercentFinAid(0.1);
		school1.setNumApplicants(1);
		school1.setPercentAdmitted(0.1);
		school1.setPercentEnrolled(0.1);
		school1.setacademicScale(1);
		school1.setSocialScale(1);
		school1.setQualOfLife(1);
		school1.setEmphasis(emphasis);
		assertTrue("edit school method fault",database.editSchool("test","test","test",
				"test",1,.1,300.0,300.0,1000.0,.1,1,.1,.1,1,1,1,emphasis,0).equals(school1.getState()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithZeroNumStudents{
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),0,school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativePercentFemale{
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),-1.0,
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverPercentFemale{
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),101.0,
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativeSatVerbal{
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    -1.0,school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverSatVerbal{
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    801.0,school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativeSatMath{
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),-1.0,school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverSatMath{
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),801.0,school1.getExpenses(),
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativeExpenses{
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),-100.0,
				school1.getPercentFinAid(),school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativePercentFinAid{
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				-1.0,school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverPercentFinAid{
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				101.0,school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativeApplicants{
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid,-1,school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativePercentAdmitted{
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid,school1.getNumApplicants(),-1.0,
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverPercentAdmitted{
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid,school1.getNumApplicants(),101.0,
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithNegativePercentEnrolled{
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid,school1.getNumApplicants(),school1.getPercentAdmitted(),
				-1.0,school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverPercentEnrolled{
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid,school1.getNumApplicants(),school1.getPercentAdmitted(),
				101.0,school1.getAcademicScale(),school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithUnderAcademicScale{
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid,school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),0,school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverAcademicScale{
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid,school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),6,school1.getSocialscale(),
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithUnderSocialScale{
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid,school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),0,
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithOverSocialScale{
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid,school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),6,
				school1.getQualOfLife(),emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithLowQualOfLife{
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid,school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				0,emphasis,0);		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditSchoolFailsWithHighQualOfLife{
		database.editSchool(school1.getSchool(),school1.getState(),school1.getLocation(),
				school1.getControl(),school1.getNumStudents(),school1.getPercentFemale(),
			    school1.getSatVerbal(),school1.getSatMath(),school1.getExpenses(),
				school1.getPercentFinAid,school1.getNumApplicants(),school1.getPercentAdmitted(),
				school1.getPercentEnrolled(),school1.getAcademicScale(),school1.getSocialscale(),
				6,emphasis,0);		
	}
	//-------------------------------------------getSchools-----------------------------------------
	@Test
	public void testGetSchools{
		ArrayList<School> array = new ArrayList<School>();
		assertTrue("School1 not found in getSchoo2",array.get(0).equals(school2));
		assertTrue("School1 not found in getSchoo3",array.get(1).equals(school3));	
	}
	//-----------------------------------------tearDown------------------------------------------------
	@After
	public void tearDown(){
		database.remove(school2.getSchool());
		database.remove(school3.getSchool());
	}
>>>>>>> branch 'master' of https://github.com/sh0rt/CMCProject.git
}
