package vn.iotstar.service.impl;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import vn.iotstar.entity.Book;
import vn.iotstar.service.IBookService;

@Transactional
public class BookServiceImpl implements IBookService {

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
    public void insert(Book book) {
        entityManager.persist(book);
    }

    @Override
    public void update(Book book) {
        Book existingBook = entityManager.find(Book.class, book.getBookid());
        if (existingBook != null) {
            entityManager.merge(book);
        }
    }

    @Override
    public List<Book> findName(String keyword) {
        return entityManager.createQuery("SELECT b FROM Books b WHERE b.name LIKE :name", Book.class)
                .setParameter("name", "%" + keyword + "%").getResultList();
    }

    @Override
    public void delete(int id) {
        Book book = entityManager.find(Book.class, id);
        if (book != null) {
            entityManager.remove(book);
        }
    }

    @Override
    public List<Book> findAllWithDetail() {
        return entityManager.createQuery("SELECT b FROM Books b LEFT JOIN FETCH b.details", Book.class).getResultList();
    }

    @Override
    public Book findBookWithDetail(int bookid) {
        return entityManager.createQuery("SELECT b FROM Books b LEFT JOIN FETCH b.details WHERE b.bookid = :bookid", Book.class)
                .setParameter("bookid", bookid).getSingleResult();
    }

    @Override
    public List<String> bookReview(int bookid) {
        return entityManager.createQuery("SELECT r.comment FROM Review r WHERE r.book.bookid = :bookid", String.class)
                .setParameter("bookid", bookid).getResultList();
    }
}
