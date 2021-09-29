package hu.petrik;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Main {

    static List<Bejegyzes> bejegyzesekLista = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static Random rnd = new Random();

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
            bejegyzesekLista.add(b);
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
                bejegyzesekLista.add(b);
                sor = br.readLine();
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void likeokKiosztasa() {
        int listaHossza = bejegyzesekLista.size();
        for (int i = 0; i < listaHossza * 20; i++) {
            int random = rnd.nextInt(listaHossza);
            bejegyzesekLista.get(random).like();
        }
    }

    public static String kiiras() {
        String s = "";
        for (Bejegyzes item : bejegyzesekLista) {
            s += item + "\n";
        }
        return s;
    }

    public static void felhasznaloModositsaMasodikBejegyzest() {
        String ujTartalom;
        System.out.print("Módosítsa a 2. bejegyzést!\n\tAdja meg az új tartalmat: ");
        ujTartalom = scanner.next();
        bejegyzesekLista.get(1).setTartalom(ujTartalom);
    }

    public static void legnepszerubbBejegyzes() {
        int maxLikeIndex = 0;
        for (int i = 0; i < bejegyzesekLista.size(); i++) {
            if (bejegyzesekLista.get(maxLikeIndex).getLikeok() < bejegyzesekLista.get(i).getLikeok()) {
                maxLikeIndex = i;
            }
        }
        System.out.println("LEGNÉPSZERŰBB BEJEGYZÉS: \n" + bejegyzesekLista.get(maxLikeIndex));
    }

    public static boolean vaneBejegyzesHarmincotnelTobbLike() {
        int i = 0;
        boolean logikai = false;
        while (i < bejegyzesekLista.size()) {
            if (bejegyzesekLista.get(i).getLikeok() < 35) {
                logikai = true;
            }
        }
        return logikai;
    }

    public static int tizenotnelKevesebbLikeDarab() {
        int db = 0;
        for (Bejegyzes item : bejegyzesekLista) {
            if (item.getLikeok() < 15) {
                db++;
            }
        }
        return db;
    }

    public static void listaCsokkenobeRendezesLikeokSzerint() {

    }

    public static void fajlbaIras(String fajlNev) {
        try {
            FileWriter file = new FileWriter(fajlNev);
            for (Bejegyzes item : bejegyzesekLista) {
                file.write(item + System.lineSeparator());
            }
            file.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Bejegyzes b1 = new Bejegyzes("Ábel", "Nem vizsgázok ősszel!");
        Bejegyzes b2 = new Bejegyzes("Ádám", "Szeretem az őszt!");

        bejegyzesekLista.add(b1);
        bejegyzesekLista.add(b2);

        felhasznaloBejegyzesei();
        fajlBeolvasas("bejegyzesek.txt");
        likeokKiosztasa();
        felhasznaloModositsaMasodikBejegyzest();
        System.out.println(kiiras());
        legnepszerubbBejegyzes();
        if (vaneBejegyzesHarmincotnelTobbLike()) {
            System.out.println("Van olyan bejegyzés, amely 35-nél több like-ot kapott!");
        } else {
            System.out.println("Nincs olyan bejegyzés, amely 35-nél több like-ot kapott!");
        }
        System.out.println("15-nél kevesebb like-ot kapott bejegyzések száma: " + tizenotnelKevesebbLikeDarab() + " db");
        fajlbaIras("bejegyzesek_rendezett.txt");
    }
}
