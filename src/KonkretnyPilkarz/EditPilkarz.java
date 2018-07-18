package KonkretnyPilkarz;

import java.sql.Date;

public class EditPilkarz {
    private int id;
    private String imie;
    private String nazwisko;
    private String waga;
    private String wzrost;
    private String data_urodzenia;
    private String aktualna_cena;
    private int fk_kraj;
    private int fk_noga;
    private int fk_pozycja;
    private int fk_sponsor;
    private int fk_klub;

    public EditPilkarz(int id, String imie, String nazwisko,
                       String waga, String wzrost, String data_urodzenia, String aktualna_cena, int fk_kraj,
                       int fk_noga, int fk_pozycja, int fk_sponsor, int fk_klub) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.waga = waga;
        this.wzrost = wzrost;
        this.data_urodzenia = data_urodzenia;
        this.aktualna_cena = aktualna_cena;
        this.fk_kraj = fk_kraj;
        this.fk_noga = fk_noga;
        this.fk_pozycja = fk_pozycja;
        this.fk_sponsor = fk_sponsor;
        this.fk_klub = fk_klub;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getWaga() {
        return waga;
    }

    public void setWaga(String waga) {
        this.waga = waga;
    }

    public String getWzrost() {
        return wzrost;
    }

    public void setWzrost(String wzrost) {
        this.wzrost = wzrost;
    }

    public String getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(String data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getAktualna_cena() {
        return aktualna_cena;
    }

    public void setAktualna_cena(String aktualna_cena) {
        this.aktualna_cena = aktualna_cena;
    }

    public int getFk_kraj() {
        return fk_kraj;
    }

    public void setFk_kraj(int fk_kraj) {
        this.fk_kraj = fk_kraj;
    }

    public int getFk_noga() {
        return fk_noga;
    }

    public void setFk_noga(int fk_noga) {
        this.fk_noga = fk_noga;
    }

    public int getFk_pozycja() {
        return fk_pozycja;
    }

    public void setFk_pozycja(int fk_pozycja) {
        this.fk_pozycja = fk_pozycja;
    }

    public int getFk_sponsor() {
        return fk_sponsor;
    }

    public void setFk_sponsor(int fk_sponsor) {
        this.fk_sponsor = fk_sponsor;
    }

    public int getFk_klub() {
        return fk_klub;
    }

    public void setFk_klub(int fk_klub) {
        this.fk_klub = fk_klub;
    }
}
