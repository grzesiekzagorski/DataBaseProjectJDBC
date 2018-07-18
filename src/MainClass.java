import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainClass {


    public static void main(String[] args) throws SQLException {

        Statement statement= null;
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");

            //  "jdbc:postgresql://nazwahosta:port/
            //   nazwabazy","uzytkownik", "haslo"
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432" +
                            "/footballPlayer", "postgres", "postgres");

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT p.id,p.imie, p.nazwisko,p.waga,p.wzrost,p.data_urodzenia,p.aktualna_cena,\n" +
                    "k.nazwa as narodowość, n.nazwa as noga, poz.nazwa as pozycja,s.nazwa as sponsor,kl.nazwa as klub\n" +
                    "FROM pilkarz p\n" +
                    "JOIN kraj k ON p.fk_kraj= k.id\n" +
                    "JOIN noga n ON p.fk_noga = n.id\n" +
                    "JOIN pozycja poz ON p.fk_pozycja = poz.id\n" +
                    "JOIN sponsor s ON p.fk_sponsor = s.id\n" +
                    "JOIN klub kl ON p.fk_klub = kl.id");

            /*Gdy odwołuje się do wpisow nie bedacych bezposrednio w tabeli pilkarz to nie mogę uzywac aliasów  */
            //  preparedStatement.setString(1,"Messi");
            statement = connection.createStatement();

//            System.out.println(selectTableSQL);

            // wykonywanie SQL
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String imie = rs.getString("imie");
                String nazwisko= rs.getString("nazwisko");
                String waga= rs.getString("waga");
                String wzrost= rs.getString("wzrost");
                String data_urodzenia= rs.getString("data_urodzenia");
                String aktualna_cena= rs.getString("aktualna_cena");
                String narodowosc= rs.getString("narodowość");
                String noga= rs.getString("noga");
                String pozycja= rs.getString("pozycja");
                String sponsor= rs.getString("sponsor");
                String klub= rs.getString("klub");



                System.out.println("Id:" + id + "  |Imie:" + imie + "  |Nazwisko:" + nazwisko + "  |waga:"
                        + waga + "  |wzrost:" + wzrost + "  |data_urodzenia:" + data_urodzenia + "  |aktualna_cena:" + aktualna_cena +
                        "|narodowosc:" + narodowosc + "|noga:" + noga + "|pozycja:" + pozycja + "|sponsor:" + sponsor +
                        "|klub:" + klub);
            }



        } catch (ClassNotFoundException e) {

            e.printStackTrace();
            System.out.append("Nie masz sterownika\n");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.append("Zle dane\n");
        } finally {
            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }
}