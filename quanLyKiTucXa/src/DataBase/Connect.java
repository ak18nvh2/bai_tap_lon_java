/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author hieuuu
 */
public class Connect {
    Connection cnn= null;
    public void ConnectSQL() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ql_ktx", "root", "");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Kết nối thất bạn!", "Thông báo", JOptionPane.ERROR_MESSAGE);        }
    }
    public ResultSet LoadData(String sql){
        try{
            Statement st=cnn.createStatement();
           return st.executeQuery(sql);
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public void UpdateData(String sql){
        try{
            Statement st= cnn.createStatement();
            st.executeUpdate(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
