<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册信息</title>
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
   <form name='form1' method="post" action="regServlet" >
   <table width="450" border="1" bgcolor="white" align="center">
     <tr>
     <th colspan="2" bgcolor="#999999"><div >请输入注册信息</div></th>
     </tr>
    
    <tr>
    <td>用户名</td>
    <td><input type="text" name="username" ></td>
    </tr>
    
     <tr>
    <td>密码</td>
    <td><input type="password" name="password" ></td>
    </tr>
    
    <tr>
    <td>性别</td><td>
    <input type="radio" name="sex" value="man" checked="checked">男
     <input type="radio" name="sex" value="woman" >女
     </td>
    </tr>
    
     <tr>
    <td>出生日期</td>
    <td><input type="text" name="birthday" ></td>
    </tr>
    
    <tr>
    <td>专业</td>
   <td><select name="zy">
   <option>计算机科学与技术</option>
   <option selected="selected">软件工程</option>
   <option>网络工程</option>
   </select></td>
   </tr>
   
      <tr>
    <td>兴趣爱好</td>
   <td><select name="ah" multiple="multiple">
   <option>打游戏</option>
   <option selected="selected">看书</option>
   <option>睡觉</option>
   </select></td>
   </tr>
   
   <tr>
   <td>证书</td>
   <td><input name="zs" type="checkbox" value="cet4">cet4
       <input name="zs" type="checkbox" value="cet6">cet6
       <input name="zs" type="checkbox" value="jsj2">计算机二级
       <input name="zs" type="checkbox" value="jsj4">计算机四级</td>
   </tr>
   
    <td colspan="2" align="center"></td>
       
  <tr>
  <td colspan="2" align="center"><input type='submit' name='queren' value="确认" onclick="return check(this.form)"> 
  <input type='reset' name='chongzhi' value="重置"> </td>
  </tr>
    
    </table>
    </form>
    
<script type="text/javascript">
         function check(form) {

          if(form.username.value=='') {
                alert("请输入用户帐号!");
                form.username.focus();
                return false;
           }
       if(form.password.value==''){
                alert("请输入密码!");
                form.password.focus();
                return false;
         }
         return true;
         }
</script>
  </body>
</html>
