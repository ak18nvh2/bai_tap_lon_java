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
    Connect cnn= new Connect();
    public ResultSet ShowDataHopDong() throws SQLException{
        cnn.ConnectSQL();
        String sql="SELECT * FROM `thongtinhopdong`";
        return cnn.LoadData(sql);
    }
    public ResultSet ShowDataTaiKhoan( String taiKhoan) throws SQLException{
        cnn.ConnectSQL();
        String sql="SELECT * FROM `thongtinhopdong` where TaiKhoan='"+taiKhoan+"'";
        return cnn.LoadData(sql);
    }
    public void InsertData( String hoTen, String maSinhVien, String ngaySinh, String gioiTinh, String queQuan, String CMND, String diaChi, String SDT, String loaiPhong, String email, String taiKhoan, String matKhau, String tinhTrang) throws SQLException{
        cnn.ConnectSQL();
        String sql="INSERT INTO `thongtinhopdong` ( `HoTen`, `MaSinhVien`, `NgaySinh`, `GioiTinh`, `QueQuan`, `CMND`, `DiaChi`, `SDT`, `LoaiPhong`, `Email`, `TaiKhoan`, `MatKhau`, `TinhTrang`) VALUES ( '"+hoTen+"', '"+maSinhVien+"', '"+ngaySinh+"', '"+gioiTinh+"', '"+queQuan+"', '"+CMND+"', '"+diaChi+"', '"+SDT+"', '"+loaiPhong+"', '"+email+"', '"+taiKhoan+"', '"+matKhau+"', '"+tinhTrang+"')";
        cnn.UpdateData(sql);
    }
}
