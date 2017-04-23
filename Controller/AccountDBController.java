package Controller;

import java.util.ArrayList;

import Entity.Account;
import Entity.User;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * This class is for managing DB which it enables to update, add, get information of
 * User or University
 * 
 * @author  Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version March 4, 2017
 */
public class AccountDBController {
 
 /**
  * University Database
  */
 private UniversityDBLibrary dblib;
 
 public AccountDBController(){
  dblib = new UniversityDBLibrary("dasc","dasc","csci230");
 }

 public boolean deleteUser(String username){
  String[][] savedSchool = dblib.user_getUsernamesWithSavedSchools();
	 ArrayList<String> oldSchoolList = new ArrayList<String>();
	 for(int i =0 ; i< savedSchool.length; i++){
		  if(savedSchool[i][0].equals(username)){
		   oldSchoolList.add(savedSchool[i][1]);
		  }
	 }
  for(int i=0; i < oldSchoolList.size(); i++){
   dblib.user_removeSchool(username, oldSchoolList.get(i));
  }
  if(dblib.user_deleteUser(username) == 1){
	  return true;
  }
  return false;
 }
 
 /**
  * Method that reactivate user
  * @param username name of the user want to reactivate
  * @return true if successfully removed
  */
 public boolean reactivateAccount(String username){
	 ArrayList<Account> list = getAccountList();
	 for(int i=0; i< list.size(); i++){
		 if(list.get(i).getUsername().equals(username)){
			 Account account = list.get(i);
			 account.setStatus("Y");
			 return this.updateAccount(account);		 
		 }
	 }
	 return false;
 }

 /**
   * Update Account information and store in DB
   * 
   * @param account Account objects that had been updated
   * @return true if the Account information can be updated
   */
 public boolean updateAccount(Account account){
  int failed = dblib.user_editUser(account.getUsername(), account.getFirstName(), account.getLastName(), account.getPassword(), 
    account.getType().charAt(0), account.getStatus().charAt(0));
  if(failed != -1){
   return true;
  }
  else
   return false;
 }
 /**
  * Obtain Account object from the database
  * Searching by username
  * 
  * @param name username of the user
  * @return corresponding Account object
  */
public User getUser(String username){
 String[][] account = dblib.user_getUsers();
 String[][] savedSchool = dblib.user_getUsernamesWithSavedSchools();
 User user = null;
 
 for(int i =0; i < account.length ;i++){
  if(account[i][2].equals(username)){
   user = new User(account[i][0], account[i][1], account[i][2], account[i][3], account[i][5],false);
  }
 }
 if(savedSchool == null){
	 return user;
 }
 for(int i =0 ; i< savedSchool.length; i++){
  if(savedSchool[i][0].equals(user.getUsername())){
   user.addSavedSchool(savedSchool[i][1]);
  }
 }
 return user;
}

/**
 * Obtain Account object from the database
 * Searching by username
 * 
 * @param name username of the user
 * @return corresponding Account object
 */
public Account getAccount(String username){
String[][] account = dblib.user_getUsers();
Account a = null;

for(int i =0; i < account.length ;i++){
 if(account[i][2].equals(username)){
  a = new Account(account[i][0], account[i][1], account[i][2], account[i][3], account[i][4], account[i][5],false);
 }
}
return a;
}
 /**
   * Add new Account information and store in DB
   * 
   * @param account Account objects that had been added
   * @return true if the Account information can be added
   */
 public boolean addAccount(Account account){
  int failed = dblib.user_addUser(account.getFirstName(), account.getLastName(), account.getUsername(), 
    account.getPassword(), account.getType().charAt(0));
  if(failed != -1){
   return true;
  }
  return false;
 }
 
 /**
  * return a list of all user in database.
  * 
  * @return ArrayList<Account> list of all account
  */
 public ArrayList<Account> getAccountList(){
   String[][] userList = dblib.user_getUsers();
   ArrayList<Account> accountList = new ArrayList<Account>();
   for(int i=0; i<userList.length; i++){
	Account account = new Account(userList[i][0], userList[i][1], userList[i][2], userList[i][3], userList[i][4], userList[i][5], false);
     accountList.add(account);
   }
   return accountList;
 }
 
 /**
  * Deactivate user from database
  * Set status of user to "N" which represent deactivated
  * @param username to deactivate
  * @return true if successfully deactivate user
  */
 public boolean deactivateAccount(String username){
	 ArrayList<Account> list = getAccountList();
	 for(int i=0; i< list.size(); i++){
		 if(list.get(i).getUsername().equals(username)){
			 Account account = list.get(i);
			 account.setStatus("N");
			 return this.updateAccount(account);		 
		 }
	 }
	 return false;
 }
 
 /**
  * save school to the list of school of the user
  * to the database
  * @param username name of the user want to save school
  * @param user to add school to the list
  * @return true if successfully add school to the list
  */ 
 public boolean saveSchool(String username, String schoolName){
	 int failed = dblib.user_saveSchool(username, schoolName);
	 if(failed != -1){
		 return true;
	 }
	 return false;
 }
 /**
  * remove school from the list of school of the user
  * from the database
  * @param username name of the user want to remove school
  * @param user to remove school from the list
  * @return true if successfully remove school from the list
  */ 
 public boolean removeSavedSchool(String username, String schoolName){
	 int failed = dblib.user_removeSchool(username, schoolName);
	 if(failed != -1){
		 return true;
	 }
	 return false;
 }
 

}