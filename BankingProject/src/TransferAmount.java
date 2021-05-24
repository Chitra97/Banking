import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/TransferAmount")
public class TransferAmount extends HttpServlet{
	
	public void service(HttpServletRequest request ,HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		
		String accountno=(String)session.getAttribute("accountno");
		
		String tamt=request.getParameter("tamt");
		Model m=new Model();
		String acc=request.getParameter("acc");
		
m.setAccountno(accountno);


boolean res=m.transferAmount(tamt,acc);
if(res==true)
{
	try {
		response.sendRedirect("transfersuccess.jsp");
	} catch (IOException e) {
		
		e.printStackTrace();
	}
}
else
{
	try {
		response.sendRedirect("transferfailure.jsp");
	} catch (IOException e) {
		
		e.printStackTrace();
	}
}

				
	}

}
