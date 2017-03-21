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
	public boolean addUniversity(String schoolName, String state, String location, String control, int numOfEnrolled,
			double femaleRatio, double satVerbal, double satMath, double expenses, double perFinanAid,
			int totNumOfApplicant, double perAdmitted, double perEnrolled, int academicScale, int socialScale, int qualOfLifeScale,
			ArrayList<String> emphases){
		
			ArrayList<String> schoolInfo=new ArrayList<>();
		   schoolInfo.add(schoolName);
		   schoolInfo.add(state);
		   schoolInfo.add(location);
		   schoolInfo.add(control);
		   schoolInfo.add(Integer.toString(numOfEnrolled));
		   schoolInfo.add(Double.toString(femaleRatio));
		   schoolInfo.add(Double.toString(satVerbal));
		   schoolInfo.add(Double.toString(satMath));
		   schoolInfo.add(Double.toString(expenses));
		   schoolInfo.add(Double.toString(perFinanAid));
		   schoolInfo.add(Integer.toString(totNumOfApplicant));
		   schoolInfo.add(Double.toString(perAdmitted));
		   schoolInfo.add(Double.toString(perEnrolled));
		   schoolInfo.add(Integer.toString(academicScale));
		   schoolInfo.add(Integer.toString(socialScale));
		   schoolInfo.add(Integer.toString(qualOfLifeScale));
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
	public boolean editUniversity(String schoolName, String state, String location, String control, int numOfEnrolled,
			double femaleRatio, double satVerbal, double satMath, double expenses, double perFinanAid,
			int totNumOfApplicant, double perAdmitted, double perEnrolled, int academicScale, int socialScale, int qualOfLifeScale,
			ArrayList<String> emphases) {
		
			ArrayList<String> schoolInfo=new ArrayList<>();
		   schoolInfo.add(schoolName);
		   schoolInfo.add(state);
		   schoolInfo.add(location);
		   schoolInfo.add(control);
		   schoolInfo.add(Integer.toString(numOfEnrolled));
		   schoolInfo.add(Double.toString(femaleRatio));
		   schoolInfo.add(Double.toString(satVerbal));
		   schoolInfo.add(Double.toString(satMath));
		   schoolInfo.add(Double.toString(expenses));
		   schoolInfo.add(Double.toString(perFinanAid));
		   schoolInfo.add(Integer.toString(totNumOfApplicant));
		   schoolInfo.add(Double.toString(perAdmitted));
		   schoolInfo.add(Double.toString(perEnrolled));
		   schoolInfo.add(Integer.toString(academicScale));
		   schoolInfo.add(Integer.toString(socialScale));
		   schoolInfo.add(Integer.toString(qualOfLifeScale));
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
	public boolean createUser(String firstName, String lastName, String username, String password, String type, String status) {
		return adminFuncController.createUser(firstName, lastName, username, password, type, status);
		
	}
	
	/**
	 * Edit an existing user information 
	 * @return true if successfully edit profile
	 */
	public boolean editUserProfile(String firstName, String lastName, String username, String password, String type, String status) {
		return adminFuncController.editUserProfile(firstName, lastName, username, password, type, status);
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
}
