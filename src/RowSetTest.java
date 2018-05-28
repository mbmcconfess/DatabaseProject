import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class RowSetTest {
    public static void main(String[] args) throws Exception {
        RowSetFactory rowSetFactory = RowSetProvider.newFactory();

        JdbcRowSet rowSet = rowSetFactory.createJdbcRowSet();
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        rowSet.setUrl(jdbc:sqlserver://localhost\ITDEPT:1433;database=sarbagya);
    }
}
