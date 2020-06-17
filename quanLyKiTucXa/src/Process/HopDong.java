/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;
import DataBase.Connect;
import java.sql.*;
/**
 *
 * @author hieuuu
 */
public class HopDong {
     public Connect cn= new Connect();
     public ResultSet ShowDanhSachHopDong() throws SQLException{
        cn.ConnectSQL();
        String sql= "SELECT * FROM hopdong";
        return cn.LoadData(sql);
    }
    public ResultSet ShowHopDongTheoMaSV(String maSV) throws SQLException{
        cn.ConnectSQL();
        String sql="SELECT * FROM hopdong WHERE MaSV='"+maSV+"'";
        return cn.LoadData(sql);
    }
    public ResultSet ShowHopDongTheoMaHD(String maHD) throws SQLException{
        cn.ConnectSQL();
        String sql="SELECT * FROM hopdong WHERE MaHD='"+maHD+"'";
        return cn.LoadData(sql);
    }
    
}
