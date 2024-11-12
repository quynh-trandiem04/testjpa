package vn.iotstar.entity;

import java.io.Serializable;
import java.util.Objects;

public class BookAuthorId implements Serializable {
    private int book;
    private int author;

   

    public int getBook() {
		return book;
	}

	public void setBook(int book) {
		this.book = book;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookAuthorId other = (BookAuthorId) obj;
		return author == other.author && book == other.book;
	}

    @Override
	public int hashCode() {
		return Objects.hash(author, book);
	}
}
