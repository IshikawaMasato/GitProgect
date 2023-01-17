package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.kadai1601dao;
import dto.kadai1601dto;
import util.GenerateHashedPw;

/**
 * Servlet implementation class kadai1701LoginServlet
 */
@WebServlet("/kadai1701LoginServlet")
public class kadai1701LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public kadai1701LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("UTF-8");
		
		String mail = request.getParameter("mail");
		String pw = request.getParameter("pw");
		
		String salt = kadai1601dao.getSalt(mail);
		
		if(salt == null) {
			String view = "WEB-INF/view/kadai1701-login.jsp?error=1";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			return;
		}
		String hashedPw = GenerateHashedPw.getSafetyPassword(pw, salt);
		
		kadai1601dto account = kadai1601dao.login(mail, hashedPw);
		
		if(account == null) {
			String view = "WEB-INF/view/kadai1701-login.jsp?error=1";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		} else {
			String view = "WEB-INF/view/sample-menu.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
