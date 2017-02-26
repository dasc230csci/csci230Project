/**
 * File: AdminFuncController.java
 */

import java.util.ArrayList;

/**
 * A Class representing a Admin Function Controller and all its functions.
 * 
 * @authors  Anh Tran, Caitlin Harvey, Daniel Song, Sam Halloran
 * @version February 2017
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
   * @param  userName the user to be deactivate
   * @return boolean
   */
  public boolean deactivateUser(String userName)
  {
    return false;
  }
  
  /**
   * A method that add a new university based on the array of input
   * 
   * @param schoolInfo the information to create a new university
   * @return  boolena to see if the university is added or not
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
   * @param userName the name of the user
   * @param firstName the first name of the user
   * @param lastName the last name of the user
   * @param passWord the pass word
   * @param type admin or student
   * @param status activate or not
   * @return boolean if the user is added or not
   */
  public boolean createUser(String userName, String firstName, String lastName, String passWord, String type, String status)
  {
    return false;
  }
  
  /**
   * A method that edit the user info
   * 
   * @param userName the name of the user
   * @param firstName the first name of the user
   * @param lastName the last name of the user
   * @param passWord the pass word
   * @param type admin or student
   * @param status activate or not
   * @return boolean if the user is added or not
   */
  public boolean editUserProfile(String userName, String firstName, String lastName, String passWord, String type, String status)
  {
    return false;
  }
  
  /**
   * A method that reset the user info
   * 
   * return account the account that has not been moddified
   */
  public Account reset()
  {
    return null;
  }
  
  /**
   * A method that return a specific user information
   * 
   * @param userName the name of the user
   * @return User the user
   */
  public Account viewSpecificUser(String userName)
  {
    return null;
  }
}

