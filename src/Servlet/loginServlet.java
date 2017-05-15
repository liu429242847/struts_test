package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import model.DBBean;
import javax.swing.*;



public class loginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		
	
		 response.setCharacterEncoding("UTF-8");
		   request.setCharacterEncoding("UTF-8");
		    String username=(String)request.getParameter("username");
		    String password=(String)request.getParameter("password");//取出login.jsp的值
		    String input=request.getParameter("yzminput");   
		  
		    String code= (String)request.getSession().getAttribute("code");  
		    		//(String)session.getAttribute("code");    
		    PrintWriter out = response.getWriter();
		if(input.equals(code))
		 {   
		    String sql="select * from student where username="+"'"+username+"'";//定义一个查询语句
		    DBBean db=new DBBean();
		    db.DBcon();
		    ResultSet rs=db.executeQuery(sql);
		 try{
		   if(rs.next())
		    {
		        if(password.equals(rs.getObject("password")))
		        {
		            request.getSession().setAttribute("username", username);
		            response.sendRedirect("loginsuccess.jsp");
		        }
		        else
		        {
		     	
		         out.print("<script language='javaScript'> alert('Wrong Password!');</script>");
		          response.setHeader("refresh", "0;url=login.jsp");
		        }
		    }
		    else  
		    {
		    	out.print("<script language='javaScript'> alert('Wrong Username!');</script>");
		        response.setHeader("refresh", "0;url=login.jsp");
		    }
		    	        rs.close();
						db.close();
		 }catch(Exception e){System.out.print("<script language='javaScript'> alert(e);</script>"); }
		 }//对应验证码
		  else
		   {   
			  out.print("<script language='javaScript'> alert('verification code is wrong!');</script>");
		        response.setHeader("refresh", "0;url=login.jsp"); 
		    }   



		  
		  
	   

		
	}
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		doPost(req,res);
		
	}
	
	

}
