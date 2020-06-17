/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import database.connect;

/**
 *
 * @author hieuuu
 */
import java.sql.*;
public class GiaoTrinh {
    public connect cnn= new connect();
    public ResultSet ShowGiaoTrinh() throws ClassNotFoundException, SQLException{
        cnn.ConnectSQL();
        String sql="Select * from giaotrinh";
        return cnn.LoadData(sql);
    }
    public ResultSet ShowGiaoTrinhTheoMa(String maGiaoTrinh) throws ClassNotFoundException, SQLException{
        cnn.ConnectSQL();
        String sql="Select * from giaotrinh where MaGT='"+maGiaoTrinh+"'";
        return cnn.LoadData(sql);
    }
    public void InSertGiaoTrinh(String maGT, String tenGT, String hoTenTG, String soLuong, String soTrang, String ngayXB, String loai) throws SQLException, ClassNotFoundException{
        cnn.ConnectSQL();
        String sql="INSERT INTO `giaotrinh` (`MaGT`, `TenGT`, `HoTenTG`, `Soluong`, `Sotrang`, `NgayXB`, `Loai`) VALUES ('"+maGT+"', '"+tenGT+"', '"+hoTenTG+"', '"+soLuong+"', '"+soTrang+"', '"+ngayXB+"', '"+loai+"')";
        cnn.UpdateData(sql);
    }
}
