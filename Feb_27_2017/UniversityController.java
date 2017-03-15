/**
 * File: UniveristyController.java
 */
import java.util.ArrayList;

/**
 * A Class representing a University Controller and all its functions.
 * 
 * @authors  Anh Tran, Caitlin Harvey, Daniel Song, Sam Halloran
 * @version February 2017
 */

public class UniversityController {
  private University university;
  //private DBController dbcontroller; uncommon after we have the class
  
  /**
   * A constructor to create a new university controller that has a specific univerisy
   * 
   * @param university the university 
   */
  public UniversityController(University university)
  {
    this.university=university;
  }
  
  /**
   * A method that create a new university based on the array of input
   * 
   * @param schoolInfo the information to create a new university
   * @return an university
   */
  public University createUniversity(ArrayList<String> schoolInfo)
  {
    return null;
  }
  
  /**
   * A method that get the details of the University
   * 
   * @param schoolName the name of the University that we need the information
   * @return University the university with the complete information
   */
  public University getUniversityInDetailed(String schoolName)
  {
    return null;
  }
  
  /**
   * A method that set the details of the university
   * 
   * @param editInfo the array that contains the information that need to be change
   * @return boolean if the changes are made or not
   */
  public boolean editUniversityInDetailed(ArrayList<String> editInfo)
  {
    return false;
  }
  
  /**
   * A method that get the saved school for student
   * 
   * @return the array list that has the name of all the saved school
   */
  public ArrayList<String> getSavedSchool()
  {
    return null;
  }
}