package Controller;

import Database.Connect;
import java.sql.SQLException;

/**
 *
 * @author hieuuu
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        Connect connection = new Connect();
        connection.getJDBCConnection();
        
        String sql = "SELECT * FROM `khachhang`";
        connection.LoadData(sql);
        
        System.out.println("");
    }
}
