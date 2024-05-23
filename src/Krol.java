class Krol extends Figura {
    public Krol(String kolor) {
        super(kolor);
        if (kolor == "bialy") {
            setSymbol("♚");
        } else setSymbol("♔");
    }
    @Override
    public boolean czyPoprawnyRuch(Pozycja startowa, Pozycja docelowa, Plansza plansza, Gracz aktualnygracz) {
        if (aktualnygracz.getKolor() == this.getKolor()) {
            int deltaX = Math.abs(startowa.getX() - docelowa.getX());
            int deltaY = Math.abs(startowa.getY() - docelowa.getY());
            // Król może poruszać się o jedno pole w dowolnym kierunku
            if (deltaX <= 1 && deltaY <= 1) {
                return true;
            }
        }
        return false;
    }

}