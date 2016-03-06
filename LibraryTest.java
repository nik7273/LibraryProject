import java.util.Scanner;

public class LibraryTest{
  public static void main(String[] args){
    System.out.println("Are you a librarian[1] or a borrower[2]?");
    Scanner ab = new Scanner(System.in);
    int response = ab.nextInt();
    if (response == 1){
      Librarian librarian = new Librarian();
      System.out.println("Do you want to add[1]/remove[2] a book or get the borrowing history[3]?");
      response = ab.nextInt();
      System.out.println("Enter the book info in the following manner: ISBN ID, Book Name, Author, Category (i.e., adventure, romance, textbook, etc.), Status (i.e., New, Excellent, Good, Bad etc.)");
      ab.nextLine();
      String bookInfo = ab.nextLine();
      int isbnn = Integer.parseInt(FileHandler.readLine(bookInfo, 1));
      String bookNombre = FileHandler.readLine(bookInfo, 2);
      String authorr = FileHandler.readLine(bookInfo, 3);
      String categoryy = FileHandler.readLine(bookInfo, 4);
      String statuss = FileHandler.readLine(bookInfo, 5);
      Book book = new Book(isbnn, bookNombre, authorr, categoryy, statuss);
      if (response == 1){
        librarian.addBook(book);
      }
      else if (response == 2){
        librarian.removeBook(book);
      }
      else if (response == 3){
        librarian.getBorrowingHistory(bookNombre);   //went to student?? printed "hello is already registered" wtf u mean
      }
      else
        System.out.println("Invalid input");
    }
    else if (response == 2){
      Borrower borrower;
      do{
      System.out.println("Are you a student[1] or a teacher[2]?");
      response = ab.nextInt();
      //if the borrower is a student
      if (response == 1){
         System.out.println("Enter the student info in the following manner: OSIS, last name, first name, grade, official class");
         ab.nextLine();
         String studentInfo = ab.nextLine();
         System.out.println(FileHandler.readLine(studentInfo, 1));
         System.out.println(FileHandler.readLine(studentInfo, 2));
         int osisnum = Integer.parseInt(FileHandler.readLine(studentInfo, 1));
         String lastNombre = FileHandler.readLine(studentInfo, 2);
         String firstNombre = FileHandler.readLine(studentInfo, 3);
         int grado = Integer.parseInt(FileHandler.readLine(studentInfo, 4));
         String officialC = FileHandler.readLine(studentInfo, 5);
         borrower = new Student(osisnum, lastNombre, firstNombre, grado, officialC);
         
      }
      //if the borrower is a teacher
      else if (response == 2){
        System.out.println("Enter your teacher info in the following manner: ID, name");
        ab.nextLine();
        String teacherInfo = ab.nextLine();
        int id = Integer.parseInt(FileHandler.readLine(teacherInfo, 1));
        System.out.println(id);
        String tName = FileHandler.readLine(teacherInfo, 2);    
        //String tName = teacherInfo.split(",")[1];    //ArrayIndexOutOfBoundsException: 1 ????
        System.out.println(tName);
        borrower = new Teacher(id, tName);
      }
      else{
        System.out.println("Seriously just enter 1 or 2");
        borrower = new Teacher(123, "name");    //should never really be used b/c of do while loop
      }
      } while ((response != 1) && (response != 2));
      System.out.println("Do you want to browse categories[1], search with key words[2], check the availability of a book[3], checkout a book[4] or return[5]?");
         response = ab.nextInt();
         if (response == 1){
           System.out.println("Enter your category: ");
           ab.nextLine();
           String category = ab.nextLine();
           borrower.browseCategory(category);
         }
         else if (response == 2){
           System.out.println("Enter your keyword: ");
           ab.nextLine();
           String keyword = ab.nextLine();
           borrower.keySearch(keyword);
         }
         else if (response == 3 || response == 4){
           System.out.println("Enter the book name or the ISBN number:");
           ab.nextLine();
           String bookname = ab.nextLine();
           if (response == 3)
             borrower.isBookAvailable(bookname);
           else
             borrower.checkOutBook(bookname);
         }
         else if (response == 5){
           System.out.println("Enter the book info in the following manner: ISBN ID, Book Name, Author, Category (i.e., adventure, romance, textbook, etc.), Status (i.e., New, Excellent, Good, Bad etc.)");
           ab.nextLine();
           String bookInfo = ab.nextLine();
           int isbnn = Integer.parseInt(FileHandler.readLine(bookInfo, 1));
           String bookNombre = FileHandler.readLine(bookInfo, 2);
           String authorr = FileHandler.readLine(bookInfo, 3);
           String categoryy = FileHandler.readLine(bookInfo, 4);
           String statuss = FileHandler.readLine(bookInfo, 5);
           Book book = new Book(isbnn, bookNombre, authorr, categoryy, statuss);
           borrower.returnBook(book);
         }
         else
           System.out.println("Invalid input");
    }
    else
      System.out.println("Invalid input");
  }
}