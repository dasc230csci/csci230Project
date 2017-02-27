package Entity;


/**
 * This is Account entity class which contains information of Account
 * Method used in subclass, Admin and User
 * 
 * @author  Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version Feburary 27, 2017
 */

public class Account {
  
  /**
   * first name of the account owner
   */
  private String firstName;
  
  /**
   * last name of the account owner
   */
  private String lastName;
  
  /**
   * username of the account
   */
  private String username;
  
  /**
   * password for the account
   */ 
  private String password;
  
  /**
   * Type of the account: "a" for admin and "u" for regular user
   */
  private String type;
  
  /**
   * active or inactive
   */
  private String status;
  
  /**
   * is logged in or not
   */
  private boolean loggedIn;

  /**
   * Account constructor sets all the basic information
   * 
   * @param firstname first name of the user
   * @param lastname last name of the user
   * @param username user name of the user
   * @param password password of the user
   * @param type type of the account: "a" for admin and "u" for user
   * @param status status of the user whether the account is activated or not
   * @param loggedIn status of the user whether the account is loggedIn
   */
  public Account(String firstname, String lastname, String username, String password, String type, String status, Boolean loggedIn){
    
    this.firstName = firstname;
    this.lastName = lastname;
    this.username = username;
    this.password = password;
    this.type = type;
    this.status = status;
    this.loggedIn = loggedIn;
  }
  
  /**
   * the getFirstName() method, returns the current instance
   * of the firstName variable
   * @return String firstName
   */
  
  public String getFirstName(){
    
    return this.firstName;
  }
  
  /**
   * the getLastName() method, returns the current instance
   * of the lastName variable
   * @returns lastName
   */
  
  public String getLastName(){
  
    return this.lastName;
  }
  
  /**
   * the getUserName() method, return the current instance 
   * of the userName variable
   * @return String userName
   */
  
  public String getUsername(){
  
    return this.username;
  }
  
  /**
   * the getPassword() method, returns the password
   * associated with the account object.
   * @return String passWord
   */
  
  public String getPassword(){
  
    return this.password;
  }
  
  /**
   * the getType() method, returns the sub class
   * the Account object takes on
   */
  
  public String getType(){
  
    return this.type;
  }
  
  /**
   * the getStatus() method, returns the current condition
   * of the account, being active or deactivated.
   * return String Status.
   */
  
  public String getStatus(){
  
    return this.status;
  }
  
  /**
   * the setFirstName() method, takes a String 
   * firstName parameter and sets it to the firstName
   * firstName variable replacing its old value
   * @param String firstName
   */
  
  public void setFirstName(String firstName){
    this.firstName = firstName;
  }
  
  /**
   * the setLastName() method, takes a String
   * lastName parameter and sets it to the
   * lastName variable, replacing its old value
   * @param String lastName
   */
  
  public void setLastName(String lastName){
    this.lastName = lastName;
  }
  
  /**
   * the setUserName() method, takes a String
   * username parameter and sets it to the userName
   * username variable, replacing its old value
   * @param String username
   */
  public void setUsername(String username){
    this.username = username;
  }
  
  /**
   * the setPassword() method, takes a String
   * password parameter and sets it to the 
   * password variable, replacing its old value
   * @param String password
   */
  public void setPassword(String password){
	  this.password = password;
  }
  
  /**
   * the setType() method, takes a String
   * type parameter and sets it to the Type
   * type variable, replacing its old value
   * @param String type
   */
  public void setType(String type){ 
    this.type = type;
  }
  
  /**
   * the setStatus() method, takes a String
   * status parameter and sets it to the Status
   * status variable, replacing its old value
   * @param String status
   */
  public void setStatus(String status){
    this.status = status;
  }
  
  /**
   * the login() method, which set loggedIn to true
   * if account is successfully loggedin
   * @return true if account is successfully loggedin
   */
  public boolean login(){
	  return false;
  }
  /**
   * the logoff() method, which set loggedIn to false
   * @return true if account is successfully logged off
   */
  public boolean logoff(){
	  return false;
  }
}