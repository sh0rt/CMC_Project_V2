package tests;

import static org.junit.Assert.*;
import CMC_Classes.*;
import org.junit.Before;
import org.junit.Test;

public class SearchHomeTest {
	double[][] errordoubles = {{-1,12} , {12,101} , {50,801}};
	int[][] errorInts = {{-1,10} , {0,3} , {2,6}};
	String errorString = "";
	
	SearchHome test;
	String[] top5 = {"AMERICAN UNIVERSITY OF BEIRUT","CHALMERS UNIVERSITY OF TECHNOLOGY","UNIVERSITY OF ALABAMA"
			,"UNIVERSITY OF BRIDGEPORT","UNIVERSITY OF CALIFORNIA BERKELEY"};
	String[] top10 = {"UNIVERSITY OF CALIFORNIA DAVIS","UNIVERSITY OF CALIFORNIA LOS ANGELES","UNIVERSITY OF CALIFORNIA SAN DIEGO",
			"UNIVERSITY OF CALIFORNIA SANTA CRUZ","UNIVERSITY OF CHICAGO"};
	
	@Before
	public void setUp() throws Exception {
		test = new SearchHome();
		// add in a state that a few schools fit
		School[] search = test.search("UNIVERSITY OF",null, null, null, null,
				null, null, null, null, null, null, null, null, null,
				null, null, null);
		/*
		for(int i=0; i<search.length; i++){
		  System.out.println(search[i].getName());
		}
		for(int i=0; i<search.length; i++){
			System.out.println(test.getRecommend()[i].getSchool());
		}
		*/
	}

	@Test 
	public void testgetTop5() { 
		assertTrue("get top5 fail", top5[0].equals(test.getTop5()[0].getSchool()));
		assertTrue("get top5 fail", top5[1].equals(test.getTop5()[1].getSchool()));
		assertTrue("get top5 fail", top5[2].equals(test.getTop5()[2].getSchool()));
		assertTrue("get top5 fail", top5[3].equals(test.getTop5()[3].getSchool()));
		assertTrue("get top5 fail", top5[4].equals(test.getTop5()[4].getSchool()));
	}
	@Test
	public void testgetTop10() { 
		assertTrue("get recommended fail", top10[0].equals(test.getRecommend()[0].getSchool()));
		assertTrue("get recommended fail", top10[1].equals(test.getRecommend()[1].getSchool()));
		assertTrue("get recommended fail", top10[2].equals(test.getRecommend()[2].getSchool()));
		assertTrue("get recommended fail", top10[3].equals(test.getRecommend()[3].getSchool()));
		assertTrue("get recommended fail", top10[4].equals(test.getRecommend()[4].getSchool()));
	}
	@Test
	public void testGetID() { 
		assertTrue("get ID fail", test.getID(0) == 2);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsNegativeGetID() { 
		 test.getID(-1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsGetIDGreaterThan10() { 
		 test.getID(11);
	}
	//----------------------------------------------------------test failures-------------------------------------------
	/*
	public School[] search(String name, String state, String location, String control, int[] numStudents,
			double[] satVerbal, double[] satMath, int[] numApplicants, double[] percentFemale, double[] expenses,
			double[] percentFinAid, double[] percentAdmitted, double[] percentEnrolled, int[] academicScale,
			int[] socialscale, int[] qualOfLife, String[] emphasis
			*/
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForEmptySchool(){
		test.search(errorString,null, null, null, null, null, null, null, 
				null, null, null, null, null, null, null, null, null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForEmptyState(){
	   test.search(null,errorString, null, null, null, null, null, null, 
				null, null, null, null, null, null, null, null, null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForEmptyLocation(){
	   test.search(null,null, errorString, null, null, null, null, null, 
				null, null, null, null, null, null, null, null, null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForEmptyControl(){
	   test.search(null,null, null, errorString, null, null, null, null, 
				null, null, null, null, null, null, null, null, null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForNegativeNumStudents(){
	   test.search(null,null, null, null, errorInts[0], null, null, null, 
				null, null, null, null, null, null, null, null, null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForNegativeSatVerbal(){
	   test.search(null,null, null, null, null, errordoubles[0], null, null, 
				null, null, null, null, null, null, null, null, null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForOverSatVerbal(){
	   test.search(null,null, null, null, null, errordoubles[2], null, null, 
				null, null, null, null, null, null, null, null, null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForNegativeSatMath(){
	   test.search(null,null, null, null, null, null, errordoubles[0], null, 
				null, null, null, null, null, null, null, null, null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForOverSatMath(){
	   test.search(null,null, null, null, null, null, errordoubles[2], null, 
				null, null, null, null, null, null, null, null, null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForNegativeNumStudents2(){
	   test.search(null,null, null, null, null, null, null, errorInts[0], 
				null, null, null, null, null, null, null, null, null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForNegativePercentFemale(){
	   test.search(null,null, null, null, null,null, null,null, errordoubles[0] ,
				null, null, null, null, null, null, null, null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForOverPercentFemale(){
	   test.search(null,null, null, null, null,null,null , null, errordoubles[1],
				 null, null, null, null, null, null, null, null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForNegativeExpenses(){
	   test.search(null,null, null, null, null, null, errordoubles[0], null, 
				null, null, null, null, null, null, null, null, null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForNegativeFinancialAid(){
	   test.search(null,null, null, null, null, null, null, null, null,
			   null, null ,errordoubles[0], null ,null,null,null,null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForOverFinancialAid(){
	   test.search(null,null, null, null, null, null, null, null, null,
			  null,null, errordoubles[1], null, null, null, null, null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForNegativePercentAdmitted(){
	   test.search(null,null, null, null, null, null, null, null, 
				null, null, null, errordoubles[0],null, null, null, null, null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForOverPercentAdmitted(){
	   test.search(null,null, null, null, null, null, null, null, 
				null, null, null, errordoubles[1],null, null, null, null, null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForNegativePErcentEnrolled(){
	   test.search(null,null, null, null, null, null, null, null, 
				null,null, null, null, errordoubles[0], null,null, null, null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForNegativeAcademicScale(){
	   test.search(null,null, null, null, null, null, null, null, 
				null, null, null, null, null, errorInts[1], null, null,null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForOverAcademicScale(){
	   test.search(null,null, null, null, null, null, null, null, 
				null, null, null, null, null, errorInts[2], null, null,null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForNegativeSocialScale(){
	   test.search(null,null, null, null, null, null, null, null, 
				null, null, null, null, null, null, errorInts[1], null,null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForOverSocialScale(){
	   test.search(null,null, null, null, null, null, null, null, 
				null, null, null, null, null, null, errorInts[2], null,null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForNegativeQualOFLife(){
	   test.search(null,null, null, null, null, null, null, null, 
				null, null, null, null, null, null, null, errorInts[1],null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsForOverQualOFLife(){
	   test.search(null,null, null, null, null, null, null, null, 
				null, null, null, null, null, null,null, errorInts[2],null);
	}
	
	}
