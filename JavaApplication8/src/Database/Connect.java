/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hieuuu
 */
public class Connect {
    public Connection conn=null;
    public void connectSQL() throws SQLException {
        try{
            String userName="root";
            String passWord="";
            String url="jdbc:mysql://localhost:3306/ql_sanpham";
            
            Class.forName("com.mysql.jdbc.Driver");
            conn= (Connection) DriverManager.getConnection(url,userName,passWord);
            
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Kết nối thất bại","Thông báo",JOptionPane.ERROR_MESSAGE);
        }  
    }
    public ResultSet LoadData(String sql){
        ResultSet rs=null;
        try{
            Statement st= (Statement) conn.createStatement();
            return st.executeQuery(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;  
    }
    public void UpdateData(String sql){
        try{
            Statement st= (Statement) conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
