import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Server")

public class Server extends HttpServlet{

	public void service(HttpServletRequest request ,HttpServletResponse response)
	{
		System.out.println("inside login");
		String custId=request.getParameter("custid");
		String pwd=request.getParameter("pwd");
		Model m=new Model();
		m.setCustid(custId);
		m.setPassword(pwd);
		boolean login=m.Result();
		if(login==true)
		{
			String name=m.getName();
			
			String accountno=m.getAccountno();
	int balance=m.getBalance();
			HttpSession session=request.getSession(true);
			session.setAttribute("name", name);
			session.setAttribute("accountno", accountno);
			session.setAttribute("balance", balance);
			try {
				response.sendRedirect("Success.jsp");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
		}
		else
		{
			try {
				response.sendRedirect("failure.jsp");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}
}
