import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logout")
public class logout extends HttpServlet{
	
	public void service(HttpServletRequest request ,HttpServletResponse response)
	{
		try {
			HttpSession session=request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

}
