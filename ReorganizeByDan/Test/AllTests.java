package Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ testAccountController.class, testAccountDBController.class, testAccount.class, testLoginController.class,
 testSearchController.class, testUniversity.class, testUniversityController.class, testUniversityDBController.class,
 testUser.class, testUserFuncController.class })
public class AllTests {

}
