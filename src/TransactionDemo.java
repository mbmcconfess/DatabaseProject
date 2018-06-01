import java.sql.*;

public class TransactionDemo {
    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String JDBC_URL = "jdbc:sqlserver:";
    static final String server = "//localhost\\ITDEPT";
    static final String database = "sarbagya";
    static final int port = 1433;

    public static void main(String[] args) {
        try{
            ResultSet rs;
            String conString = JDBC_URL + server + ":" + port + ";databaseName=" + database + ";integratedSecurity=true";
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(conString);
            System.out.println("Connection Obtained.");
            Statement statement = connection.createStatement();
            System.out.println("Statement is created.");

            connection.setAutoCommit(true);
            String sql1 = "UPDATE student SET rollno =rollno+1 " + " where name='Sarbagya'";
            String sql2 = "UPDATE student SET rollno =rollno+2 " + " where name='Pemba'";

            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);
            connection.commit();
            rs = statement.executeQuery("SELECT * FROM student;");
            System.out.println("After transaction complete");

            while(rs.next()){
                System.out.println("The name of the person is "+
                rs.getString("name")+
                " whose roll number is "+
                rs.getInt("rollno"));
            }
            rs.close();
            statement.close();
        }catch (SQLException se){

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
