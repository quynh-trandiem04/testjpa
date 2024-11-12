package vn.iotstar.entity;

import java.io.Serializable;
import java.util.Objects;

public class RatingId implements Serializable {
    private int user;
    private int book;

    

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RatingId other = (RatingId) obj;
		return book == other.book && user == other.user;
	}

    public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getBook() {
		return book;
	}

	public void setBook(int book) {
		this.book = book;
	}

	@Override
	public int hashCode() {
		return Objects.hash(book, user);
	}
}
