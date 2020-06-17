/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author hieuuu
 */
import java.sql.*;
public class connect {
    public Connection cnn= null;
    public void ConnectSQL() throws ClassNotFoundException, SQLException{
        String url="jdbc:mysql://localhost:3306/qlgiaotrinh";
        String user="root";
        String pass="";
        Class.forName("com.mysql.jdbc.Driver");
        cnn= DriverManager.getConnection(url,user,pass);
    }
    public ResultSet LoadData(String sql) throws SQLException{
        Statement st= cnn.createStatement();
        return   st.executeQuery(sql);
    }
    public void UpdateData(String sql) throws SQLException{
        Statement st= cnn.createStatement();
        st.executeUpdate(sql);
    }
}
