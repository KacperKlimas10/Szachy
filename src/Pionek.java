class Pionek extends Figura {
    public Pionek(String kolor) {
        super(kolor);
        if (kolor.equals("bialy")) {
            setSymbol('♟');
        } else setSymbol('♙');
    }
    @Override
    public boolean czyPoprawnyRuch(Pozycja startowa, Pozycja docelowa, Plansza plansza, Gracz aktualnygracz) {
        if (aktualnygracz.getKolor().equals("bialy") && this.getKolor().equals("bialy")) {
            // Sprawdza czy pionek może poruszyć się o jedno lub dwa pola do przodu
            if (startowa.getX() == 1 && (docelowa.getX() == startowa.getX() + 1 || docelowa.getX() == startowa.getX() + 2)) {
                if (!plansza.getPola(docelowa.getX(), docelowa.getY()).czyZajete()) {
                    // Ruch o jedno pole do przodu
                    if (docelowa.getX() == startowa.getX() + 1 && docelowa.getY() == startowa.getY()) {
                        promocja(plansza, docelowa);
                        return true;
                    }
                    // Ruch dwa pola do przodu
                    else if (docelowa.getX() == startowa.getX() + 2 && docelowa.getY() == startowa.getY()) {
                        if (!plansza.getPola(docelowa.getX(), docelowa.getY()).czyZajete()) {
                            return true;
                        }
                    }
                }
            }
            else if (docelowa.getX() == startowa.getX() + 1 && docelowa.getY() == startowa.getY()) {
                if (!plansza.getPola(docelowa.getX(), docelowa.getY()).czyZajete()) {
                    promocja(plansza, docelowa);
                    return true;
                }
            }
            // bicie na skos
            else if (docelowa.getX() == startowa.getX() + 1 && (docelowa.getY() == startowa.getY() + 1 || docelowa.getY() == startowa.getY() - 1)) {
                // Sprawdza czy pole docelowe jest zajęte przez figurę przeciwnika
                if (plansza.getPola(docelowa.getX(), docelowa.getY()).czyZajete()) {
                    promocja(plansza, docelowa);
                    return true;
                }
            }
        }
        else if (aktualnygracz.getKolor().equals("czarny") && this.getKolor().equals("czarny")) {
            // Sprwadza czy pionek może poruszyć się o jedno lub dwa pola do przodu
            if (startowa.getX() == 6 && (docelowa.getX() == startowa.getX() - 1 || docelowa.getX() == startowa.getX() - 2)) {
                if (!plansza.getPola(docelowa.getX(), docelowa.getY()).czyZajete()) {
                    // Pionek porusza się o jedno pole do przodu
                    if (docelowa.getX() == startowa.getX() - 1 && docelowa.getY() == startowa.getY()) {
                        promocja(plansza, docelowa);
                        return true;
                    }
                    // Pionek porusza się o dwa pola do przodu
                    else if (docelowa.getX() == startowa.getX() - 2 && docelowa.getY() == startowa.getY()) {
                        if (!plansza.getPola(docelowa.getX(), docelowa.getY()).czyZajete()) {
                            return true;
                        }
                    }
                }
            }
            else if (docelowa.getX() == startowa.getX() - 1 && docelowa.getY() == startowa.getY()) {
                if (!plansza.getPola(docelowa.getX(), docelowa.getY()).czyZajete()) {
                    promocja(plansza, docelowa);
                    return true;
                }
            }
            // bicie na skos
            else if (docelowa.getX() == startowa.getX() - 1 && (docelowa.getY() == startowa.getY() + 1 || docelowa.getY() == startowa.getY() - 1)) {
                // czy pole docelowe jest zajęte przez figurę przeciwnika
                if (plansza.getPola(docelowa.getX(), docelowa.getY()).czyZajete()) {
                    promocja(plansza, docelowa);
                    return true;
                }
            }
        }
        return false;
    }
    private void promocja(Plansza plansza, Pozycja docelowa) {   // Awansowuje pionka na hetmana
        if (this.getKolor().equals("bialy")) {
            if (docelowa.getX() == 7) {     // gdy bialy jest na pierwszym wierszu czarnego
                Figura promocja = new Krolowa("bialy");
                plansza.getPola(7, docelowa.getY()).setFigura(promocja);
            }
        } else {
            if (docelowa.getX() == 0) { // gdy czarny jest na pierwszym wierszu bialego
                Figura promocja = new Krolowa("czarny");
                plansza.getPola(0, docelowa.getY()).setFigura(promocja);
            }
        }
    }
}