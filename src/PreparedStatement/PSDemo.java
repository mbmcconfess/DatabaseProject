package PreparedStatement;

import java.sql.*;

public class PSDemo {
    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String JDBC_URL = "jdbc:sqlserver:";
    static final String server = "//localhost\\ITDEPT";
    static final String database = "sarbagya";
    static final int port = 1433;

    public static void main(String[] args) {
        Connection connection;
        PreparedStatement statement;
        String conString = JDBC_URL + server + ":" + port + ";databaseName=" + database + ";integratedSecurity=true";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(conString);
            String sql = "update STUDENT set name=? where rollNo=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,"Pemba");
            statement.setInt(2,1);
            statement.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        }catch (Exception e){

        }
    }
}
