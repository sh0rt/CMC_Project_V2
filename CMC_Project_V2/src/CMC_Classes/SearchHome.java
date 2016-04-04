package CMC_Classes;


/** SearchHome
 * @authors Megan Pekarek, Cassie Meyer, Tyler Weiss, Conor Lorsung
 * @version March 15th, 2016
 */

import java.util.*;

public class SearchHome {
	DataBaseHome database;
	private School[] top5, recommend;
	private int[] top10;

	/**
	 * Search home through database
	 * 
	 * @param database
	 */
	public SearchHome(DataBaseHome database) {
		super();
		top10 = new int[10];
		top5 = new School[5];
		recommend = new School[5];
		this.database = database;
	}
	
	public SearchHome() {
		super();
		top10 = new int[10];
		top5 = new School[5];
		recommend = new School[5];
		this.database = new DataBaseHome();
	}
	/**
	 * Searches school by parameters
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

		try{
		if(name.equals(""))
			throw new IllegalArgumentException();
		}catch(NullPointerException ex){}
		try{
		if( state.equals(""))
			throw new IllegalArgumentException();
		}catch(NullPointerException ex){}
		try{
		if( location.equals(""))
			throw new IllegalArgumentException();
		}catch(NullPointerException ex){}
		try{
		if( control.equals("") )
			throw new IllegalArgumentException();
		}catch(NullPointerException ex){}
		try{
	    if( numStudents[0] <0 || numStudents[0] > numStudents[1] )
	    	throw new IllegalArgumentException();
		}catch(NullPointerException ex){}
	    try{
		if( satVerbal[0] < 0 || satVerbal[1] > 800 || satVerbal[0] > satVerbal[1])
			throw new IllegalArgumentException();
		}catch(NullPointerException ex){}
		try{
		if( satMath[0] < 0 || satMath[1] > 800 || satMath[0] > satMath[1])
			throw new IllegalArgumentException();
		}catch(NullPointerException ex){}
		try{
		if( numApplicants[0] < 0  || numApplicants[0] > numApplicants[1])
			throw new IllegalArgumentException();
		}catch(NullPointerException ex){}
		try{
		if( percentFemale[0] < 0 || percentFemale[0] > percentFemale[1] || 100 < percentFemale[1] )
			throw new IllegalArgumentException();
		}catch(NullPointerException ex){}
		try{
		if( expenses[0] < 0 || expenses[0] > expenses[1])
			throw new IllegalArgumentException();
		}catch(NullPointerException ex){}
		try{
		if( percentFinAid[0] < 0 || percentFinAid[1] > 100 || percentFinAid[0] > percentFinAid[1])
			throw new IllegalArgumentException();
		}catch(NullPointerException ex){}
		try{
		if( percentAdmitted[0] < 0 || percentAdmitted[1] > 100 || percentAdmitted[0] > percentAdmitted[1])
			throw new IllegalArgumentException();
		}catch(NullPointerException ex){}
		try{
		if( percentEnrolled[0] < 0 || percentEnrolled[1] > 100 || percentEnrolled[0] > percentEnrolled[1])
			throw new IllegalArgumentException();
		}catch(NullPointerException ex){}
		try{
		if( academicScale[0] < 1 || academicScale[1] > 5 || academicScale[0] > academicScale[1])
			throw new IllegalArgumentException();
		}catch(NullPointerException ex){}
		try{
		if( qualOfLife[0] < 1 || qualOfLife[1] > 5 || qualOfLife[0] > qualOfLife[1])
			throw new IllegalArgumentException();
		}catch(NullPointerException ex){}
		try{
		if( socialscale[0] < 1 || socialscale[1] > 5 || socialscale[0] > socialscale[1])
			throw new IllegalArgumentException();
		}catch(NullPointerException ex){}
		
		School[] top = new School[5];
		ArrayList<School> schools = database.getSchools();
		int[][] tally = new int[schools.size()][17];
		int[] tallys = new int[schools.size()];
		
		String[] s = new String[4]; // strings
		s[0] = name;
		s[1] = state;
		s[2] = location;
		s[3] = control;

		int[][] i = new int[5][2]; // integers
		i[0] = numStudents;
		i[1] = numApplicants;
		i[2] = academicScale;
		i[3] = socialscale;
		i[4] = qualOfLife;

		double[][] d = new double[7][2]; // doubles
		d[0] = satVerbal;
		d[1] = satMath;
		d[2] = percentFemale;
		d[3] = expenses;
		d[4] = percentFinAid;
		d[5] = percentAdmitted;
		d[6] = percentEnrolled;

		for (int t = 0; t < schools.size(); t++) {
			try {
				if (schools.get(t).getName().contains(s[0])) {
					tallys[t] += 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (schools.get(t).getState().contains(s[1])) {
					tallys[t] += 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (schools.get(t).getLocation().contains(s[2])) {
					tallys[t] += 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (schools.get(t).getControl().contains(s[3])) {
					tallys[t] +=1;
				}
			} catch (NullPointerException ex) {
			}

			try {
				if (i[0][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < i[0][1]) {
					tallys[t] += 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (i[1][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < i[1][1]) {
					tallys[t] += 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (i[2][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < i[2][1]) {
					tallys[t] += 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (i[3][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < i[3][1]) {
					tallys[t] += 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (i[4][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < i[4][1]) {
					tallys[t] += 1;
				}
			} catch (NullPointerException ex) {
			}

			try {
				if (d[0][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < d[0][1]) {
					tallys[t] += 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (d[1][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < d[1][1]) {
					tallys[t] += 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (d[2][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < d[2][1]) {
					tallys[t] += 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (d[3][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < d[3][1]) {
					tallys[t] += 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (d[4][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < d[4][1]) {
					tallys[t] += 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (d[5][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < d[5][1]) {
					tallys[t] += 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (d[6][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < d[6][1]) {
					tallys[t] += 1;
				}
			} catch (NullPointerException ex) {
			}
		}
		
		int highest = 0;
		int index = 0;
		int[] temp = new int[10];
		int[] count = tallys;
		for (int p = 0; p < 5; p++) { // find highest
			for (int g = 0; g < schools.size(); g++) {
				if (count[g] > highest) {
					highest = count[g];
					index = g;
				}
			}
		//	System.out.println(highest + " " + index);
			temp[p] = index; // index in the array of schools
			highest = 0;
			count[index] = 0;	
		}
		for (int h = 0; h < 5; h++) {
			for (int k = 0; k < schools.size(); k++) {
				if (count[k] > highest) {
					highest = count[k];
					index = k;
				}
			}
			temp[h + 5] = index;
			highest = 0;
			count[index] = 0;
		}
		top[0] = schools.get(temp[0]);
		top[1] = schools.get(temp[1]);
		top[2] = schools.get(temp[2]);
		top[3] = schools.get(temp[3]);
		top[4] = schools.get(temp[4]);
		this.top5[0] = schools.get(temp[0]);
		this.top5[1] = schools.get(temp[1]);
		this.top5[2] = schools.get(temp[2]);
		this.top5[3] = schools.get(temp[3]);
		this.top5[4] = schools.get(temp[4]);
		recommend[0] = schools.get(temp[5]);
		recommend[1] = schools.get(temp[6]);
		recommend[2] = schools.get(temp[7]);
		recommend[3] = schools.get(temp[8]);
		recommend[4] = schools.get(temp[9]);
		this.top10 = temp;
		return top;
	}
		//------------------------------finish up here------------------------------------------------ ^^^^^^^^^^
//		String[] em = emphasis;
	/*
		for (int t = 0; t < schools.size(); t++) {
			try {
				if (schools.get(t).getName().contains(s[0])) {
					tally[t][0] = 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (schools.get(t).getState().contains(s[1])) {
					tally[t][1] = 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (schools.get(t).getLocation().contains(s[2])) {
					tally[t][2] = 1;
				}
			} catch (NullPointerException ex) {		System.out.println(test.getID(0));
			}
			try {
				if (schools.get(t).getControl().contains(s[3])) {
					tally[t][3] = 1;
				}
			} catch (NullPointerException ex) {
			}

			try {
				if (i[0][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < i[0][1]) {
					tally[t][4] = 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (i[1][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < i[1][1]) {
					tally[t][5] = 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (i[2][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < i[2][1]) {
					tally[t][6] = 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (i[3][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < i[3][1]) {
					tally[t][7] = 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (i[4][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < i[4][1]) {
					tally[t][8] = 1;
				}
			} catch (NullPointerException ex) {
			}

			try {
				if (d[0][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < d[0][1]) {
					tally[t][9] = 1;
				}
			} catch (NullPointerException ex) {
			}
			try {		System.out.println(test.getID(0));
				if (d[1][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < d[1][1]) {
					tally[t][10] = 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if		int highest = 0;
				int index = 0;
				int[] temp = new int[10];
				int[] count = new int[schools.size()]; (d[2][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < d[2][1]) {
					tally[t][11] = 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (d[3][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < d[3][1]) {
					tally[t][12] = 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (d[4][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < d[4][1]) {
					tally[t][13] = 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (d[5][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < d[5][1]) {
					tally[t][14] = 1;
				}
			} catch (NullPointerException ex) {
			}
			try {
				if (d[6][0] < schools.get(t).getNumStudents() && schools.get(t).getNumStudents() < d[6][1]) {
					tally[t][15] = 1;
				}
			} catch (NullPointerException ex) {
			}

		}
		int highest = 0;
		int index = 0;
		int[] temp = new int[10];
		int[] count = new int[schools.size()];

		for (int q = 0; q < schools.size(); q++) { // get sum
			for (int t = 0; t < 16; t++) {
				count[q] += tally[q][t];
			}
		}

		for (int p = 0; p < 5; p++) { // find highest
			for (int g = 0; g < schools.size(); g++) {
				if (count[g] > highest) {
					highest = count[g];
					index = g;
				}
			}
			System.out.println(highest + " " + index);
			temp[p] = index; // index in the array of schools
			highest = 0;
			count[index] = 0;
		}

		for (int h = 0; h < 5; h++) {
			for (int k = 0; k < schools.size(); k++) {
				if (count[k] > highest) {
					highest = count[k];
					index = k;
				}
			}
			temp[h + 5] = index;
			highest = 0;
			count[index] = 0;
		}
		top[0] = schools.get(temp[0]);
		top[1] = schools.get(temp[1]);
		top[2] = schools.get(temp[2]);
		top[3] = schools.get(temp[3]);
		top[4] = schools.get(temp[4]);
		this.top5[0] = schools.get(temp[0]);
		this.top5[1] = schools.get(temp[1]);
		this.top5[2] = schools.get(temp[2]);
		this.top5[3] = schools.get(temp[3]);
		this.top5[4] = schools.get(temp[4]);
		recommend[0] = schools.get(temp[5]);
		recommend[1] = schools.get(temp[6]);
		recommend[2] = schools.get(temp[7]);
		recommend[3] = schools.get(temp[8]);
		recommend[4] = schools.get(temp[9]);
		this.top10 = temp;
		return top;
	}
	*/

	/**
	 * gets school ID
	 * 
	 * @param searchID
	 * @return top 10 schools based off search
	 */
	public int getID(int searchID) {
		if(searchID<0 || searchID>10)
			throw new IllegalArgumentException("ID must be between 0 and 10");
		return this.top10[searchID];
	}

	/**
	 * gets top 5 schools
	 * 
	 * @return schools
	 */
	public School[] getTop5() {
		return this.top5;
	}

	/**
	 * gets Recommendations based off of school search
	 * 
	 * @return schools
	 */
	public School[] getRecommend() {
		return this.recommend;
	}
	//---------------------------implementing correct way-----------------------------------
}
