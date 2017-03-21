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
 * @version Mar 4, 2017
 */
public class AccountDBController {
 
 /**
  * University Database
  */
 private UniversityDBLibrary dblib;
 
 public AccountDBController(){
  dblib = new UniversityDBLibrary("dasc","dasc","csci230");
 }
 //////////////////////////////////////////////////////////////////// leave for testing
 public UniversityDBLibrary getdblib(){
  return dblib;
 }
 public void deleteUser(String username){
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
  dblib.user_deleteUser(username);
 }
//////////////////////////////////////////////////////////////////
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
Account user = null;

for(int i =0; i < account.length ;i++){
 if(account[i][2].equals(username)){
  user = new User(account[i][0], account[i][1], account[i][2], account[i][3], account[i][5],false);
 }
}
return user;
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
  * Update the list of school of the user
  * to the database
  * @param user to update school list
  * @return true if successfully update school list
  */
 public boolean updateSchoolList(User user){
	 int isRemoved = 0, isSaved = 0;
	 String[][] savedSchool = dblib.user_getUsernamesWithSavedSchools();
	 ArrayList<String> oldSchoolList = new ArrayList<String>();
	 for(int i =0 ; i< savedSchool.length; i++){
		  if(savedSchool[i][0].equals(user.getUsername())){
		   oldSchoolList.add(savedSchool[i][1]);
		  }
	 }
	  ArrayList<String> newSchoolList = user.getSavedSchool();
	  for(int i =0; i < oldSchoolList.size(); i++){
		  dblib.user_removeSchool(user.getUsername(), oldSchoolList.get(i));
		  }
	  for(int i =0; i < newSchoolList.size(); i++){
		  dblib.user_saveSchool(user.getUsername(), newSchoolList.get(i));
		  }
	  return true;
 }
}