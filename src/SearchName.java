
import KonkretnyPilkarz.ShowPilkarz;

import java.sql.SQLException;
import java.util.*;

public class SearchName extends Query {

    public SearchName()
    {
        super("SELECT p.id,p.imie, p.nazwisko,p.waga,p.wzrost,p.data_urodzenia,p.aktualna_cena,\n" +
                "k.nazwa as narodowość, n.nazwa as noga, poz.nazwa as pozycja,s.nazwa as sponsor,kl.nazwa as klub\n" +
                "FROM pilkarz p\n" +
                "JOIN kraj k ON p.fk_kraj= k.id\n" +
                "JOIN noga n ON p.fk_noga = n.id\n" +
                "JOIN pozycja poz ON p.fk_pozycja = poz.id\n" +
                "JOIN sponsor s ON p.fk_sponsor = s.id\n" +
                "JOIN klub kl ON p.fk_klub = kl.id");
    }

    @Override
    protected void transformSQL(Map<String, Object> context) {
        String wartoscName =(String) context.get("p.imie");
        String wartoscSurName =(String) context.get("p.nazwisko");

        String imie = "p.imie ='" + wartoscName +"'";
        String nazwisko = "p.nazwisko ='" + wartoscSurName +"'";
        if(wartoscName != null && wartoscSurName != null)
        {
            sql += " WHERE " + imie + " AND " + nazwisko;
        }
        else if(wartoscName != null)
        {
            sql += " WHERE " + imie;
        }
        else if(wartoscSurName!= null)
        {
            sql += " WHERE " + nazwisko;
        }
    }

    @Override
    protected void process(Map<String, Object> context) throws SQLException {

        List<ShowPilkarz> pilkarze = new ArrayList<>();
        while (resultSet.next()) {

            int id = resultSet.getInt("id");
            String imie = resultSet.getString("imie");
            String nazwisko= resultSet.getString("nazwisko");
            String waga= resultSet.getString("waga");
            String wzrost= resultSet.getString("wzrost");
            String data_urodzenia= resultSet.getString("data_urodzenia");
            String aktualna_cena= resultSet.getString("aktualna_cena");
            String narodowosc= resultSet.getString("narodowość");
            String noga= resultSet.getString("noga");
            String pozycja= resultSet.getString("pozycja");
            String sponsor= resultSet.getString("sponsor");
            String klub= resultSet.getString("klub");

            pilkarze.add(new ShowPilkarz(id,imie,nazwisko,waga,wzrost,data_urodzenia,aktualna_cena,narodowosc,noga,
                    pozycja,sponsor,klub));
        }
        context.put("wynik",pilkarze);

    }
    public static void main(String [] args) throws SQLException, ClassNotFoundException {
        SearchName searchName  = new SearchName();
        Map<String,Object> context = new HashMap<String, Object>();
        context.put("p.imie","Edinson");
        context.put("p.nazwisko","Cavani");
        //System.out.println(searchName.sql);
        searchName.execute(context);
        List<ShowPilkarz> pilkarze = (List<ShowPilkarz>) context.get("wynik");
        for(ShowPilkarz x:pilkarze)
        {
            System.out.println(x);
        }


    }
}





