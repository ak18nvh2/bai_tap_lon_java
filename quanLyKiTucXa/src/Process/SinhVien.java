/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

/**
 *
 * @author hieuuu
 */
import DataBase.Connect;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SinhVien {

    public Connect cn = new Connect();

    public ResultSet ShowSinhVien() throws SQLException {
        cn.ConnectSQL();
        String sql = "SELECT * FROM sinhvien";
        return cn.LoadData(sql);
    }

    public ResultSet ShowSinhVienTheoMaSV(String maSV) throws SQLException {
        cn.ConnectSQL();
        String sql = "SELECT * FROM sinhvien WHERE MaSV='" + maSV + "'";
        return cn.LoadData(sql);
    }
    
    public ResultSet ShowSinhVienTheoSoCMT(String soCMT) throws SQLException {
        cn.ConnectSQL();
        String sql = "SELECT * FROM sinhvien WHERE SoCMND='" + soCMT + "'";
        return cn.LoadData(sql);
    }

    public ResultSet ShowSinhVienTheoTaiKhoan(String taiKhoan) {
        try {
            cn.ConnectSQL();
            String sql = "Select * from sinhvien where TaiKhoan='" + taiKhoan + "'";
            return cn.LoadData(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public ResultSet DemSoLuongSVYeuCauKyHopDong(){
        try {
            cn.ConnectSQL();
            String sql= "SELECT COUNT(*) AS \"Tong\" FROM `sinhvien` WHERE `TrangThaiKyHopDong`='0'";
            return cn.LoadData(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet ShowSinhVienChuaKyHopDong() {
        try {
            cn.ConnectSQL();
            String sql = "Select * from sinhvien where TrangThaiKyHopDong='0'";
            return cn.LoadData(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public ResultSet ShowSinhVienDaKyHopDong(String taiKhoan) {
        try {
            cn.ConnectSQL();
            String sql = "Select * from sinhvien where TrangThaiKyHopDong='1' and TaiKhoan='"+taiKhoan+"'";
            return cn.LoadData(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public ResultSet ShowSinhVienYeuCauGiaHan() {
        try {
            cn.ConnectSQL();
            String sql = "Select * from sinhvien where YeuCauGiaHan>0 and TrangThaiKyHopDong=1";
            return cn.LoadData(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
     public ResultSet DemSinhVienYeuCauGiaHan() {
        try {
            cn.ConnectSQL();
            String sql = "SELECT COUNT(*) AS \"Tong\" FROM `sinhvien` WHERE YeuCauGiaHan>0 and TrangThaiKyHopDong=1";
            return cn.LoadData(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public void InsertData(String maSV, String hoTen, int gioiTinh, String soCMT, String ngaySinh, String queQuan,
            String soDT, String email, String hocLuc, String loaiPhong, String taiKhoan, String matKhau, String hanhKiem, int dangKy, int thongBao,int phongO) {
        try {
            cn.ConnectSQL();

            String sql = "INSERT INTO sinhvien values('" + maSV + "',N'" + hoTen + "','" + gioiTinh + "','" + soCMT + "','" + ngaySinh
                    + "','" + queQuan + "','" + soDT + "','" + email + "','" + hocLuc + "','"+hanhKiem+"', NULL, NULL, '" + loaiPhong + "',NULL, '" + taiKhoan + "','" + matKhau + "','"+dangKy+"','"+thongBao+"','"+phongO+"')";
            cn.UpdateData(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nhập sai mã sinh viên!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void setHoanThanhDangKy(String tenPhong, String maSV){
        try {
            cn.ConnectSQL();
            String sql="UPDATE `sinhvien` SET `TenPhong` = '"+tenPhong+"', `TrangThaiKyHopDong` = '1', `YeuCauGiaHan` = '0' WHERE `sinhvien`.`MaSV` = '"+maSV+"'";
            cn.UpdateData(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void setThongBao( String maSV,int kieu){
        try {
            cn.ConnectSQL();
            String sql="UPDATE `sinhvien` SET `ThongBao` = '"+kieu+"' WHERE `sinhvien`.`MaSV` = '"+maSV+"'";
            cn.UpdateData(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
/*
    public void EditData(String maSV, String hoTen, int gioiTinh, String soCMT, String ngaySinh, String queQuan,
            String soDT, String email, String hocLuc, String loaiPhong, String taiKhoan, String matKhau, String thoiGianBatDau, String thoiGianKetThuc) {
        String sql = "UPDATE `sinhvien` SET `HoTen` =  '"+hoTen+"', `GioiTinh` = '"+gioiTinh+"', `SoCMND` = '"+soCMT+"', `NgaySinh` = '"+ngaySinh+"', `QueQuan` =  '"+queQuan+"', `SoDT` = '"+soDT+"', `Email` = '"+email+"', `HocLuc` = '"+hocLuc+"', `ThoiGianBatDauTuQuan` = '"+thoiG+"', `ThoiGianKetThucTuQuan` = '2020-06-10', `LoaiPhong` = 'CLC', `TenPhong` = '31', `TaiKhoan` = 'user01', `MatKhau` = '11' WHERE `sinhvien`.`MaSV` = '2020202020';
        cn.UpdateData(sql);
    }
*/
}
