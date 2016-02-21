public class Category{
	private String categoryName;
	private ArrayList<Book> booksInCategory;
	public Category(String name){
		categoryName = name;
		booksInCategory = new ArrayList<Book>();
	}
	public ArrayList<Book> getBooks(){
		return booksInCategory;
	}
}