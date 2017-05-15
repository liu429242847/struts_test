package model;
import java.sql.*;




public class DBBean {
     String driverStr = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
     String connStr = "jdbc:sqlserver://localhost:1433; DatabaseName=student";
     String dbusername = "sa";
     String dbpassword = "1234";
     Connection conn = null;
    Statement stmt = null;

    public void DBcon()
    {
        try
        {
            Class.forName(driverStr);
            conn = DriverManager.getConnection(connStr, dbusername, dbpassword);
            stmt = conn.createStatement();
        } 
        catch (Exception ex) {
            System.out.println("数据连接失败！");
        } 
        
    }

    public int executeUpdate(String s) {
        int result = 0;
        System.out.println("--更新语句:"+s+"\n");
        try {
            result = stmt.executeUpdate(s);
        } catch (Exception ex) {
            System.out.println("执行更新错误！");
        }
        return result;
    }
    public boolean execQuery(String s){
    	 boolean bupdate=false;
        try {
            stmt.executeUpdate(s);
            bupdate=true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return bupdate;
    }
    public ResultSet executeQuery(String s) {
        ResultSet rs = null;
        System.out.print("--查询语句:"+s+"\n");
        try {
            rs = stmt.executeQuery(s);
        } catch (Exception ex) {
            System.out.println("ִ执行查询错误！");
        }
        return rs;
    }
    public void close() {
        try {
            stmt.close();
            conn.close();
        } catch (Exception e) {
        }
    }
}