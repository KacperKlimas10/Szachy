class Pole {
    private Figura figura;
    private Pozycja pozycja;

    public Pole(Figura figura, Pozycja pozycja) {
        this.figura = figura;
        this.pozycja = pozycja;
    }

    public boolean czyZajete() {
        return figura != null;
    }

    public Figura getFigura() {
        return figura;
    }

    public Pozycja getPozycja() {
        return pozycja;
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    }
}