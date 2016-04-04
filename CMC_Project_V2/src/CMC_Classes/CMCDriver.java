package CMC_Classes;
import dblibrary.project.csci230.*;
/**
 * @title CMCDriver
 * @author DropDatabase
 * @version 3/15/16
 *  This class interacts with all of the user interfaces and tests their functionalities
 */
public class CMCDriver{
  
 private UniversityDBLibrary database;
 private DataBaseHome dbhome;
 private StudentUI studentInterface;
 private AdminInterface adminInterface;
 private UserInterface userInterface;
 User user;
 private final int PRINT_TEXT_SLEEP = 200;
 private final int FUNCTION_SLEEP = 1000;
  /**
  * runs each of the demo methods
  */
 public void run(){
   initializeDatabase();
   demoUserFunctionalities();
   demoAdminFunctionalities();
   demoStudentFunctionalities();
 }
  /**
  * Demonstrates Student functionalities
  */
 public void demoStudentFunctionalities(){
   p("Lets login as a student");
   user = userInterface.login("C","L");
   studentInterface = new StudentUI(user);
   p("Alright, now lets take a look at our profile");
   p("Profile: \n"+studentInterface.viewProfile());
   try{Thread.sleep(FUNCTION_SLEEP);}catch(InterruptedException ex){}
   p("Lets change our password to 'lors'");
   p(studentInterface.editProfile("Connor", "Lorsung", "lors"));
   p("lets search for schools containing 'Minn' in their name");
   int[] em = new int[2];
   double[] e = new double[2];
   String emp = "";
   String[] empt = new String[1];
   p("Search Results:\n"+ studentInterface.search("Minn", emp, emp, emp, em, e, e, em,
                               e, e, e, e, e, em, em, em, empt));
   try{Thread.sleep(FUNCTION_SLEEP);}catch(InterruptedException ex){}
   p("lets take a peek at the University of Minnesota");
   p("School details:\n "+studentInterface.viewExpandedSchool(0));
   p("lets save 'University of Minnesota' and 'University of Minnesota Duluth'");
   p(studentInterface.saveSchool(0));
   p(studentInterface.saveSchool(1));
   p("Lets see if our schools have been saved to our profile");
   p("Saved Schools: \n"+studentInterface.viewSavedSchools());
   try{Thread.sleep(FUNCTION_SLEEP);}catch(InterruptedException ex){}
   p("lets get rid of umd");
   p(studentInterface.removeSchool(0));
   p("lets verify the removal");
   p("Saved Schools: \n"+studentInterface.viewSavedSchools());
   try{Thread.sleep(FUNCTION_SLEEP);}catch(InterruptedException ex){}
   p("Last but not least, lets take a look at some recommended Schools based off of our previous search");
   p("Recommended Schools: \n" + studentInterface.recommendations());
   try{Thread.sleep(FUNCTION_SLEEP);}catch(InterruptedException ex){}
   p("There we go, there are the all of the use case functionalities for the CMC System");
   p("THE END");
   p("Phase 2");
   p("Group: DropDatabase");
   p("Members: Tyler, Megan, Connor, Cassie");
 }
  /**
  * demonstrates admin functionalities
  */
 public void demoAdminFunctionalities(){
   adminInterface = new AdminInterface(user);
   p("Admin Functionality Demo");
   p("Admin has the ability to: view schools, edit school, add school, \n \t view school, add user, edit user, deactivate user");
   p("First we explore the view schools feature");
   p(adminInterface.viewSchools());
   try{Thread.sleep(FUNCTION_SLEEP);}catch(InterruptedException ex){}
   p("Now lets Add a school");
   p("We will give it the name of 'Tyler is so cool'");
   String[] myEmphasis = {"being cool","being smart"};
   adminInterface.addNewSchool("Tyler is so cool", "Florida", "SUBURBAN", "PRIVATE",
       100, .8, 500, 501, 50.0, .9, 100000, .2, .15, 4, 5, 5, myEmphasis);
   p("Now lets see if the school shows up...");
   p(adminInterface.viewSchools());
   try{Thread.sleep(FUNCTION_SLEEP);}catch(InterruptedException ex){}
   p("Great, lets learn a little more about my new School");
   p("Here are the details\n"+ adminInterface.viewSchool(3));
   p("Great, lets increase the number of students to match todays data (50000)");
   p(adminInterface.editSchool("Tyler is so cool", "Florida", "SUBURBAN", "PRIVATE",
       50000, .8, 500, 501, 50.0, .9, 100000, .2, .15, 4, 5, 5, myEmphasis));
   p("lets check by viewing the school");
   p("Here are the details\n"+ adminInterface.viewSchool(3));
   try{Thread.sleep(FUNCTION_SLEEP);}catch(InterruptedException ex){}
   p("Perfect, now lets see what users are currently in the system");
   p(adminInterface.viewUsers());
   try{Thread.sleep(FUNCTION_SLEEP);}catch(InterruptedException ex){}
   p("Lets learn a little bit about 'user'");
   p("User Details: \n"+adminInterface.viewUser(0));
   try{Thread.sleep(FUNCTION_SLEEP);}catch(InterruptedException ex){}
   p("cool, now lets add a new user with a username of 'tim123'");
   p(adminInterface.addUser("Timothy", "Wiggins", "tim123", "mit123",'s'));
   p("Great, lets verify that he's in the system");
   p(adminInterface.viewUsers());
   try{Thread.sleep(FUNCTION_SLEEP);}catch(InterruptedException ex){}
   p("He's there, he looks sketchy though. Let's deactivate him.");
   p(adminInterface.deactivateUser(4));
   try{Thread.sleep(FUNCTION_SLEEP);}catch(InterruptedException ex){}
   p("He's out of the system!");
   p("Lets change his password to 'timSucks' just to be safe");
   p(adminInterface.editUser("Timothy", "Wiggins", "tim123", "timSucks",'s','d'));
   p("lets make sure");
   p("User Details: \n"+adminInterface.viewUser(0));
   try{Thread.sleep(FUNCTION_SLEEP);}catch(InterruptedException ex){}
   p("Perfect, thats all for admin functionality");
   p("Logging out of the system");
   user = null;
   adminInterface = null;
   userInterface = new UserInterface();
 }
  /**
  * Demonstrates user functionalities
  */
 public void demoUserFunctionalities(){
  userInterface = new UserInterface();
   p("User Functionality demo");
   p("User has the ability to: log in");
   p("submitting improper credentials 'u' and 'pass'");
   if(userInterface.login("u", "pass") == UserInterface.INCORRECT)
     p("Perfect, login failed.");
   else
     p("Somehow login succeded, might wanna check up on that");
   p("now submitting proper credentials 'user' and 'pass' ");
   if(userInterface.login("user", "pass") == UserInterface.INCORRECT)
     p("ERROR, login failed.");
   else
     p("There we go, we are now logged in as an admin");
   user = userInterface.login("user", "pass");
   userInterface = null;
 }
  /**
  * Creates database object and populates it with fake data for testing
  */
 public void initializeDatabase(){
   p("Initializing database");
   database = new UniversityDBLibrary("dropdataba", "dropdataba", "ccmt4");
   dbhome = new DataBaseHome();
   p("Database up");
   p("Adding users to the database");
      database.user_addUser("Tyler","Weiss","user","pass",'a');
      //database.user_addUser("Conor","Lorsung","C","L",'s');
      //database.user_addUser("Megan","Pekarek","M","P",'s');
      //database.user_addUser("Cassie","I'm_So_Sorry","c","l",'s');
      try{Thread.sleep(FUNCTION_SLEEP);}catch(InterruptedException ex){}
   p("Added Users");
   p("Adding Schools to the database");
   /*
      database.university_addUniversity("Saint Johns University","Minnesota", "SMALL-CITY", "PRIVATE", 5000, .5, 20,30,5000.0,.3,1000,.5,.3,4,3,5);
      database.university_addUniversity("University of Minnesota Duluth","Minnesota", "UNKNOWN", "STATE", 50000, .7, 20,30,5000.0,.3,1000,.5,.3,4,3,5);
      database.university_addUniversity("University of Minnesota","Minnesota", "URBAN", "UNKNOWN", 500000, .45, 20,30,5000.0,.3,1000,.5,.3,4,3,5);
      database.university_addUniversity("University of Mankato","Minnesota", "URBAN", "UNKNOWN", 500000, .45, 20,30,5000.0,.3,1000,.5,.3,4,3,5);
      database.university_addUniversity("University of Mars Minnesota","Minnesota", "URBAN", "UNKNOWN", 500000, .45, 20,30,5000.0,.3,1000,.5,.3,4,3,5);
      database.university_addUniversity("University of school","Minnesota", "URBAN", "UNKNOWN", 500000, .45, 20,30,5000.0,.3,1000,.5,.3,4,3,5);
      database.university_addUniversity("southwest","Minnesota", "URBAN", "UNKNOWN", 500000, .45, 20,30,5000.0,.3,1000,.5,.3,4,3,5);
      database.university_addUniversity("St thomas","Minnesota", "URBAN", "UNKNOWN", 500000, .45, 20,30,5000.0,.3,1000,.5,.3,4,3,5);
      database.university_addUniversity("hamline","Minnesota", "URBAN", "UNKNOWN", 500000, .45, 20,30,5000.0,.3,1000,.5,.3,4,3,5);
      database.university_addUniversity("gustavis","Minnesota", "URBAN", "UNKNOWN", 500000, .45, 20,30,5000.0,.3,1000,.5,.3,4,3,5);
      database.university_addUniversity("bethel","Minnesota", "URBAN", "UNKNOWN", 500000, .45, 20,30,5000.0,.3,1000,.5,.3,4,3,5);
      */
      try{Thread.sleep(FUNCTION_SLEEP);}catch(InterruptedException ex){}
   p("Added Schools to the database");
   p("Initialization complete");
 }
  /**
  * @param text the text to print out
  */
  public void p(String text){
    try{
  System.out.println("CMC Driver: " + text); 
  Thread.sleep(PRINT_TEXT_SLEEP);
    }catch(InterruptedException ex){}
 }
  
 public static void main(String[] args){
  new CMCDriver().run(); 
 }
}