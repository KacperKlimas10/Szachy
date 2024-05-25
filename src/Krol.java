class Krol extends Figura {
    boolean czyRuszony = false;
    public Krol(String kolor) {
        super(kolor);
        if (kolor == "bialy") {
            setSymbol('♚');
        } else setSymbol('♔');
    }
    @Override
    public boolean czyPoprawnyRuch(Pozycja startowa, Pozycja docelowa, Plansza plansza, Gracz aktualnygracz) {
        if (aktualnygracz.getKolor() == this.getKolor()) {
            int deltaX = Math.abs(startowa.getX() - docelowa.getX());
            int deltaY = Math.abs(startowa.getY() - docelowa.getY());
            // Król może poruszać się o jedno pole w dowolnym kierunku
            if (deltaX <= 1 && deltaY <= 1) {
                this.setCzyRuszony(true);
                return true;
            }
            else if (startowa.getY() == 3 && docelowa.getY() == 1) {
                return krotkaRoszada(plansza);
            }
            else if (startowa.getY() == 3 && docelowa.getY() == 5) {
                return dlugaRoszada(plansza);
            }
        }
        return false;
    }
    @Override
    public boolean CzyRuszony() {
        return czyRuszony;
    }
    @Override
    public void setCzyRuszony(boolean czyRuszony) {
        this.czyRuszony = czyRuszony;
    }

    public boolean dlugaRoszada(Plansza plansza) {
        if (!this.CzyRuszony()) {
            if (this.getKolor() == "bialy") {
                if (!plansza.getPola(0, 7).getFigura().CzyRuszony()) {
                    for (int i = 4; i <= 6; i++) {
                        if (plansza.getPola(0, i).getFigura() != null) {
                            return false;
                        }
                    }
                    Figura figura = plansza.getPola(0, 7).getFigura();
                    plansza.getPola(0, 7).setFigura(null);
                    plansza.getPola(0, 4).setFigura(figura);
                    plansza.getPola(0, 4).getFigura().setCzyRuszony(true);
                    return true;
                }
            } else {
                if (!plansza.getPola(7, 7).getFigura().CzyRuszony()) {
                    for (int i = 4; i <= 6; i++) {
                        if (plansza.getPola(7, i).getFigura() != null) {
                            return false;
                        }
                    }
                    Figura figura = plansza.getPola(7, 7).getFigura();
                    plansza.getPola(7, 7).setFigura(null);
                    plansza.getPola(7, 4).setFigura(figura);
                    plansza.getPola(7, 4).getFigura().setCzyRuszony(true);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean krotkaRoszada(Plansza plansza) {
        if (!this.CzyRuszony()) {
            if (this.getKolor() == "bialy") {
                if (!plansza.getPola(0, 0).getFigura().CzyRuszony()) {
                    for (int i = 1; i <= 2; i++) {
                        if (plansza.getPola(0, i).getFigura() != null) {
                            return false;
                        }
                    }
                    Figura figura = plansza.getPola(0, 0).getFigura();
                    plansza.getPola(0, 0).setFigura(null);
                    plansza.getPola(0, 2).setFigura(figura);
                    plansza.getPola(0, 2).getFigura().setCzyRuszony(true);
                    return true;
                }
            } else {
                if (!plansza.getPola(7, 7).getFigura().CzyRuszony()) {
                    for (int i = 4; i <= 6; i++) {
                        if (plansza.getPola(7, i).getFigura() != null) {
                            return false;
                        }
                    }
                    Figura figura = plansza.getPola(7, 0).getFigura();
                    plansza.getPola(7, 0).setFigura(null);
                    plansza.getPola(7, 2).setFigura(figura);
                    plansza.getPola(7, 2).getFigura().setCzyRuszony(true);
                    return true;
                }
            }
        }
        return false;
    }
}