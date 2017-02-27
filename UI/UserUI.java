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
 * @version Feburary 27, 2017
 */

public class UserUI {
	/**
	 * UserFuncController which provide
	 * functionality of user
	 */
	private UserFuncController userFuncController;
  
  /**
   * the viewSavedSchools method, returns the current
   * array list of saved schools associated with the
   * current user signed in.
   * @return ArrayList<String> of saved schools
   */
  public ArrayList<String> viewSavedSchool(){
    return null;
  }
  
  /**
   * the viewProfile() method, returns a Account object(either Student or Admin)
   * and allows the user to alter he/shes personal profile as they 
   * see fit.
   * @return an instance of the Users Account
   */ 
  public Account viewProfile(){
    return null;
  }
  
  /**
   * the search() method, used whenever a call is made by
   * the user to search for schools, 
   * returning a collection of University objects
   * @return a collection of University objects
   */  
  public ArrayList<String> search(){
	  return null;
  }
  
  /**
   * the editProfile() method, needs further clarification
   * on its exact uses 
   * @return true if successfully edit profile
   */  
  public boolean editProfile(){
	  return false;
  }
  
  /**
   * the resetUserInfo() method, sets the current account
   * to the original defult blank profile eraseing any personal
   * information associated with the account.
   * @return ArrayList<String> user information
   */
  public ArrayList<String> resetUserInfo(){
	  return null;
  }
  
  /**
   * the saveScool() method, sends the University choosen
   * to be saved to the savedSchools array list 
   * that is saved for the user.
   * @returns true if the school is successfully saved 
   */
  public boolean saveSchool(){
	  return false;
  }
  
  /**
   * the removeSavedSchool() method, removes a specified school
   * (assuming it is present in the users savedSchools array) and 
   * return a boolean true if it was successfully removed. 
   * @returns true if the school successfully removed 
   */ 
  public boolean removeSavedUniversity(){
	  return false;
  }
  
  /**
   * the viewUniversityInDetail() method, displays all the previously
   * hidden information about the schools acedemics and other
   * statistics users may find useful
   * @return ArrayList<String> information of the school
   */
  public ArrayList<String> viewUniversityInDetail(){
	  return null;
  }
  
  /**
   * the resetSchoolSearchForm() method, after a search is conducted,
   * the search criteria fields are cleared to become ready to 
   * execute another search whenever.
   * @returns true if successfully reset
   */
  public boolean resetSchoolSearchForm(){
	  return false;
  }
}