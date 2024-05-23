abstract class Figura {
    private char symbol;
    private String kolor;

    public Figura(String kolor) {
//      this.symbol = symbol;
        this.kolor = kolor;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getKolor() {
        return kolor;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public abstract boolean czyPoprawnyRuch(Pozycja startowa, Pozycja docelowa, Plansza plansza, Gracz aktualnygracz);
}