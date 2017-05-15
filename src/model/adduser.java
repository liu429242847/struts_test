package model;


import java.sql.*;
import java.lang.*;
import java.util.Date;

import model.user;;

 public class adduser extends DBBean {
	 String username; 
     String password; 
     String sex; 
     String birthday; 
     String zy;
     String ah;
     String zs;
 public void getinfo()
 { 

	 try{
	 user us=new user();
	 username=us.getusername();
	 password=us.getpassword();
	 sex=us.getsex();
	 birthday=us.getbirthday();
	 zy=us.getzy();
	 ah=us.getah();
	 zs=us.getzs();}
	 catch (Exception e) {
         System.out.println(e);
        
     }
	
 }
     
 public boolean addNewUser( ){
 boolean boadduser=false;
 
 try {
//进行用户注册的记录添加操作，生成sql语句 "+zy+"  "+ah+"
 
  String sSql= "insert into student values('"+username+"','"+password+"','"+sex+"','"+birthday+"','null','null','"+zs+"')";
  
//一种调试的方法，可以打印出sql语句，以便于查看错误
  System.out.println(sSql);
//调用父类的executeUpdate方法，并根据成功以否来设置返回值
 
  if(super.execQuery(sSql)) 
	  boadduser=true;
    }
 catch (Exception e) 
 {
//出错处理
  System.out.println("adduser.addNewUser: " + e);
 }
 super.close();	 
 return boadduser;
}

//checkUser()方法用来检查用户名是否重复

//如果重复返回一个false
 public boolean checkUser(){
  boolean boadduser=false;
  
  try {
//构建sql查询语句
   String sql="select * from student where username='"+username+"'";
//调用父类的executeQuery方法
  
   ResultSet rs=super.executeQuery(sql);
   if(rs!=null){
//查询出来的记录集为空
   boadduser=false;
   }else{
    boadduser=true;
   }
  }
  catch(Exception ex) {
//出错处理
   System.err.println("adduser.addNewUser: " + ex.getMessage());
  }
  super.close();
  return boadduser;
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

public String getSex() {
	return sex;
}

public void setSex(String sex) {
	this.sex = sex;
}

public String getBirthday() {
	return birthday;
}

public void setBirthday(String birthday) {
	this.birthday = birthday;
}

public String getZy() {
	return zy;
}

public void setZy(String zy) {
	this.zy = zy;
}

public String getAh() {
	return ah;
}

public void setAh(String ah) {
	this.ah = ah;
}

public String getZs() {
	return zs;
}

public void setZs(String zs) {
	this.zs = zs;
}


 
}