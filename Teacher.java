//- Teachers.txt: Contains "ID", "Name"
//- A Librarian can have the options to:
//a. Enter a new book (program needs to add the book to the Book.txt)
//b. Remove a book (program needs to remove the book from the Book.txt)
//c. Check borrowing history of a book by entering the ISBN or book name
import java.*;
import java.util.*;
import java.io.*;

public class Teacher extends Borrower{
  
  public Teacher(int id, String name){
    String formattedString = "" + id + ", " + name;  
    
    if (FileHandler.contains(FileHandler.readFile("Teachers.txt"), formattedString)){
      System.out.println(name + " is already registered");
    }
    else{
      FileHandler.writeFile("Teachers.txt", formattedString);
    }
    
    this.name = name;
    
    maxBooks = 4;
    maxWeeks = 2;
    booksPossessed = new ArrayList<Book>();
  }
  
  
  

}




