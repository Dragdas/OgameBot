package com.ogam.ogambot.logicElements;

public class Price {

    private long metal;
    private long cristal;
    private long deuter;

    public Price(long metal, long cristal, long deuter) {
        this.metal = metal;
        this.cristal = cristal;
        this.deuter = deuter;
    }

    public long getMetal() {
        return metal;
    }

    public long getCristal() {
        return cristal;
    }

    public long getDeuter() {
        return deuter;
    }

    @Override
    public String toString() {
        return "Price{" +
                "metal=" + metal +
                ", cristal=" + cristal +
                ", deuter=" + deuter +
                '}';
    }
}
