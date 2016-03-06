public class Librarian{
  
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
      counter++;
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