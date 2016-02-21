//Books.txt: Contains "ISBN ID", "Book Name", "Author", "Category" (i.e., adventure, romance, textbook, etc.), "Status" (i.e., New, Excellent, Good, Bad etc.)

public class Book{
  private String formattedString;
  
  public Book(int isbn, String name, String author, String category, String status){
    formattedString = "" + isbn + ", " + name + ", " + author + ", " + category + ", " + status;  
    //FileHandler.writeFile("Books.txt", formattedString);
    
    if (FileHandler.contains(FileHandler.readFile("Books.txt"), formattedString)){
      System.out.println(name + " is already registered");
    }
    else {
      System.out.println("Adding " + name);
      FileHandler.writeFile("Students.txt", formattedString);
    }
    
  }
  
  public Book(String formattedString){
    this.formattedString = formattedString;
  }
  
  public String toString(){
    return formattedString;
  }
  
  public boolean equals(Book book){
    return toString().equals(book.toString()); 
  }
}