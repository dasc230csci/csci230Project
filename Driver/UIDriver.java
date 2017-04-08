package Driver;
import java.util.ArrayList;

import Controller.AccountDBController;
import Controller.UniversityDBController;
import Entity.Account;
import Entity.University;
import Entity.User;
import UI.AdminUI;
import UI.LoginUI;
import UI.UserUI;


/**
 * This is UIDriver class which shows all functionalities of AdminUI and UserUI 
 * 
 * @author  Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version March 27, 2017
 */
public class UIDriver {
	
	/**
	 * UserUI object contains user functionalities
	 */
	private UserUI userUi = new UserUI("useru");
	/**
	 * AdminUI object contains user functionalities
	 */
	private AdminUI adminUi = new AdminUI("adminu");
	
	/**
	 * LoginUI object to verify user
	 */
	private LoginUI loginUi = new LoginUI();
	
	/**
	 * Default Constructor. initialize AccountDBController to delete existing user in database
	 * so that driver is working
	 */
	public UIDriver(){
		
		AccountDBController ac = new AccountDBController();/////for reactivating and delete existing user(just for showing)
		ac.reactivateAccount("useru");
		ac.deleteUser("testu");
	}
	
	/**
	 * Method to check whether user can loggin
	 */
	public void loggin(){
		System.out.println("====================loggin()====================");
		System.out.println("Succeed if u : " + loginUi.verifyUser("useru", "password"));
		System.out.println("Succeed if a : " + loginUi.verifyUser("nadmin", "password"));
	}
	
	/**
	 * Method to view the user's own profile
	 */
	public void viewProfile(){
		System.out.println("====================viewProfile()====================");
		System.out.println("First Name : " + userUi.viewProfile().getFirstName());
		System.out.println("Last Name : " + userUi.viewProfile().getLastName());
		System.out.println("Username : " + userUi.viewProfile().getUsername());
		System.out.println("Password : " + userUi.viewProfile().getPassword());
		System.out.println("Type : " + userUi.viewProfile().getType());
		System.out.println("Status : " + userUi.viewProfile().getStatus());	
	}
	
	/** 
	 * View the saved school of the user
	 */
	public void viewSavedSchool(){
		System.out.println("====================viewSavedSchool()====================");
		ArrayList<String> savedSchools = userUi.viewSavedSchool();
		  for(int i=0; i < savedSchools.size(); i++){  
			  System.out.println("School" + (i+1) + " : " + savedSchools.get(i));
		  }	
	}
	
	/**
	 * Edit the profile of the user
	 */
	public void editProfile(){
		System.out.println("====================editProfile()====================");
		User u = userUi.viewProfile();
		System.out.println("Before : " + u.getFirstName() + " , " + u.getLastName());
		userUi.editProfile("userfEdited", "userlEdited", "password");
		u = userUi.viewProfile();
		System.out.println("After : " + u.getFirstName() + " , " + u.getLastName());
		userUi.editProfile("userf", "userl", "password");
	}
	
	/**
	 * Method to save school to the user's account
	 */
	public void saveSchool(){
		System.out.println("====================saveSchool()====================");
		System.out.println("Old Saved Schools Array : " + userUi.viewSavedSchool());
		System.out.println("Saved SJU: " + userUi.saveUniversity("ST JOHNS UNIVERSITY"));		
		System.out.println("New Saved Schools Array : " + userUi.viewSavedSchool());
	}
	
	/**
	 * Method to remove school from the user's account
	 */
	public void removeSchool(){
		System.out.println("====================removeSchool()====================");
		System.out.println("Saved school Array before Removal : " + userUi.viewSavedSchool());
		System.out.println("Removed SJU: " + userUi.removeSavedUniversity("ST JOHNS UNIVERSITY"));
		System.out.println("Saved school Array  after removal : " + userUi.viewSavedSchool());
	}
	
	/**
	 * Method to view saved school in detail by user
	 */
	public void viewSavedSchoolDetail(){
		System.out.println("====================viewSavedSchoolDetail()====================");
		University u = userUi.viewUniversityInDetail("BARD");
		System.out.println("Name : " + u.getSchoolName() + " State : " + u.getState());
		System.out.println("====================searchRecommendation()====================");
		System.out.println("Searching for Universities similar to Bard University...");
		System.out.println("                                                        ");
		ArrayList<University> list = userUi.searchRecommendation("BARD");
		for(University university : list){
			System.out.println(university.getSchoolName());
		}
	}
	
	/**
	 * Method to search University by criteria that user want to find
	 */
	public void search(){
		System.out.println("====================search()====================");
		ArrayList<University> searched = userUi.search("ST", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 
				"", "", "", "", "", "", "", 
				"", "", "FINE_ARTS", "BIOLOGY", "", "", "");
		System.out.println("Searching for schools with emphasis in Fine Arts and Biology...");
		System.out.println("                                                               ");
		for(int i =0 ; i < searched.size(); i++){
			System.out.println(searched.get(i).getSchoolName());
		}
	}
	////////////////////////////////////////////////////////////////
	/////////////////AdminUI Layer
	/**
	 * Method to view all user by admin
	 */
	public void viewAllAccount(){
		System.out.println("====================viewAllAccount()====================");
		ArrayList<Account> account = adminUi.viewAllUser();
		for(int i= 0; i < account.size(); i++){
			System.out.println("Account " + (i+1) +" : " +account.get(i).getUsername());
		}
	}
	
