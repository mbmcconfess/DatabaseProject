import java.sql.*;

public class MultipleResultDemo {
    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String JDBC_URL = "jdbc:sqlserver:";
    static final String server = "//localhost\\ITDEPT";
    static final String database = "sarbagya";
    static final int port = 1433;

    public static void main(String[] args) {

        try{
            int rsCount = 0,rollno;
            String name;
            String conString = JDBC_URL + server + ":" + port + ";databaseName=" + database + ";integratedSecurity=true";
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(conString);
            System.out.println("Connection Obtained.");
            Statement statement = connection.createStatement();
            System.out.println("Statement is created.");

            String sql = "SELECT * FROM student where rollno=15" + "SELECT * FROM student where rollno=24";
            boolean results = statement.execute(sql);
            do{
                if(results){
                    ResultSet rs = statement.getResultSet();
                    rsCount++;
                    System.out.println("ResultSet#" + rsCount);
                    while (rs.next()){
                        rollno = rs.getInt("rollno");
                        name  = rs.getString("name");
                        System.out.println("The name is "+name+" and roll no. is "+rollno);
                    }
                    rs.close();
                    results = statement.getMoreResults();
                }
            }while (results);
            statement.close();
            connection.close();
        }catch (SQLException se){

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
