package CMC_Classes;


import java.util.*;

/**
 * Student Interface
 * 
 * @author Megan, Cassie, Tyler, Conor
 * @version 3/15/16
 */
public class StudentUI {
	/**
	 * @student the student
	 * @database the database
	 */
	StudentHome student;

	/**
	 * constructs student object and sets the database parameter
	 * 
	 * @param user
	 *            the user
	 * @param database
	 *            the database
	 */
	public StudentUI(User user) {
		student = new StudentHome(user);
	}

	/**
	 * views user profile
	 * 
	 * @return string of user info
	 */
	public String viewProfile() {
		String type, status;
		User user = student.getUser();
		if (user.getType() == 'a')
			type = "Admin";
		else
			type = "Student";
		if (user.getStatus() == 'a')
			status = "Active";
		else
			status = "Deactivated";
		String temp = "\tFirst name: " + user.getFirstName() + "\n" + "\tLast name: " + user.getLastName() + "\n"
				+ "\tUsername: " + user.getUsername() + "\n" + "\tPassword: " + user.getPassword() + "\n" + "\tType: "
				+ type + "\n" + "\tStatus: " + status + "\n";
		return temp;
	}

	/**
	 * allows user to edit profile
	 * 
	 * @param first
	 *            first name
	 * @param last
	 *            last name
	 * @param password
	 *            users password
	 * @return the successful save message
	 */
	public String editProfile(String first, String last, String password) {
		student.editProfile(first, last, password);
		return "Succesfully changed profile";
	}

	/**
	 * allows user to view their saved schools
	 * 
	 * @return a string of the saved schools
	 */
	public String viewSavedSchools() {
		ArrayList<School> schools = student.getUser().getSchools();
		String string = "";
		for (int i = 0; i < schools.size(); i++) {
			string = new String(string + "\tSchool " + i + ": " + schools.get(i).getSchool() + "\n");
		}
		return string;
	}

	/**
	 * allows user to remove a school from their list of saved schools
	 * 
	 * @param ID
	 *            user ID
	 * @return a successful remove message
	 */
	public String removeSchool(int ID) {
		School school = student.getUser().getSavedSchools().get(ID);
		student.removeSchool(school);
		return "Succesfully removed " + school.getSchool() + " from your saved schools list.";
	}

	/**
	 * searches all schools
	 * 
	 * @param name
	 *            school name
	 * @param state
	 *            school state
	 * @param location
	 *            school location
	 * @param control
	 *            school control
	 * @param numStudents
	 *            num of students at school
	 * @param satVerbal
	 *            avg sat verbal score at school
	 * @param satMath
	 *            avg sat math score at school
	 * @param numApplicants
	 *            avg num of applicants to school
	 * @param percentFemale
	 *            percent of female students at school
	 * @param expenses
	 *            expenses of the school
	 * @param percentFinAid
	 *            percentage of students recieving financial aid at the school
	 * @param percentAdmitted
	 *            percentage of students admitted at the school
	 * @param percentEnrolled
	 *            percentage of students that decide to enroll
	 * @param academicScale
	 *            academic scale of the school
	 * @param socialscale
	 *            social scale of the school
	 * @param qualOfLife
	 *            quality of life at the school
	 * @param emphasis
	 *            emphasis the school excels in
	 * @return string of schools matching search
	 */
	public String search(String name, String state, String location, String control, int[] numStudents,
			double[] satVerbal, double[] satMath, int[] numApplicants, double[] percentFemale, double[] expenses,
			double[] percentFinAid, double[] percentAdmitted, double[] percentEnrolled, int[] academicScale,
			int[] socialscale, int[] qualOfLife, String[] emphasis) {

		School[] results = student.search(name, state, location, control, numStudents, satVerbal, satMath,
				numApplicants, percentFemale, expenses, percentFinAid, percentAdmitted, percentEnrolled, academicScale,
				socialscale, qualOfLife, emphasis);
		String temp = "Result 1: " + results[0].getName() + "\n" + "Result 2: " + results[1].getName() + "\n"
				+ "Result 3: " + results[2].getName() + "\n" + "Result 4: " + results[3].getName() + "\n" + "Result 5: "
				+ results[4].getName() + "\n";
		// School[] recommend = student.getRecommend();
		return temp;
	}

	/**
	 * shows user recommended schools
	 * 
	 * @return string of recommended schools
	 */
	public String recommendations() {
		School[] results = student.getRecommend();
		String temp = "Recommendation 1: " + results[0].getName() + "\n" + "Recommendation 2: " + results[1].getName()
				+ "\n" + "Recommendation 3: " + results[2].getName() + "\n" + "Recommendation 4: "
				+ results[3].getName() + "\n" + "Recommendation 5: " + results[4].getName() + "\n";
		return temp;
	}

	/**
	 * allows user to view expanded school
	 * 
	 * @param ID
	 *            specific ID number
	 * @return string of expanded schools info
	 */
	public String viewExpandedSchool(int ID) {
		School school = student.getSearch()[ID];
		String temp = "School: " + school.getSchool() + "\n" + "State: " + school.getState() + "\n" + "Location: "
				+ school.getLocation() + "\n" + "control: " + school.getControl() + "\n" + "Number of Students; "
				+ school.getNumStudents() + "\n" + "Percent Female: " + school.getPercentFemale() + "\n"
				+ "sat Verbal: " + school.getSatVerbal() + "\n" + "sat Math: " + school.getSatMath() + "\n"
				+ "expenses: " + school.getExpenses() + "\n" + "Percent financial Aid: " + school.getPercentFinAid()
				+ "\n" + "Number of Applicants: " + school.getNumApplicants() + "\n" + "Percent Admitted: "
				+ school.getPercentAdmitted() + "\n" + "Percent Enrolled: " + school.getPercentEnrolled() + "\n"
				+ "Academic Scale: " + school.getAcademicScale() + "\n" + "Social Scale: " + school.getSocialscale()
				+ "\n" + "Quality of life: " + school.getQualOfLife() + "\n" + "Emphasis: "
				+ Arrays.toString(school.getEmphasis()) + "\n";
		return temp;
	}

	/**
	 * saves a school to users profile
	 * 
	 * @param id
	 *            is users specific id
	 * @return confirmation of save message
	 */
	public String saveSchool(int id) {
		School school = student.getSearch()[id];
		student.addSchool(school);
		return "Saved " + school.getSchool() + " to your list of schools.";
	}
}
