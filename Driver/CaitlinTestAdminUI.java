 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.Comparator;
 import java.util.HashMap;
 import java.util.Iterator;
 import java.util.List;
 import java.util.Map;

 import Controller.*;
 import Entity.*;
 import UI.*;
 import dblibrary.project.csci230.UniversityDBLibrary;
 
 /**
  * Caitlin's initial driver test class for Admin UI constructor and top methods:
  * viewAllUser, deactivateUser, addUniversity, editUniversity
  */
public class CaitlinTestAdminUI {

 public static void main(String[] args) {
 

  Account admin = new Account("adminf", "adminl", "adminu", "password", "a", "Y", true);
  
  /**
   * Test constructor
   * 
   * Create new AdminUI object, see if object is an AdminUI
   */
  AdminUI aui = new AdminUI("adminf");
  
  if (aui instanceof AdminUI){
   System.out.println("UI construction success."); 
  }
  else {
   System.out.println("UI construction fail.");
  }

  //separate values
  System.out.println(" ");
  
  /**
   * Test viewAllUser
   * 
   * Create an array of all users, print each user in the array.
   */
  ArrayList<Account> usersToView = aui.viewAllUser();
  for (Account accnt : usersToView) {
   System.out.println(accnt.getUsername());
  }
  
  //separate values
  System.out.println(" ");
  
  /**
   * Test deactivateUser
   * 
   * Print status of deactivation.
   */
  AccountDBController db = new AccountDBController();
  
  Account tempUser = new User("tempuserf", "tempuserl", "tempuseru", "password", "Y", false);
  db.addAccount(tempUser);
  
  boolean userIsDeactivated = aui.deactivateUser("tempuseru");
  if (userIsDeactivated == true) {
   System.out.println("User successfully deactivated."); 
  }
  else {
   System.out.println("User deactivation failed.");
  }
  
  //separate values
  System.out.println(" ");
  
  /**
   * Test addUniversity
   * 
   * Print status of University addition.
   */
  //create string array for emphases
  ArrayList<String> emphasesArray = new ArrayList<String>();
  emphasesArray.add("SUBJ1");
  emphasesArray.add("SUBJ2");
  
  boolean universityIsAdded = aui.addUniversity("TEST UNIVERSITY", "TEST STATE", "TEST LOCATION", "TEST CONTROL", 5000, 
         52, 500, 500, 500, 99, 800,
         72, 65, 4, 2, 3, emphasesArray);
  
  if (universityIsAdded == true){
   System.out.println("University successfully added.");
  }
  
  else {
   System.out.println("University addition failed.");
  }
  
  //separate values
  System.out.println(" ");
  
  /**
   * Test editUniversity
   * 
   * Print status of University edit.
   */
  boolean universityIsEdited = aui.editUniversity("TEST UNIVERSITY EDITED", "TEST STATE", "TEST LOCATION", "TEST CONTROL", 5000, 
    52, 500, 500, 500, 99, 800,
    72, 65, 4, 2, 3, emphasesArray);

  if (universityIsEdited == true){
   System.out.println("University successfully edited.");
  }
  
  else {
   System.out.println("University edit failed.");
  }
  
  /**
   * test createUser
   */
  boolean userCreated = aui.createUser("testf", "testl", "testu", "testp", "u", "Y");
  if(userCreated==true){
    System.out.println("create user success"); 
  }
  else{
   System.out.println("we have a problem"); 
  }
  
  /**
   * test editUserProfile
   */
  boolean isEdited = aui.editUserProfile("testfirst", "testl", "testu", "testp", "u", "Y");
  if(isEdited==true){
    System.out.println("edit user success"); 
  }
  else{
   System.out.println("we have a problem"); 
  }
  
  
  /**
   * test viewProfile
   */
  Account viewAccount = aui.viewProfile("testu");
  System.out.println(viewAccount.getUsername()+" "+viewAccount.getFirstName()+" "+viewAccount.getLastName()+" "+viewAccount.getPassword());
  
  /**
   * test viewUniversityList
   */
  ArrayList<University> uList = aui.viewUniversityList();
  System.out.println(uList);
  
 }//main

}//class
