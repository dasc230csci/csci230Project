package Controller;

import java.util.ArrayList;

import Entity.*;
import dblibrary.project.csci230.UniversityDBLibrary;
/**
 * This class is for managing DB which it enables to update, add, get information of
 * User or University
 * 
 * @author  Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version March 27, 2017
 */
public class UniversityDBController {
	
	/**
	 * University Database
	 */
	private UniversityDBLibrary dblib;
	
	/**
	  * Default Constructor
	  */
	public UniversityDBController(){
		dblib = new UniversityDBLibrary("dasc","dasc","csci230");
	}
	////////////////////////////////////////////////// leave for testing
	public boolean deleteUniversity(String name){
		if(getUniversity(name) == null){
			return false;
		}
		ArrayList<String> oldEmp = getUniversity(name).getEmphases();
		for(int i = 0; i < oldEmp.size(); i++){
			dblib.university_removeUniversityEmphasis(name, oldEmp.get(i));
		}
		int failed = dblib.university_deleteUniversity(name);
		if(failed != -1){
			return true;
		}
		else
			return false;
	}
	///////////////////////////////////////////////////
	/**
	  * Obtain University object from the database
	  * Searching by name of the school
	  * 
	  * @param schoolName name of the school
	  * @return corresponding University object and return null
	  *  if the school does not exist
	  */
	public University getUniversity(String schoolName){
		ArrayList<String> emphases = new ArrayList<String>();
		String[][] arr = dblib.university_getNamesWithEmphases();
		String[][] school = dblib.university_getUniversities();
		University university = null;
				
		for(int i =0 ; i < arr.length; i++){
			if(arr[i][0].equals(schoolName)){
				emphases.add(arr[i][1]);
			}
		}		
		for(int i =0 ; i< school.length ; i++){
			if(school[i][0].equals(schoolName)){
				for(int j = 0; j < school[i].length; j++){
					university = new University(school[i][0],school[i][1],school[i][2],school[i][3],Integer.parseInt(school[i][4]),
							Double.parseDouble(school[i][5]),Double.parseDouble(school[i][6]),Double.parseDouble(school[i][7]),
							Double.parseDouble(school[i][8]),Double.parseDouble(school[i][9]),Integer.parseInt(school[i][10]),
							Double.parseDouble(school[i][11]),Double.parseDouble(school[i][12]),Integer.parseInt(school[i][13]),
							Integer.parseInt(school[i][14]),Integer.parseInt(school[i][15]),emphases);
				}
			}
		}
		return university;
	}
	
	/**
	  * Update University information and store in DB
	  * 
	  * @param university University objects that had been updated
	  * @return true if the information can be updated
	  */
	public boolean updateUniversity(University university){
		String[][] arr = dblib.university_getNamesWithEmphases();
		ArrayList<String> previousEmphases = new ArrayList<String>();
		int updateEmpFailed = 0;
		int failed = dblib.university_editUniversity(university.getSchoolName(), university.getState(), university.getLocation(), university.getControl(), university.getNumOfEnrolled(),
				university.getFemaleRatio(), university.getSatVerbal(), university.getSatMath(), university.getExpenses(), 
				university.getPerFinanAid(), university.getTotNumOfApplicant(), university.getPerAdmitted(), university.getPerEnrolled(),
				university.getAcademicsScale(), university.getSocialScale(), university.getQualOfLifeScale());		
		if(failed != 1){
			return false;
		}
		for(int i =0 ; i < arr.length; i++){
			if(arr[i][0].equals(university.getSchoolName())){
				previousEmphases.add(arr[i][1]);
			}
		}
		if(previousEmphases != null){
			for(int i = 0; i < previousEmphases.size(); i++){
				dblib.university_removeUniversityEmphasis(university.getSchoolName(), previousEmphases.get(i));
			}
		}
		ArrayList<String> newEmphases = university.getEmphases();
		for(int i = 0; i < newEmphases.size(); i++){
			updateEmpFailed = dblib.university_addUniversityEmphasis(university.getSchoolName(), newEmphases.get(i));
		}
		
		if(updateEmpFailed != -1){
			return true;
		}
		return false;
	}

	/**
	  * Add new University in DB
	  * 
	  * @param university University objects that had been added
	  * @return true if the University can be added
	  */
	public boolean addUniversity(University university){
		int addEmpFailed = 0;
		int failed = dblib.university_addUniversity(university.getSchoolName(), university.getState(), university.getLocation(), university.getControl(), university.getNumOfEnrolled(),
				university.getFemaleRatio(), university.getSatVerbal(), university.getSatMath(), university.getExpenses(), 
				university.getPerFinanAid(), university.getTotNumOfApplicant(), university.getPerAdmitted(), university.getPerEnrolled(),
				university.getAcademicsScale(), university.getSocialScale(), university.getQualOfLifeScale());
		ArrayList<String> emphases = university.getEmphases();
		for(int i = 0; i < emphases.size(); i++){
			addEmpFailed = dblib.university_addUniversityEmphasis(university.getSchoolName(), emphases.get(i));
		}		
		if(failed != -1 && addEmpFailed != -1){
			return true;
		}
		return false;
	}
	
	/**
	 * Get the list of all universities in database
	 * 
	 * @return ArrayList<University> ArrayList that contains university objects
	 */
	public ArrayList<University> getUniversityList(){
		
		ArrayList<University> schoolInfo = new ArrayList<University>();
		String[][] school = dblib.university_getUniversities();
		String[][] empArr = dblib.university_getNamesWithEmphases();
		for(int i =0 ; i < school.length; i++){
			ArrayList<String> emphases = new ArrayList<String>();
			for(int j = 0; j < empArr.length; j++){
				if(empArr[j][0].equals(school[i][0])){
					emphases.add(empArr[j][1]);
				}
			}
			University university = new University(school[i][0],school[i][1],school[i][2],school[i][3],Integer.parseInt(school[i][4]),
					Double.parseDouble(school[i][5]),Double.parseDouble(school[i][6]),Double.parseDouble(school[i][7]),
					Double.parseDouble(school[i][8]),Double.parseDouble(school[i][9]),Integer.parseInt(school[i][10]),
					Double.parseDouble(school[i][11]),Double.parseDouble(school[i][12]),Integer.parseInt(school[i][13]),
					Integer.parseInt(school[i][14]),Integer.parseInt(school[i][15]),emphases);
			schoolInfo.add(university);
		}
		return schoolInfo;
	}
}
