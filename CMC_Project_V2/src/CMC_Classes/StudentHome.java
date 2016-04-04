package CMC_Classes;


/** StudentHome
 * @authors Megan Pekarek, Cassie Meyer, Tyler Weiss, Conor Lorsung
 * @version March 15th, 2016
 */

import java.util.*;
//REMIND TYLER TO FINISH THIS RIGHT HEREEEEEEEEE!!!!!!!
public class StudentHome {
	//USE THE DATABASE SO WHEN STUDENT ADDS STUFF IT ALSO GOES TO DATABASE EVERY TIME!!!!!
	private User user;
	//private DataBaseHome database;
	private SearchHome search;

	/**
	 * Student Home
	 * 
	 * @param user,
	 *            database
	 */
	public StudentHome(User user) {
		super();
		this.user = user;
		//		this.database = database;
		search = new SearchHome();
	}

	/**
	 * gets User
	 * 
	 * @return user
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 * edits user profile by its first, last, and pasword
	 * 
	 * @param first,
	 *            last, password
	 * @return user
	 */
	public User editProfile(String first, String last, String password) {
		this.user.setFirstName(first);
		this.user.setLastName(last);
		this.user.setPassword(password);
		return this.user;
	}

	/**
	 * gets saved schools from array list
	 * 
	 * @return users saved schools
	 */
	public ArrayList<School> getSavedSchools() {
		return this.user.getSavedSchools();
	}

	/**
	 * Removes school from array list
	 * 
	 * @param school
	 * @return schools or null if school doesn't exist
	 */
	public School removeSchool(School school) {
		ArrayList<School> schools = this.user.getSavedSchools();
		ArrayList<School> returnList = new ArrayList<School>();
		for (int i = 0; i < schools.size(); i++) {
			if (school == schools.get(i))
				continue;
			else
				returnList.add(schools.get(i));
		}
		this.user.setSchools(returnList);
		if (schools.size() != returnList.size())
			return school;
		else
			return null;
	}

	/**
	 * adds school to array list
	 * 
	 * @param school
	 * @return school
	 */
	public School addSchool(School school) {
		ArrayList<School> temp = this.user.getSchools();
		temp.add(school);
		this.user.setSchools(temp);
		return school;
	}

	/**
	 * gets school from array list
	 * 
	 * @param id
	 * @return null
	 */
	public School getSchool(int id) {
		return null;
	}

	/**
	 * Searches school based off of parameters
	 * 
	 * @param name
	 * @param state
	 * @param location
	 * @param control
	 * @param numStudents
	 * @param satVerbal
	 * @param satMath
	 * @param numApplicants
	 * @param percentFemale
	 * @param expenses
	 * @param percentFinAid
	 * @param percentAdmitted
	 * @param percentEnrolled
	 * @param academicScale
	 * @param socialscale
	 * @param qualOfLife
	 * @param emphasis
	 * @return schools
	 */
	public School[] search(String name, String state, String location, String control, int[] numStudents,
			double[] satVerbal, double[] satMath, int[] numApplicants, double[] percentFemale, double[] expenses,
			double[] percentFinAid, double[] percentAdmitted, double[] percentEnrolled, int[] academicScale,
			int[] socialscale, int[] qualOfLife, String[] emphasis) {

		return search.search(name, state, location, control, numStudents, satVerbal, satMath, numApplicants,
				percentFemale, expenses, percentFinAid, percentAdmitted, percentEnrolled, academicScale, socialscale,
				qualOfLife, emphasis);
	}

	/**
	 * gets recommendations based off of school search
	 * 
	 * @return school recommendations
	 */
	public School[] getRecommend() {
		return search.getRecommend();
	}

	/**
	 * searches school by student
	 * 
	 * @return top 5 schools
	 */
	public School[] getSearch() {
		return search.getTop5();
	}

	/**
	 * searches school by ID by student
	 * 
	 * @param id
	 * @return school
	 */
	public int getSearchID(int id) {
		return search.getID(id - 1);
	}
}
