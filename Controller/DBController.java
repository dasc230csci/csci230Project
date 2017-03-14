package Controller;

import java.util.ArrayList;

import Entity.*;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * This class is for managing DB which it enables to update, add, get information of
 * User or University
 * 
 * @author  Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version Mar 4, 2017
 */
public class DBController {
	
	/**
	 * University Database
	 */
	private UniversityDBLibrary dblib;
	
	/**
	  * Default Constructor
	  */
	public DBController(){
		dblib = new UniversityDBLibrary("dasc","dasc","csci230");
	}
	////////////////////////////////////////////////// leave for testing
	public boolean deleteUniversity(String name){
		if(getUniversity(name) == null){
			return false;
		}
		int failed = dblib.university_deleteUniversity(name);
		ArrayList<String> oldEmp = getUniversity(name).getEmphases();
		for(int i = 0; i < oldEmp.size(); i++){
			dblib.university_removeUniversityEmphasis(name, oldEmp.get(i));
		}		
		if(failed != -1){
			return true;
		}
		else
			return false;
	}
	public UniversityDBLibrary getDB(){
		return this.dblib;
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
		int updateEmpFailed = 0;
		int failed = dblib.university_editUniversity(university.getSchoolName(), university.getState(), university.getLocation(), university.getControl(), university.getNumOfEnrolled(),
				university.getFemaleRatio(), university.getSatVerbal(), university.getSatMath(), university.getExpenses(), 
				university.getPerFinanAid(), university.getTotNumOfApplicant(), university.getPerAdmitted(), university.getPerEnrolled(),
				university.getAcademicsScale(), university.getSocialScale(), university.getQualOfLifeScale());
		ArrayList<String> previousEmphases = getUniversity(university.getSchoolName()).getEmphases();
		for(int i = 0; i < previousEmphases.size(); i++){
			dblib.university_removeUniversityEmphasis(university.getSchoolName(), previousEmphases.get(i));
		}
		ArrayList<String> emphases = university.getEmphases();
		for(int i = 0; i < emphases.size(); i++){
			updateEmpFailed = dblib.university_addUniversityEmphasis(university.getSchoolName(), emphases.get(i));
		}
		
		if(failed != -1 && updateEmpFailed != -1){
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
	  * Search the university with the criteria that user input the information
	  * 
	  * @param schoolInfo ArrayList<String> that user want to search
	  * @return list of name of school within criteria that user input
	  */
	public ArrayList<String> search(ArrayList<String> schoolInfo){
		ArrayList<String> emphases = new ArrayList<String>();
		ArrayList<String> searched = new ArrayList<String>();
		ArrayList<String> schoolList = new ArrayList<String>();
		String[][] school = dblib.university_getUniversities();

		for (int i = 0; i < school.length; i++) {
			if (school[i][0].contains(schoolInfo.get(0)) && school[i][1].contains(schoolInfo.get(1))
					&& school[i][2].contains(schoolInfo.get(2)) && school[i][3].contains(schoolInfo.get(3))
					&& Double.parseDouble(school[i][4]) >= Double.parseDouble(schoolInfo.get(4))
					&& Double.parseDouble(school[i][4]) <= Double.parseDouble(schoolInfo.get(5))
					&& Double.parseDouble(school[i][5]) >= Double.parseDouble(schoolInfo.get(6))
					&& Double.parseDouble(school[i][5]) <= Double.parseDouble(schoolInfo.get(7))
					&& Double.parseDouble(school[i][6]) >= Double.parseDouble(schoolInfo.get(8))
					&& Double.parseDouble(school[i][6]) <= Double.parseDouble(schoolInfo.get(9))
					&& Double.parseDouble(school[i][7]) >= Double.parseDouble(schoolInfo.get(10))
					&& Double.parseDouble(school[i][7]) <= Double.parseDouble(schoolInfo.get(11))
					&& Double.parseDouble(school[i][8]) >= Double.parseDouble(schoolInfo.get(12))
					&& Double.parseDouble(school[i][8]) <= Double.parseDouble(schoolInfo.get(13))
					&& Double.parseDouble(school[i][9]) >= Double.parseDouble(schoolInfo.get(14))
					&& Double.parseDouble(school[i][9]) <= Double.parseDouble(schoolInfo.get(15))
					&& Integer.parseInt(school[i][10]) >= Integer.parseInt(schoolInfo.get(16))
					&& Integer.parseInt(school[i][10]) <= Integer.parseInt(schoolInfo.get(17))
					&& Double.parseDouble(school[i][11]) >= Double.parseDouble(schoolInfo.get(18))
					&& Double.parseDouble(school[i][11]) <= Double.parseDouble(schoolInfo.get(19))
					&& Double.parseDouble(school[i][12]) >= Double.parseDouble(schoolInfo.get(20))
					&& Double.parseDouble(school[i][12]) <= Double.parseDouble(schoolInfo.get(21))
					&& Integer.parseInt(school[i][13]) >= Integer.parseInt(schoolInfo.get(22))
					&& Integer.parseInt(school[i][13]) <= Integer.parseInt(schoolInfo.get(23))
					&& Integer.parseInt(school[i][14]) >= Integer.parseInt(schoolInfo.get(24))
					&& Integer.parseInt(school[i][14]) <= Integer.parseInt(schoolInfo.get(25))
					&& Integer.parseInt(school[i][15]) >= Integer.parseInt(schoolInfo.get(26))
					&& Integer.parseInt(school[i][15]) <= Integer.parseInt(schoolInfo.get(27))) {
				schoolList.add(school[i][0]);
			}
		} //////////////////////// search school without emphases
		
		for (int i = 28; i < schoolInfo.size(); i++) {
			emphases.add(schoolInfo.get(i));
		} //////////////////////// create emphases from schoolInfo to search
		
		if (!emphases.isEmpty()){
			for (int i = 0; i < schoolList.size(); i++) {
				for(int j = 0 ; j < emphases.size(); j++){
					if (getUniversity(schoolList.get(i)).getEmphases().contains(emphases.get(j))){
						searched.add(schoolList.get(i)); /////////////////////add school to final list that met with criteria
					}
				}
			}
		}
		else{
			searched = schoolList; //////////if emphases criteria is empty, then ignore it
		}
		return searched;
	}
	
	/**
	  * Search the university with the criteria that the university has been found
	  * by the user
	  * 
	  * @param University university with the information that user found from the search
	  * @return list of name of school within criteria
	  */
	public ArrayList<University> searchRecommendation(University university){
		return null;
	}
}
