package hu.petrik;

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

    public static String kiiras() {
        String s = "";
        for (Bejegyzes item: bejegyzeekLista) {
            s += item;
        }
        return s;
    }

    public static void main(String[] args) {
        Bejegyzes b1 = new Bejegyzes("Ábel", "Nem vizsgázok ősszel!");
        Bejegyzes b2 = new Bejegyzes("Ádám", "SZeretem az őszt!");

        bejegyzeekLista.add(b1);
        bejegyzeekLista.add(b2);

        felhasznaloBejegyzesei();
        System.out.println(kiiras());
    }
}
