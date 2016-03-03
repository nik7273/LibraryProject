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
      String bookInfo = ab.nextLine();
      /*String isbnn = bookInfo.split(",")[0].trim();
      String bookNombre = bookInfo.split(",")[1].trim();
      String authorr = bookInfo.split(",")[2].trim();
      String categoryy = bookInfo.split(",")[3].trim();
      String statuss = bookInfo.split(",")[4].trim();*/
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
    else if (response == 1){
      System.out.println("Are you a teacher[1] or a student[2]?");
      response = ab.nextInt();
      //if the borrower is a teacher
      if (response == 1){
         System.out.println("Enter the student info in the following manner: OSIS, last name, first name, grade, official class");
         String studentInfo = ab.nextLine();
         int osisnum = Integer.parseInt(FileHandler.readLine(studentInfo, 1));
         String lastNombre = FileHandler.readLine(studentInfo, 2);
         String firstNombre = FileHandler.readLine(studentInfo, 3);
         int grado = Integer.parseInt(FileHandler.readLine(studentInfo, 4));
         String officialC = FileHandler.readLine(studentInfo, 5);
         Student student = new Student(osisnum, lastNombre, firstNombre, grado, officialC);
         System.out.println("Do you want to browse categories[1], search with key words[2], check the availability of a book[3], checkout a book[4] or return[5]?");
         response = ab.nextInt();
         if (response == 1){
         }
         else if (response == 2){
         }
      }
      //if the borrower is a student
      else if (response == 2){
        System.out.println("Enter your teacher info in the following manner: ID, name");
        String teacherInfo = ab.nextLine();
        int id = Integer.parseInt(FileHandler.readLine(teacherInfo, 1));
        String tName = FileHandler.readLine(teacherInfo, 2);
        Teacher teacher = new Teacher(id, tName);
      }
      else
        System.out.println("Seriously just enter 1 or 2");
    }
    else
      System.out.println("Invalid input");
  }
}