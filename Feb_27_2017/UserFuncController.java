/**
 * File: UserFuncController.java
 */

/**
 * Controller class with functions for the User.
 * 
 * @authors Caitlin Harvey, Daniel Song, Sam Halloran, Anh Tran
 */
public class UserFuncController {

	/**
	 * Creates the Controller.
	 */
	public UserFuncController() {
	
	}
	
	/**
	 * Saves a school to User account.
	 * 
	 * @param schoolName - Name of school to save
	 * @return boolean 
	 */
	public boolean saveSchool(String schoolName) {
		return true;
		
	}
	
	/**
	 * Allows user to edit individual profile.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param passWord
	 * @return boolean
	 */
	public boolean editProfile(String firstName, String lastName, String passWord){
		return true;
	}

	/**
	 * Allows user to view a specific saved school
	 * 
	 * @param schoolName
	 */
	public void viewSavedSchool(String schoolName){
		
	}
	
	/**
	 * Removes a saved University from user account.
	 * 
	 * @param schoolName
	 * @return boolean
	 */
	public boolean removeSavedUniversity(String schoolName){
		return true;
	}
	
	//undecided return
	/**
	 * Resets user information.
	 */
	public void resetUserInfo() {
		
	}
	
	/**
	 * Gets the university is greater detail.
	 * 
	 * @return University
	 */
	public University getUniversityInDetail() {
		return null;
		
	}
}
