
public class Teacher extends Borrower{
	private int id;
	private String name;
	public Teacher(int id, String name){
		this.id = id;
		this.name = name; 
	}
	public void writeTeacherToFile(FileWriter out){
		out.print(id + ",");
		out.print(name + "\n");
	}
	public String checkAvailability(Library library, String bookName){
		for(Book b : library.getBookList()){
			if(b.getName().equals(bookName))
				return b.getAvailability();
		}
	}
	public void browseBooks(Category category){

	}
	public void checkOut(String bookName){

	}
	public void returnBook(String bookName){

	}

}