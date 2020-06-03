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
public class AccAdmin {
    Connect c= new Connect();
    public ResultSet ShowData(String taiKhoan) throws SQLException{
        c.ConnectSQL();
        String sql="SELECT * FROM taikhoanadmin WHERE TKhoan='"+taiKhoan+"'";
        return c.LoadData(sql);
    }
    public void InsertData(String taiKhoan, String matKhau,String hoTen, String gioiTinh, String ngaySinh,String maCanBo) throws SQLException{
        c.ConnectSQL();
        String sql = "INSERT INTO `taikhoanadmin` values('" + taiKhoan +"','"+matKhau+
                "',N'"+hoTen+"',N'"+gioiTinh+"','"+ngaySinh+ "','"+maCanBo+"')";
        c.UpdateData(sql);
    }
}
