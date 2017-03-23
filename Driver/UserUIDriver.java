package Driver;
import java.util.ArrayList;

import Entity.University;
import UI.UserUI;

public class UserUIDriver {
	
	UserUI ui = new UserUI("testu");
	
	/**
	 * Method to view the user's own profile
	 */
	public void viewProfile(){
		System.out.println("====================viewProfile()====================");
		System.out.println("First Name : " + ui.viewProfile().getFirstName());
		System.out.println("Last Name : " + ui.viewProfile().getLastName());
		System.out.println("Username : " + ui.viewProfile().getUsername());
		System.out.println("Type : " + ui.viewProfile().getType());
		System.out.println("Status : " + ui.viewProfile().getStatus());	
	}
	
	/**
	 * Method to save school to the user's account
	 */
	public void saveSchool(){
		System.out.println("====================saveSchool()====================");
		System.out.println(ui.saveSchool("ST JOHNS UNIVERSITY"));		
		System.out.println(ui.viewSavedSchool());
	}
	
	/**
	 * Method to remove school from the user's account
	 */
	public void removeSchool(){
		System.out.println("====================removeSchool()====================");
		System.out.println(ui.removeSavedUniversity("ST JOHNS UNIVERSITY"));
		System.out.println(ui.viewSavedSchool());
	}
	
	/**
	 * Method to search University by criteria that user want to find
	 */
	public void search(){
		System.out.println("====================search()====================");
		ArrayList<University> searched = ui.search("ST", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 
				"", "", "", "", "", "", "", 
				"", "", "FINE_ARTS", "BIOLOGY", "", "", "");
		for(int i =0 ; i < searched.size(); i++){
			System.out.println(searched.get(i).getSchoolName());
		}
	}
	

	public static void main(String[] args) {
		UserUIDriver uDriver = new UserUIDriver();
		uDriver.viewProfile();
		uDriver.saveSchool();
		uDriver.removeSchool();
		uDriver.search();
	}

}
