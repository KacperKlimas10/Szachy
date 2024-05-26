class SterowaniePlansza {
    private Plansza plansza;

    public SterowaniePlansza() {
        plansza = new Plansza();
        plansza.inicjalizujPlansze();
    }

    public void wykonajRuch(Pozycja startowa, Pozycja docelowa, Gracz aktualnygracz) {
        Pole startowePole = plansza.getPola(startowa.getX(), startowa.getY());
        Pole docelowePole = plansza.getPola(docelowa.getX(), docelowa.getY());

        if (!startowePole.czyZajete()) {
            System.out.println("Błąd: Pole startowe jest puste!");
        }
        Figura figura = startowePole.getFigura();
        if (figura.czyPoprawnyRuch(startowa, docelowa, plansza, aktualnygracz)) {
            docelowePole.setFigura(figura);
            startowePole.setFigura(null);
            System.out.println("Ruch wykonany pomyślnie!");
            System.out.println(plansza);
        } else {
            System.out.println("Błąd: Niepoprawny ruch!");
            System.out.println(plansza);
        }
    }

}