import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/forgotPassword")

public class forgotPassword extends HttpServlet  {
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	{
	try {
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		
		HttpSession session=request.getSession(true);
		session.setAttribute("email", email);
		
	    forgotPassword.sendEmail(email);
	    out.print("Email sent successfully");
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	}

public  static void sendEmail(String email)
{
	
	
Properties pro=new Properties();
pro.put("mail.smtp.host", "smtp.gmail.com");
pro.put("mail.smtp.port", "587");
pro.put("mail.smtp.auth", "true");
pro.put("mail.smtp.starttls.enable","true");

Session session=Session.getDefaultInstance(pro, new javax.mail.Authenticator()
		{
		protected PasswordAuthentication getPasswordAuthentication()
		{
	return new PasswordAuthentication(email,"L0gin@1234s");
	
		}
});
MimeMessage message=new MimeMessage(session);
try {
	String htmlcode="<a href='http://localhost:8062/BankingProject/forgotPasswordSuccess.jsp'>click here to change password</a>";
	
	message.setFrom(new InternetAddress(email));
	message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
	message.setSubject("hi welcome");
	message.setText("welcome to mail");
	message.setContent(htmlcode, "text/html");
	
	Multipart emailContent= new MimeMultipart();
	
	
	Transport.send(message);
	
	
	
} catch (AddressException e) {
	
	e.printStackTrace();
} catch (MessagingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}

