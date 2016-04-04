package CMC_Classes;


/**
 * School
 * 
 * @authors Megan Pekarek, Cassie Meyer, Tyler Weiss, Conor Lorsung
 * @version March 15th, 2016
 */

public class School {

	/**
	 * @name is school name
	 * @state is school state
	 * @location is school location(suburban, urban, small-city, or -1 if
	 *           unknown
	 * @control is number of students enrolled at the school
	 * @numStudents is num of students at the school
	 * @numApplicants is the num of applicants at the school
	 * @academicScale is academic scale of the school
	 * @socialScale is the social scale of the school
	 * @qualOfLife is the quality of life at the school
	 * @percentFemale is the percentage of female students at the school
	 * @expenses is the cost of the school tuition and other expenses at the
	 *           school
	 * @percentFinAid is the percentage of students recieving financial aid
	 * @percentAdmitted is the percentage of students admitted
	 * @percentEnrolled is the percentage of student applicants that decide to
	 *                  enroll
	 * @satVerbal average SAT verbal score of enrolled students
	 * @satMath average SAT math score of enrolled students
	 * @emphasis five strings of areas in which the school excels
	 */
	private String name, state, location, control;
	private int numStudents, numApplicants, academicScale, socialscale, qualOfLife;
	private double percentFemale, expenses, percentFinAid, percentAdmitted, percentEnrolled, satVerbal, satMath;
	private String[] emphasis;

	/**
	 * constructs the school object
	 *
	 * @name is school name
	 * @state is school state
	 * @location is school location(suburban, urban, small-city, or -1 if
	 *           unknown
	 * @control is number of students enrolled at the school
	 * @numStudents is num of students at the school
	 * @numApplicants is the num of applicants at the school
	 * @academicScale is academic scale of the school
	 * @socialScale is the social scale of the school
	 * @qualOfLife is the quality of life at the school
	 * @percentFemale is the percentage of female students at the school
	 * @expenses is the cost of the school tuition and other expenses at the
	 *           school
	 * @percentFinAid is the percentage of students recieving financial aid
	 * @percentAdmitted is the percentage of students admitted
	 * @percentEnrolled is the percentage of student applicants that decide to
	 *                  enroll
	 * @satVerbal average SAT verbal score of enrolled students
	 * @satMath average SAT math score of enrolled students
	 * @emphasis five strings of areas in which the school excels
	 */
	public School(String name, String state, String location, String control, int numStudents, double satVerbal,
			double satMath, int numApplicants, double percentFemale, double expenses, double percentFinAid,
			double percentAdmitted, double percentEnrolled, int academicScale, int socialscale, int qualOfLife,
			String[] emphasis) {
		super();
		this.name = name;
		this.state = state;
		this.location = location;
		this.control = control;
		this.numStudents = numStudents;
		this.satVerbal = satVerbal;
		this.satMath = satMath;
		this.numApplicants = numApplicants;
		this.percentFemale = percentFemale;
		this.expenses = expenses;
		this.percentFinAid = percentFinAid;
		this.percentAdmitted = percentAdmitted;
		this.percentEnrolled = percentEnrolled;
		this.academicScale = academicScale;
		this.socialscale = socialscale;
		this.qualOfLife = qualOfLife;
		this.emphasis = emphasis;
	}

	public School(String name, String state, String location, String control, int numStudents, double percentFemale,
			double satVerbal, double satMath, double expenses, double percentFinAid, int numApplicants,
			double percentAdmitted, double percentEnrolled, int academicScale, int socialscale, int qualOfLife) {
		super();
		this.name = name;
		this.state = state;
		this.location = location;
		this.control = control;
		this.numStudents = numStudents;
		this.satVerbal = satVerbal;
		this.satMath = satMath;
		this.numApplicants = numApplicants;
		this.percentFemale = percentFemale;
		this.expenses = expenses;
		this.percentFinAid = percentFinAid;
		this.percentAdmitted = percentAdmitted;
		this.percentEnrolled = percentEnrolled;
		this.academicScale = academicScale;
		this.socialscale = socialscale;
		this.qualOfLife = qualOfLife;
		this.emphasis = new String[1];
	}

