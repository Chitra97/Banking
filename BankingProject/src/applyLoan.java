import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/applyLoan")

public class applyLoan extends HttpServlet

{
	
	public void service(HttpServletRequest request ,HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		String accountno=(String)session.getAttribute("accountno");
		Model m=new Model();
		m.setAccountno(accountno);
		boolean applyLoan=m.ApplyLoan();
	System.out.println(applyLoan);
		if(applyLoan==true)
		{
			String email=m.getEmail();
			session.setAttribute("email", email);
			try {
				response.sendRedirect("applyLoansuccess.jsp");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		else
		{
			try {
				response.sendRedirect("applyLoanfailure.jsp");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}

}
