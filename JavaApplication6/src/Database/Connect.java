package Database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author camng
 */
public class Connect {

    public Connection conn  = null;
    public ResultSet result = null;

    // Phương thức thực hiện kết nối cơ sở dữ liệu
    public Connection getJDBCConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ql_kh";
        String username = "root";
        String password = "";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return this.conn;
    }

    //Phương thức dùng để truy vẫn cơ sở dữ liệu: Select
    public ResultSet LoadData(String sql) {
        try {
            Statement statement = conn.createStatement();
            this.result         = statement.executeQuery(sql);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.result;
    }

    //Phương thức hiển thị Thêm, sửa, xóa dữ liệu: in
    public void UpdateData(String sql) {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