	/*
	 * Method to deactivate the account the admin want
	 */
	public void deactivateUser(){
		System.out.println("====================deactivateUser()====================");
		System.out.println("Before : " + userUi.viewProfile().getStatus());
		System.out.println("Deactivated : " + adminUi.deactivateUser("useru"));
		System.out.println("After : " + userUi.viewProfile().getStatus());
	}
	
	/**
	 * Method to add new University by Admin
	 */
	public void addUniversity(){
		System.out.println("====================addUniversity()====================");
		ArrayList<String> emphasesArray = new ArrayList<String>();
		  emphasesArray.add("SUBJ1");
		  emphasesArray.add("SUBJ2");
		  
		  boolean universityIsAdded = adminUi.addUniversity("TESTU", "TEST STATE", "TEST LOCATION", 
				  "TEST CONTROL", "5000", 
		         "52", "500", "500", "500", "99", "800",
		         "72", "65", "4", "2", "3", emphasesArray);
		  System.out.println("Successful to Add : " + universityIsAdded);
		  System.out.println("STATE : " + userUi.viewUniversityInDetail("TESTU").getState());
		  System.out.println("EMPHASES : " + userUi.viewUniversityInDetail("TESTU").getEmphases().get(0));
	}
	
	/**
	 * Method to edit University by Admin
	 */
	public void editUniversity(){
		System.out.println("====================editUniversity()====================");
		ArrayList<String> emphasesArray = new ArrayList<String>();
		  emphasesArray.add("CHANGED1");
		  emphasesArray.add("CHANGED2");
		  boolean universityIsEdited = adminUi.editUniversity("TESTU", "TESTEDITED", "TEST LOCATION", 
				  "TEST CONTROL", "5000", 
		         "52", "500", "500", "500", "99", "800",
		         "72", "65", "4", "2", "3", emphasesArray);
		 System.out.println("Successful to Edit : " + universityIsEdited);
		 System.out.println("STATE : " + userUi.viewUniversityInDetail("TESTU").getState());
		 System.out.println("EMPHASES : " + userUi.viewUniversityInDetail("TESTU").getEmphases().get(0));
		 UniversityDBController univ = new UniversityDBController();
		 univ.deleteUniversity("TESTU");
	}
	
	/**
	 * Method to add new User
	 */
	public void createUser(){
		System.out.println("====================createUser()====================");
		System.out.print("Before : ");
		for(int i = 0 ; i < adminUi.viewAllUser().size(); i++){
			System.out.print(adminUi.viewAllUser().get(i).getUsername() + " : ");
		}
		System.out.println("");
		boolean userCreated = adminUi.createUser("testf", "testl", "testu", "testp", "u", "Y");
		System.out.println("Created : " + userCreated);
		System.out.print("After : ");
		for(int i = 0 ; i < adminUi.viewAllUser().size(); i++){
			System.out.print(adminUi.viewAllUser().get(i).getUsername() + " : ");
		} 
		System.out.println("");
	}
	
	/**
	 * Method to edit admin's profile
	 */
	public void adminEditProfile(){
		System.out.println("====================adminEditProfile()====================");
		Account u = adminUi.viewOthersProfile("testu");
		System.out.println("Before : " + u.getFirstName() + " , " + u.getLastName() + " , " + u.getType());
		adminUi.editUserProfile("testfEDITED", "testl", "testu", "testp", "a", "Y");
		u = adminUi.viewOthersProfile("testu");
		System.out.println("After : " + u.getFirstName() + " , " + u.getLastName()+ " , " + u.getType());
	}
	
	/**
	 * Method to view all university list by admin
	 */
	public void viewAllUniversity(){
		System.out.println("====================viewAllUniversity()====================");
		ArrayList<University> university = adminUi.viewUniversityList();
		System.out.println(university.size());
		for(University u : university){
			System.out.println(u.getSchoolName());
		}
	}

	public static void main(String[] args){
		UIDriver uiDriver = new UIDriver();
		System.out.println("===============================================");
		System.out.println("====================Login UI====================");
		System.out.println("===============================================");
		System.out.println("                                               ");
		uiDriver.loggin();
		System.out.println("===============================================");
		System.out.println("====================User UI====================");
		System.out.println("===============================================");
		System.out.println("                                               ");
		uiDriver.viewProfile();
		uiDriver.viewSavedSchool();
		uiDriver.editProfile();
		uiDriver.saveSchool();
		uiDriver.removeSchool();
		uiDriver.viewSavedSchoolDetail();
		uiDriver.search();
		System.out.println("==================================================");
		System.out.println("======================Admin UI====================");
		System.out.println("==================================================");
		System.out.println("                                                  ");
		uiDriver.viewAllAccount();
		uiDriver.deactivateUser();
		uiDriver.addUniversity();
		uiDriver.editUniversity();
		uiDriver.createUser();
		uiDriver.adminEditProfile();
		uiDriver.viewAllUniversity();
	}

}
