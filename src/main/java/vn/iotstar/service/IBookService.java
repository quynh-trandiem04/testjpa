package vn.iotstar.service;

import java.util.List;
import vn.iotstar.entity.Book;

public interface IBookService {
    List<Book> findAll();
    Book findById(int id);
    void insert(Book book);
    void update(Book book);
    void delete(int id);
    List<Book> findName(String keyword);
    List<Book> findAllWithDetail();
    List<String> bookReview(int bookid);
    Book findBookWithDetail(int bookid);
}
