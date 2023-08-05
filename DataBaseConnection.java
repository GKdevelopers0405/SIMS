import java.sql.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pavan kumar
 */
public class DataBaseConnection {
    static Connection con;

    /**
     *
     * @return
     * @throws ClassNotFoundException
     */
    public Connection getCon() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mainproject","root","21AJ1A0535");
        }catch(SQLException ex){
            
        }
        return con;
    }
}
