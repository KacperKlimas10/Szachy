class Krolowa extends Figura {
    public Krolowa(String kolor) {
        super(kolor);
        if (kolor.equals("bialy")) {
            setSymbol('♛');
        } else setSymbol('♕');
    }
    @Override
    public boolean czyPoprawnyRuch(Pozycja startowa, Pozycja docelowa, Plansza plansza, Gracz aktualnygracz) {
        if (aktualnygracz.getKolor().equals(this.getKolor())) {
            // Ruch królowej łączy możliwości ruchu gońca i wieży
            // Skopiowane z wiezy
            if (startowa.getX() == docelowa.getX() || startowa.getY() == docelowa.getY()) {
                // Ruch wieży jest możliwy tylko wzdłuż wiersza lub kolumny
                if (startowa.getX() == docelowa.getX() || startowa.getY() == docelowa.getY()) {
                    if (czySciezkaJestWolna(startowa, docelowa, plansza)) {
                        return true;
                    }
                }
                return false;
            }
            else if (Math.abs(startowa.getX() - docelowa.getX()) == Math.abs(startowa.getY() - docelowa.getY())) {
                // czy na drodze gońca nie ma innych figur // Skopiowane z gońca
                int dirX = (docelowa.getX() - startowa.getX()) > 0 ? 1 : -1;
                int dirY = (docelowa.getY() - startowa.getY()) > 0 ? 1 : -1;
                int x = startowa.getX() + dirX;
                int y = startowa.getY() + dirY;
                while (x != docelowa.getX() && y != docelowa.getY()) {
                    if (plansza.getPola(x, y).czyZajete()) {
                        return false; // Na drodze figury są inne figury
                    }
                    x += dirX;
                    y += dirY;
                }
                return true; // Ruch jest poprawny dla gońca
            }
        }
        return false;
    }
    // Funkcja sprawdzajaca sciezke (z klasy Wieza)
    private boolean czySciezkaJestWolna(Pozycja startowa, Pozycja docelowa, Plansza plansza) {
        if (startowa.getX() == docelowa.getX()) { // dla ruchów wzdloz wierszy
            int minY = Math.min(startowa.getY(), docelowa.getY()); // Szuka minimalnej wartosci aby iterowac z inkrementacja
            int maxY = Math.max(startowa.getY(), docelowa.getY()); // Okresla max zeby wiedziec gdzie zakonczyc petle
            for (int y = minY + 1; y < maxY; y++) { // Zaczyna sie od od minX + 1 ponieważ sprawdzamy tylko pola pomiedzy startowym a docelowym
                if (plansza.getPola(startowa.getX(), y).czyZajete()) { // Jezeli na polu znajduje sie figura to zwraca false
                    return false;
                }
            }
        } else if (startowa.getY() == docelowa.getY()) { // dla ruchów wzdloz kolumny
            int minX = Math.min(startowa.getX(), docelowa.getX());  // Szuka minimalnej wartosci aby interowac z inkrementacja
            int maxX = Math.max(startowa.getX(), docelowa.getX());  // Okresla max zeby wiedziec gdzie zakonczyc petle
            for (int x = minX + 1; x < maxX; x++) { // Zaczyna sie od od minX + 1 ponieważ sprawdzamy tylko pola pomiedzy startowym a docelowym
                if (plansza.getPola(x, startowa.getY()).czyZajete()) { // Jezeli na polu znajduje sie figura to zwraca false
                    return false;
                }
            }
        }

        Figura figuraDocelowa = plansza.getPola(docelowa.getX(), docelowa.getY()).getFigura();
        if (figuraDocelowa != null && figuraDocelowa.getKolor() == this.getKolor()) { // Sprawdza czy na polu docelowym znajduje figura tego samego koloru
            return false;
        }
        return true;
    }
}