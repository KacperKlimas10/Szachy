class Skoczek extends Figura {
    public Skoczek(String kolor) {
        super(kolor);
        if (kolor == "bialy") {
            setSymbol("♞");
        } else setSymbol("♘");
    }
    @Override
    public boolean czyPoprawnyRuch(Pozycja startowa, Pozycja docelowa, Plansza plansza, Gracz aktualnygracz) {
        if (aktualnygracz.getKolor() == this.getKolor()) {
            int deltaX = Math.abs(startowa.getX() - docelowa.getX());
            int deltaY = Math.abs(startowa.getY() - docelowa.getY());
            // Skoczek może przeskoczyć na pole, które jest w kształcie litery "L" (deltaX * deltaY == 2)
            if (deltaX * deltaY == 2) {
                return true;
            }
        }
        return false;
    }
}