

import KonkretnyPilkarz.DeletePilkarz;
import KonkretnyPilkarz.EditPilkarz;
import KonkretnyPilkarz.ShowPilkarz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterfejsOkno extends JFrame {

    private DefaultListModel<ShowPilkarz> pilkarzListModel;

    public InterfejsOkno()
    {
        JPanel searchPanel = createSearchPanel();
        add(searchPanel, BorderLayout.NORTH);

        JPanel deletePanel = createDeletePanel();
        add(deletePanel, BorderLayout.EAST);

        JPanel addEditPanel = createaddEditPanel();
        add(addEditPanel, BorderLayout.WEST);

        JPanel foundPanel = createFoundPanel();
        add(foundPanel,BorderLayout.CENTER);

        pack();
        setVisible(true);
    }
    private JPanel createDeletePanel() {
       final JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE),"Usuń"));
        panel.add(new JLabel("Id: "));
        final JTextField poleTekstoweDeleteId= new JTextField(5);
        panel.add(poleTekstoweDeleteId);
        JButton przyciskUsun = new JButton("Usuń");
        panel.add(przyciskUsun);
        przyciskUsun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deleteOfListFootballer(poleTekstoweDeleteId.getText());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        return panel;
    }

    private void deleteOfListFootballer(String Id) throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(Id);
        RemovePilkarz removePilkarz= new RemovePilkarz();
        Map<String,Object> context = new HashMap<String, Object>();
        DeletePilkarz pilkarz = new DeletePilkarz(id);
        //System.out.println(pilkarz);
        context.put("pilkarz",pilkarz);
        removePilkarz.executeForAktualizuj(context);
        pilkarzListModel.removeAllElements();
    }

    private JPanel createFoundPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE),"Znalezieni piłkarze"));
        pilkarzListModel = new DefaultListModel<>();
        JList<ShowPilkarz> listaPilkarzy = new JList<>(pilkarzListModel);
        listaPilkarzy.setVisibleRowCount(5);
        listaPilkarzy.setPreferredSize(new Dimension(1500,2000));
        panel.add(new JScrollPane(listaPilkarzy));
        return panel;
    }

    private JPanel createaddEditPanel() {
        final JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE),"Utwórz/Zmień"));
        panel.setLayout(new GridLayout(13,2,5,5));
        panel.add(new JLabel("Id: "));
        final JTextField poleTekstoweId= new JTextField(15);
        panel.add(poleTekstoweId);
        panel.add(new JLabel("Imię: "));
        final JTextField poleTekstoweName= new JTextField(15);
        panel.add(poleTekstoweName);
        panel.add(new JLabel("Nazwisko: "));
        final JTextField poleTekstoweSurName= new JTextField(15);
        panel.add(poleTekstoweSurName);
        panel.add(new JLabel("Waga: "));
        final JTextField poleTekstoweWaga= new JTextField(5);
        panel.add(poleTekstoweWaga);
        panel.add(new JLabel("Wzrost: "));
        final JTextField poleTekstoweWzrost= new JTextField(5);
        panel.add(poleTekstoweWzrost);
        panel.add(new JLabel("Data urodzenia: "));
        final JTextField poleTekstoweData_Urodzenia= new JTextField(15);
        panel.add(poleTekstoweData_Urodzenia);
        panel.add(new JLabel("Aktualna Cena: "));
        final JTextField poleTekstoweAktualna_Cena= new JTextField(15);
        panel.add(poleTekstoweAktualna_Cena);
        panel.add(new JLabel("Narodowość: "));
        final JTextField poleTekstoweNarodowosc= new JTextField(15);
        panel.add(poleTekstoweNarodowosc);
        panel.add(new JLabel("Noga: "));
        final JTextField poleTekstoweNoga= new JTextField(15);
        panel.add(poleTekstoweNoga);
        panel.add(new JLabel("Pozycja: "));
        final JTextField poleTekstowePozycja= new JTextField(15);
        panel.add(poleTekstowePozycja);
        panel.add(new JLabel("Sponsor: "));
        final JTextField poleTekstoweSponsor= new JTextField(15);
        panel.add(poleTekstoweSponsor);
        panel.add(new JLabel("Klub: "));
        final JTextField poleTekstoweKlub= new JTextField(15);
        panel.add(poleTekstoweKlub);
        JButton przyciskDodaj = new JButton("Dodaj");
        panel.add(przyciskDodaj);
        przyciskDodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dodajDoListyPilkarzy(poleTekstoweId.getText(),poleTekstoweName.getText(),poleTekstoweSurName.getText(),
                            poleTekstoweWaga.getText(),poleTekstoweWzrost.getText(),poleTekstoweData_Urodzenia.getText(),
                            poleTekstoweAktualna_Cena.getText(),poleTekstoweNarodowosc.getText(),poleTekstoweNoga.getText(),
                            poleTekstowePozycja.getText(),poleTekstoweSponsor.getText(),poleTekstoweKlub.getText());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JButton przyciskZmien = new JButton("Zmień");
        panel.add(przyciskZmien);
        przyciskZmien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    zmienListePilkarzy(poleTekstoweId.getText(),poleTekstoweName.getText(),poleTekstoweSurName.getText(),
                            poleTekstoweWaga.getText(),poleTekstoweWzrost.getText(),poleTekstoweData_Urodzenia.getText(),
                            poleTekstoweAktualna_Cena.getText(),poleTekstoweNarodowosc.getText(),poleTekstoweNoga.getText(),
                            poleTekstowePozycja.getText(),poleTekstoweSponsor.getText(),poleTekstoweKlub.getText());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        return panel;
    }

    private void zmienListePilkarzy(String Id, String Imie, String Nazwisko, String Waga, String Wzrost,
                                    String data_urodzenia, String aktualna_cena, String Narodowosc,
                                    String Noga, String Pozycja, String Sponsor, String Klub) throws SQLException, ClassNotFoundException {


        int id = Integer.parseInt(Id);
        int kraj = Integer.parseInt(Narodowosc);
        int noga = Integer.parseInt(Noga);
        int pozycja = Integer.parseInt(Pozycja);
        int sponsor = Integer.parseInt(Sponsor);
        int klub = Integer.parseInt(Klub);


        AktualizujPilkarz aktualizujPilkarz = new AktualizujPilkarz();
        Map<String,Object> context = new HashMap<String, Object>();
        EditPilkarz pilkarz = new EditPilkarz(id,Imie,Nazwisko,Waga,Wzrost,data_urodzenia,aktualna_cena,kraj,noga,
                pozycja,sponsor,klub);
        //System.out.println(pilkarz);
        context.put("pilkarz",pilkarz);
        aktualizujPilkarz.executeForAktualizuj(context);
        pilkarzListModel.removeAllElements();



    }

    private void dodajDoListyPilkarzy(String Id, String Imie, String Nazwisko, String Waga, String Wzrost,
                                      String data_urodzenia, String aktualna_cena, String Narodowosc,
                                      String Noga, String Pozycja, String Sponsor, String Klub) throws SQLException, ClassNotFoundException {

        int id = Integer.parseInt(Id);
        int kraj = Integer.parseInt(Narodowosc);
        int noga = Integer.parseInt(Noga);
        int pozycja = Integer.parseInt(Pozycja);
        int sponsor = Integer.parseInt(Sponsor);
        int klub = Integer.parseInt(Klub);


        AddPilkarz addPilkarz= new AddPilkarz();
        Map<String,Object> context = new HashMap<String, Object>();
        EditPilkarz pilkarz = new EditPilkarz(id,Imie,Nazwisko,Waga,Wzrost,data_urodzenia,aktualna_cena,kraj,noga,
        pozycja,sponsor,klub);
        //System.out.println(pilkarz);
        context.put("pilkarz",pilkarz);
        addPilkarz.executeForAktualizuj(context);
        pilkarzListModel.removeAllElements();
    }


    private JPanel createSearchPanel() {
        final JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE),"Wyszukiwanie"));
        panel.add(new JLabel("Imię: "));
        final JTextField poleTekstoweImie = new JTextField(25);
        panel.add(poleTekstoweImie);
        panel.add(new JLabel("Nazwisko: "));
        final JTextField poleTekstoweNazwisko = new JTextField(25);
        panel.add(poleTekstoweNazwisko);
        JButton przyciskSzukaj = new JButton("Szukaj");
        przyciskSzukaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    aktualizujListePilkarzy(poleTekstoweImie.getText(),poleTekstoweNazwisko.getText());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        panel.add(przyciskSzukaj);
        JButton przyciskPokaz= new JButton("Pokaż Wszystko");
        przyciskPokaz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pokazWszystkichPilkarzy();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        panel.add(przyciskPokaz);
        return panel;
    }

    private void pokazWszystkichPilkarzy() throws SQLException, ClassNotFoundException {
        WszyscyPilkarze wszyscyPilkarze= new WszyscyPilkarze();
        Map<String,Object> context = new HashMap<String, Object>();
        context.put("p.imie","Wszyscy");
        //System.out.println(searchName.sql);
        wszyscyPilkarze.execute(context);
        java.util.List<ShowPilkarz> pilkarze = (List<ShowPilkarz>) context.get("wynik");
        pilkarzListModel.removeAllElements();
        for(ShowPilkarz pilkarz :pilkarze)
        {
            pilkarzListModel.addElement(pilkarz);
        }

    }

    private void aktualizujListePilkarzy(String imie, String nazwisko) throws SQLException, ClassNotFoundException {
        SearchName searchName  = new SearchName();
        Map<String,Object> context = new HashMap<String, Object>();

        if(niepusty(imie)) {
            context.put("p.imie", imie);
        }
        if(niepusty(nazwisko)) {
            context.put("p.nazwisko", nazwisko);
        }
        //System.out.println(searchName.sql);
        searchName.execute(context);
        java.util.List<ShowPilkarz> pilkarze = (List<ShowPilkarz>) context.get("wynik");
        pilkarzListModel.removeAllElements();
        for(ShowPilkarz x:pilkarze)
        {
            pilkarzListModel.addElement(x);
        }

    }

    private boolean niepusty(String imie) {
        return imie != null && imie.isEmpty()==false;
    }

    public static void main(String[] args)
    {
        new InterfejsOkno();
    }


}