	/**
	 * returns the state the school is located in
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * sets the state the school is located in
	 *
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		if(state.equals(""))
			throw new IllegalArgumentException();
		this.state = state;
	}

	/**
	 * returns the location of the school
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * sets the location for the school
	 *
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		if(location.equals(""))
			throw new IllegalArgumentException();
		this.location = location;
	}

	/**
	 * returns the control of the school
	 *
	 * @return the control
	 */
	public String getControl() {
		return control;
	}

	/**
	 * sets the control of the school
	 *
	 * @param control
	 *            the control to set
	 */
	public void setControl(String control) {
		if(control.equals(""))
			throw new IllegalArgumentException();
		this.control = control;
	}

	/**
	 * returns the number of enrolled students at the school
	 *
	 * @return the numStudents
	 */
	public int getNumStudents() {
		return numStudents;
	}

	/**
	 * sets the number of enrolled students for the school
	 *
	 * @param numStudents
	 *            the numStudents to set
	 */
	public void setNumStudents(int numStudents) {
		if(numStudents < 0)
			throw new IllegalArgumentException();
		this.numStudents = numStudents;
	}

	/**
	 * returns the average satVerbal score for the school
	 *
	 * @return the satVerbal
	 */
	public double getSatVerbal() {
		return satVerbal;
	}

	/**
	 * sets the satVerbal average score for the school
	 *
	 * @param satVerbal
	 *            the satVerbal to set
	 */
	public void setSatVerbal(double satVerbal) {
		if(satVerbal < 0 || satVerbal > 800)
			throw new IllegalArgumentException();
		this.satVerbal = satVerbal;
	}

	/**
	 * returns the average satMath score of the school
	 *
	 * @return the satMath
	 */
	public double getSatMath() {
		return satMath;
	}

	/**
	 * sets the average satMath score for the school
	 *
	 * @param satMath
	 *            the satMath to set
	 */
	public void setSatMath(double satMath) {
		if(satMath < 0 || satMath > 800)
			throw new IllegalArgumentException();
		this.satMath = satMath;
	}

	/**
	 * gets the number of applicants
	 *
	 * @return the numApplicants
	 */
	public int getNumApplicants() {
		return numApplicants;
	}

	/**
	 * sets the number of applicants
	 * 
	 * @param numApplicants
	 *            the numApplicants to set
	 */
	public void setNumApplicants(int numApplicants) {
		if(numApplicants < 0 )
			throw new IllegalArgumentException();
		this.numApplicants = numApplicants;
	}

	/**
	 * gets the percentage of female students
	 * 
	 * @return the percentFemale
	 */
	public double getPercentFemale() {
		return percentFemale;
	}

	/**
	 * sets the percentage of female students
	 * 
	 * @param percentFemale
	 *            the percentFemale to set
	 */
	public void setPercentFemale(double percentFemale) {
		if(percentFemale < 0 || percentFemale > 100)
			throw new IllegalArgumentException();
		this.percentFemale = percentFemale;
	}

	/**
	 * gets the schools expenses
	 * 
	 * @return the expenses
	 */
	public double getExpenses() {
		return expenses;
	}

	/**
	 * sets the schools expenses
	 * 
	 * @param expenses
	 *            the expenses to set
	 */
	public void setExpenses(double expenses) {
		if(expenses < 0 )
			throw new IllegalArgumentException();
		this.expenses = expenses;
	}

	/**
	 * gets the percentage of students receiving financial aid
	 * 
	 * @return the percentFinAid
	 */
	public double getPercentFinAid() {
		return percentFinAid;
	}

	/**
	 * sets the percentage of students receiving financial aid
	 * 
	 * @param percentFinAid
	 *            the percentFinAid to set
	 */
	public void setPercentFinAid(double percentFinAid) {
		if(percentFinAid < 0 || percentFinAid > 100)
			throw new IllegalArgumentException();
		this.percentFinAid = percentFinAid;
	}

	/**
	 * gets the percent admitted
	 * 
	 * @return the percentAdmitted
	 */
	public double getPercentAdmitted() {
		return percentAdmitted;
	}

	/**
	 * sets the percent admitted
	 * 
	 * @param percentAdmitted
	 *            the percentAdmitted to set
	 */
	public void setPercentAdmitted(double percentAdmitted) {
		if(percentAdmitted < 0 || percentAdmitted > 100)
			throw new IllegalArgumentException();
		this.percentAdmitted = percentAdmitted;
	}

	/**
	 * gets the percent enrolled
	 * 
	 * @return the percentEnrolled
	 */
	public double getPercentEnrolled() {
		return percentEnrolled;
	}

