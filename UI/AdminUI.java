/**
 * File: AdminUI.java
 */
package UI;
import java.util.ArrayList;
import Controller.AdminFuncController;
import Entity.*;

/**
 * Class to represent the Admin UI.
 * 
 * @author  Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version Feburary 27, 2017
 */
public class AdminUI {
	
	/**
	 * AdminFuncController which provide
	 * functionality of admin
	 */
	private AdminFuncController adminFuncController;
	
	/**
	 * username of the user
	 */
	private String username;
	
	/**
	 * Default constructor.
	 */
	public AdminUI(String username) {
		this.username = username;
		this.adminFuncController = new AdminFuncController();
	}

	/**
	 * View a list of all users.
	 * @return ArrayList<String> list of all users
	 */
	public ArrayList<Account> viewAllUser() {
		return adminFuncController.viewAllUser();
	}
	
	/**
	 * Deactivate a specific user.
	 * @return true if successfully deactivate user
	 */
	public boolean deactivateUser(String username) {
		return adminFuncController.deactivateUser(username);
	}
	
	/**
	 * Add new university.
	 * 
	 * @return true if successfully add new university
	 */
	public boolean addUniversity(String schoolName, String state, String location, String control, String numOfEnrolled,
			String femaleRatio, String satVerbal, String satMath, String expenses, String perFinanAid,
			String totNumOfApplicant, String perAdmitted, String perEnrolled, String academicScale, String socialScale, String qualOfLifeScale,
			ArrayList<String> emphases){
		
			ArrayList<String> schoolInfo=new ArrayList<>();
		   schoolInfo.add(schoolName);
		   schoolInfo.add(state);
		   schoolInfo.add(location);
		   schoolInfo.add(control);
		   schoolInfo.add(numOfEnrolled);
		   schoolInfo.add(femaleRatio);
		   schoolInfo.add(satVerbal);
		   schoolInfo.add(satMath);
		   schoolInfo.add(expenses);
		   schoolInfo.add(perFinanAid);
		   schoolInfo.add(totNumOfApplicant);
		   schoolInfo.add(perAdmitted);
		   schoolInfo.add(perEnrolled);
		   schoolInfo.add(academicScale);
		   schoolInfo.add(socialScale);
		   schoolInfo.add(qualOfLifeScale);
		   schoolInfo.addAll(emphases);
		   if(adminFuncController.addUniversity(schoolInfo)){
			   return true;
		   }
		   return false;
	}
	
	/**
	 * Edit university information
	 * 
	 * @return true if successfully edit university
	 */
	public boolean editUniversity(String schoolName, String state, String location, String control, String numOfEnrolled,
			String femaleRatio, String satVerbal, String satMath, String expenses, String perFinanAid,
			String totNumOfApplicant, String perAdmitted, String perEnrolled, String academicScale, String socialScale, String qualOfLifeScale,
			ArrayList<String> emphases){
		
			ArrayList<String> schoolInfo=new ArrayList<>();
		   schoolInfo.add(schoolName);
		   schoolInfo.add(state);
		   schoolInfo.add(location);
		   schoolInfo.add(control);
		   schoolInfo.add(numOfEnrolled);
		   schoolInfo.add(femaleRatio);
		   schoolInfo.add(satVerbal);
		   schoolInfo.add(satMath);
		   schoolInfo.add(expenses);
		   schoolInfo.add(perFinanAid);
		   schoolInfo.add(totNumOfApplicant);
		   schoolInfo.add(perAdmitted);
		   schoolInfo.add(perEnrolled);
		   schoolInfo.add(academicScale);
		   schoolInfo.add(socialScale);
		   schoolInfo.add(qualOfLifeScale);
		   schoolInfo.addAll(emphases);
		   if(adminFuncController.editUniversityInDetailed(schoolInfo)){
			   return true;
		   }
		   return false;
	}
	
	
	/**
	 * Create a new user.
	 * @return true if successfully create new user
	 */
	public boolean createUser(String firstName, String lastName, String userName, String password, String type, String status) {
		return adminFuncController.createUser(firstName, lastName, userName, password, type, status);
		
	}
	
	/**
	 * Edit an existing user information 
	 * @return true if successfully edit profile
	 */
	public boolean editUserProfile(String firstName, String lastName, String userName, String password, String type, String status) {
		return adminFuncController.editUserProfile(firstName, lastName, userName, password, type, status);
	}
	
	/**
	 * View user's information
	 * obtain account information from database
	 * @return Account which contains information of the user
	 */
	public Account viewProfile(){
		Account account = adminFuncController.getProfile(username);
		return account;
	}
	
	/**
	 * View other user's information
	 * obtain account information from database
	 * @return Account which contains information of the user
	 */
	public Account viewOthersProfile(String username){
		Account account = adminFuncController.getProfile(username);
		return account;
	}
	
	/**
	 * View all universities that exist in database
	 * @return ArrayList<University> list of all universities
	 */
	public ArrayList<University> viewUniversityList(){
		return adminFuncController.getUniversityList();
	}
	
}
