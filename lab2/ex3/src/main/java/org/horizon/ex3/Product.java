package org.horizon.ex3;


public class Product {
    private String name;
    private double priceExcludingTax;
    private double vat;

    public Product(String name, double priceExcludingTax, double vat) {
        this.name = name;
        this.priceExcludingTax = priceExcludingTax;
        this.vat = vat;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPriceExcludingTax() { return priceExcludingTax; }
    public void setPriceExcludingTax(double priceExcludingTax) { this.priceExcludingTax = priceExcludingTax; }

    public double getVat() { return vat; }
    public void setVat(double vat) { this.vat = vat; }
}

