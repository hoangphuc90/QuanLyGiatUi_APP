package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Thông tin kết nối
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyGiatUi;encrypt=false;trustServerCertificate=true;";
    private static final String USER = "sa";       // user SQL Server
    private static final String PASS = "123456";       // mật khẩu của user

    // Hàm lấy kết nối
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Nạp driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Kết nối CSDL
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy driver JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối CSDL: " + e.getMessage());
        }
        return conn;
    }

    // Hàm test kết nối
    public static void main(String[] args) {
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            System.out.println(" Kết nối SQL Server thành công!");
        } else {
            System.out.println(" Kết nối SQL Server thất bại!");
            
        }
        
    }
}
