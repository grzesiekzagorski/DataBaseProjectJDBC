package KonkretnyPilkarz;



public class ShowPilkarz {
    private int id;
    private String imie;
    private String nazwisko;
    private String waga;
    private String wzrost;
    private String data_urodzenia;
    private String aktualna_cena;
    private String narodowosc;
    private String noga;
    private String pozycja;
    private String sponsor;
    private String klub;

    public ShowPilkarz(int id, String imie, String nazwisko, String waga, String wzrost, String data_urodzenia,
                       String aktualna_cena, String narodowosc, String noga, String pozycja, String sponsor, String klub) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.waga = waga;
        this.wzrost = wzrost;
        this.data_urodzenia = data_urodzenia;
        this.aktualna_cena = aktualna_cena;
        this.narodowosc = narodowosc;
        this.noga = noga;
        this.pozycja = pozycja;
        this.sponsor = sponsor;
        this.klub = klub;
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

    public String getNarodowosc() {
        return narodowosc;
    }

    public void setNarodowosc(String narodowosc) {
        this.narodowosc = narodowosc;
    }

    public String getNoga() {
        return noga;
    }

    public void setNoga(String noga) {
        this.noga = noga;
    }

    public String getPozycja() {
        return pozycja;
    }

    public void setPozycja(String pozycja) {
        this.pozycja = pozycja;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getKlub() {
        return klub;
    }

    public void setKlub(String klub) {
        this.klub = klub;
    }

    @Override
    public String toString() {
        return "ShowPilkarz{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", waga='" + waga + '\'' +
                ", wzrost='" + wzrost + '\'' +
                ", data_urodzenia='" + data_urodzenia + '\'' +
                ", aktualna_cena='" + aktualna_cena + '\'' +
                ", narodowosc='" + narodowosc + '\'' +
                ", noga='" + noga + '\'' +
                ", pozycja='" + pozycja + '\'' +
                ", sponsor='" + sponsor + '\'' +
                ", klub='" + klub + '\'' +
                '}';
    }
}
