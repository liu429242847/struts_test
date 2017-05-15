<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="model.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String islogin = (String)session.getAttribute("username");
%>
<jsp:useBean id="counter"  scope="application"  class="model.Counter"   />
 
 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>loginsuccess</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%if(islogin!=null && islogin.length()>0){ %>
  <%=islogin %>已登录<a href="quit.jsp">退出</a> <br>
  <%}else{ %>
        response.sendRedirect("login.jsp");
      <%} %>
      
     您是第
<jsp:getProperty name="counter" property="count"/>位访问者
      
  </body>
</html>
