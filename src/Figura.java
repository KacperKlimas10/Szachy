abstract class Figura {
    private char symbol;
    private final String kolor;
    private boolean czyRuszony = false;

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

    public abstract boolean czyPoprawnyRuch(Pozycja startowa, Pozycja docelowa, Plansza plansza, Gracz aktualnygracz);

    public boolean CzyRuszony() { return czyRuszony;}

    public void setCzyRuszony(boolean czyRuszony) { this.czyRuszony = czyRuszony;}
}