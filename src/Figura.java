abstract class Figura {
    private String symbol;
    private String kolor;

    public Figura(String kolor) {
//      this.symbol = symbol;
        this.kolor = kolor;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getKolor() {
        return kolor;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public abstract boolean czyPoprawnyRuch(Pozycja startowa, Pozycja docelowa, Plansza plansza, Gracz aktualnygracz);
}