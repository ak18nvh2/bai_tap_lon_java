/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proccess;
import Database.Connect;
import java.sql.*;
/**
 *
 * @author hieuuu
 */
public class LoaiSP {
    public Connect cn= new Connect();
    public ResultSet ShowLoaiSP() throws SQLException{
        cn.connectSQL();
        String sql= "SELECT * FROM loaisp";
        return cn.LoadData(sql);
    }
    public ResultSet ShowLoaiSP(String maLoai) throws SQLException{
        cn.connectSQL();
        String sql="SELECT * FROM loaisp WHERE Maloai='"+maLoai+"'";
        return cn.LoadData(sql);
    }
    public void InsertData(String maLoai, String tenLoai){
        String sql="INSERT INTO loaisp values('"+maLoai+"',N'"+tenLoai+"')";
        cn.UpdateData(sql);
    }
    public void EditData(String maLoai, String tenLoai){
        String sql="UPDATE loaisp set Tenloai=N'"+tenLoai+"' where Maloai='"+maLoai+"'";
        cn.UpdateData(sql);
    }
    public void DeleteData(String maLoai){
        String sql="Delete from loaisp where Maloai='"+maLoai+"'";
        cn.UpdateData(sql);
    }
}
