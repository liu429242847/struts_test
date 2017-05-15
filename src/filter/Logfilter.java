package filter;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.PrintWriter;

public class Logfilter implements Filter {  
    FilterConfig config;  
   
    public void destroy() {  
        this.config = null;  
    }  
    
    public void doFilter(ServletRequest req, ServletResponse res,  
            FilterChain chain) throws IOException, ServletException {  
    	
    	
        // 获取ServletContext 对象，用于记录日志  
        ServletContext context = this.config.getServletContext();  
      
        System.out.println("before the log filter!");  
         
        // 将请求转换成HttpServletRequest 请求  
        HttpServletRequest hreq = (HttpServletRequest) req;  
        HttpServletResponse hres = (HttpServletResponse) res;
        hres.setCharacterEncoding("UTF-8");
		hreq.setCharacterEncoding("UTF-8");
		
        // 记录日志 
        String url = hreq.getServletPath();
        System.out.println("Log Filter已经截获到用户的请求的地址:"+hreq.getServletPath()); 
        PrintWriter out = res.getWriter();
        
        
        
       
   try {  
      if("/login.jsp".equals(url)||"/index.jsp".equals(url)||"/".equals(url))
      {
             	//放行
          System.out.println("已放行");
          chain.doFilter(req, res); 
            // Filter 只是链式处理，请求依然转发到目的地址。  
        	//hres.sendRedirect ("login.jsp");
      }
      else
      {//不是登录请求
    	 String islogin= (String)hreq.getSession().getAttribute("username");
      
        //拿到session，判断session中有没有保存的登录信息
         System.out.println("不放行");
        if(islogin!=null && islogin.length()>0)
        {
        	 chain.doFilter(req, res);//session中有保存的用户信息，证明已登录，放行	

        }
        else
        { 
    	//否则就是没登录，不予放行
    	//  hreq.setAttribute("message", "请先登录");
    //	  hreq.getRequestDispatcher("/userlogin.jsp").forward(req, res);   
         // out.print("<script language='javaScript'> alert('请登录!');</script>");
        	  System.out.println("piease login!");  
    	  hres.sendRedirect("login.jsp");
        }
     }
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        System.out.println("after the log filter!");  
        //long after = System.currentTimeMillis();  
        // 记录日志  
        //context.log("过滤结束");  
        // 再次记录日志  
        //context.log(" 请求被定位到" + ((HttpServletRequest) req).getRequestURI()  
        //      + "所花的时间为: " + (after - before));  
    }  
   
    public void init(FilterConfig config) throws ServletException {  
        System.out.println("begin do the log filter!");  
        this.config = config;  
    }  
   
 }  