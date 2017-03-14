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
 * @version Feburary 27, 2017
 */
public class AdminFuncController
{
  private AccountController accountController;
  private UniversityController universityController;
  private Account account;
  
  /**
   * constuctor for the AdminFuncController with specific admin
   * 
   * @param admin the admin
   */
  public AdminFuncController(Admin admin)
  {
    this.account=admin;
  }
  
  /**
   * This method allow account to see all the user
   * 
   * @return the list of user names
   */
  public ArrayList<String> viewAllUser()
  {
    return null;
  }
  
  /**
   * This method deactivate the user
   * 
   * @param  username the user to be deactivate
   * @return true if successfully deactivate user
   */
  public boolean deactivateUser(String username)
  {
    return false;
  }
  
  /**
   * A method that add a new university based on the array of input
   * 
   * @param schoolInfo the information to create a new university
   * @return  boolean to see if the university is added or not
   */
  public boolean addUniversity(ArrayList<String> schoolInfo)
  {
    return false;
  }
  
   /**
   * A method that set the details of the university
   * 
   * @param schoolInfo the array that contains the information that need to be change
   * @return boolean if the changes are made or not
   */
  public boolean editUniversityInDetailed(ArrayList<String> schoolInfo)
  {
    return false;
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
    return false;
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
    return false;
  }
  
  /**
   * A method that reset the user info
   * 
   * return account the account that has not been modified
   */
  public Account reset()
  {
    return null;
  }
  
  /**
   * A method that return a specific user information
   * 
   * @param username the name of the user
   * @return User the specific user want to view
   */
  public Account viewSpecificUser(String username)
  {
    return null;
  }
}

