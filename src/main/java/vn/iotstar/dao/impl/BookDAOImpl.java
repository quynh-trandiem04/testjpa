package vn.iotstar.dao.impl;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import vn.iotstar.dao.IBookDAO;
import vn.iotstar.entity.Book;

public class BookDAOImpl implements IBookDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> findAll() {
        return entityManager.createQuery("SELECT b FROM Books b", Book.class).getResultList();
    }

    @Override
    public Book findById(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    @Transactional
    public void insert(Book book) {
        entityManager.persist(book);
    }

    @Override
    @Transactional
    public void update(Book book) {
        Book existingBook = entityManager.find(Book.class, book.getBookid());
        if (existingBook != null) {
            entityManager.merge(book);
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        Book book = entityManager.find(Book.class, id);
        if (book != null) {
            entityManager.remove(book);
        }
    }

    @Override
    public List<Book> findName(String keyword) {
        return entityManager.createQuery("SELECT b FROM Books b WHERE b.title LIKE :keyword", Book.class)
                .setParameter("keyword", "%" + keyword + "%")
                .getResultList();
    }

    @Override
    public List<Book> findAllWithDetail() {
        return entityManager.createQuery("SELECT b FROM Books b LEFT JOIN FETCH b.authors LEFT JOIN FETCH b.reviews", Book.class)
                .getResultList();
    }

    @Override
    public List<String> bookReview(int bookid) {
        return entityManager.createQuery(
                        "SELECT CONCAT('User: ', u.fullname, ', ', u.email, ', Review: ', r.rating, ' -- ', r.reviewText) " +
                        "FROM Review r JOIN r.user u WHERE r.book.bookid = :bookid", String.class)
                .setParameter("bookid", bookid)
                .getResultList();
    }

    @Override
    public Book findBookWithDetail(int bookid) {
        return entityManager.createQuery(
                        "SELECT b FROM Books b LEFT JOIN FETCH b.authors LEFT JOIN FETCH b.reviews WHERE b.bookid = :bookid", Book.class)
                .setParameter("bookid", bookid)
                .getSingleResult();
    }
}
