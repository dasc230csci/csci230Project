package Test.Functionality;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ testAdminFunctionality.class, testLoginFunctionality.class, testUserFunctionality.class })
public class AllTests {

}
