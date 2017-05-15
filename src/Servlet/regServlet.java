package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import model.*;

import javax.swing.*;



public class regServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		
	
		 response.setCharacterEncoding("UTF-8");
		 request.setCharacterEncoding("UTF-8");
		 String username; 
	     String password; 
	     String sex; 
	     String birthday; 
	     String zy;
	     String ah;
	     String zs;
	  
	   PrintWriter out = response.getWriter();
	   DBBean db=new DBBean();
	  // adduser add=new adduser(); 
	   username=request.getParameter("username"); 
	     password=request.getParameter("password"); 
	     sex=request.getParameter("sex"); 
	     birthday=request.getParameter("birthday"); 
	     zy=request.getParameter("zy"); 
	     ah=request.getParameter("ah");
	     zs=request.getParameter("zs"); 
	   
	  // add.getinfo();
	db.DBcon();
	   try{
	     String qsql="select * from student where username='"+username+"'";
	      ResultSet rs=db.executeQuery(qsql);
	    if(rs.next()==false)
	     {
	        String sql = "insert into student values( '"+username+"', '"+password+"', '"+sex+"','"+birthday+"','null','null','null')";
	     //if(add.addNewUser())
	     if(db.executeUpdate(sql)!=0)
	     {
	     out.print("<script language='javaScript'> alert('registration completed!');</script>");
	     response.setHeader("REFRESH","0;url=login.jsp");
	     }
	}else
	     { 
	     out.print("<script language='javaScript'> alert('Username already exists!');</script>");
	     response.setHeader("REFRESH","0;url=index.jsp");
	      }
	   
				
		} catch (Exception ex) {
					  out.print("<script language='javaScript'> alert(ex);</script>");
	     response.setHeader("REFRESH","0;url=index.jsp");
				}

		
	}
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		doPost(req,res);
		
	}
	
	

}
