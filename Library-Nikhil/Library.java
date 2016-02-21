public class Library {
	private ArrayList<Book> libraryBooks;
	public static void main(String[] args){

	}
	public Library(){}
	public ArrayList<Book> getBookList(){
		return libraryBooks;
	}
	public void addBook(Book book){
		libraryBooks.add(book);
	}
	public void removeBook(String bookName){
		for(int i = 0; i < libraryBooks.size(); i++){
			if(libraryBooks.get(i).getName().equals(bookName)){
				libraryBooks.remove(i);
			}
		}
	}
}