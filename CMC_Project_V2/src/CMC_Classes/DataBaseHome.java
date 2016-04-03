package CMC_Classes;

import java.util.*;

import dblibrary.project.csci230.*;

public class DataBaseHome{
 // private UniversityDBLibrary database;
//private DataBase database;
private UniversityDBLibrary dummydatabase;

public DataBaseHome(){
  dummydatabase = new UniversityDBLibrary("dropdataba", "dropdataba", "ccmt4");
 // dummydatabase = data; 
}

public User login(String username, String password){
	if(username.equals(""))
		throw new IllegalArgumentException();
	else if(password.equals(""))
		throw new IllegalArgumentException();
  String[][] users = dummydatabase.user_getUsers();
    for(int i=0; i< users.length ; i++){
      //System.out.println(users[i][2] + " " + users[i][3]);
       if(username.equals(users[i][2]) && password.equals(users[i][3]))
         return new User(users[i][0], users[i][1], users[i][2], users[i][3], users[i][4].charAt(0),'a' );
  }
    return null;
}

public User addUser(String firstname, String lastname, String username, String password, char type){
	if(type != 'a' || type != 's')
		throw new IllegalArgumentException("type is not a or s");
	else if(firstname.equals(""))
		throw new IllegalArgumentException("empty argument");
	else if(lastname.equals(""))
		throw new IllegalArgumentException("empty argument");
	else if(username.equals(""))
		throw new IllegalArgumentException("empty argument");
	else if(password.equals(""))
		throw new IllegalArgumentException("empty argument");
	else if(type == ' ')
		throw new IllegalArgumentException("empty argument");
	
  dummydatabase.user_addUser(firstname,lastname,username,password, type);
  return new User(firstname,lastname,username,password, type,'a');
}
    public ArrayList<User> getUsers(){
    String[][] temp = dummydatabase.user_getUsers();
    ArrayList<User> users = new ArrayList<User>();
    
    for(int i=0; i<temp.length;i++){
      users.add(new User(temp[i][0],temp[i][1],temp[i][2],temp[i][3],temp[i][4].charAt(0),temp[i][5].charAt(0)));
    }
      return users;
    }
    
    public User editUser(String firstname, String lastname, String username, String password, char type,char status){
    	if(type != 'a' || type != 's')
    		throw new IllegalArgumentException("type is not a or s");
    	else if(firstname.equals(""))
    		throw new IllegalArgumentException("empty argument");
    	else if(lastname.equals(""))
    		throw new IllegalArgumentException("empty argument");
    	else if(username.equals(""))
    		throw new IllegalArgumentException("empty argument");
    	else if(password.equals(""))
    		throw new IllegalArgumentException("empty argument");
    	else if(type != 'a' || type != 's')
    		throw new IllegalArgumentException("empty argument");
    	
      dummydatabase.user_editUser(firstname,lastname,username,password, type,status);
      return new User(firstname,lastname,username,password,type,status);
    }
    
    public User deactivateUser(int id){
      if(id < 0)
    	  throw new IllegalArgumentException("id can not be less than 0");
      String[][] temp = dummydatabase.user_getUsers();
      if(id> temp.length)
    	  throw new IllegalArgumentException("id to large");
      dummydatabase.user_editUser(temp[id][2],temp[id][0],temp[id][1],temp[id][3],temp[id][4].charAt(0),'d');
                  return new User(temp[id][0],temp[id][1],temp[id][2],temp[id][3],temp[id][4].charAt(0),'d');
    }
    
    public ArrayList<School> getSchools(){
      String[][] temp = dummydatabase.university_getUniversities();
      ArrayList<School> ret = new ArrayList<School>();
      
      for(int i=0; i<temp.length; i++){
        ret.add( new School(temp[i][0],temp[i][1],temp[i][2],temp[i][3],Integer.parseInt(temp[i][4]),Double.parseDouble(temp[i][5]),Double.parseDouble(temp[i][6]),
                            Double.parseDouble(temp[i][7]),Double.parseDouble(temp[i][8]),Double.parseDouble(temp[i][9]),Integer.parseInt(temp[i][10]),
                            Double.parseDouble(temp[i][11]),Double.parseDouble(temp[i][12]),Integer.parseInt(temp[i][13]),
                            Integer.parseInt(temp[i][14]),Integer.parseInt(temp[i][15])));
      }
      return ret;
    }
   // Integer.parseInt(  Double.parseDouble(
                     
    public School getSchool(int id){
      String[][] temp = dummydatabase.university_getUniversities();
      return new School(temp[id][0],temp[id][1],temp[id][2],temp[id][3],Integer.parseInt(temp[id][4]),Double.parseDouble(temp[id][5]),Double.parseDouble(temp[id][6]),
              Double.parseDouble(temp[id][7]),Double.parseDouble(temp[id][8]),Double.parseDouble(temp[id][9]),Integer.parseInt(temp[id][10]),
              Double.parseDouble(temp[id][11]),Double.parseDouble(temp[id][12]),Integer.parseInt(temp[id][13]),
              Integer.parseInt(temp[id][14]),Integer.parseInt(temp[id][15]));
    }
    
    public School editSchool(String school,String state, String location, String control, int numStudents, double percentFemale, double satVerbal, double satMath,
                           double expenses, double percentFinAid, int numApplicants, double percentAdmitted, double percentEnrolled, int academicScale,
                           int socialScale, int qualOflife, String[] emphasis, int id){
      
   dummydatabase.university_editUniversity(school, state,location, control, numStudents, percentFemale, satVerbal, satMath,
      expenses, percentFinAid, numApplicants, percentAdmitted, percentEnrolled, academicScale, socialScale, qualOflife);
  
      String[][] temp = dummydatabase.university_getEmphases();
      for(int i=0; i<temp[id].length; i++){
       dummydatabase.university_removeUniversityEmphasis(school, temp[id][i]); 
      }
      for(int i=0; i<emphasis.length; i++){
       dummydatabase.university_addUniversityEmphasis(school, emphasis[i]); 
      }
      
      return new School(school,state,location,control,numStudents,satVerbal,satMath,numApplicants,
                        percentFemale,expenses,percentFinAid,percentAdmitted,percentEnrolled,
                        academicScale,socialScale,qualOflife,emphasis);
    }
    
  public School addSchool(String school, String state, String location, String control, int numStudents,
			double percentFemale, double satVerbal, double satMath, double expenses, double percentFinAid, int numApplicants,
			double percentAdmitted, double percentEnrolled, int academicScale, int socialScale, int qualOflife
			){
	  
	  dummydatabase.university_addUniversity(school, state, location, control, numStudents,percentFemale, satVerbal, satMath, expenses,
			  percentFinAid, numApplicants, percentAdmitted, percentEnrolled, academicScale, socialScale,
				qualOflife);
	  
	  return new School(school, state, location, control, numStudents,percentFemale, satVerbal, satMath, expenses,
			  percentFinAid, numApplicants, percentAdmitted, percentEnrolled, academicScale, socialScale,
				qualOflife);
  }
  //ants, double percentAdmitted, double percentEnrolled, int academicsScale, int socialScale, int qualityOfLifeScale)
    public void removeSchool(String name){
    	dummydatabase.university_deleteUniversity(name);
    }
}

