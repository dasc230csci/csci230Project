package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Entity.Account;
import Entity.User;

public class testAccount {

 private Account account;
 
 @Before
 public void init(){
  this.account = new Account("firstName", "lastName", "username", "password", "u", "Y", true);
 }
 
 @Test
 public void testAccount(){
  assertTrue(account instanceof Account);
 }

 @Test(expected=IllegalArgumentException.class)
 public void testAccountConstructor_InvalidFirstName(){
  Account newAccount = new Account(null, "lastName", "username", "password", "u", "Y", true);
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testAccountConstructor_InvalidLastName(){
  Account newAccount = new Account("firstName", null, "username", "password", "u", "Y", true);
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testAccountConstructor_InvalidUserName(){
  Account newAccount = new Account("firstName", "lastName", null, "password", "u", "Y", true);
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testAccountConstructor_InvalidPassword(){
  Account newAccount = new Account("f", "lastName", "username", null, "u", "Y", true);
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testAccountConstructor_InvalidType(){
  Account newAccount = new Account("f", "lastName", "username", "password", "c", "Y", true);
  
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testAccountConstructor_InvalidType_Case2(){
  Account newAccount = new Account("firstName", "lastName", "username", "password",null, "Y", true);
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testAccountConstructor_InvalidStatus(){
  Account newAccount = new Account("f", "lastName", "username", "password", "u", "B", true);
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testAccountConstructor_InvalidStatus_Case2(){
  Account newAccount = new Account("firstName", "lastName", "username", "password","a", null, true);
 }
 
 @Test
 public void testGetFirstName() {
  assertTrue(account.getFirstName().equals("firstName"));
 }

 @Test
 public void testGetLastName() {
  assertTrue(account.getLastName().equals("lastName"));
 }

 @Test
 public void testGetUsername() {
  assertTrue(account.getLastName().equals("lastName"));
 }

 @Test
 public void testGetPassword() {
  assertTrue(account.getPassword().equals("password"));
 }

 @Test
 public void testGetType() {
  assertTrue(account.getType().equals("u"));
 }

 @Test
 public void testGetStatus() {
  assertTrue(account.getStatus().equals("Y"));
 }

 @Test
 public void testGetLoggedIn() {
  assertTrue(account.getLoggedIn());
 }

 @Test
 public void testSetFirstName() {
  assertTrue(account.getFirstName().equals("firstName"));
  account.setFirstName("setFirstName");
  assertTrue(account.getFirstName().equals("setFirstName"));
 }

 @Test
 public void testSetLastName() {
  assertTrue(account.getLastName().equals("lastName"));
  account.setLastName("setLastName");
  assertTrue(account.getLastName().equals("setLastName"));
 }

 @Test
 public void testSetUsername() {
  assertTrue(account.getUsername().equals("username"));
  account.setUsername("setUsername");
  assertTrue(account.getUsername().equals("setUsername"));
 }

 @Test
 public void testSetPassword() {
  assertTrue(account.getPassword().equals("password"));
  account.setPassword("setPassword");
  assertTrue(account.getPassword().equals("setPassword"));
 }

 @Test
 public void testSetType() {
  assertTrue(account.getType().equals("u"));
  account.setType("a");
  assertTrue(account.getType().equals("a"));
 }

 @Test
 public void testSetStatus() {
  assertTrue(account.getStatus().equals("Y"));
  account.setStatus("N");
  assertTrue(account.getStatus().equals("N"));
 }

 @Test
 public void testSetLoggedIn() {
  assertTrue(account.getLoggedIn());
  account.setLoggedIn(false);
  assertTrue(account.getLoggedIn() == false);
 }

}
