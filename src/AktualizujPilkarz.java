
import KonkretnyPilkarz.EditPilkarz;

import java.sql.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class AktualizujPilkarz extends Query {

    @Override
    protected void process(Map<String, Object> context) throws SQLException {
        EditPilkarz pilkarz = (EditPilkarz) context.get("pilkarz");

        PreparedStatement preparedStatement = connection.prepareStatement
                (
                        "UPDATE pilkarz SET imie= ?, nazwisko= ?,waga= ?,wzrost= ?,data_urodzenia= ?,aktualna_cena= ?,\n" +
                                "Fk_kraj= ?,Fk_noga= ?,Fk_pozycja= ?,Fk_sponsor= ?,Fk_klub= ?\n" +
                                "WHERE id= ? ");

        preparedStatement.setString(1,pilkarz.getImie());
        preparedStatement.setString(2,pilkarz.getNazwisko());
        preparedStatement.setString(3,pilkarz.getWaga());
        preparedStatement.setString(4,pilkarz.getWzrost());
        preparedStatement.setString(5,pilkarz.getData_urodzenia());
        preparedStatement.setString(6, pilkarz.getAktualna_cena());
        preparedStatement.setInt(7, pilkarz.getFk_kraj());
        preparedStatement.setInt(8,pilkarz.getFk_noga());
        preparedStatement.setInt(9,pilkarz.getFk_pozycja());
        preparedStatement.setInt(10,pilkarz.getFk_sponsor());
        preparedStatement.setInt(11,pilkarz.getFk_klub());
        preparedStatement.setInt(12,pilkarz.getId());

        preparedStatement.execute();


    }
    public static void main(String [] args) throws  SQLException, ClassNotFoundException {
        AktualizujPilkarz aktualizujPilkarz = new AktualizujPilkarz();
        Map<String,Object> context = new HashMap<String, Object>();
        EditPilkarz pilkarz = new EditPilkarz(1,"Zinedine","Zidane","76","184",
                "1972-04-12","93.760.020$",7,1,10,
                1,28);
        //System.out.println(pilkarz);
        context.put("pilkarz",pilkarz);
        aktualizujPilkarz.executeForAktualizuj(context);
    }
}

