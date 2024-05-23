class Krolowa extends Figura {
    public Krolowa(String kolor) {
        super(kolor);
        if (kolor == "bialy") {
            setSymbol('♛');
        } else setSymbol('♕');
    }
    @Override
    public boolean czyPoprawnyRuch(Pozycja startowa, Pozycja docelowa, Plansza plansza, Gracz aktualnygracz) {
        if (aktualnygracz.getKolor() == this.getKolor()) {
            // Ruch królowej łączy możliwości ruchu gońca i wieży
            if (startowa.getX() == docelowa.getX() || startowa.getY() == docelowa.getY() ||
                    Math.abs(startowa.getX() - docelowa.getX()) == Math.abs(startowa.getY() - docelowa.getY())) {
                return true;
            }
        }
        return false;
    }

}