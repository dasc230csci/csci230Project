/**
 * File: AdminFuncController.java
 */
package Controller;

import java.util.ArrayList;
import Entity.*;

/**
 * A Class representing a Admin Function Controller and all its functions.
 * 
 * @author  Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version March 27, 2017
 */
public class AdminFuncController
{
  /**
   * AccountController to add, edit or get account or user	
   */
  private AccountController accountController;
  
  /**
   * UniversityController to add, edit or get university
   */
  private UniversityController universityController;
  
  /**
   * Default Constructor. Initialize AccountController and University Controller
   * 
   */
  public AdminFuncController()
  {
	  accountController = new AccountController();
	  universityController = new UniversityController();
  }
  
  /**
   * This method allow account to see all the user
   * 
   * @return the list of user names
   */
  public ArrayList<Account> viewAllUser()
  {
   return accountController.getAccountList();
  }
  
  /**
   * This method deactivate the user
   * 
   * @param  username the user to be deactivate
   * @return true if successfully deactivate user
   */
  public boolean deactivateUser(String username)
  {
	  boolean isFailed = accountController.deactivateAccount(username);
	  return isFailed;
  }
  
  /**
   * A method that add a new university based on the array of input
   * 
   * @param schoolInfo the information to create a new university
   * @return  boolean to see if the university is added or not
   */
  public boolean addUniversity(ArrayList<String> schoolInfo)
  {
	boolean isFailed = universityController.createUniversity(schoolInfo);
    return isFailed;
  }
  
   /**
   * A method that set the details of the university
   * 
   * @param schoolInfo the array that contains the information that need to be change
   * @return boolean if the changes are made or not
   */
  public boolean editUniversityInDetailed(ArrayList<String> schoolInfo)
  {
	boolean isFailed = universityController.editUniversityInDetailed(schoolInfo);
    return isFailed;
  }
  
  /**
   * A method that create a new user
   * 
   * @param firstName the first name of the user
   * @param lastName the last name of the user
   * @param username the name of the user
   * @param password the password of the user
   * @param type admin or student
   * @param status activate or not
   * @return boolean if the user is added or not
   */
  public boolean createUser(String firstName, String lastName, String userName, String password, String type, String status)
  {
  accountController.createAccount(firstName, lastName, userName, password, type, status);
  return true;
  }
  
  /**
   * A method that edit the user info
   * 
   * @param firstName the first name of the user
   * @param lastName the last name of the user
   * @param username the name of the user
   * @param password the pass word
   * @param type admin or student
   * @param status activate or not
   * @return boolean if the user is added or not
   */
  public boolean editUserProfile(String firstName, String lastName, String username, String password, String type, String status)
  {
    return accountController.adminEditProfile(firstName, lastName, username, password, type, status);
  }
  
  /**
   * A method that get the user information
   * 
   * @param username name of the user
   * @return account information of the user
   */
  public Account getProfile(String username)
  {
	Account account = accountController.getAccountInfo(username);  
    return account;
  }
  
  	/**
	 * Get all universities that exist in database
	 * @return ArrayList<University> list of all universities
	 */
  public ArrayList<University> getUniversityList(){
	  return universityController.getUniversityList();
  }
}