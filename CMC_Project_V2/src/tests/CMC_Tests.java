package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AdminHomeTest.class, AdminInterfaceTest.class, DatabaseHomeTest.class, SchoolTest.class,
		SearchHomeTest.class, StudentHomeTest.class, StudentUserInterfaceTest.class, UserHomeTest.class,
		UserInterfaceTest.class, UserTest.class })
public class CMC_Tests {

}
