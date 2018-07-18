
import KonkretnyPilkarz.EditPilkarz;

import java.sql.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class AddPilkarz extends Query {

    @Override
    protected void process(Map<String, Object> context) throws SQLException {
        EditPilkarz pilkarz = (EditPilkarz) context.get("pilkarz");

        PreparedStatement preparedStatement = connection.prepareStatement
                ("insert into pilkarz(id, imie, nazwisko,waga,wzrost,data_urodzenia,aktualna_cena,Fk_kraj,Fk_noga,Fk_pozycja,Fk_sponsor,Fk_klub)\n" +
                        "values (?,?,?,?,?,?,?,?,?,?,?,?);"
                );

        preparedStatement.setInt(1,pilkarz.getId());
        preparedStatement.setString(2,pilkarz.getImie());
        preparedStatement.setString(3,pilkarz.getNazwisko());
        preparedStatement.setString(4,pilkarz.getWaga());
        preparedStatement.setString(5,pilkarz.getWzrost());
        preparedStatement.setString(6,pilkarz.getData_urodzenia());
        preparedStatement.setString(7, pilkarz.getAktualna_cena());
        preparedStatement.setInt(8, pilkarz.getFk_kraj());
        preparedStatement.setInt(9,pilkarz.getFk_noga());
        preparedStatement.setInt(10,pilkarz.getFk_pozycja());
        preparedStatement.setInt(11,pilkarz.getFk_sponsor());
        preparedStatement.setInt(12,pilkarz.getFk_klub());


        preparedStatement.execute();


    }
    public static void main(String [] args) throws  SQLException, ClassNotFoundException {
        AddPilkarz addPilkarz= new AddPilkarz();
        Map<String,Object> context = new HashMap<String, Object>();
        EditPilkarz pilkarz = new EditPilkarz(10,"Marco","Reus","74","181",
               "1987-05-16","57.000.320$",15,2,7,
                4,23);
        //System.out.println(pilkarz);
        context.put("pilkarz",pilkarz);
        addPilkarz.executeForAktualizuj(context);
    }
}

