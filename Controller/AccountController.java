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
public class AccountController {
  
  /**
   * Account account which contains information of account
   */
  private Account account;
  
  /**
   * DBController dbController which enable access to the database to obtain
   * or update information of University
   */
  private DBController dbController;
  
  /**
   * AccountDBController adbController which enable access to the database to obtain
   * or update information of Account
   */
  private AccountDBController adbController;
  
  /**
   * Default Constructor
   */
  public AccountController(){
  }
  
  /**
   * Account constructor which has Account object to edit information
   * @param account to edit information
   */
  public AccountController(Account account){
    this.account = account;
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
    if(type=="a"){
      Account newAdmin = new Account(firstName, lastName, userName, password, type, status, true);
      if(adbController.addAccount(newAdmin)==true){
        return true; 
      }
    }
    if(type=="u"){
      User newUser = new User(firstName, lastName, userName, password, status, true);
      if(adbController.addUser(newUser)==true){
        return true; 
      }
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
    if(type=="a"){
      if(adbController.updateAccount(newAccount)==true){
        return true; 
      }
    }
    if(type=="u"){
      if(adbController.updateUser((User)newAccount)==true){
        return true; 
      }
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
    User newUser = adbController.getAccount(username);
    newUser.setFirstName(firstName);
    newUser.setLastName(lastName);
    newUser.setPassword(password);
    if(adbController.updateUser(newUser)==true){
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
    Account deacAccount = adbController.getAccount(username);
    deacAccount.setStatus("deactivate");
    if(deacAccount.getType()=="a"){
      if(adbController.updateAccount(deacAccount)==true){
        return true; 
      }
    }
    if(deacAccount.getType()=="u"){
      if(adbController.updateUser((User)deacAccount)==true){
        return true; 
      }
    }
    return false;
  }
  
  /**
   * Method that reset information of the Account before edit
   * @param username username of the Account to reset
   * @return Account which contains information of the user
   */
  public Account resetAccountInfo(String username){
    return null;
  }
  
  /**
   * Method that verify information of the Account
   * Access to the database for verification 
   * @param username username of the Account to verify
   * @param password password of the Account to verify
   * @return true if Account is verified
   */
  public boolean verifyAccount(String username, String password){
    User user = adbController.getAccount(username);
    if(user.getPassword()==password){
      return true;
    }
    return false;
  }
  
  /**
   * Method that return the specific Account object from database
   * @param username username of the Account to get
   * @return Account object returned from database
   */
  public User getAccountInfo(String username){
    User newAccount = adbController.getAccount(username);
    return newAccount;
  }
  
  /**
   * Method that get all the users in database for admin
   * @return ArrayList<String> list of all users in database
   */
  public ArrayList<String> getUsernameList(){
    return adbController.getUsernameList();
  }
  
  /**
   * Method that enable users to save(add) school in user's school list
   * @param schoolName name of the school want to save(add)
   * @return true if successfully saved
   */
  public boolean saveSchool(User user, String schoolName){
    user.addSavedSchool(schoolName);
    if(adbController.updateUser(user)==true){
      return true;
    }
    return false;
  }
  
  /**
   * Method that enable users to remove school in user's school list
   * @param schoolName name of the school want to remove
   * @return true if successfully removed
   */
  public boolean removeSavedSchool(User user, String schoolName){
    user.removeSavedSchool(schoolName);
    if(adbController.updateUser(user)==true){
      return true;
    }
    return false;
  }
}