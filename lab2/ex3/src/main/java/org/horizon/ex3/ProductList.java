package org.horizon.ex3;

import java.util.ArrayList;

import java.util.ArrayList;

public class ProductList {
    private final ArrayList<Product> products;

    public ProductList() {
        products = new ArrayList<>();
        products.add(new Product("Laptop", 1200.0, 0.19));
        products.add(new Product("Mouse", 20.0, 0.19));
        products.add(new Product("Keyboard", 50.0, 0.19));
        products.add(new Product("Monitor", 300.0, 0.19));
    }

    public Product findByName(String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
}