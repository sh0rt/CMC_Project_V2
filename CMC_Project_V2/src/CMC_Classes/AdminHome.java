package CMC_Classes;

/** AdminHome
* @authors Megan Pekarek, Cassie Meyer, Tyler Weiss, Conor Lorsung
* @version March 15th, 2016
*/

import java.util.*;

public class AdminHome {

	private ArrayList<User> users;
	private ArrayList<School> schools;
	//private User thisUser;
	private DataBaseHome database;

	/**
	 * Sets parameters equal to correct variables
	 * 
	 * @param user,
	 *            database
	 */
	public AdminHome(User user) {
		super();
		this.database = new DataBaseHome();
	//	this.thisUser = user;

		this.users = database.getUsers();
		this.schools = database.getSchools();
	}

	/**
	 * gets schools from list
	 * 
	 * @return schools
	 */
	public ArrayList<School> getSchools() {
		return schools;
	}

	/**
	 * gets users from list
	 * 
	 * @return users
	 */
	public ArrayList<User> getUsers() {
		return users;
	}

	/**
	 * Edits school by it's parameters
	 * 
	 * @param school,
	 *            state, location, control, numStudents, percentFemale
	 *            satVerbal, satMath, expenses, percentFinAid, numApplicants,
	 *            percentAdmitted percentEnrolled, academicScale, socialScale,
	 *            qualOflife, emphasis
	 * @return schools
	 */
	public School editSchool(String school, String state, String location, String control, int numStudents,
			double percentFemale, int satVerbal, int satMath, double expenses, double percentFinAid, int numApplicants,
			double percentAdmitted, double percentEnrolled, int academicScale, int socialScale, int qualOflife,
			String[] emphasis) {
		int i = 0;
		while (i < schools.size() && !schools.get(i).getSchool().equals(school)) {
			i++;
		}
		if (i == schools.size())
			return null;
		else {
			schools.get(i).setState(state);
			schools.get(i).setLocation(location);
			schools.get(i).setControl(control);
			schools.get(i).setNumStudents(numStudents);
			schools.get(i).setPercentFemale(percentFemale);
			schools.get(i).setSatVerbal(satVerbal);
			schools.get(i).setSatMath(satMath);
			schools.get(i).setExpenses(expenses);
			schools.get(i).setPercentFinAid(percentFinAid);
			schools.get(i).setNumApplicants(numApplicants);
			schools.get(i).setPercentAdmitted(percentAdmitted);
			schools.get(i).setPercentEnrolled(percentEnrolled);
			schools.get(i).setAcademicScale(academicScale);
			schools.get(i).setSocialscale(socialScale);
			schools.get(i).setQualOfLife(qualOflife);
		}
		return schools.get(i);

	}

	/**
	 * Adds new school by its parameters.
	 * 
	 * @param school,
	 *            state, location, control, numStudents, percentFemale
	 *            satVerbal, satMath, expenses, percentFinAid, numApplicants,
	 *            percentAdmitted percentEnrolled, academicScale, socialScale,
	 *            qualOflife, emphasis\
	 * @return schools
	 */
	public School addNewSchool(String school, String state, String location, String control, int numStudents,
			double percentFemale, int satVerbal, int satMath, double expenses, double percentFinAid, int numApplicants,
			double percentAdmitted, double percentEnrolled, int academicScale, int socialScale, int qualOflife,
			String[] emphasis) {

		School temp = new School(school, state, location, control, numStudents, satVerbal, satMath, numApplicants,
				percentFemale, expenses, percentFinAid, percentAdmitted, percentEnrolled, academicScale, socialScale,
				qualOflife, emphasis);
		database.addSchool(school, state, location, control,numStudents,percentFemale,satVerbal, satMath, expenses, percentFinAid,
				numApplicants, percentAdmitted, percentEnrolled, academicScale, socialScale, qualOflife, emphasis);
		schools.add(temp);
		return temp;
	}
/*
 * java.lang.String school,
                                    java.lang.String state,
                                    java.lang.String location,
                                    java.lang.String control,
                                    int numberOfStudents,
                                    double percentFemales,
                                    double SATVerbal,
                                    double SATMath,
                                    double expenses,
                                    double percentFinancialAid,
                                    int numberOfApplicants,
                                    double percentAdmitted,
                                    double percentEnrolled,
                                    int academicsScale,
                                    int socialScale,
                                    int qualityOfLifeScale)
                                    
 */
	/**
	 * adds new user by completing its parameters
	 * 
	 * @param firstName,
	 *            lastName, username, password, type
	 * @return users
	 */
	public User addNewUser(String firstName, String lastName, String username, String password, char type) {
		User temp = new User(firstName, lastName, username, password, type, 'a');
		users.add(temp);
		return temp;
	}

	/**
	 * edits a user by changing any of its parameters
	 * 
	 * @param firstName,
	 *            lastName, username, password, type, status
	 * @return user
	 */
	public User editUser(String firstName, String lastName, String username, String password, char type, char status) {
		int i = 0;
		while (i < users.size() && users.get(i).getUsername().equals(username)) {
			i++;
		}
		if (i == users.size())
			return null;
		else {
			users.get(i).setFirstName(firstName);
			users.get(i).setLastName(lastName);
			users.get(i).setType(type);
			users.get(i).setPassword(password);
			users.get(i).setStatus(status);
		}
		return users.get(i);
	}

	/**
	 * saves changes made to edit school/user
	 */
	public void save() {
		for (int i = 0; i < schools.size(); i++) {
			School temp = schools.get(i);
			database.editSchool(temp.getSchool(), temp.getState(), temp.getLocation(), temp.getControl(),
					temp.getNumStudents(), temp.getPercentFemale(), temp.getSatVerbal(), temp.getSatMath(),
					temp.getExpenses(), temp.getPercentFinAid(), temp.getNumApplicants(), temp.getPercentAdmitted(),
					temp.getPercentEnrolled(), temp.getAcademicScale(), temp.getSocialscale(), temp.getQualOfLife(),
					temp.getEmphasis(), i);
		}
		for (int i = 0; i < users.size(); i++) {
			User temp = users.get(i);
			database.editUser(i, temp.getFirstName(), temp.getLastName(), temp.getUsername(), temp.getPassword(),
					temp.getType(), temp.getStatus());

		}
	}

	/**
	 * gets user through ID
	 * 
	 * @param ID
	 * @return users ID
	 */
	public User getUser(int ID) {
		return this.users.get(ID);
	}

}
