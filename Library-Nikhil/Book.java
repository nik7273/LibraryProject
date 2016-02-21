public class Book{
	private String isbn, name, author, category, status;
	private boolean available = true;
	private int borrowedCounter = 0;
	public Book(String isbn, String name, String author, String category, String status){
		this.isbn = isbn;
		this.name = name; 
		this.author = author;
		this.category = category;
		this.status = status;
	} 
	public void setAvailability(){
		available = !available; 
	}
	public String getAvailability(){
		if(available){
			return "Available";
		}else{
			return "Unavailable";
		}
	}
	public String getName(){
		return name;
	}
	public void incrementBorrowedCounter(){
		borrowedCounter++;
	}
	public void getBorrowedCounter(){
		return borrowedCounter;
	}


}