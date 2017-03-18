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
	private AdminFuncController adminFuncCon;
	private Admin theAdmin;
	
	/**
	 * Default constructor.
	 */
	public AdminUI(Admin admin) {
		this.adminFuncCon = new AdminFuncController(admin);
		this.theAdmin = admin;
	}

	/**
	 * View a list of all users.
	 * @return ArrayList<String> list of all users
	 */
	public ArrayList<String> viewAllUser() {
		ArrayList<String> savedSchool = this.adminFuncCon.viewAllUser();
		return savedSchool;	
	}
	
	/**
	 * Deactivate a specific user.
	 * @return true if successfully deactivate user
	 */
	public boolean deactivateUser(String username) {
		return adminFuncCon.deactivateUser(username);
	}
	
	/**
	 * Add new university.
	 * 
	 * @return true if successfully add new university
	 */
	public boolean addUniversity(String schoolName, String state, String location, String control, int numOfEnrolled,
			double femaleRatio, double satVerbal, double satMath, double expenses, double perFinanAid,
			int totNumOfApplicant, double perAdmitted, double perEnrolled, int academicScale, int socialScale, int qualOfLifeScale,
			ArrayList<String> emphases) {
		
			ArrayList<String> schoolInfo=new ArrayList<>();
		   schoolInfo.add(schoolName);
		   schoolInfo.add(state);
		   schoolInfo.add(location);
		   schoolInfo.add(control);
		   schoolInfo.add(numOfEnrolled+"");
		   schoolInfo.add(femaleRatio+"");
		   schoolInfo.add(satVerbal+"");
		   schoolInfo.add(satMath+"");
		   schoolInfo.add(expenses+"");
		   schoolInfo.add(perFinanAid+"");
		   schoolInfo.add(totNumOfApplicant+"");
		   schoolInfo.add(perAdmitted+"");
		   schoolInfo.add(perEnrolled+"");
		   schoolInfo.add(academicScale+"");
		   schoolInfo.add(socialScale+"");
		   schoolInfo.add(qualOfLifeScale+"");
		   schoolInfo.add(emphases+"");
		   if(adminFuncCon.addUniversity(schoolInfo)==true){
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
		   schoolInfo.add(numOfEnrolled+"");
		   schoolInfo.add(femaleRatio+"");
		   schoolInfo.add(satVerbal+"");
		   schoolInfo.add(satMath+"");
		   schoolInfo.add(expenses+"");
		   schoolInfo.add(perFinanAid+"");
		   schoolInfo.add(totNumOfApplicant+"");
		   schoolInfo.add(perAdmitted+"");
		   schoolInfo.add(perEnrolled+"");
		   schoolInfo.add(academicScale+"");
		   schoolInfo.add(socialScale+"");
		   schoolInfo.add(qualOfLifeScale+"");
		   schoolInfo.add(emphases+"");
		   if(adminFuncCon.editUniversityInDetailed(schoolInfo)==true){
			   return true;
		   }
		   return false;
		   }
	
	
	/**
	 * Create a new user.
	 * @return true if successfully create new user
	 */
	public boolean createUser(String firstName, String lastName, String userName, String password, String type, String status) {
		return adminFuncCon.createUser(firstName, lastName, userName, password, type, status);
		
	}
	
	/**
	 * Edit an existing user information 
	 * @return true if successfully edit profile
	 */
	public boolean editUserProfile(String firstName, String lastName, String userName, String password, String type, String status) {
		return adminFuncCon.editUserProfile(firstName, lastName, userName, password, type, status);
		
	}
	
	/**
	 * Reset user's typed information in fields
	 * @return ArrayList<String> information of user
	 */
	public ArrayList<String> resetUserInfo(String username) {
		Account newAccount = adminFuncCon.reset(username);
		ArrayList<String> newInfo = new ArrayList<>();
		newInfo.add(newAccount.getFirstName());
		newInfo.add(newAccount.getLastName());
	    newInfo.add(newAccount.getUsername());
		newInfo.add(newAccount.getPassword());
		newInfo.add(newAccount.getType());
		newInfo.add(newAccount.getStatus());
		return newInfo;
		
	}
	
	/**
	 * View a specific user.
	 * 
	 * @return User the specific user want to view 
	 */
	public User viewSpecificUser(String username) {
		return adminFuncCon.viewSpecificUser(username);
	}
	
	/**
	 * Confirmation message to confirm a reset.
	 */
	public void confirmReset(String username) {
	}
}
