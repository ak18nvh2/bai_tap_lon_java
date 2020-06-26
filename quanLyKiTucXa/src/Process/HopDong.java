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
import javax.swing.JOptionPane;

/**
 *
 * @author hieuuu
 */
public class HopDong {

    public Connect cn = new Connect();

    public ResultSet ShowDanhSachHopDong() throws SQLException {
        cn.ConnectSQL();
        String sql = "SELECT * FROM hopdong";
        return cn.LoadData(sql);
    }

    public void InsertNewData(String maSV, String ngayBD, String ngayKT) {
        try {
            cn.ConnectSQL();

            String sql = "INSERT INTO `hopdong` (`MaHD`, `NgayBatDau`, `NgayKetThuc`, `MaSV`) VALUES (NULL, '" + ngayBD + "', '" + ngayKT + "', '" + maSV + "');";
            cn.UpdateData(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nhập sai!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void UpdateOldData(String maSV, String ngayKT) {
        try {
            cn.ConnectSQL();

            String sql = "UPDATE `hopdong` SET `NgayKetThuc` = '" + ngayKT + "' WHERE `hopdong`.`MaSV` = " + maSV;
            cn.UpdateData(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nhập sai!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ResultSet ShowHopDongTheoMaSV(String maSV) throws SQLException {
        cn.ConnectSQL();
        String sql = "SELECT * FROM hopdong WHERE MaSV='" + maSV + "'";
        return cn.LoadData(sql);
    }

    public ResultSet ShowHopDongTheoMaHD(String maHD) throws SQLException {
        cn.ConnectSQL();
        String sql = "SELECT * FROM hopdong WHERE MaHD='" + maHD + "'";
        return cn.LoadData(sql);
    }

    public void SetYeuCauGiaHan(String maSV, int thang) throws SQLException {
        cn.ConnectSQL();
        String sql = "UPDATE `sinhvien` SET `YeuCauGiaHan` = '" + thang + "' WHERE `sinhvien`.`MaSV` = '" + maSV + "'";
        cn.UpdateData(sql);
    }

    public ResultSet DemSoLuongHopDong() {
        try {
            cn.ConnectSQL();
            String sql = "SELECT COUNT(*) AS \"Tong\" FROM `hopdong`";
            return cn.LoadData(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet TimTheoKhoangThoiGian(String ngbd, String ngaykt) throws SQLException {
        cn.ConnectSQL();
        String sql = "SELECT * FROM `hopdong` WHERE `NgayBatDau`>='" + ngbd + "' AND`NgayKetThuc`<='" + ngaykt + "'";
        return cn.LoadData(sql);
    }

}
