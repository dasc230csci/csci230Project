/*
 * File: University.java
 */
package Entity;

import java.util.*;

/**
 * A Class representing a University and all its functions.
 * 
 * @author  Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version Feburary 27, 2017
 */
public class University {
	
	private String schoolName, state, location, control;
	private int numOfEnrolled, totNumOfApplicant, academicsScale, socialScale, qualOfLifeScale;
	private double femaleRatio, satVerbal, satMath, expenses, perFinanAid, perAdmitted, perEnrolled;
	private ArrayList<String> emphases;

	/**
	 * Constructor of the University class to create an university with the
	 * specific information for parameter
	 * 
	 * @param schoolName school name
	 * @param state state school is in
	 * @param location specific location of the school
	 * @param control private or public
	 * @param numOfEnrolled number of enrollment
	 * @param femaleRatio the ratio of female to male
	 * @param satVerbal the SAT verbal score
	 * @param satMath the SAT math score
	 * @param expenses the expenses of one school year
	 * @param perFinanAid the percentage of students get financial aid
	 * @param totNumOfApplicant total number of applicant
	 * @param perAdmitted the percentage of applicants that get accepted
	 * @param perEnrolled the percentage of applicants that enrolled
	 * @param academicScale scale of academic from 1-5
	 * @param socialScale the quality of the community and social life
	 * @param qualOfLifeScale the quality of life scale 
	 * @param emphases the emphases of the school
	 */
	public University(String schoolName, String state, String location, String control, int numOfEnrolled,
			double femaleRatio, double satVerbal, double satMath, double expenses, double perFinanAid,
			int totNumOfApplicant, double perAdmitted, double perEnrolled, int academicScale, int socialScale, int qualOfLifeScale,
			ArrayList<String> emphases) {
		this.schoolName = schoolName;
		this.state = state;
		this.location = location;
		this.control = control;
		this.numOfEnrolled = numOfEnrolled;
		this.femaleRatio = femaleRatio;
		this.satVerbal = satVerbal;
		this.satMath = satMath;
		this.expenses = expenses;
		this.perFinanAid = perFinanAid;
		this.totNumOfApplicant = totNumOfApplicant;
		this.perAdmitted = perAdmitted;
		this.perEnrolled = perEnrolled;
		this.academicsScale = academicScale;
		this.socialScale = socialScale;
		this.qualOfLifeScale = qualOfLifeScale;
		this.emphases = emphases;
	}

	/**
	 * Returns the school name.
	 * 
	 * @return the schoolName
	 */
	public String getSchoolName() {
		return schoolName;
	}

	/**
	 * Sets the school name.
	 * 
	 * @param schoolName
	 *            the schoolName to set
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	/**
	 * Returns the state.
	 * 
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 * 
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Returns the location.
	 * 
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 * 
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Returns the control.
	 * 
	 * @return the control
	 */
	public String getControl() {
		return control;
	}

	/**
	 * Sets the control.
	 * 
	 * @param control
	 *            the control to set
	 */
	public void setControl(String control) {
		this.control = control;
	}

	/**
	 * Returns the number of enrolled.
	 * 
	 * @return the numOfEnrolled
	 */
	public int getNumOfEnrolled() {
		return numOfEnrolled;
	}

	/**
	 * Sets the number of enrolled.
	 * 
	 * @param numOfEnrolled
	 *            the numOfEnrolled to set
	 */
	public void setNumOfEnrolled(int numOfEnrolled) {
		this.numOfEnrolled = numOfEnrolled;
	}

	/**
	 * Returns total number of applicants.
	 * 
	 * @return the totNumOfApplicant
	 */
	public int getTotNumOfApplicant() {
		return totNumOfApplicant;
	}

	/**
	 * Sets total number of applicants.
	 * 
	 * @param totNumOfApplicant
	 *            the totNumOfApplicant to set
	 */
	public void setTotNumOfApplicant(int totNumOfApplicant) {
		this.totNumOfApplicant = totNumOfApplicant;
	}

	/**
	 * Returns the academic scale.
	 * 
	 * @return the academicsScale
	 */
	public int getAcademicsScale() {
		return academicsScale;
	}

