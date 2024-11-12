package vn.iotstar.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rating")
@IdClass(RatingId.class) 
public class Rating {
    @Id
    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "bookid", referencedColumnName = "bookid")
    private Book book;

    @Column
    private byte rating;

    @Column(columnDefinition = "TEXT")
    private String reviewText;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public byte getRating() {
		return rating;
	}

	public void setRating(byte rating) {
		this.rating = rating;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

    
}
