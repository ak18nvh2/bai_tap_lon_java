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
public class Phong {
    public Connect cn= new Connect();
     public ResultSet ShowPhong() throws SQLException{
        cn.ConnectSQL();
        String sql= "SELECT * FROM sinhvien";
        return cn.LoadData(sql);
    }
    public ResultSet ShowPhongTheoSoPhong(String maPhong) throws SQLException{
        cn.ConnectSQL();
        String sql="SELECT * FROM phong WHERE SoPhong='"+maPhong+"'";
        return cn.LoadData(sql);
    }
    public ResultSet ShowPhongConTrongTheoLoaiPhong(String loaiPhong) throws SQLException{
        cn.ConnectSQL();
        String sql="Select * from phong where LoaiPhong='"+loaiPhong+"' and SoNguoiToiDa > SoNguoiHienCo";
        return cn.LoadData(sql);
    }
    public void TangThanhVienTrongPhong(String tenPhong) throws SQLException{
        cn.ConnectSQL();
        String sql="UPDATE `phong` SET `SoNguoiHienCo` = SoNguoiHienCo+1 WHERE `phong`.`TenPhong` = "+tenPhong;
        cn.UpdateData(sql);
    }
    
}
