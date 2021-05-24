import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class Model {
	String url="jdbc:mysql://localhost:3306/lms";
	String user="root";
	String passwrd="admin@123";
	PreparedStatement pstmt;
	Connection con;
	String name;
	String accountno;
	int balance;
	ResultSet rs;
String custid;
String password;
String email;


	
	public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
	public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAccountno() {
	return accountno;
}
public void setAccountno(String accountno) {
	this.accountno = accountno;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

	public String getCustid() {
	return custid;
}
public void setCustid(String custid) {
	this.custid = custid;
}
	public Model() 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
				 con=DriverManager.getConnection(url, user, passwrd);
			} catch (SQLException e) {
				
				e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	public boolean Result()
	{
		System.out.println("inside result");
		String sql="select * from lms.banking where custid=? and password=?";
		try {
			 pstmt=con.prepareStatement(sql);
			 pstmt.setString(1, custid);
			 pstmt.setString(2, password);
			 rs= pstmt.executeQuery();
			 while(rs.next()==true)
			 {
				 System.out.println(custid);
				 System.out.println(password);
				 name=rs.getString(1);
				 accountno=rs.getString(2);
				 balance=rs.getInt(3);
				 return true;
			 }
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkBalance()
	{
		String sql="select * from lms.banking where accountno=?";
		
		System.out.println(accountno);
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, accountno);
			rs=pstmt.executeQuery();
			System.out.println(sql);
			while(rs.next()==true)
			{
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean changePassword()
	{
		String sql="update lms.banking set password=? where accountno=?";
		try {
			System.out.println(password);
			System.out.println(accountno);
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, accountno);
			int x=pstmt.executeUpdate();
			System.out.println("inside changePassword");
			System.out.println(x);
			if(x==1)
			{
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
public boolean transferAmount(String tamt,String acc)


{
	String sql="update lms.banking set balance=balance-? where accountno=?";
	
System.out.println(tamt);
	try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,tamt);
		pstmt.setString(2, accountno);
		int x=pstmt.executeUpdate();
		System.out.println(sql);
		
		if(x==1)
		{
			String s="insert into lms.statement values(?,?)";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1, accountno);
			pstmt.setString(2, tamt);
			pstmt.executeUpdate();
			
		
			String s1="update lms.banking set balance=balance+? where accountno=?";
			pstmt=con.prepareStatement(s1);
			pstmt.setString(1,tamt);
			pstmt.setString(2, acc);
			pstmt.executeUpdate();
			
			return true;
	
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return false;
}
public ArrayList transferAmount()
{
	ArrayList al=new ArrayList();
	System.out.println(accountno);
	String sql="select * from lms.statement where accountno=?";
	try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, accountno);
		rs=pstmt.executeQuery();
		while(rs.next()==true)
		{
			al.add(rs.getInt(2));
			
		}
		return al;
		
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	return null;
	
}

public boolean ApplyLoan()
{
	String sql="select * from lms.banking where accountno=?";
	try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, accountno);
		rs=pstmt.executeQuery();
		while(rs.next()==true)
		{
			email=rs.getString(6);
			
			return true;
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return false;
}

public boolean changeForgotPassword()
{
	String sql="update lms.banking set password=? where email=?";
	try {
		
		System.out.println(email);
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, password);
		pstmt.setString(2, email);
		int x=pstmt.executeUpdate();
		System.out.println("inside changeForgotPassword");
		System.out.println(x);
		if(x==1)
		{
			return true;
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return false;
}
}

