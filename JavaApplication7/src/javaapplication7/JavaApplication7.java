/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hieuuu
 */
public class JavaApplication7 {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        Connection conn= null;
        Statement stmt= null;
        
        try{
            Class.forName(hienThi.JDBC_DRIVER);
            
            conn= (Connection) DriverManager.getConnection(hienThi.DB_URL, hienThi.USER, hienThi.PASS);
            
            stmt= (Statement) conn.createStatement();
            String sql;
            String nameTable="khachhang";
            sql="select * from "+nameTable;
            ResultSet rs= stmt.executeQuery(sql);
            
            while(rs.next()){
                int maKH= rs.getInt("MaKH");
                String hoTen= rs.getString("TenKH");
                int tuoi=rs.getInt("Tuoi");
                System.out.println("Ma: "+maKH);
                System.out.println("Ten: "+hoTen);
                System.out.println("Tuoi: "+tuoi);
                System.out.println("");
            }
            rs.close();
            stmt.close();
            conn.close();
            
        }
        catch (SQLException se){
            se.printStackTrace();
        }
        catch(Exception e){
        e.printStackTrace();
    }
    }
    
}
