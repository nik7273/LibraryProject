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
    booksPossessed = new ArrayList<Book>();
  }
  
  public void checkOutBook(String bookName){

    Date checkoutDate = new Date();
    // 1 week is 6.048 * 10^8 milliseconds
    int weekInMilliseconds = 604800000 * 2;
    Date returnBeforeDate = new Date(checkoutDate.getTime() + weekInMilliseconds);
    
    System.out.println("You must return the book before " + returnBeforeDate.toString());
    super.checkOutBook(bookName);
  }
  
  public void addBook(Book book){
    FileHandler.writeFile("Books.txt", book.toString());
  }
  
  public void removeBook(Book book){
    String[] books = FileHandler.readFile("Books.txt");
    
    int counter = 1;
    for (String singleBook: books){
      if (singleBook.equals(book.toString())){
        FileHandler.removeLine("Books.txt", counter);
        System.out.println("\tSuccesfuly Removed " + FileHandler.readLine(singleBook, 2));
        break;
      }
    }
  }
  
  public String getBorrowingHistory(String bookName){
    String[] borrowingHistory = FileHandler.readFile("BorrowingHistory.txt");
    
    for(String line: borrowingHistory){
      System.out.println(FileHandler.readLine(line, 2));
      if (FileHandler.readLine(line, 2).equals(bookName) || FileHandler.readLine(line, 1).equals(bookName)){
        return line;
      }
    }
    
    return "No History Found";
  }
}




