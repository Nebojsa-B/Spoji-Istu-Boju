package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    private static Connection con = null;
    
    public DB() throws ClassNotFoundException, SQLException
    {
        if (DB.con == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DB.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projektni_zadatak?useSSL=false", "root", "password");
        }
    }
    
    public void execute(String sql) throws SQLException {
        Statement stmt = DB.con.createStatement();
        stmt.execute(sql);
    }
    
    public ResultSet query(String sql) throws SQLException {
        Statement stmt = DB.con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }
    
    public void close() throws SQLException {
        if (DB.con != null)
        {
            DB.con.close();
            DB.con = null;
        }
    }
}