	/**
	 * Sets the academic scale.
	 * 
	 * @param academicsScale
	 *            the academicsScale to set
	 */
	public void setAcademicsScale(int academicsScale) {
		this.academicsScale = academicsScale;
	}

	/**
	 * Returns the social scale.
	 * 
	 * @return the socialScale
	 */
	public int getSocialScale() {
		return socialScale;
	}

	/**
	 * Sets the social scale.
	 * 
	 * @param socialScale
	 *            the socialScale to set
	 */
	public void setSocialScale(int socialScale) {
		this.socialScale = socialScale;
	}

	/**
	 * Returns the quality of life scale.
	 * 
	 * @return the qualOfLifeScale
	 */
	public int getQualOfLifeScale() {
		return qualOfLifeScale;
	}

	/**
	 * Sets the quality of life scale.
	 * 
	 * @param qualOfLifeScale
	 *            the qualOfLifeScale to set
	 */
	public void setQualOfLifeScale(int qualOfLifeScale) {
		this.qualOfLifeScale = qualOfLifeScale;
	}

	/**
	 * Returns the female ratio.
	 * 
	 * @return the femaleRatio
	 */
	public double getFemaleRatio() {
		return femaleRatio;
	}

	/**
	 * Sets the female ratio.
	 * 
	 * @param femaleRatio
	 *            the femaleRatio to set
	 */
	public void setFemaleRatio(Double femaleRatio) {
		this.femaleRatio = femaleRatio;
	}

	/**
	 * Returns the SAT Verbal.
	 * 
	 * @return the satVerbal
	 */
	public double getSatVerbal() {
		return satVerbal;
	}

	/**
	 * Sets the SAT Verbal
	 * 
	 * @param satVerbal
	 *            the satVerbal to set
	 */
	public void setSatVerbal(Double satVerbal) {
		this.satVerbal = satVerbal;
	}

	/**
	 * Returns the SAT math.
	 * 
	 * @return the satMath
	 */
	public double getSatMath() {
		return satMath;
	}

	/**
	 * sets the SAT math.
	 * 
	 * @param satMath
	 *            the satMath to set
	 */
	public void setSatMath(Double satMath) {
		this.satMath = satMath;
	}

	/**
	 * Returns the expenses.
	 * 
	 * @return the expenses
	 */
	public double getExpenses() {
		return expenses;
	}

	/**
	 * Sets the expenses.
	 * 
	 * @param expenses
	 *            the expenses to set
	 */
	public void setExpenses(Double expenses) {
		this.expenses = expenses;
	}

	/**
	 * Returns the per admitted ratio.
	 * 
	 * @return the perAdmitted
	 */
	public double getPerAdmitted() {
		return perAdmitted;
	}

	/**
	 * Sets the per admitted ratio.
	 * 
	 * @param perAdmitted
	 *            the perAdmitted to set
	 */
	public void setPerAdmitted(Double perAdmitted) {
		this.perAdmitted = perAdmitted;
	}

	/**
	 * Returns the per enrolled ratio.
	 * 
	 * @return the perEnrolled
	 */
	public double getPerEnrolled() {
		return perEnrolled;
	}

	/**
	 * Sets the per enrolled ratio.
	 * 
	 * @param perEnrolled
	 *            the perEnrolled to set
	 */
	public void setPerEnrolled(Double perEnrolled) {
		this.perEnrolled = perEnrolled;
	}

	/**
	 * Returns the emphases.
	 * 
	 * @return the emphases
	 */
	public ArrayList<String> getEmphases() {
		return emphases;
	}

	/**
	 * Sets the emphases.
	 * 
	 * @param emphases
	 *            the emphases to set
	 */
	public void setEmphases(ArrayList<String> emphases) {
		this.emphases = emphases;
	}
	
	/**
	 * Method to get percentage of student who get financial aid
	 * @return double perFinanAid
	 */
	public double getPerFinanAid(){
		return this.perFinanAid;
	}
	
	/**
	 * Method to set percentage of student who get financial aid
	 * @param perFinanAid percentage of student receive financial aid
	 */
	public void setPerFinanAid(double perFinanAid){
		this.perFinanAid = perFinanAid;
	}

}
