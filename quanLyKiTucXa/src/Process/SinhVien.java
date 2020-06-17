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

    public ResultSet ShowSinhVienTheoTaiKhoan(String taiKhoan)  {
        try {
            cn.ConnectSQL();
            String sql = "Select * from sinhvien where TaiKhoan='" + taiKhoan + "'";
            return cn.LoadData(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void InsertData(String maSV, String hoTen, int gioiTinh, String soCMT, String ngaySinh, String queQuan,
            String soDT, String email, String hocLuc, String loaiPhong, String taiKhoan, String matKhau)  {
        try {
            cn.ConnectSQL();
            
            String sql = "INSERT INTO sinhvien values('" + maSV + "',N'" + hoTen + "','"+gioiTinh+"','"+soCMT+"','"+ngaySinh
                    +"','"+queQuan+"','"+soDT+"','"+email+"','"+hocLuc+"',NULL, NULL, '"+loaiPhong+"',NULL, '"+taiKhoan+"','"+matKhau+"')";
            cn.UpdateData(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nhập sai mã sinh viên!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    
}