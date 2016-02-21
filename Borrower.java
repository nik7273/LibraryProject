public abstract class Borrower {
	public abstract String checkAvailability(String bookName);
	public abstract void browseBooks(Category category);
	public abstract void checkOut(String bookName);
	public abstract void returnBook(String bookName);
}
