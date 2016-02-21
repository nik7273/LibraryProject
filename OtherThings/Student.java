//Students.txt: Contains "OSIS", "Last Name", "First Name", "Grade", "Official Class"
import java.*;
import java.util.*;
import java.io.*;

public class Student extends Borrower{

  
  public Student(int osis, String lastName, String firstName, int grade, String officialClass){
    String formattedString = "" + osis + ", " + lastName + ", " + firstName + ", " + grade + ", " + officialClass;  
    
    if (FileHandler.contains(FileHandler.readFile("Students.txt"), formattedString)){
      System.out.println(firstName + " " + lastName + " is already registered");
    }
    else {
      FileHandler.writeFile("Students.txt", formattedString);
    
    }
    
    name = firstName + lastName;
    
    maxBooks = 2;
    booksPossessed = new ArrayList<Book>();
  }
}




