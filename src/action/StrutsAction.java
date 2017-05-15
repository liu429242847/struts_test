package action;


import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import model.DBBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StrutsAction extends ActionSupport implements ServletResponseAware{
	private javax.servlet.http.HttpServletResponse response;
	private String username;
	private String password;
	private String yzminput; 
	private  String code;
	private String message="";
	public String execute() throws Exception {
		 response.setContentType("text/html;charset=UTF-8");
         response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
         PrintWriter out = response.getWriter();
		
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("username",getUsername());
			request.put("password",getPassword());
			request.put("yaminput",getYzminput());
			code=(String)ActionContext.getContext().getSession().get("code");  
		if(yzminput.equals(code))
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
			        	ActionContext.getContext().getSession().put("username",username);
			        	 rs.close();
						 db.close();
			        	return "success";
			        }
			        else
			        {
			     	message="Wrong Password!";
			        // out.print("<script language='javaScript'> alert('Wrong Password!');</script>");
			         rs.close();
					 db.close();
			         return "error";
			        }
			    }
			    else  
			    {
			    	message="Wrong Username!";
			    	//out.print("<script language='javaScript'> alert('Wrong Username!');</script>");
			    	 rs.close();
					 db.close();
			       return  "error";
			    }
			    	       
			 }catch(Exception e){System.out.print("<script language='javaScript'> alert(e);</script>"); }
		}//对应验证码
			 
			else
			   {   
				 message="verification code is wrong!";
				// out.print("<script language='javaScript'> alert('verification code is wrong!');</script>");
			       return "error";
			    }   


		return "error";
			  
		
		}



	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getYzminput() {
		return yzminput;
	}


	public void setYzminput(String yzminput) {
		this.yzminput = yzminput;
	}
	public void setServletResponse(HttpServletResponse response) {
		   this.response = response;
		}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}
}
