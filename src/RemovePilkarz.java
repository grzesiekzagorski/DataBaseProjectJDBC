
import KonkretnyPilkarz.DeletePilkarz;

import java.sql.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class RemovePilkarz extends Query {
    @Override
    protected void process(Map<String, Object> context) throws SQLException {
        DeletePilkarz pilkarz = (DeletePilkarz) context.get("pilkarz");

        PreparedStatement preparedStatement = connection.prepareStatement
                ("DELETE FROM pilkarz WHERE  id= ?");


        preparedStatement.setInt(1,pilkarz.getId());
        preparedStatement.execute();


    }

    public static void main(String [] args) throws  SQLException, ClassNotFoundException {
        RemovePilkarz removePilkarz= new RemovePilkarz();
        Map<String,Object> context = new HashMap<String, Object>();
        DeletePilkarz pilkarz = new DeletePilkarz(13);
        //System.out.println(pilkarz);
        context.put("pilkarz",pilkarz);
        removePilkarz.executeForAktualizuj(context);
    }

}
