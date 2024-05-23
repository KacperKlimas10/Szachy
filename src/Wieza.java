class Wieza extends Figura {
    public Wieza(String kolor) {
        super(kolor);
        if (kolor == "bialy") {
            setSymbol("♜");
        } else setSymbol("♖");
    }
    @Override
    public boolean czyPoprawnyRuch(Pozycja startowa, Pozycja docelowa, Plansza plansza, Gracz aktualnygracz) {
        if (aktualnygracz.getKolor() == this.getKolor()) {
            // Ruch wieży jest możliwy tylko wzdłuż wiersza lub kolumny
            if (startowa.getX() == docelowa.getX() || startowa.getY() == docelowa.getY()) {
                return true;
            }
        }
        return false;
    }
}