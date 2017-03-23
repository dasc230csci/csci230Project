package Driver;
import java.util.ArrayList;

import Entity.University;
import UI.UserUI;

public class UserUIDriver {

	public static void main(String[] args) {
		UserUI ui = new UserUI("testu");
		System.out.println("====================viewProfile()====================");
		System.out.println("First Name : " + ui.viewProfile().getFirstName());
		System.out.println("Last Name : " + ui.viewProfile().getLastName());
		System.out.println("Username : " + ui.viewProfile().getUsername());
		System.out.println("Type : " + ui.viewProfile().getType());
		System.out.println("Status : " + ui.viewProfile().getStatus());		
		System.out.println("====================saveSchool()====================");
		System.out.println(ui.saveSchool("ST JOHNS UNIVERSITY"));
		System.out.println(ui.viewSavedSchool());
		System.out.println("====================removeSchool()====================");
		System.out.println(ui.removeSavedUniversity("ST JOHNS UNIVERSITY"));
		System.out.println(ui.viewSavedSchool());
		System.out.println("====================search()====================");
		ArrayList<University> searched = ui.search("ST", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 
				"", "", "", "", "", "", "", 
				"", "", "FINE_ARTS", "BIOLOGY", "", "", "");
		for(int i =0 ; i < searched.size(); i++){
			System.out.println(searched.get(i).getSchoolName());
		}
	}

}
