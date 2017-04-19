package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import UI.AdminUI;
import Controller.*;
import Entity.*;

public class testU19ViewAllUserProfiles {
	private AdminUI adminui;
	private AdminFuncController adminFuncController;
	private AccountController accountController;
	private AccountDBController accountDBController;
	
	@Before
	public void setUp() throws Exception {
		adminui = new AdminUI("nadmin");
		adminFuncController = new AdminFuncController();
		accountController = new AccountController();
		accountDBController = new AccountDBController();
	}

	@Test
	public void testAdminUIViewAllUser() {
		assertTrue(this.adminui.viewAllUser() instanceof ArrayList);
	}

	@Test
	public void testAdminFuncControllerViewAllUser() {
		assertTrue(this.adminFuncController.viewAllUser() instanceof ArrayList);
	}
	
	@Test
	public void testAccountControllerGetAccountList() {
		assertTrue(this.accountController.getAccountList() instanceof ArrayList);
	}
	
	@Test
	public void testAccountDBControllerGetAcccountList() {
		assertTrue(this.accountDBController.getAccountList() instanceof ArrayList);
	}
}
