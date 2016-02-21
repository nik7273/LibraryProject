//- A borrower can have the options to:
//a. Browse books available in a category by entering the category (Program prints the list of books in that category)
//b. Check the availability of a book by entering the ISBN number or book name (Program print the availability of the selected book)
//c. Check out a book by entering the ISBN number or book name and print a receipt
//d. Return a book and print receipt
//- A Librarian can have the options to:
//a. Enter a new book (program needs to add the book to the Book.txt)
//b. Remove a book (program needs to remove the book from the Book.txt)
//c. Check borrowing history of a book by entering the ISBN or book name
//2) Your program must read three input files in comma delimited .txt format to get information:

import java.util.*;
import java.io.*;


public abstract class Borrower{
  public String name;
  public int booksHeld;
  public int maxBooks;
  public ArrayList<Book> booksPossessed;
  
//  public abstract void browseCategory(String category);
//  
//  public abstract boolean isBookAvailable(String bookName);
//  public abstract boolean isBookAvailable(int isbn);
//  
//  public abstract void checkOutBook(String bookName);
//  public abstract void checkOutBook(int isbn);
//  
//  public abstract void returnBook(Book bookName);
  
  // a. Browse books available in a category by 
  // entering the category (Program prints the list of books in that category)
  public void browseCategory(String category){
    System.out.println("\nBrowsing\nAvailable Books:");    
    String[] books = FileHandler.readFile("Books.txt");    
    for (String book: books){
      if (FileHandler.readLine(book, 4).equals(category)){
        System.out.println("    " + FileHandler.readLine(book, 2));
      }
    }
  }
  
  //b. Check the availability of a book by entering the ISBN number or book name (Program print the availability of the selected book)
  public boolean isBookAvailable(String bookName){
    System.out.println("\nChecking for Available Books");    
    String[] books = FileHandler.readFile("Books.txt");    
    
    for (String book: books){
      if (FileHandler.readLine(book, 1).equals(bookName) || FileHandler.readLine(book, 2).equals(bookName)){
        return true;
      }
    }
    
    return false;
  }
  
  public boolean isBookAvailable(int isbn){
    return isBookAvailable("" + isbn);
  }
  
//c. Check out a book by entering the ISBN number or book name and print a receipt
  public void checkOutBook(String bookName){
    System.out.println("\nChecking out a Book");    
    
    if (!isBookAvailable(bookName))
      return;
    
    Date checkoutDate = new Date();
    
    if (booksHeld < 10/*maxBooks*/){
      String[] books = FileHandler.readFile("Books.txt");    
      
      int counter = 1;
      for (String book: books){
        if (FileHandler.readLine(book, 1).equals(bookName) || FileHandler.readLine(book, 2).equals(bookName)){
          FileHandler.removeLine("Books.txt", counter);
          System.out.println("\tSuccesfuly Checked out " + FileHandler.readLine(book, 2));
          
          
          // Adding the name of the Book if it doesn't exist
          String[] borrowedBooks = FileHandler.readFile("BorrowingHistory.txt");
          if (borrowedBooks.length > 0){
            for (String line: borrowedBooks){
              
              String bookTitle = FileHandler.readLine(line, 1);
              
              if (bookTitle.equals(FileHandler.readLine(book, 2))){
                System.out.println("Book found");
                break;
              }
              else if (bookTitle.equals(FileHandler.readLine(FileHandler.readFile("BorrowingHistory.txt")[FileHandler.linesInFile("BorrowingHistory.txt") - 1], 1))){
                System.out.println("Book added");
                FileHandler.writeFile("BorrowingHistory.txt", FileHandler.readLine(book, 2) + ", ");
                break;
              }
            }
          }
          else {
            System.out.println("Book added");
            FileHandler.writeFile("BorrowingHistory.txt", FileHandler.readLine(book, 2) + ", ");
          }
          
          borrowedBooks = FileHandler.readFile("BorrowingHistory.txt");
          
          int count = 1;
          for(String line: borrowedBooks){
            if (FileHandler.readLine(line, 1).equals(FileHandler.readLine(book, 2))){
              break;
            }
            count++;
          }
          
          FileHandler.appendToLine("BorrowingHistory.txt", name + " on " + checkoutDate.toString() + ", ", count);
          
          booksPossessed.add(new Book(book));
          break;
        }
        counter++;
      }
      booksHeld++;
    }
    else{
      System.out.println("\tYou are already holding too many books");
    }
    
  }
  
  public void checkOutBook(int isbn){
    checkOutBook("" + isbn);
  }
  
  
//d. Return a book and print receipt
  public void returnBook(Book book){

    boolean hasBook = false;
    
    for (Book singleBook: booksPossessed){
      hasBook = (singleBook.equals(book))? true: hasBook;
    }
    
    if (hasBook){
      FileHandler.writeFile("Books.txt", book.toString());
      
      System.out.println("RECEIPT: YOU HAVE RETURNED THE BOOK: " + FileHandler.readLine(book.toString(), 2));
    }
    else{
      System.out.println("You don't have that book");
    }
  }
}