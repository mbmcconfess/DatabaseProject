package PreparedStatement;

import java.sql.*;
import java.util.Scanner;

public class PSDemo {
    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String JDBC_URL = "jdbc:sqlserver:";
    static final String server = "//localhost\\ITDEPT";
    static final String database = "sarbagya";
    static final int port = 1433;

    public static void main(String[] args) {
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        Scanner input = new Scanner(System.in);
        int c;
        String conString = JDBC_URL + server + ":" + port + ";databaseName=" + database + ";integratedSecurity=true";

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(conString);

            System.out.println("Press 1 for UPDATE\nPress 2 for DELETE\nPress 3 for INSERT");
            System.out.print(">>");
            c= input.nextInt();
            switch(c) {

                case 1:
                    String updateString = "UPDATE student SET name=? where rollno=?";
                    statement = connection.prepareStatement(updateString);
                    statement.setString(1, "Shyam");
                    statement.setInt(2, 2);
                    statement.executeUpdate();
                    break;

                case 2:
                    String deleteString = "DELETE student where rollno=?";
                    statement = connection.prepareStatement(deleteString);
                    statement.setInt(1, 3);
                    statement.executeUpdate();
                    break;


                case 3:
                    String insertString = "insert into  STUDENT values(?,?)";
                    statement = connection.prepareStatement(insertString);

                    statement.setString(1, "Ram");
                    statement.setInt(2, 2);
                    statement.executeUpdate();

                    statement.setString(1, "Sita");
                    statement.setInt(2, 3);
                    statement.executeUpdate();
                    break;
            }

            Statement statement1 = connection.createStatement();
            resultSet = statement1.executeQuery("SELECT * FROM student");

            while(resultSet.next()){
                System.out.println("The name of the person is "+
                    resultSet.getString("name") +
                    " whose roll no. is " +
                    resultSet.getInt("rollno"));
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }catch (Exception e){
        }
    }
}
