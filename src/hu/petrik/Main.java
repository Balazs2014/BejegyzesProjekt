package hu.petrik;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Bejegyzes> bejegyzeekLista = new ArrayList<>();

    public static void main(String[] args) {
        Bejegyzes b1 = new Bejegyzes("Ábel", "Nem vizsgázok ősszel!");
        Bejegyzes b2 = new Bejegyzes("Ádám", "SZeretem az őszt!");

        bejegyzeekLista.add(b1);
        bejegyzeekLista.add(b2);
    }
}
