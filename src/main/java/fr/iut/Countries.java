package fr.iut;

public enum Countries {

    France(1.2),
    Island(1.255),
    Suisse(1.08),
    Croatie(1.25),
    Danemark(1.25),
    Allemagne(1.19);

    private final Double taxToApply;

    private Countries(Double taxYoApply) {
        this.taxToApply = taxYoApply;
    }

    public Double getTaxToApply() {
        return this.taxToApply;
    }
}
