package Controller;

import java.util.ArrayList;

import Entity.University;

/**
 * public class searchController, controls all calls
 * made to search through the university database with 
 * the methods stored in the class, then makes the call
 * to the DB controller to conducted the search.
 */


public class SearchController{
	
	/**
	 * DBController to search school
	 */
	private DBController dbController;
	
	/**
	 * ArrayList<String> to save searched school list
	 */
	private ArrayList<String> searchedSchool;
  
  /**
   * the default constructor method for the search controller 
   * class, creates an instance of the controller in order to 
   * execute the search methods in the database.
   */
  
	/**
	 * Default Constructor
	 */
  public SearchController(){
	  dbController = new DBController();
  }
  
  /**
   * the search() method, used whenever a call is made by ]
   * the user to search for schools similar to the provided 
   * school parameter, returning a collection of University objects
   * with similar school statistics as the parameter
   * @param ArrayList<String> information of the school to search
   * @return a collection of University objects
   */
  public ArrayList<University> search(ArrayList<String> schoolInfo){
	ArrayList<String> searchedSchoolList = dbController.search(schoolInfo);
    return null;
  }
  /**
   * the searchRecomendations() method, returns the top 5 schools
   * it finds to be the most similar to the parameter provided 
   * University
   * @param ArrayList<String> information of the school to search recommendation
   * @return a collection of 5 university objects
   */
  public ArrayList<University> searchRecomendations(ArrayList<String> schoolInfo){
	  return null;
  }
}