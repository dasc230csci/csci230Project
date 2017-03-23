package Testing;

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
  * Sam's driver test class for the User UI constructor and the following methods:
  * editProfile(fn, ln, pass), viewUniversityInDetail(schoolName), UserUI(), viewSavedSchools()
  */
public class SamsTestUserUI {

 public static void main(String[] args) {
 

  User user = new User("userf", "userl", "useru", "password", "Y", true);
  
  /**
   * Test constructor
   * 
   * Creates a new UserUI object, then tests to confirm the object is a UserUI instance
   */
  UserUI uui = new UserUI("useru");
  uui.saveSchool("SAINT JOHNS UNIVERSITY");
  
  if (uui instanceof UserUI){
   System.out.println("UI construction success."); 
  }
  else {
   System.out.println("UI construction fail.");
  }
  
  /*
   * Test the editProfile(firstName, lastName, password) command for Users.
   * 
   * edit the first name of the test user to userf EDITED then confirm the edit with the
   * methods boolean return.
   */
  boolean isEdited = uui.editProfile("userf EDITED", "userl", "password");
  if(isEdited==true){
	  System.out.println("Edits made were succesful");
	  
  }
  else{
	 System.out.println("EditProfile() test failed"); 
	  
  }
  
  /*
   * testing the viewUniversityInDetail(schoolName) command for Users
   * 
   * looks ups the details for BARD college which will return the BARD university object or
   * failed
   */
  University testUni = uui.viewUniversityInDetail("BARD");
  if(testUni instanceof University){
	  
	  System.out.println("successfully recieved a University object to view");
  }
  else{
	  
	  System.out.println("viewUniversityInDetail(schoolName) test failed");
  }
  
  /*
   * testing the viewSavedSchools() command for User, should have Saint Johns already in his 
   * saved schools, i will add BARD to it then confirm it was added
   */
  
  ArrayList<String> savedSchools = uui.viewSavedSchool();
  for(int i=0; i < savedSchools.size(); i++){
	  
	  
	  System.out.println(savedSchools.get(i));
  }
  if(savedSchools.size()==1){
	  uui.saveSchool("BARD");
  }
 
  if(savedSchools.size()==2){
	 
	  System.out.println("BARD was successfully added and returned by the viewSavedSchool method");
	  uui.removeSavedUniversity("BARD");
  }
  else{
	  
	  System.out.println("viewSavedSchools() test failed.");
  }
  
 }
}