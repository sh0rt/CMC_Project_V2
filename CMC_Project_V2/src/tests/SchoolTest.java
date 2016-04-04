package tests;

import static org.junit.Assert.*;
import CMC_Classes.*;
import org.junit.Before;
import org.junit.Test;

public class SchoolTest {
	School school1;
	
	@Before
	public void setUp() throws Exception {
		school1 = new School("University of Minnesota","Minnesota", "URBAN", "UNKNOWN", 500000, .45, 20,30,5000.0,.3,1000,.5,.3,4,3,5);
	}
	//-----------------------------------------------------------Test getters-------------------------------------------------------------
	@Test
	public void getState() {
		assertTrue("getState working", school1.getState().equals("Minnesota"));
	}
	@Test
	public void getLocation() {
		assertTrue("getLocation working", school1.getLocation().equals("URBAN"));
	}
	@Test
	public void getControl() {
		assertTrue("getControl working", school1.getControl().equals("UNKNOWN"));
	}
	@Test
	public void getNumberOfStudents() {
		assertTrue("getNumberOfStudents working", school1.getNumStudents() == 500000);
	}
	@Test
	public void getPercentFemales() {
		assertTrue("getPercentFemales working", school1.getPercentFemale() == .45);
	}
	@Test
	public void getSATVerbal() {
		assertTrue("getSatVerbal working", school1.getSatVerbal() == 20);
	}
	@Test
	public void getSatMath() {
		assertTrue("getSatMath working", school1.getSatMath() == 30);
	}
	@Test
	public void getExpenses() {
		assertTrue("getSatMath working", school1.getExpenses() == 5000.0);
	}
	@Test
	public void getPercentFinancialAid() {
		assertTrue("getPercentFinancialAid working", school1.getPercentFinAid() == .3);
	}
	@Test
	public void getNumberOfAplicants() {
		assertTrue("getNumberOfApplicants working", school1.getNumApplicants() == 1000);
	}
	@Test
	public void getPercentAdmitted() {
		assertTrue("getPercentAdmitted working", school1.getPercentAdmitted() == .5);
	}
	@Test
	public void getPercentEnrolled() {
		assertTrue("getPercentFinancialAid working", school1.getPercentEnrolled() == .3);
	}
	@Test
	public void getAcademicScale() {
		assertTrue("getAcademicScale working", school1.getAcademicScale() == 4);
	}
	@Test
	public void getSocialScale() {
		assertTrue("getSocialScale working", school1.getSocialscale() == 3);
	}
	@Test
	public void getQualOfLifeScale() {
		assertTrue("getQualOfLifeScale working", school1.getQualOfLife() == 5);
	}
	@Test
	public void testGetEmphasis() {
		school1.addEmphasis("compsci");
		assertTrue("getEmphasis working", school1.getEmphasisString().contains("compsci"));
	}
	@Test
	public void testGetSchool() {
		assertTrue("getSchool working", school1.getSchool() == "University of Minnesota");
	}
	//----------------------------------------------------------test setters------------------------------- ADD IN SETTERS TO ONES BELOW!!!!
	@Test
	public void setState() {
		school1.setState("test");
		assertTrue("setState working", school1.getState().equals("test"));
	}
	@Test
	public void setLocation() {
		school1.setLocation("test");
		assertTrue("setLocation working", school1.getLocation().equals("test"));
	}
	@Test
	public void setControl() {
		school1.setControl("test");
		assertTrue("setControl working", school1.getControl().equals("test"));
	}
	@Test
	public void setNumberOfStudents() {
		school1.setNumStudents(1000);
		assertTrue("setNumberOfStudents working", school1.getNumStudents() == 1000);
	}
	@Test
	public void setPercentFemales() {
		school1.setPercentFemale(20.0);
		assertTrue("setPercentFemales working", school1.getPercentFemale() == 20.0);
	}
	@Test
	public void setSATVerbal() {
		school1.setSatVerbal(300.0);
		assertTrue("setSatVerbal working", school1.getSatVerbal() == 300.0);
	}
	@Test
	public void setSatMath() {
		school1.setSatMath(300.0);
		assertTrue("setSatMath working", school1.getSatMath() == 300.0);
	}
	@Test
	public void setExpenses() {
		school1.setExpenses(1000.0);
		assertTrue("setSatMath working", school1.getExpenses() == 1000.0);
	}
	@Test
	public void setPercentFinancialAid() {
		school1.setPercentFinAid(10.0);
		assertTrue("setPercentFinancialAid working", school1.getPercentFinAid() == 10.0);
	}
	@Test
	public void setNumberOfAplicants() {
		school1.setNumApplicants(1);
		assertTrue("setNumberOfApplicants working", school1.getNumApplicants() == 1);
	}
	@Test
	public void setPercentAdmitted() {
		school1.setPercentAdmitted(.3);
		assertTrue("setPercentAdmitted working", school1.getPercentAdmitted() == .3);
	}
	@Test
	public void setPercentEnrolled() {
		school1.setPercentEnrolled(.4);
		assertTrue("setPercentFinancialAid working", school1.getPercentEnrolled() == .4);
	}
	@Test
	public void setAcademicScale() {
		school1.setAcademicScale(2);
		assertTrue("setAcademicScale working", school1.getAcademicScale() == 2);
	}
	@Test
	public void setSocialScale() {
		school1.setSocialscale(2);
		assertTrue("setSocialScale working", school1.getSocialscale() == 2);
	}
	@Test
	public void setQualOfLifeScale() {
		school1.setQualOfLife(1);
		assertTrue("setQualOfLifeScale working", school1.getQualOfLife() == 1);
	}
	@Test
	public void testSetEmphasis() {
		String[] test = {"code", "computers", "stuff"};
		school1.setEmphasis(test);
		assertTrue("setEmphasis working", school1.getEmphasisString().contains("code"));
		assertTrue("setEmphasis working", school1.getEmphasisString().contains("computers"));
		assertTrue("setEmphasis working", school1.getEmphasisString().contains("stuff"));
	}
	//---------------------------------------------Test Failures------------------------------------------------
	@Test(expected = IllegalArgumentException.class)
	public void setEmptyState(){
		school1.setState("");
	}
	@Test(expected = IllegalArgumentException.class)
	public void setEmptyLocation(){
		school1.setLocation("");
	}
	@Test(expected = IllegalArgumentException.class)
	public void setEmptyControl(){
		school1.setControl("");
	}
	@Test(expected = IllegalArgumentException.class)
	public void setNegativeNumStudents(){
		school1.setNumStudents(-1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void setNegativeSatVerbal(){
		school1.setSatVerbal(-1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void setOverSatVerbal(){
		school1.setSatVerbal(801);
	}
	@Test(expected = IllegalArgumentException.class)
	public void setNegativeSatMath(){
		school1.setSatMath(-1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void setOverSatMath(){
		school1.setSatMath(801);
	}
	@Test(expected = IllegalArgumentException.class)
	public void setNegativeNumApplicants(){
		school1.setNumApplicants(-1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void setNegativePercentFemale(){
		school1.setPercentFemale(-1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void setOverPercentFemale(){
		school1.setPercentFemale(801);
	}
	@Test(expected = IllegalArgumentException.class)
	public void setNegativeExpenses(){
		school1.setExpenses(-1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void setNegativePercentFinAid(){
		school1.setPercentFinAid(-1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void setOverPercentFinAid(){
		school1.setPercentFinAid(801);
	}
	@Test(expected = IllegalArgumentException.class)
	public void setNegativePercentAdmitted(){
		school1.setPercentAdmitted(-1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void setOverPercentAdmitted(){
		school1.setPercentAdmitted(801);
	}
	@Test(expected = IllegalArgumentException.class)
	public void setNegativePercentEnrolled(){
		school1.setPercentEnrolled(-1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void setOverPercentEnrolled(){
		school1.setPercentEnrolled(801);
	}
	@Test(expected = IllegalArgumentException.class)
	public void setUnderAcademicScale(){
		school1.setAcademicScale(0);
	}
	@Test(expected = IllegalArgumentException.class)
	public void setOverAcademicScale(){
		school1.setAcademicScale(6);
	}
	@Test(expected = IllegalArgumentException.class)
	public void setUnderSocialScale(){
		school1.setSocialscale(0);
	}
	@Test(expected = IllegalArgumentException.class)
	public void setOverSocialScale(){
		school1.setSocialscale(6);
	}
	@Test(expected = IllegalArgumentException.class)
	public void setUnderQualOfLife(){
		school1.setQualOfLife(0);
	}
	@Test(expected = IllegalArgumentException.class)
	public void setOverQualOfLife(){
		school1.setQualOfLife(6);
	}
	@Test(expected = IllegalArgumentException.class)
	public void setEmptyEmphasis() {
		school1.setEmphasis(null);
	}
	
}
