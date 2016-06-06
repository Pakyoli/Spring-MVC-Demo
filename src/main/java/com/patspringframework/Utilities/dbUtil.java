package com.patspringframework.Utilities;

import java.sql.*;

/**
 * Created by pakyo_000 on 6/6/2016.
 */
public class dbUtil {

    private static Connection conn = null;
    private static final String url = "jdbc:mysql://localhost:3306/mysite";
    private static final String username = "patrick";
    private static final String password = "pat123";

    public static Connection getConn() throws SQLException{

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(url,username,password);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return conn;
    }

    public static void closeConn(){

        try{
            conn.close();
        }catch (SQLException se){
            se.printStackTrace();
        }
    }

    public static void closeStmt(PreparedStatement stmt){

        try{
            stmt.close();
        }catch (SQLException se){
            se.printStackTrace();
        }
    }

    public static void closeRS(ResultSet rs){

        try{
            rs.close();
        }catch (SQLException se){
            se.printStackTrace();
        }
    }
}
