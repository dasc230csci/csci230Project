
/**
 * File: UniveristyController.java
 */
package Controller;
import java.util.ArrayList;

import Entity.University;

/**
 * A Class representing a University Controller and all its functions.
 * 
 * @author  Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version March 27, 2017
 */

public class UniversityController {
	
	/**
	 * DBController to access to database to edit, or add new university
	 */
	private UniversityDBController universityDBController;
	
	/**
	 * Default Constructor. Initialize UniversityDBController
	 */
	public UniversityController(){
		universityDBController = new UniversityDBController();
	}

	/**
	 * A method that create a new university based on the array of input
	 * 
	 * @param schoolInfo the information to create a new university
	 * @return boolean true if successfully create new university
	 */
	public boolean createUniversity(ArrayList<String> schoolInfo){
		ArrayList<String> emphases = new ArrayList<String>();
		for(int i = 16; i < schoolInfo.size(); i++){
			emphases.add(schoolInfo.get(i));
		}
		University newUniversity = new University(schoolInfo.get(0),schoolInfo.get(1),schoolInfo.get(2),schoolInfo.get(3),Integer.parseInt(schoolInfo.get(4)),
				Double.parseDouble(schoolInfo.get(5)),Double.parseDouble(schoolInfo.get(6)),Double.parseDouble(schoolInfo.get(7)),
				Double.parseDouble(schoolInfo.get(8)),Double.parseDouble(schoolInfo.get(9)),Integer.parseInt(schoolInfo.get(10)),
				Double.parseDouble(schoolInfo.get(11)),Double.parseDouble(schoolInfo.get(12)),Integer.parseInt(schoolInfo.get(13)),
				Integer.parseInt(schoolInfo.get(14)),Integer.parseInt(schoolInfo.get(15)),emphases);
		boolean isFailed = universityDBController.addUniversity(newUniversity);
		return isFailed;
	}

	/**
	 * A method that get the details of the University
	 * 
	 * @param schoolName the name of the University that we need the information
	 * @return University the university with the complete information
	 */
	public University getUniversityInDetailed(String schoolName){
		University university = universityDBController.getUniversity(schoolName);
		return university;
	}

	/**
	 * A method that set the details of the university
	 * 
	 * @param editInfo the array that contains the information that need to be change
	 * @return boolean if the changes are made or not
	 */
	public boolean editUniversityInDetailed(ArrayList<String> editInfo){
		ArrayList<String> emphases = new ArrayList<String>();
		for(int i = 16; i < editInfo.size(); i++){
			emphases.add(editInfo.get(i));
		}
		University newUniversity = new University(editInfo.get(0),editInfo.get(1),editInfo.get(2),editInfo.get(3),Integer.parseInt(editInfo.get(4)),
				Double.parseDouble(editInfo.get(5)),Double.parseDouble(editInfo.get(6)),Double.parseDouble(editInfo.get(7)),
				Double.parseDouble(editInfo.get(8)),Double.parseDouble(editInfo.get(9)),Integer.parseInt(editInfo.get(10)),
				Double.parseDouble(editInfo.get(11)),Double.parseDouble(editInfo.get(12)),Integer.parseInt(editInfo.get(13)),
				Integer.parseInt(editInfo.get(14)),Integer.parseInt(editInfo.get(15)),emphases);
		boolean isFailed = universityDBController.updateUniversity(newUniversity);
		return isFailed;
	}
	
	/**
	 * Get all universities that exist in database
	 * @return ArrayList<University> list of all universities
	 */
	public ArrayList<University> getUniversityList(){
		ArrayList<University> universityList = new ArrayList<University>();
		universityList = universityDBController.getUniversityList();
		return universityList;
	}
}