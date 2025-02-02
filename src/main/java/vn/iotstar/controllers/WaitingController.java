package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.entity.User;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/waiting")
public class WaitingController extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			User u = (User) session.getAttribute("account");
			req.setAttribute("email", u.getEmail());
			if (u.getIs_admin() == 1) {
				resp.sendRedirect(req.getContextPath() + "/admin/home");				
			}
			else {
				resp.sendRedirect(req.getContextPath() + "/home");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/home");
		}
	}
}