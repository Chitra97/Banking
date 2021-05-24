import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CheckBalance")
public class CheckBalance extends HttpServlet{
	
	public void service(HttpServletRequest request ,HttpServletResponse response)
	{
		System.out.println("inside check");
	HttpSession	session=request.getSession();
	String accno=(String)session.getAttribute("accountno");
	Model m=new Model();
			m.setAccountno(accno);
			boolean bal=m.checkBalance();
			if(bal==true)
			{
				try {
					response.sendRedirect("balanceSuccess.jsp");
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			else
			{
				try {
					response.sendRedirect("balancefaliue.jsp");
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
	}

}
