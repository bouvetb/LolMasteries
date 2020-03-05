package cmd;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        API api = new API();
        ArrayList<Perso> p = new ArrayList<>();
        p=api.Maitrise("nvers");
        for (Perso tm: p) {
            System.out.println(tm);
        }
    }
}
