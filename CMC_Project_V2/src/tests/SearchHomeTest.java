package tests;

import static org.junit.Assert.*;
import CMC_Classes.*;
import org.junit.Before;
import org.junit.Test;

public class SearchHomeTest {
	SearchHome test;
	@Before
	public void setUp() throws Exception {
		School[] top 5, top10;

		test = new SearchHome();
		// add in a state that a few schools fit
		String[] search = test.search(null, STATE!!!!, null, null, null,
				null, null, null, null, null, null, null, null, null,
				null, null, null);
	}

	@Test
	public void testgetTop5() { 
		assertTrue("get top5 fail", top5.equals(search.getTop5());
	}
	@Test
	public void testgetTop5() { 
		assertTrue("get recommended fail", top10.equals(search.getRecommended());
	}
	@Test
	public void testGetID() { 
		assertTrue("get ID fail", search.getID(0).equals(0));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsNegativeGetID() { 
		 search.getID(-1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFailsGetIDGreaterThan10() { 
		 search.getID(11);
	}
}
