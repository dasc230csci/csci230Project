package Controller;

import java.util.ArrayList;
import Entity.*;


/**
 * This is AccountController controller class which enable functionalities such as 
 * edit, add, create, remove, and update the Account
 * 
 * @author  Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version Feburary 27, 2017
 */
public class AccountController{  
  
  /**
   * AccountDBController adbController which enable access to the database to obtain
   * or update information of Account
   */
  private AccountDBController adbController;
  
  /**
   * Default Constructor
   */
  public AccountController(){
	  this.adbController = new AccountDBController();
  }
 
  /**
   * Method that create new Account with specified information
   * and save into database
   * 
   * @param firstname first name of the user
   * @param lastname last name of the user
   * @param username user name of the user
   * @param password password of the user
   * @param type type of the account: "a" for admin and "u" for user
   * @param status status of the user whether the account is activated or not
   * @return true if successfully create new Account
   */
  public boolean createAccount(String firstName, String lastName, String userName, String password, String type, String status){
      Account account = new Account(firstName, lastName, userName, password, type, status, false);
      if(adbController.addAccount(account)){
        return true; 
      }
    return false;
  }
  
  /**
   * Method that editProfile for Admin
   * Enable edit profile with specified information and save into database
   * @param firstname first name of the user
   * @param lastname last name of the user
   * @param username user name of the user
   * @param password password of the user
   * @param type type of the account: "a" for admin and "u" for user
   * @param status status of the user whether the account is activated or not
   * @return true if successfully edit profile
   */
  public boolean adminEditProfile(String firstName, String lastName,String username, String password, String type, String status){
    Account newAccount = adbController.getAccount(username);
    newAccount.setFirstName(firstName);
    newAccount.setLastName(lastName);
    newAccount.setUsername(username);
    newAccount.setPassword(password);
    newAccount.setType(type);
    newAccount.setStatus(status);
    if(adbController.updateAccount(newAccount)){
        return true; 
      }
    return false;
  }
  
  /**
   * Method that editProfile for User
   * Enable edit profile with specified information and save into database
   * @param firstname first name of the user
   * @param lastname last name of the user
   * @param username user name of the user
   * @param password password of the user
   * @return true if successfully edit profile
   */
  public boolean userEditProfile(String username, String firstName, String lastName, String password){
    Account newAccount = adbController.getAccount(username);
    newAccount.setFirstName(firstName);
    newAccount.setLastName(lastName);
    newAccount.setPassword(password);
    if(adbController.updateAccount(newAccount)){
      return true; 
    }
    return false;
  }
  
  /**
   * Method that deactivate Account
   * Set status of the Account with "N" which means deactivated
   * @param username username of the Account to deactivate
   * @return true if successfully edit profile
   */
  public boolean deactivateAccount(String username){
    if(adbController.deactivateAccount(username))
    	return true;
    return false;
  }
  
  /**
   * Method that verify information of the Account
   * Access to the database for verification 
   * @param username username of the Account to verify
   * @param password password of the Account to verify
   * @return true if Account is verified
   */
  public String verifyAccount(String username, String password){
    Account account = adbController.getAccount(username);
    if(account == null){
    	throw new NullPointerException("username password wrong combination");
    }
    else if(account.getPassword().equals(password)){
      return account.getType();
    }
    return "failed";
  }
  
  /**
   * Method that return the specific Account object from database
   * @param username username of the Account to get
   * @return Account object returned from database
   */
  public Account getAccountInfo(String username){
    Account account = adbController.getAccount(username);
    return account;
  }
  /**
   * Method that return the specific Account object from database
   * @param username username of the Account to get
   * @return Account object returned from database
   */
  public User getUserInfo(String username){
	  User user = adbController.getUser(username);
    return user;
  }
  
  /**
   * Method that get all the users in database for admin
   * @return ArrayList<Account> list of all users in database
   */
  public ArrayList<Account> getAccountList(){
    return adbController.getAccountList();
  }
  
  /**
   * Method that enable users to save(add) school in user's school list
   * @param schoolName name of the school want to save(add)
   * @return true if successfully saved
   */
  public boolean saveSchool(String username, String schoolName){
	User user= adbController.getUser(username);
    user.addSavedSchool(schoolName);
    if(adbController.updateSchoolList(user)){
      return true;
    }
    return false;
  }
  
  /**
   * Method that enable users to remove school in user's school list
   * @param schoolName name of the school want to remove
   * @return true if successfully removed
   */
  public boolean removeSavedSchool(String username, String schoolName){
	User user = adbController.getUser(username);
    user.removeSavedSchool(schoolName);
    if(adbController.updateSchoolList(user)){
      return true;
    }
    return false;
  }
}