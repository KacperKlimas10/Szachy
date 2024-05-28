class Plansza {
    private Pole[][] pola;

    public void inicjalizujPlansze() {
        pola = new Pole[8][8];

        // Inicjalizacja pionków
        for (int i = 0; i < 8; i++) {
            pola[1][i] = new Pole(new Pionek("bialy"), new Pozycja(1, i));
            pola[6][i] = new Pole(new Pionek("czarny"), new Pozycja(6, i));
        }

        // Inicjalizacja pustych pól
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                pola[i][j] = new Pole(null, new Pozycja(i, j));
            }
        }

        // Inicjalizacja białych figur
        pola[0][0] = new Pole(new Wieza("bialy"), new Pozycja(0, 0));
        pola[0][1] = new Pole(new Skoczek("bialy"), new Pozycja(0, 1));
        pola[0][2] = new Pole(new Goniec("bialy"), new Pozycja(0, 2));
        pola[0][3] = new Pole(new Krol("bialy"), new Pozycja(0, 3));
        pola[0][4] = new Pole(new Krolowa("bialy"), new Pozycja(0, 4));
        pola[0][5] = new Pole(new Goniec("bialy"), new Pozycja(0, 5));
        pola[0][6] = new Pole(new Skoczek("bialy"), new Pozycja(0, 6));
        pola[0][7] = new Pole(new Wieza("bialy"), new Pozycja(0, 7));

        // Inicjalizacja czarnych figur
        pola[7][0] = new Pole(new Wieza("czarny"), new Pozycja(7, 0));
        pola[7][1] = new Pole(new Skoczek("czarny"), new Pozycja(7, 1));
        pola[7][2] = new Pole(new Goniec("czarny"), new Pozycja(7, 2));
        pola[7][3] = new Pole(new Krol("czarny"), new Pozycja(7, 3));
        pola[7][4] = new Pole(new Krolowa("czarny"), new Pozycja(7, 4));
        pola[7][5] = new Pole(new Goniec("czarny"), new Pozycja(7, 5));
        pola[7][6] = new Pole(new Skoczek("czarny"), new Pozycja(7, 6));
        pola[7][7] = new Pole(new Wieza("czarny"), new Pozycja(7, 7));
    }

    public Pole getPola(int x, int y) {
        return pola[x][y];
    }

    public String toString() {
        StringBuilder plansza = new StringBuilder();
        plansza.append("  0   1   2   3   4   5   6   7 \n");
        for (int i = 0; i < 8; i++) {
            plansza.append(i).append(" ");
            for (int j = 0; j < 8; j++) {
                if (pola[i][j].getFigura() == null) {
                    plansza.append(" ◻︎ ");
                } else {
                    plansza.append(pola[i][j].getFigura().getSymbol()).append("  ");
                }
            }
            plansza.append("\n");
        }
        return plansza.toString();
    }
}