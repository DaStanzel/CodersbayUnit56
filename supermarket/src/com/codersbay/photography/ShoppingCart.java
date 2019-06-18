package com.codersbay.photography;

public class ShoppingCart {
    private double sum;
    private double taxes;
    private Product[] products;

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    // Konstruktor
    public ShoppingCart(double summe, Product[] products) {
        this.sum = summe;
        this.products = products;

    }

    public ShoppingCart() {
        this(0d, new Product[0]);
    }

    public void calcUst() {
        sum = 0d;
        for (Product p : products) {
            sum += p.getPrice() * p.getStock();
        }
        this.taxes = sum * 0.2;

    }

    public void rechnungsDatenAusgeben() {
        double summe = 0d;
        System.out.println("- - - - - - - - - - - - - - - - - - - -");
        System.out.println("Rechnung");
        for (int i = 0; i < this.products.length; i++) {
            System.out.println(String.format("%20s %3dx%3.2f EUR", products[i].getName(), products[i].getStock(), products[i].getPrice()));
            System.out.println(String.format("%33.2f EUR", (products[i].getStock() * products[i].getPrice())));
            summe += products[i].getStock() * products[i].getPrice();
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - -");
        System.out.println("Gesamt: " + summe + " EUR");
        calcUst();
        System.out.println(String.format("enthaltene Mehrwertsteuer: %3.2f EUR", this.taxes));
        System.out.println("- - - - - - - - - - - - - - - - - - - -");
    }

    public void addArticle(Product article) {
        int i;
        for (i = 0; i < this.products.length; i++)
            if (
                    this.products[i].getColor() == article.getColor() &&
                            this.products[i].getName() == article.getName() &&
                            this.products[i].getPrice() == article.getPrice()
            ) {
                this.products[i].setStock(this.products[i].getStock()+1);
                article.setStock(article.getStock()-1);
                break;
            }
        if (i >= this.products.length) {
            Product product[] = new Product[this.products.length + 1];
            for (i = 0; i < this.products.length; i++)
                product[i] = this.products[i];
            product[i] = new Product(article);
            product[i].setStock(1);
            if (article.getStock()> 0)
                article.setStock(article.getStock()-1);
            this.products = product;
        }
    }

}
