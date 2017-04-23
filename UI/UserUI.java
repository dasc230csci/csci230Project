/**
 * File: UserUI.java
 */

package UI;

import java.util.ArrayList;
import Entity.*;
import Controller.*;

/**
 * Class to represent the User UI.
 * 
 * @author  Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version March 27, 2017
 */


public class UserUI{
 /**
  * UserFuncController which provide
  * functionality of user
  */
 private UserFuncController userFuncController;
 
 /**
  * Allows functionality of logout.
  */
 private LoginController loginController;
 
 /**
  * username of the User
  */
 private String username;
 
 /**
  * information of the User
  */
 private User user;
  
 /**
  * the constructor to create a UserUI for a specific user
  * @param user the user using the system
  */
 public UserUI(String username){
   this.userFuncController= new UserFuncController();
   this.username = username;
   user = userFuncController.getProfile(username);
   user.setLoggedIn(true);
   this.loginController = new LoginController();
 }

 
  /**
   * the viewSavedSchools method, returns the current
   * array list of saved schools associated with the
   * current user signed in.
   */
  public ArrayList<String> viewSavedSchool(){
    ArrayList<String> savedSchool = this.userFuncController.viewSavedSchool(username);
    return savedSchool;
  }
  
  /**
   * the viewProfile() method, returns a Account object(either User or Admin)
   * and allows the user to alter his/her personal profile as they 
   * see fit.
   * @return an instance of the Users Account
   */ 
  public User viewProfile(){
	this.user = userFuncController.getProfile(username);
	this.user.setLoggedIn(true);
    return this.user;
  }
  
  /**
   * this method edit the profile of user
   * 
   * @param firstname first name of the user
   * @param lastname last name of the user
   * @param password password of the user
   * @return true if successfully edit profile
   */  
  public boolean editProfile(String firstName, String lastName, String password){
    if(userFuncController.editProfile(username, firstName, lastName, password)){
     return true; 
    }
   return false;
  }
  
  /**
   * the saveScool() method, sends the University chosen
   * to be saved to the savedSchools array list 
   * that is saved for the user.
   * 
   * @param schoolName name of the school to be saved
   * @returns true if the school is successfully saved 
   */
  public boolean saveUniversity(String schoolName){
    if(userFuncController.saveSchool(username, schoolName)){
      return true;
    }
   return false;
  }
  
  /**
   * the removeSavedUniversity() method, removes a specified school
   * (assuming it is present in the users savedSchools array) and 
   * return a boolean true if it was successfully removed.
   * 
   * @param schoolName name of the school to be saved
   * @returns true if the school successfully removed 
   */ 
  public boolean removeSavedUniversity(String schoolName){
    if(userFuncController.removeSavedSchool(username, schoolName)){
      return true;
    }
    return false;
  }
  
  /**
   * the viewSchoolInDetail() method, displays all the previously
   * hidden information about the schools academics and other
   * statistics users may find useful
   * 
   * @param schoolName name of the school to view
   * @return university information of the school
   */
  public University viewUniversityInDetail(String schoolName){
    return userFuncController.getUniversityInDetail(schoolName);
  }
  
  /**
   * the search() method, search schools that match with criteria
   * that user provides
   * @param ArrayList<String> criteria which is provided by user
   * @return ArrayList<University> searched university based on the criteria
   */
  public ArrayList<University> search(ArrayList<String> criteria){
	  ArrayList<University> searched = userFuncController.search(criteria);
	  return searched;
  }
  /**
   * Search recommendation school similar to the school that
   * user viewed in detail
   * @param schoolName name of the school user viewed
   * @return ArrayList<University> recommendation list of searched university
   */
  public ArrayList<University> searchRecommendation(String schoolName){
	  return userFuncController.searchRecommendation(schoolName);
  }
  
  /**
   * Logs User out of CMC system
   * returns true if user is successfully logged out
   * 
   * @param userName username of user to logoff
   * @return boolean to determine if user is logged out
   */
  public boolean logOff(){
 	 return this.loginController.logOff(user);
  }
  
  /**
   * get the user name
   * 
   * @return String the user name
   */
  public String getUsername(){
	  return this.username;
  }
 }