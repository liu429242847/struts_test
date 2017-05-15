<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String islogin = (String)session.getAttribute("username");
%>


<script  type="text/javascript">
var msg ="${message}";
if(msg !=""){
alert(msg);}
</script>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
  
<title>登录界面</title>
</head>
<body>
 <%if(islogin!=null && islogin.length()>0){ %>
  <%=islogin %>用户已经登录成功！<a href="quit.jsp">退出</a>
  <%}else{ %>
    <center>
        <h1 style="color:red">登录</h1>
        
            <form name="loginForm" action="struts.action" method="post">
                <table  border="0">
                    <tr>
                        <td >账号：</td>
                        <td><input type="text" name="username"></td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td><input type="password" name="password">
                        </td>
                    </tr>
                    <tr>
                        <td>验证码:</td><td><input type=text name=yzminput maxlength=4>      </td>
                        <td><img border=0 src="verServlet">  
                        </td>
                    </tr>
                </table>
            <br>
            
             <input type="submit" value="登录" style="color:#BC8F8F">
            </form>
  
     <!-- 注册-->    
            <form action="index.jsp">
                <input type="submit" value="注册" style="color:#BC8F8F">
            </form>
    </center>
    <%} %>
</body>
</html>
