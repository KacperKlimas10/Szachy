class Goniec extends Figura {
    public Goniec(String kolor) {
        super(kolor);
        if (kolor.equals("bialy")) {
            setSymbol('♝');
        } else setSymbol('♗');
    }
    @Override
    public boolean czyPoprawnyRuch(Pozycja startowa, Pozycja docelowa, Plansza plansza, Gracz aktualnygracz) {
        if (aktualnygracz.getKolor().equals(this.getKolor())) {
            // Czy ruch jest po skosie
            if (Math.abs(docelowa.getX() - startowa.getX()) == Math.abs(docelowa.getY() - startowa.getY())) {
                // Czy na drodze gońca nie ma innych figur
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
}