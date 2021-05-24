import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/GetStatement")

public class GetStatement extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		String accountno=(String)session.getAttribute("accountno");
		Model m=new Model();
	
	m.setAccountno(accountno);
	ArrayList statement=m.transferAmount();
	System.out.println(statement);
	session.setAttribute("statement",statement );
	if(statement.isEmpty())
	{
		try {
			response.sendRedirect("statementfailure.jsp");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	else
	{
		try {
			response.sendRedirect("statementsuccess.jsp");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	}
	


}
