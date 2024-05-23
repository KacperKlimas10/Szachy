class Pionek extends Figura {
    public Pionek(String kolor) {
        super(kolor);
        if (kolor == "bialy") {
            setSymbol('♟');
        } else setSymbol('♙');
    }
    @Override
    public boolean czyPoprawnyRuch(Pozycja startowa, Pozycja docelowa, Plansza plansza, Gracz aktualnygracz) {
        if (aktualnygracz.getKolor() == "bialy" && this.getKolor() == "bialy") {
            // czy pionek może poruszyć się o jedno lub dwa pola do przodu
            if (startowa.getX() == 1 && (docelowa.getX() == startowa.getX() + 1 || docelowa.getX() == startowa.getX() + 2)) {
                if (!plansza.getPola(docelowa.getX(), docelowa.getY()).czyZajete()) {
                    // Pionek porusza się o jedno pole do przodu
                    if (docelowa.getX() == startowa.getX() + 1 && docelowa.getY() == startowa.getY()) {
                        return true;
                    }
                    // Pionek porusza się o dwa pola do przodu
                    else if (docelowa.getX() == startowa.getX() + 2 && docelowa.getY() == startowa.getY()) {
                        if (!plansza.getPola(docelowa.getX(), docelowa.getY()).czyZajete()) {
                            return true;
                        }
                    }
                }
            }
            else if (docelowa.getX() == startowa.getX() + 1 && docelowa.getY() == startowa.getY()) {
                if (!plansza.getPola(docelowa.getX(), docelowa.getY()).czyZajete()) {
                    return true;
                }
            }
            // bicie na skos
            else if (docelowa.getX() == startowa.getX() + 1 && (docelowa.getY() == startowa.getY() + 1 || docelowa.getY() == startowa.getY() - 1)) {
                // czy pole docelowe jest zajęte przez figurę przeciwnika
                if (plansza.getPola(docelowa.getX(), docelowa.getY()).czyZajete()) {
                    return true;
                }
            }
        }
        else if (aktualnygracz.getKolor() == "czarny" && this.getKolor() == "czarny") {
            // czy pionek może poruszyć się o jedno lub dwa pola do przodu
            if (startowa.getX() == 6 && (docelowa.getX() == startowa.getX() - 1 || docelowa.getX() == startowa.getX() - 2)) {
                if (!plansza.getPola(docelowa.getX(), docelowa.getY()).czyZajete()) {
                    // Pionek porusza się o jedno pole do przodu
                    if (docelowa.getX() == startowa.getX() - 1 && docelowa.getY() == startowa.getY()) {
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
                    return true;
                }
            }
            // bicie na skos
            else if (docelowa.getX() == startowa.getX() - 1 && (docelowa.getY() == startowa.getY() + 1 || docelowa.getY() == startowa.getY() - 1)) {
                // czy pole docelowe jest zajęte przez figurę przeciwnika
                if (plansza.getPola(docelowa.getX(), docelowa.getY()).czyZajete()) {
                    return true;
                }
            }
        }
        return false;
    }
}