package vn.iotstar.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book_author")
@IdClass(BookAuthorId.class) 
public class BookAuthor {
    @Id
    @ManyToOne
    @JoinColumn(name = "bookid", referencedColumnName = "bookid")
    private Book book;

    @Id
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    private Author author;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

    
}
