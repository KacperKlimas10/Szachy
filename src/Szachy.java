import java.util.Scanner;

public class Szachy {
    private Plansza plansza;
    private Gracz bialyGracz;
    private Gracz czarnyGracz;
    private Gracz aktualnyGracz;

    public Szachy() {
        plansza = new Plansza();
        plansza.inicjalizujPlansze();
        bialyGracz = new Gracz("bialy");
        czarnyGracz = new Gracz("czarny");
        aktualnyGracz = bialyGracz; // Początkowo zaczyna gracz biały
    }

    public void rozpocznijGre() {

        System.out.println("Gra Start!");
        System.out.println(plansza);
        SterowaniePlansza sterowaniePlansza = new SterowaniePlansza();

        while (!czyKoniecGry()) {
            System.out.println("Ruch gracza: " + aktualnyGracz.getKolor());

            Scanner scanner = new Scanner(System.in);

            System.out.print("Podaj wiersz pozycji startowej: ");
            int startX = scanner.nextInt();
            System.out.print("Podaj kolumne pozycji startowej: ");
            int startY = scanner.nextInt();
            Pozycja startowa = new Pozycja(startX, startY);

            System.out.print("Podaj wiersz pozycji docelowej: ");
            int endX = scanner.nextInt();
            System.out.print("Podaj kolumne pozycji docelowej: ");
            int endY = scanner.nextInt();
            Pozycja docelowa = new Pozycja(endX, endY);

            sterowaniePlansza.wykonajRuch(startowa, docelowa, aktualnyGracz);

            zmienGracza();
        }
        System.out.println("Koniec gry.");
    }
    public boolean czyKoniecGry() {
        // Jezeli szach mat to koniec.
        return false;
    }
    public void zmienGracza() {
        aktualnyGracz = (aktualnyGracz == bialyGracz) ? czarnyGracz : bialyGracz;
    }
}