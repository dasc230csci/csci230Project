//package ????

//public class Account contains the getter and setter
//methods used in the sub class User and Admin.
import java.util.*;

/**
* public class Account contains the getter and setter
* methods used in the sub class User and Admin.
*/


public class Account { //extends compareTo??
  
  //first name of the account owner
  private String firstName;
  //last name of the account owner
  private String lastName;
  //username of the account
  private String userName;
  //password for the account
  private String passWord;
  //what sub class the account object is casted too
  private String Type;
  //active or inactive
  private String Status;
  //is logged in or not
  private Boolean LoggedIn;

  /**
   * default Account constructor sets all the basic information
   * tied to the Account object being created.
   * 
   * @param firstname
   * @param lastname
   * @param username
   * @param password
   * @param type
   * @param status
   * @param loggedIn
   */
 
  
  public Account(String firstname, String lastname, String username, String password, String type, String status, Boolean loggedIn){
    
    this.firstName = firstname;
    this.lastName = lastname;
    this.userName = username;
    this.passWord = password;
    this.Type = type;
    this.Status = status;
    this.LoggedIn = loggedIn;
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
  
  public String getUserName(){
  
    return this.userName;
  }
  
  /**
   * the getPassword() method, returns the password
   * associated with the account object.
   * @return String passWord
   */
  
  public String getPassword(){
  
    return this.passWord;
  }
  
  /**
   * the getType() method, returns the sub class
   * the Account object takes on
   */
  
  public String getType(){
  
    return this.Type;
  }
  
  /**
   * the getStatus() method, returns the current condition
   * of the account, being active or deactivated.
   * return String Status.
   */
  
  public String getStatus(){
  
    return this.Status;
  }
  
  /**
   * the setFirstName() method, takes a String 
   * newName parameter and sets it to the firstName
   * variable replacing its old value
   * @param String newName
   */
  
  public void setFirstName(String newName){
  
    this.firstName = newName;
  }
  
  /**
   * the setLastName() method, takes a String
   * newLName parameter and sets it to the
   * lastName variable, replacing its old value
   * @param String newLName
   */
  
  public void setLastName(String newLName){
    
    this.lastName = newLName;
  }
  
  /**
   * the setUserName() method, takes a String
   * newUName parameter and sets it to the userName
   * Variable, replacing its old value
   * @param String newUName
   */
  public void setUserName(String newUName){
    
    this.userName = newUName;
  }
  
  /**
   * the setPassword() method, takes a String
   * newPWord parameter and sets it to the 
   * passWord variable, replacing its old value
   * @param String newPWord
   */
  public void setPassword(String newPWord){
  
    this.passWord = newPWord;
  }
  
  /**
   * the setType() method, takes a String
   * newT parameter and sets it to the Type
   * variable, replacing its old value
   * @param String newT
   */
  public void setType(String newT){
  
    this.Type = newT;
  }
  
  /**
   * the setStatus() method, takes a String
   * newS parameter and sets it to the Status
   * variable, replacing its old value
   * @param String newS
   */
  public void setStatus(String newS){
  
    this.Status = newS;
  }
  
  /**
   * the logStatus method, returns a Boolean true
   * is the Account is currently logged in, and a false
   * if the Account is offline
   * @return Boolean
   */
  public Boolean logStatus(){
    
    if(this.LoggedIn == true){
      return true;
    }
    
    return false;
  }
  
  
}
