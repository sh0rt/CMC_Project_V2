package CMC_Classes;


/** AdminInterface
 * @authors Megan Pekarek, Cassie Meyer, Tyler Weiss, Conor Lorsung
 * @version March 15th, 2016
 */

import java.util.*;

public class AdminInterface {
	AdminHome admin;

	public AdminInterface(User user) {
		admin = new AdminHome(user);
	}

	/**
	 * views school by admin
	 * 
	 * @param ID
	 * @return school
	 */
	public String viewSchools() {
		ArrayList<School> schools = admin.getSchools();
		String temp = "Schools within the database include: \n";
		for (int i = 0; i < schools.size(); i++) {
			temp = new String(temp + "\t" + i + ": " + schools.get(i).getSchool() + "\n");
		}
		return temp;
	}

	/**
	 * Edits school by admin
	 * 
	 * @param school,
	 *            state, location, control, numStudents, percentFemale,
	 *            satVerbal, satMath, expenses, percentFinAid, numApplicants,
	 *            percentAdmitted, percentEnrolled, academicScale, socialScale,
	 *            qualOflife, emphasis
	 * @return new school
	 */
	public String editSchool(String school, String state, String location, String control, int numStudents,
			double percentFemale, int satVerbal, int satMath, double expenses, double percentFinAid, int numApplicants,
			double percentAdmitted, double percentEnrolled, int academicScale, int socialScale, int qualOflife,
			String[] emphasis) {

		return "Successfully changed " + admin.editSchool(school, state, location, control, numStudents, percentFemale,
				satVerbal, satMath, expenses, percentFinAid, numApplicants, percentAdmitted, percentEnrolled,
				academicScale, socialScale, qualOflife, emphasis).getSchool();

	}

	/**
	 * Adds new school by admin
	 * 
	 * @param school,
	 *            state, location, control, numStudents, percentFemale,
	 *            satVerbal, satMath, expenses, percentFinAid, numApplicants,
	 *            percentAdmitted, percentEnrolled, academicScale, socialScale,
	 *            qualOflife, emphasis
	 * @return new school
	 */
	public String addNewSchool(String school, String state, String location, String control, int numStudents,
			double percentFemale, int satVerbal, int satMath, double expenses, double percentFinAid, int numApplicants,
			double percentAdmitted, double percentEnrolled, int academicScale, int socialScale, int qualOflife,
			String[] emphasis) {
		return admin.addNewSchool(school, state, location, control, numStudents, percentFemale, satVerbal, satMath,
				expenses, percentFinAid, numApplicants, percentAdmitted, percentEnrolled, academicScale, socialScale,
				qualOflife, emphasis).getName() + " succesfully Added";
	}

	/**
	 * view school by ID called by admin
	 * 
	 * @param ID
	 * @return school
	 */
	public String viewSchool(int ID) {
		if(ID<=0 || ID >= admin.getSchools().size())
			throw new IllegalArgumentException();
		School school = admin.getSchools().get(ID);
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
	 * add user called by admin
	 * 
	 * @param firstName,
	 *            lastName, username, password, type
	 * @return new user
	 */
	public String addUser(String firstName, String lastName, String username, String password, char type) {
		User user = admin.addNewUser(firstName, lastName, username, password, type);
		return "Successfuly added " + user.getFirstName() + " to the system.";
	}

	/**
	 * edit user called by admin
	 * 
	 * @param firstName,
	 *            lastName, username, password, type, status
	 * @return user
	 */
	public String editUser(String firstName, String lastName, String username, String password, char type,
			char status) {
		User user = admin.editUser(firstName, lastName, username, password, type, status);
		return "Succesfully made changes to " + user.getFirstName() + ".";
	}

	/**
	 * deactivates user called by admin
	 * 
	 * @param id
	 * @return removed user
	 */
	public String deactivateUser(int id) {
		if(id <= 0)
			throw new IllegalArgumentException();
		User user = admin.getUser(id);
		admin.editUser(user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword(), user.getType(),'d');
		return "Succesfully deactivated " + user.getFirstName() + ".";
	}

	/**
	 * view user called by admin
	 * 
	 * @return users
	 */
	public String viewUsers() {
		String string = "Users currently in the system: \n";
		ArrayList<User> users = admin.getUsers();
		for (int i = 0; i < users.size(); i++) {
			string = string + "\t User " + i + ":" + users.get(i).getUsername() + "\n";
		}
		return string;
	}

	/**
	 * view user by ID called by admin
	 * 
	 * @param ID
	 * @return user
	 */
	public String viewUser(int ID) {
		if(ID<=0 || ID >= admin.getSchools().size())
			throw new IllegalArgumentException();
		String type, status;
		User user = admin.getUsers().get(ID);
		if (user.getType() == 'a')
			type = "Admin";
		else
			type = "Student";
		if (user.getStatus() == 'a')
			status = "Active";
		else
			status = "Deactivated";
		String temp = "\tFirst Name: " + user.getFirstName() + "\n" + "\tLast Name: " + user.getLastName() + "\n"
				+ "\tUsername: " + user.getUsername() + "\n" + "\tPassword: " + user.getPassword() + "\n" + "\tType; "
				+ type + "\n" + "\tStatus: " + status + "\n";
		return temp;
	}
}
