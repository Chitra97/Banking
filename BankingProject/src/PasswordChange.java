import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PasswordChange")

public class PasswordChange extends HttpServlet{
	
	public void service(HttpServletRequest request ,HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		
//		String email="chitranr97@gmail.com";
		String npwd=request.getParameter("np");
	String email=(String)session.getAttribute("email");
		
		System.out.println(email);
		Model m=new Model();
		m.setEmail(email);
		m.setPassword(npwd);
		boolean res=m.changeForgotPassword();
		if(res==true)
		{
			try {
				response.sendRedirect("changePasswordSucces.jsp");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		else
		{
			
			try {
				response.sendRedirect("changePasswordFailure.jsp");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
			
	}

}
