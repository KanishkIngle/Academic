/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kanishk
 */
import java.sql.*;
public class JavaDB {
    static Connection conn=null;
    public static Connection getConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","1234");            
        }
        catch(Exception e)
                {
                    System.out.println(e);
                }
        return conn;
    }
}
