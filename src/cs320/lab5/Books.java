package cs320.lab5;

public class Books {

	int id;
	String title;
	String author;
	int copies;

	public Books(int id, String title,String author,int copies){
		
		this.id = id;
		this.title =title ;
		this.author = author;
		this.copies = copies;
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}
}
