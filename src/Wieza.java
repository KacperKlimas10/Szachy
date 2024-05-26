class Wieza extends Figura {
    private boolean czyRuszony = false;
    public Wieza(String kolor) {
        super(kolor);
        if (kolor.equals("bialy")) {
            setSymbol('♜');
        } else setSymbol('♖');
    }

    @Override
    public boolean czyPoprawnyRuch(Pozycja startowa, Pozycja docelowa, Plansza plansza, Gracz aktualnygracz) {
        if (!(aktualnygracz.getKolor().equals(this.getKolor()))) {
            return false;
        }
        // Ruch wieży jest możliwy tylko wzdłuż wiersza lub kolumny
        if (startowa.getX() == docelowa.getX() || startowa.getY() == docelowa.getY()) {
            if (czySciezkaJestWolna(startowa, docelowa, plansza)) {
                this.setCzyRuszony(true);
                return true;
            }
        }
        return false;
    }

    private boolean czySciezkaJestWolna(Pozycja startowa, Pozycja docelowa, Plansza plansza) {
        if (startowa.getX() == docelowa.getX()) { // dla ruchów wzdloz wierszy
            int minY = Math.min(startowa.getY(), docelowa.getY()); // Szuka minimalnej wartosci aby interowac z inkrementacja
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
        if (figuraDocelowa != null && figuraDocelowa.getKolor().equals(this.getKolor())) { // Sprawdza czy na polu docelowym znajduje figura tego samego koloru
            return false;
        }
        return true;
    }

    @Override
    public boolean CzyRuszony() {
        return czyRuszony;
    }

    @Override
    public void setCzyRuszony(boolean czyRuszony) {
        this.czyRuszony = czyRuszony;
    }
}