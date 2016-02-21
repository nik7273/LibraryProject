public class Student extends Borrower{
	private String firstName, lastName, officialClass;
	private int osisNumber, gradeLevel;
	private ArrayList<Book> borrowed;
	public Student(String fn, String ln, String class, int osis, int grade){
		firstName = fn;
		lastName = ln;
		officialClass = class;
		osisNumber = osis;
		gradeLevel = grade; 
	}
	public String checkAvailability(Library library, String bookName){
		for(Book b : library.getBookList()){
			if(b.getName().equals(bookName))
				return b.getAvailability();
		}
	}
	public void writeStudentToFile(FileWriter out){
		out.print(osisNumber + ",");
		out.print(lastName + ",");
		out.print(firstName + ",");
		out.print(gradeLevel + ",");
		out.print(officialClass + "\n");
	}
	public void browseBooks(String categoryName){
		for(int j = 0; j < library.getCategoryList.size(); j++){
			if(library.getCategoryList.get(j).getCategoryName().equals(categoryName)){
				for(int i = 0; i < library.getCategoryList().get(j).getBooks().size(); i++){
					System.out.println(category.getBooks().get(i).getName());
				}
			}
		}
	}
	//is there an efficient way to find the correct book without looping through all of them? 
	public void checkOut(String bookName, Category category){
		for(int i = 0; i < category.getBooks.size(); i++){
			Book current = category.getBooks().get(i);
			if(current.getName().equals(bookName) && current.getAvailability().equals("Available")){
				current.setAvailability();
				current.incrementBorrowedCounter();
				borrowed.add(current);
				System.out.println("Checked Out: " + current.getName());
			}
		}
	}
	public void returnBook(String bookName, Category category){

	}
}