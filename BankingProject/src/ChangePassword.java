import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ChangePassword")

public class ChangePassword extends HttpServlet{
	
	public void service(HttpServletRequest request ,HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		String accountno=(String)session.getAttribute("accountno");
		//String email=(String)session.getAttribute("email");
		String npwd=request.getParameter("np");
		System.out.println(npwd);
		Model m=new Model();
		m.setAccountno(accountno);
		m.setPassword(npwd);
		//m.setEmail(email);
		boolean res=m.changePassword();
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
		
		//*********forgot password***********//
		
//		boolean change=m.changeForgotPassword();
//		if(change==true)
//		{
//			try {
//				response.sendRedirect("changeSuccess.jsp");
//			} catch (IOException e) {
//				
//				e.printStackTrace();
//			}
//		}
//		else
//		{
//			
//			try {
//				response.sendRedirect("changeFailure.jsp");
//			} catch (IOException e) {
//				
//				e.printStackTrace();
//			}
//		}
//		
//		
		
			
	}
	

}
