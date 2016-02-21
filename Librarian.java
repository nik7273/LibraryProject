public class Librarian{
	public Librarian(){
	}
	public void enterBook(Library library, String isbn, String name, String author, String category, String status){
		library.addBook(new Book(isbn, name, author, category, status))
	}
	public void removeBook(Library library, String name){
		library.removeBook(name);
	}
	public void checkBorrowingHistory(){
		//plan for checking borrow history
		//separate books by having a borrowedCounter
		//loop through number of lines for each borrowedCounter for each book
		//then print the first line through as many times as the borrowed counter reaches
	}
}