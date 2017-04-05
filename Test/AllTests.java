package Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AccountDBControllerTest.class, testAccount.class, testLoginController.class,
  testUniversityController.class, testUserFuncController.class, UniversityDBControllerTest.class,
  UniversityTest.class })
public class AllTests {

}
