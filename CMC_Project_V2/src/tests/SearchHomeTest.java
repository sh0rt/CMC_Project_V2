package tests;

import static org.junit.Assert.*;
import CMC_Classes.*;
import org.junit.Before;
import org.junit.Test;

public class SearchHomeTest {
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
}
