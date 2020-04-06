package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.User;
import repository.UserRepositoryImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = UserRepositoryImpl.getLoginUser(email, password);
		if(user!=null) {
			
			response.sendRedirect("user?id="+user.getId());
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("login.html");  
			PrintWriter out= response.getWriter();
			out.println("<p style=\"font-size: 30px; color: #ff0000; margin-left: 42%; margin-top: 5%;\" >Incorrect username or password.</p>");
			rd.include(request, response);
		}
}

}