	/**
	 * sets the percent enrolled
	 * 
	 * @param percentEnrolled
	 *            the percentEnrolled to set
	 */
	public void setPercentEnrolled(double percentEnrolled) {
		if(percentEnrolled < 0 || percentEnrolled > 100)
			throw new IllegalArgumentException();
		this.percentEnrolled = percentEnrolled;
	}

	/**
	 * gets the academic scale
	 * 
	 * @return the academicScale
	 */
	public int getAcademicScale() {
		return academicScale;
	}

	/**
	 * sets the academic scale
	 * 
	 * @param academicScale
	 *            the academicScale to set
	 */
	public void setAcademicScale(int academicScale) {
		if(academicScale < 1 || academicScale > 5)
			throw new IllegalArgumentException();
		this.academicScale = academicScale;
	}

	/**
	 * gets the social scale
	 * 
	 * @return the socialscale
	 */
	public int getSocialscale() {
		return socialscale;
	}

	/**
	 * sets the social scale
	 * 
	 * @param socialscale
	 *            the socialscale to set
	 */
	public void setSocialscale(int socialscale) {
		if(socialscale < 1 || socialscale > 5)
			throw new IllegalArgumentException();
		this.socialscale = socialscale;
	}

	/**
	 * gets the quality of life
	 * 
	 * @return the qualOfLife
	 */
	public int getQualOfLife() {
		return qualOfLife;
	}

	/**
	 * sets the quality of life
	 * 
	 * @param qualOfLife
	 *            the qualOfLife to set
	 */
	public void setQualOfLife(int qualOfLife) {
		if(qualOfLife < 1 || qualOfLife > 5)
			throw new IllegalArgumentException();
		this.qualOfLife = qualOfLife;
	}

	/**
	 * gets the emphasis of the school
	 * 
	 * @return the emphasis
	 */
	public String[] getEmphasis() {
		return emphasis;
	}

	/**
	 * sets the emphasis for the school
	 * 
	 * @param emphasis
	 *            the emphasis to set
	 */
	public void setEmphasis(String[] emphasis) {
		if(emphasis == null)
			throw new IllegalArgumentException();
		this.emphasis = emphasis;
	}

	/**
	 * gets string of emphases
	 * 
	 * @return emphases
	 */
	public String getEmphasisString() {
		String temp = "";
		for (int i = 0; i < this.emphasis.length; i++) {
			temp = temp + ", " + emphasis[i];
		}
		return temp;
	}

	/**
	 * removes an emphasis
	 * 
	 * @param emphasis
	 *            is schools emphasis
	 */
	public void removeEmphasis(String emphasis) {
		boolean found = false;
		String[] temp = new String[this.emphasis.length-1];
		for(int i=0; i<this.emphasis.length;i++){
			if (this.emphasis[i] == emphasis || found){
				found = true;
				if(i<this.emphasis.length-2)
					this.emphasis[i] = this.emphasis[i+1];
			}else
				this.emphasis[i]=this.emphasis[i];
		}
		if(found){
			for(int i=0;i< this.emphasis.length;i++){
				temp[i] = this.emphasis[i];
			}
			this.emphasis = temp;
		}
	}
		
		/*
		boolean found = false;
		try {
			for (int i = 0; i < this.emphasis.length; i++) {
				if (this.emphasis[i] == emphasis || found) {
					if (i < this.emphasis.length - 1)
						this.emphasis[i] = this.emphasis[i + 1];
					else
						this.emphasis[i] = null;
					found = true;
				}
			}
		} catch (NullPointerException ex) {
		}
	}

	/**
	 * gets the name of the school
	 * 
	 * @return the name of the school
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * sets the name of the school
	 * 
	 * @param name
	 *            name of the school
	public void setName(String name) {
		
		this.name = name;
	}
	 * sets the school with the name
	 * 
	 * @param name
	 *            is name of school
	 */


	/**
	 * gets the schools name
	 * 
	 * @return the name of the school
	 */
	public String getSchool() {
		return this.name;
	}
	
	public void addEmphasis(String emphasis){
	    String[] temp = new String[this.emphasis.length];
	    for(int i=0; i<this.emphasis.length; i++){
	    	temp[i] = this.emphasis[i];
	    }
		temp[this.emphasis.length-1] = emphasis;
		this.emphasis = temp;
	}
}
