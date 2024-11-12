package vn.iotstar.controllers;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.entity.Book;
import vn.iotstar.entity.Rating;
import vn.iotstar.entity.User;
import vn.iotstar.service.IBookService;
import vn.iotstar.service.impl.BookServiceImpl;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5	)
@WebServlet(urlPatterns = {"/books", "/admin/books", "/book/detail", "/admin/book/detail"})
public class BookController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public IBookService bookService = new BookServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		if (url.contains("books") || url.contains("admin/books")) {
			List<Book> list = bookService.findAllWithDetail();
			req.setAttribute("listbook", list);
			req.getRequestDispatcher("/views/books-list.jsp").forward(req, resp);
		}
		else if (url.contains("detail")) {	
			int id = Integer.parseInt(req.getParameter("id"));
			List <String> list = bookService.bookReview(id);
			req.setAttribute("list", list);
			System.out.print(list);
			Book book = bookService.findBookWithDetail(1);
			req.setAttribute("book", book);
			req.getRequestDispatcher("/views/bookDetail.jsp").forward(req, resp);
		}
		
		
	}
	
}
