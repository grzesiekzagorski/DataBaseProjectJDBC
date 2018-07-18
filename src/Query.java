
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

abstract public class Query {

    protected String sql;
    protected Connection connection;
    private Statement statement;
    protected ResultSet resultSet;


    public Query(){
        this("");
    }
    public Query(String sql) {
        this.sql = sql;
    }

    public void execute()throws SQLException, ClassNotFoundException{
        execute(new HashMap<String, Object>());
    }

    public void execute(Map<String ,Object> context) throws SQLException, ClassNotFoundException {
        try {
            connectToDataBase();
            transformSQL(context);
            executeSQL();
            process(context);
            close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    /*Metoda stworzona z konieczności wyrzucanego wyjątku*/
    public void executeForAktualizuj(Map<String ,Object> context) throws SQLException, ClassNotFoundException {
        try {
            connectToDataBase();
            transformSQL(context);
            executeSQL();
            process(context);
            closeForAktualizuj();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }




    protected void transformSQL(Map<String ,Object> context) { }


    private void connectToDataBase() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        //  "jdbc:postgresql://nazwahosta:port/
        //   nazwabazy","uzytkownik", "haslo"
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432" +
                        "/footballPlayer", "postgres", "postgres");
    }

    private void executeSQL() throws SQLException {

        statement = connection.createStatement();

        if(sql == null || sql.trim().equals(""))
        {
            return;
        }

        resultSet = statement.executeQuery(sql);
    }

    abstract protected void process(Map<String, Object> context) throws SQLException;

    private void close() throws SQLException {
        resultSet.close();
        statement.close();
        connection.close();
    }

    /*Metoda stworzona z konieczności wyrzucanego wyjątku*/
    private void closeForAktualizuj() throws SQLException {
        connection.close();
    }
}







