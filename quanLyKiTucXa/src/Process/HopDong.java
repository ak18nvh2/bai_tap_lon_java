/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;
import DataBase.Connect;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public ResultSet DemSoLuongHopDong(){
        try {
            cn.ConnectSQL();
            String sql= "SELECT COUNT(*) AS \"Tong\" FROM `hopdong`";
            return cn.LoadData(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
