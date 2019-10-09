package fr.iut;

public enum Countries {

    France(1.2);

    private final Double taxToApply;

    private Countries(Double taxYoApply) {
        this.taxToApply = taxYoApply;
    }

    public Double getTaxToApply() {
        return this.taxToApply;
    }
}
