/**
 * File: AdminUI.java
 */
package UI;
import java.util.ArrayList;
import Controller.AdminFuncController;
import Entity.User;

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
	 * Default constructor.
	 */
	public AdminUI() {
	}

	/**
	 * View a list of all users.
	 * @return ArrayList<String> list of all users
	 */
	public ArrayList<String> viewAllUser() {
		return null;
	}
	
	/**
	 * Deactivate a specific user.
	 * @return true if successfully deactivate user
	 */
	public boolean deactivateUser() {
		return false;
	}
	
	/**
	 * Add new university.
	 * 
	 * @return true if successfully add new university
	 */
	public boolean addUniversity() {
		return false;
	}
	
	/**
	 * Edit university information
	 * 
	 * @return true if successfully edit university
	 */
	public boolean editUniversity() {
		return false;
	}
	
	/**
	 * Create a new user.
	 * @return true if successfully create new user
	 */
	public boolean createUser() {
		return false;
	}
	
	/**
	 * Edit an existing user information 
	 * @return true if successfully edit profile
	 */
	public boolean editUserProfile() {
		return false;
	}
	
	/**
	 * Reset user's typed information in fields
	 * @return ArrayList<String> information of user
	 */
	public ArrayList<String> resetUserInfo() {
		return null;
	}
	
	/**
	 * View a specific user.
	 * 
	 * @return User the specific user want to view 
	 */
	public User viewSpecificUser() {
		return null;
	}
	
	/**
	 * Confirmation message to confirm a reset.
	 */
	public void confirmReset() {
	}
}

