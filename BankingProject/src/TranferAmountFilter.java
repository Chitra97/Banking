

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class TranferAmountFilter
 */
public class TranferAmountFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TranferAmountFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		int tamt=Integer.parseInt(request.getParameter("tamt"));
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session=req.getSession();

		int balance=(int)session.getAttribute("balance");
		
		System.out.println("inside filter");
		if(tamt>0 && balance>tamt)
		{
			
			chain.doFilter(request, response);
			
		}
		else
		{
			((HttpServletResponse)(response)).sendRedirect("statementfailure.jsp");
			
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
