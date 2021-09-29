package hu.petrik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Bejegyzes> bejegyzeekLista = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void felhasznaloBejegyzesei() {
        int ujBejegyzesekSzama;
        System.out.print("Hány új bejegyzést szeretné felvenni? ");
        ujBejegyzesekSzama = Integer.parseInt(scanner.next());

        for (int i = 0; i < ujBejegyzesekSzama; i++) {
            String szerzo, tartalom;
            System.out.print((i + 1) + ". BEJEGYZÉS\n\tAdd meg a bejegyzés szerzőjét: ");
            szerzo = scanner.next();
            System.out.print("\tAdd meg a bejegyzés tartalmát: ");
            tartalom = scanner.next();
            Bejegyzes b = new Bejegyzes(szerzo, tartalom);
            bejegyzeekLista.add(b);
        }
    }

    public static void fajlBeolvasas(String fajlNev) {
        try {
            FileReader fr = new FileReader(fajlNev);
            BufferedReader br = new BufferedReader(fr);
            String sor = br.readLine();
            while (sor != null) {
                String[] e = sor.split(";");
                Bejegyzes b = new Bejegyzes(e[0], e[1]);
                bejegyzeekLista.add(b);
                sor = br.readLine();
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static String kiiras() {
        String s = "";
        for (Bejegyzes item: bejegyzeekLista) {
            s += item + "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        Bejegyzes b1 = new Bejegyzes("Ábel", "Nem vizsgázok ősszel!");
        Bejegyzes b2 = new Bejegyzes("Ádám", "Szeretem az őszt!");

        bejegyzeekLista.add(b1);
        bejegyzeekLista.add(b2);

        felhasznaloBejegyzesei();
        System.out.println(kiiras());
    }
}
