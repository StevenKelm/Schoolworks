import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AufgabePogSKarraylist {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Integer> punkte = new ArrayList<Integer>();

    public static void main(String[] args) {

        createMenu();

    }

    public static void createMenu() {                   // Methode für das Menü
        System.out.println(" 1 - Punktzahl hinzufügen " +
                "\n 2 - Alle Punkte mit Noten anzeigen " +
                "\n 3 - Durchschnitt " +
                "\n 4 - Beste/Schlechteste " +
                "\n 5 - Punktzahl löschen " +
                "\n 6 - Punktzahl ändern " +
                "\n 7 - Beenden ");

        int auswahl = sc.nextInt();                     // Erste Auswahl
        switch (auswahl) {
            case 1:                                     // Auswahl für die Eingabe
                if (punkte.size() > 10) {               // Prüft, ob die Liste schon das Max erreicht hat
                    System.out.println("Kapazität erreicht." +
                            "\n Möchten Sie die älteste Zahl löschen?" +
                            "\n 1 - Ja" +
                            "\n 2 - Nein");
                    int auswahl2 = sc.nextInt();        // 2 Auswahl
                    switch (auswahl2) {
                        case 1:
                            punktzahlAltLoeschen();
                            createMenu();
                            break;
                        case 2:
                            System.out.println("Sie werden nun zum Menü geschickt ");
                            createMenu();
                            break;
                    }
                } else {

                    int wert = punktzahlEingabe();
                    punkte.add(wert);
                    createMenu();
                }
                createMenu();
                break;

            case 2:                                     // Auswahl für die Anzeige
                punktzahlAnzeige();
                menuZurueck();
                createMenu();
                break;

            case 3:                                     // Auswahl für den Durchschnitt
                durchschnittRechnen();
                menuZurueck();
                createMenu();
                break;

            case 4:                                     // Auswahl für die Beste/Schlechteste Punktzahl
                punktZahlBesteSclechteste();
                menuZurueck();
                createMenu();
                break;

            case 5:                                     // Auswahl um eine Punktzahl zu löschen
                punktzahlLoeschen();
                menuZurueck();
                createMenu();
                break;

            case 6:                                 // Auswahl um eine Punktzahl zu ändern
                punktzahlAnzeige();
                punktzahlAendern();
                menuZurueck();
                createMenu();
                break;

            case 7:
                System.out.println("Beende das Programm...");
                beenden();
                break;
        }
    }

    public static int punktzahlEingabe() {              // Methode für die Eingabe der Punktzahl


        System.out.println("Geben Sie eine Ganzzahl zwischen 1-100 ein:  ");
        int punktzahl = sc.nextInt();
        if (punktzahl < 0 || punktzahl > 100) {        // Überprüfung, ob die Zahl in den angegebenen Bereich liegt
            System.out.println("Außerhalb der angegebenen Ziffern." +
                    "\n Probier es erneut.");
           return punktzahlEingabe();
        }

        return punktzahl;
    }

    public static void punktzahlAnzeige() {             // Methode für die Anzeige

        System.out.println("Hier sind die gespeicherten Punktzahlen " +
                "\n");
        for (int j = 0; j < punkte.size(); j++) {       // Schleife um die Punkte anzuzeigen
            int note = noteRechnen(punkte.get(j));
            System.out.println((j + 1) + " - " + punkte.get(j) + " Note = " + note);
        }
    }

    public static void punktzahlLoeschen() {            // Methode um eine Punktzahl zu löschen
        System.out.println("Möchten Sie eine Zahl auswählen oder die älteste löschen?" +
                "\n 1 - Auswahl" +
                "\n 2 - Älteste");
        int auswahl = sc.nextInt();
        switch (auswahl) {
            case 1:
                punktzahlAnzeige();
                System.out.println("Wählen Sie aus ");
                punktzahlWahlLoeschen();
                break;
            case 2:
                punktzahlAltLoeschen();
                break;
        }
    }

    public static void punktzahlAltLoeschen() {         // Methode um die älteste Zahl zu löschen
        punkte.remove(0);
        System.out.println(" Älteste Zahl gelöscht.");
    }

    public static void punktzahlWahlLoeschen() {        // Methode um eine ausgewählte Zahl zu löschen
        int loeschAuswahl = sc.nextInt();
        switch (loeschAuswahl) {

            case 1:
                punkte.remove(0);
                System.out.println("Erste Zahl gelöscht");
                break;

            case 2:
                punkte.remove(1);
                System.out.println("Zweite Zahl gelöscht");
                break;

            case 3:
                punkte.remove(2);
                System.out.println("Dritte Zahl gelöscht");
                break;

            case 4:
                punkte.remove(3);
                System.out.println("Vierte Zahl gelöscht");
                break;

            case 5:
                punkte.remove(4);
                System.out.println("Fünfte Zahl gelöscht");
                break;

            case 6:
                punkte.remove(5);
                System.out.println("Sechste Zahl gelöscht");
                break;

            case 7:
                punkte.remove(6);
                System.out.println("Siebte Zahl gelöscht");
                break;

            case 8:
                punkte.remove(7);
                System.out.println("Achte Zahl gelöscht");
                break;

            case 9:
                punkte.remove(8);
                System.out.println("Neunte Zahl gelöscht");
                break;

            case 10:
                punkte.remove(9);
                System.out.println("Zehnte Zahl gelöscht");
                break;
        }

    }

    public static int noteRechnen(int punktzahl) {      // Methode zum Berechnen der Note
        if (punktzahl > 92) {
            return 1;
        } else if (punktzahl > 81) {
            return 2;
        } else if (punktzahl > 67) {
            return 3;
        } else if (punktzahl > 50) {
            return 4;
        } else if (punktzahl > 30) {
            return 5;
        } else {
            return 6;
        }
    }

    public static void durchschnittRechnen() {          // Durchschnittsrechner mit Notenauswertung
        int summeDurchschnitt = 0;

        for (int i = 0; i < punkte.size(); i++) {
            summeDurchschnitt = summeDurchschnitt + punkte.get(i);
            System.out.println(summeDurchschnitt);
        }

        int durchschnittRechnung = summeDurchschnitt / punkte.size();
        System.out.println("Die Durchschnittlichen Punkte sind " + durchschnittRechnung +
                " Damit beträgt die Durchschnittliche Note " + noteRechnen(durchschnittRechnung));
    }

    public static void punktZahlBesteSclechteste() {
        System.out.println("Das ist die Beste Punktzahl = " + Collections.max(punkte)
                + "\n Das ist  die Schlechteste Punktzahl = " + Collections.min(punkte));

    }

    public static void menuZurueck() {
        System.out.println("Drücken Sie Enter um zum Menü zu kommen.");
        sc.nextLine();
        sc.nextLine();
    }

    public static void punktzahlAendern() {             // Methode um die Punktzahl zu ändern
        int auswahlAdd = sc.nextInt();
        int auswahlAdded;
        switch (auswahlAdd) {

            case 1:
                System.out.println("Geben Sie die Punktzahl ein");
                auswahlAdded = sc.nextInt();
                punkte.set(0, auswahlAdded);
                System.out.println("Erste Zahl wurde geändert");
                break;

            case 2:
                System.out.println("Geben Sie die Punktzahl ein");
                auswahlAdded = sc.nextInt();
                punkte.set(1, auswahlAdded);
                System.out.println("Zweite Zahl wurde geändert");
                break;

            case 3:
                System.out.println("Geben Sie die Punktzahl ein");
                auswahlAdded = sc.nextInt();
                punkte.set(2, auswahlAdded);
                System.out.println("Dritte Zahl wurde geändert");
                break;

            case 4:
                System.out.println("Geben Sie die Punktzahl ein");
                auswahlAdded = sc.nextInt();
                punkte.set(3, auswahlAdded);
                System.out.println("Vierte Zahl wurde geändert");
                break;

            case 5:
                System.out.println("Geben Sie die Punktzahl ein");
                auswahlAdded = sc.nextInt();
                punkte.set(4, auswahlAdded);
                System.out.println("Fünfte Zahl wurde geändert");
                break;

            case 6:
                System.out.println("Geben Sie die Punktzahl ein");
                auswahlAdded = sc.nextInt();
                punkte.set(5, auswahlAdded);
                System.out.println("Sechste Zahl wurde geändert");
                break;

            case 7:
                System.out.println("Geben Sie die Punktzahl ein");
                auswahlAdded = sc.nextInt();
                punkte.set(6, auswahlAdded);
                System.out.println("Siebte Zahl wurde geändert");
                break;

            case 8:
                System.out.println("Geben Sie die Punktzahl ein");
                auswahlAdded = sc.nextInt();
                punkte.set(7, auswahlAdded);
                System.out.println("Achte Zahl wurde geändert");
                break;

            case 9:
                System.out.println("Geben Sie die Punktzahl ein");
                auswahlAdded = sc.nextInt();
                punkte.set(8, auswahlAdded);
                System.out.println("Neunte Zahl wurde geändert");
                break;

            case 10:
                System.out.println("Geben Sie die Punktzahl ein");
                auswahlAdded = sc.nextInt();
                punkte.set(9, auswahlAdded);
                System.out.println("Zehnte Zahl wurde geändert");
                break;
        }

    }

    public static void beenden() {

        sc.close();
        System.exit(0);
    }
}