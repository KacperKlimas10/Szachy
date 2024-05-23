class Wieza extends Figura {
    private boolean czyRuszony = false;
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
                setCzyRuszony(true);
                return true;
            }
        }
        return false;
    }

    public boolean isCzyRuszony() {
        return czyRuszony;
    }

    public void setCzyRuszony(boolean czyRuszony) {
        this.czyRuszony = czyRuszony;
    }
}