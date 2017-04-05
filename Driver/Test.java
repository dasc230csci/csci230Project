package Driver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Controller.AccountController;
import Controller.AccountDBController;
import Controller.SearchController;
import Controller.UniversityController;
import Controller.UniversityDBController;
import Entity.Account;
import Entity.University;
import Entity.User;
import UI.LoginUI;
import dblibrary.project.csci230.UniversityDBLibrary;

public class Test {

	
	
	
	public static void main(String args[]){
	AccountDBController db = new AccountDBController();
	AccountController a = new AccountController();
	UniversityDBController u = new UniversityDBController();
	//int failed = db.getdblib().user_saveSchool("useru", "ST JOHNS UNIVERSITY");
	//Account admin = new Account("adminf", "adminl", "adminu", "password", "a", "Y", true);
	//User user = new User("userf", "userl", "useru", "password", "Y", true);
	//boolean istrue = db.addAccount(user);
	//boolean isSaved = a.saveSchool("useru", "BARD");
	//User userTest = a.getUserInfo("useru");
	ArrayList<University> list = new ArrayList<University>();
	list = u.getUniversityList();
	
	//System.out.println(userTest.getSavedSchool());
		/*for(University i : list){
			System.out.println(i.getSchoolName());
		}*/
	
	LoginUI ui = new LoginUI();
	String isFailed = ui.verifyUser("user", "password");
	System.out.println(isFailed);
	
	}
	
	
	
}
